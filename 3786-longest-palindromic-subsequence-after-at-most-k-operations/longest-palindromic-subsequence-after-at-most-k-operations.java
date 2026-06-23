class Solution {
    int[][][] dp;
    String s;

    public int longestPalindromicSubsequence(String s, int k) {
        this.s = s;
        int n = s.length();

        dp = new int[n][n][k + 1];

        for (int[][] arr : dp) {
            for (int[] row : arr) {
                Arrays.fill(row, -1);
            }
        }

        return find(0, n - 1, k);
    }

    private int find(int l, int r, int k) {
        if (l > r) return 0;
        if (l == r) return 1;

        if (dp[l][r][k] != -1) return dp[l][r][k];

        int ans = 0;

        // skip one side
        ans = Math.max(find(l + 1, r, k), find(l, r - 1, k));

        // try matching s[l] and s[r]
        int diff = Math.abs(s.charAt(l) - s.charAt(r));
        int cost = Math.min(diff, 26 - diff);

        if (cost <= k) {
            ans = Math.max(ans, 2 + find(l + 1, r - 1, k - cost));
        }

        return dp[l][r][k] = ans;
    }
}