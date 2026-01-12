class Solution {
    static final int MOD = 1_000_000_007;

    public int minMaxSums(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);

        // comb[i][j] = number of ways to choose j elements from i elements
        long[][] comb = new long[n + 1][k + 1];

        // Base case
        for (int i = 0; i <= n; i++) {
            comb[i][0] = 1;
        }

        // Build combinations table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                comb[i][j] = (comb[i - 1][j] + comb[i - 1][j - 1]) % MOD;
            }
        }

        long ans = 0;

        // Count MIN contributions
        for (int i = 0; i < n; i++) {
            for (int len = 1; len <= k; len++) {
                int remaining = n - i - 1;   // elements to the right
                if (remaining >= len - 1) {
                    ans = (ans + nums[i] * comb[remaining][len - 1]) % MOD;
                }
            }
        }

        // Count MAX contributions
        for (int i = 0; i < n; i++) {
            for (int len = 1; len <= k; len++) {
                int remaining = i;          // elements to the left
                if (remaining >= len - 1) {
                    ans = (ans + nums[i] * comb[remaining][len - 1]) % MOD;
                }
            }
        }

        return (int) ans;
    }
}
