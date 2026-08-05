class Solution {
    private long[][] memo;
    public long maxTotal(int[] nums, String s) {
        int n = nums.length;
        // memo[i][prevCovered]: state for index i with prevCovered flag (0 or 1)
        memo = new long[n][2];
        for (long[] row : memo) {
            Arrays.fill(row, -1);
        }
        return solve(0, 0, nums, s);
    }

    private long solve(int i, int prevCovered, int[] nums, String s) {
        // Base case: Reached end of array
        if (i == nums.length) {
            return 0;
        }

        // Return memoized result if already computed
        if (memo[i][prevCovered] != -1) {
            return memo[i][prevCovered];
        }

        long ans = 0;

        if (s.charAt(i) == '0') {
            // No token at index i: skip to next index.
            // Index i is NOT covered, so index i-1 is left as-is, and index i won't cover i.
            // Pass prevCovered = 0 for index i+1.
            ans = solve(i + 1, 0, nums, s);
        } else {
            // Token present at index i:
            // Option 1: Keep token at i (covers index i)
            // Next index i+1 will see that index i is covered (prevCovered = 1)
            long keepAtI = nums[i] + solve(i + 1, 1, nums, s);
            // Option 2: Move token left to i-1 (covers index i-1)
            long moveLeft = 0;
            if (i > 0 && prevCovered == 0) {
                // Can only move left if i > 0 and index i-1 is not yet covered.
                // Since token moves to i-1, index i itself remains UNCOVERED.
                // Next index i+1 will see index i is free (prevCovered = 0).
                moveLeft = nums[i - 1] + solve(i + 1, 0, nums, s);
            }
            ans = Math.max(keepAtI, moveLeft);
        }
        return memo[i][prevCovered] = ans;
    }
}