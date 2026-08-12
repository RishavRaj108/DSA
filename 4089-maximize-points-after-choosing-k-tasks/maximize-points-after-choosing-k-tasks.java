class Solution {
    public long maxPoints(int[] tech1, int[] tech2, int k) {
        int n = tech1.length;
        int[][] diff = new int[n][2];
        for(int i = 0;i < n;i++){
            diff[i][0] = tech1[i] - tech2[i];
            diff[i][1] = i;
        }
        Arrays.sort(diff , (a,b) -> b[0] - a[0]);
        long sum = 0L;
        
        for(int i = 0;i < k;i++){
            int ind = diff[i][1];
            sum += tech1[ind];
        }

        for(int i = k;i < n;i++){
            int ind = diff[i][1];
            if(tech1[ind] > tech2[ind]){
                sum += tech1[ind];
            }else{
                sum += tech2[ind];
            }
        }
        return sum;
    }
}