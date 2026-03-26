class Solution {
    Long[][] dp;

    public long maximumTotalCost(int[] nums) {
        dp = new Long[nums.length][2];
        return solve(0, 1, nums);
    }

    private long solve(int i, int sign, int[] nums) {
        if (i == nums.length) return 0;

        int s = (sign == 1) ? 0 : 1;
        if (dp[i][s] != null) return dp[i][s];

        long take = nums[i] * sign + solve(i + 1, -sign, nums);
        long restart = nums[i] + solve(i + 1, -1, nums);

        return dp[i][s] = Math.max(take, restart);
    }
}