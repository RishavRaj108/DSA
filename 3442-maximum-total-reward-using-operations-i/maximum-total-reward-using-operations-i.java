class Solution {
    public int maxTotalReward(int[] rewardValues) {
        Arrays.sort(rewardValues);

        int n = rewardValues.length;
        int maxSum = 4000;

        int[][] dp = new int[n][maxSum + 1];
        for (int[] row : dp) Arrays.fill(row, -1);

        return solve(0, 0, rewardValues, dp);
    }

    private int solve(int i, int sum, int[] vals, int[][] dp) {
        if (i == vals.length) return sum;

        if (dp[i][sum] != -1) return dp[i][sum];

        // skip
        int notTake = solve(i + 1, sum, vals, dp);

        // take (only if valid)
        int take = 0;
        if (vals[i] > sum) {
            take = solve(i + 1, sum + vals[i], vals, dp);
        }

        return dp[i][sum] = Math.max(take, notTake);
    }
}