class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int n = nums.length;
        int m = queries.length;

        boolean[] res = new boolean[m];
        int[] pref = new int[n];

        for(int i = 1;i < n;i++){
            // for each index we will check if its parity is diffrent from prev index
            int parity = nums[i] % 2;
            if(nums[i - 1] % 2 == parity){
                pref[i] = pref[i - 1] + 1;
            }else{
                pref[i] = pref[i - 1];
            }

        }

        int ind = 0;
        for(int[] quer : queries){
            int start = quer[0];
            int end = quer[1];
            if(pref[start] == pref[end]){
                res[ind++] = true;
            }else{
                res[ind++] = false;
            }
        }
        return res;
    }
}