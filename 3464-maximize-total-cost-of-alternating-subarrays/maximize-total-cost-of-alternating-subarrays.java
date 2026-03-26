class Solution {
    Long[][] dp;
    public long maximumTotalCost(int[] nums) {
     // now for dp part
     int n = nums.length;
     dp = new Long[n][2];
     return solve(0,1,nums);   
    }
    public long solve(int ind , int sign , int[] nums){
        if(ind == nums.length)return 0;
        int s = sign == 1? 1 : 0;
        if(dp[ind][s] != null)return dp[ind][s];
        // take current
        long take = nums[ind] * sign + solve(ind + 1, -sign,nums);
        // not take current and start a new subarray
        long notake= nums[ind] + solve(ind + 1, -1,nums);
        return dp[ind][s] = Math.max(take , notake);
    }
}