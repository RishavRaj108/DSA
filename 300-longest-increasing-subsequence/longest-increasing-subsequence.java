class Solution {
    public int lengthOfLIS(int[] nums) {
        // i need to track the prev choosen element
        int n = nums.length;
        int[][] dp = new int[n + 1][n + 1];
        for(int[] arr : dp){
            Arrays.fill(arr , -1);
        }
        return find(0 , -1, nums,dp);
    }
    public int find(int ind,int prev , int[] nums,int[][] dp){
        if(ind >= nums.length)return 0;
        if(dp[ind][prev + 1] != -1)return dp[ind][prev + 1];

        // check if poss
        int best;
        if(prev == -1 || nums[prev] < nums[ind]){
            best = Math.max( 1 + find(ind + 1,ind,nums,dp) ,find(ind + 1,prev,nums,dp));
        }else{
            best =  find(ind + 1,prev,nums,dp);
        }
        return dp[ind][prev + 1]= best;
    }
}