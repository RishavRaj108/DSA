class Solution {

    // Memo: (index, prevIndex, remaining k)
    int[][][] dp;
    int[] nums;
    int n;

    public int maximumLength(int[] nums, int k) {
        this.nums = nums;
        this.n = nums.length;

        // prevIndex: -1 → mapped to 0, rest shifted by +1
        dp = new int[n][n + 1][k + 1];

        for (int[][] layer : dp) {
            for (int[] row : layer) {
                Arrays.fill(row, -1);
            }
        }

        return solve(0, -1, k);
    }

    private int solve(int i, int prevIndex, int k) {
        // Base case: no elements left
        if (i == n) return 0;
        // Shift prevIndex for storage
        int prevKey = prevIndex + 1;
        if (dp[i][prevKey][k] != -1) {
            return dp[i][prevKey][k];
        }
        // ❌ Option 1: Skip current element
        int notTake = solve(i + 1, prevIndex, k);
        // ✅ Option 2: Take current element
        int take = 0;

        if (prevIndex == -1) {
            // First element → no change used
            take = 1 + solve(i + 1, i, k);
        } else {
            if (nums[i] == nums[prevIndex]) {
                // Same value → no change
                take = 1 + solve(i + 1, i, k);
            } else if (k > 0) {
                // Different value → consume 1 change
                take = 1 + solve(i + 1, i, k - 1);
            }
        }
        return dp[i][prevKey][k] = Math.max(take, notTake);
    }
}