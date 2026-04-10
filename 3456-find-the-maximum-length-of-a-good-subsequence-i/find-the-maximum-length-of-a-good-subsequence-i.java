class Solution {
    Integer[][][] dp;
    public int maximumLength(int[] nums, int k) {
        // find max len of subseq
        // at each step possiblity
        // if no same do nothing
        // if diff and k > 0 try reducing k
        // start a new subseq

        // now dp states n ,subseq size ,k
        
        int n = nums.length;
        dp = new Integer[n][n + 1][k + 1];

        return findMax(0,-1,nums , k);
    }
    public int findMax(int i,int prev , int[] nums , int k){
        if(i == nums.length)return 0;
        int p = prev + 1;
        if(dp[i][p][k] != null)return dp[i][p][k];
        int take = 0;
        int noTake = 0;
        if(prev == -1 ){
            take = 1 + findMax( i + 1 , i , nums, k);
            noTake = findMax(i + 1,prev , nums , k);
        }else{
            if(nums[i] == nums[prev]){
                take = 1 + findMax( i + 1 , i , nums, k);
            }
            if(k > 0){
                take = Math.max(take , 1 + findMax(i + 1 , i , nums , k - 1));
            }
            noTake = findMax(i + 1,prev , nums , k);
        }
        return dp[i][p][k] = Math.max(take , noTake);
    }
}