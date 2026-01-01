class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];

        Arrays.fill(dp, - 1);

        return findMax(0, nums, dp);
    }
    public int findMax(int ind , int[] nums, int[] dp){
        if(ind >= nums.length)return 0;

        if(dp[ind] != -1)return dp[ind];

        int take = nums[ind] + findMax(ind + 2, nums,dp);
        int not = findMax(ind + 1,nums,dp);

        return dp[ind] = Math.max(take,not);
    }
}