class Solution {
    public long findScore(int[] nums) {
        int n = nums.length;
        long score = 0;

        int[] mark = new int[n];

        int[][] vals = new int[n][2];
        for(int i = 0;i < n;i++){
            vals[i][0] = i;
            vals[i][1] = nums[i];
        }

        Arrays.sort(vals , (a,b) -> {
            if(a[1] == b[1]){
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });

        for(int i = 0;i < n;i++){
            int ind = vals[i][0];
            int num = vals[i][1];
            if(mark[ind] == 0){
                score += num;
                mark[ind] = 1;
                if(ind > 0){
                    mark[ind - 1] = 1;
                }
                if(ind < n - 1){
                    mark[ind + 1] = 1;
                }
            }
        }
        return score;
    }
}