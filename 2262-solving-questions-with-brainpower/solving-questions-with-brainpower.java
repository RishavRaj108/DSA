class Solution {
    long[] dp;

    public long mostPoints(int[][] questions) {
        int n = questions.length;
        dp = new long[n];
        Arrays.fill(dp, -1);
        return find(0, questions);
    }

    public long find(int i, int[][] questions) {
        int n = questions.length;

        if (i >= n) {
            return 0;
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        // Skip question i
        long skip = find(i + 1, questions);

        // Solve question i
        int next = i + questions[i][1] + 1;
        long solve = questions[i][0] + find(next, questions);

        return dp[i] = Math.max(skip, solve);
    }
}