class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int n = nums.length;
        int m = queries.length;

        boolean[] res = new boolean[m];

        // for each index i have to find the max safe stop it can travel
        int[] canVisit = new int[n];
        int i = 0;
        int j = 0;
        while(i < n){
            if(j < i){
                j = i;
            }
            while(j + 1 < n && nums[j + 1] % 2 != nums[j] % 2){
                j++;
            }
            canVisit[i] = j;
            i++;
        }
        int ind = 0;
        for(int[] quer : queries){
            int start = quer[0];
            int end = quer[1];

            if(canVisit[start] >= end){
                res[ind++] = true;
            }else{
                res[ind++] = false;
            }
        }
        return res;
    }
}