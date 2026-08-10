public class Solution {
    // Memoization table: memo[i][prev] stores the length of the longest 
    // ideal subsequence starting from index 'i' with previous character 'prev'.
    // prev ranges from 0 to 25 for 'a'-'z', and 26 represents 'no character chosen yet'.
    private int[][] memo;
    public int longestIdealString(String s, int k) {
        int n = s.length();
        // Initialize memo array with -1 (representing unvisited states)
        memo = new int[n][27];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        // Start recursion from index 0 with no previous character (represented by 26)
        return solve(0, 26, s, k);
    }
    private int solve(int i, int prevChar, String s, int k) {
        // Base Case: If we reach the end of the string, no more characters can be added
        if (i == s.length()) {
            return 0;
        }
        // Return cached result if already calculated
        if (memo[i][prevChar] != -1) {
            return memo[i][prevChar];
        }
        // Option 1: Exclude the current character
        int exclude = solve(i + 1, prevChar, s, k);
        // Option 2: Include the current character (if valid)
        int include = 0;
        int currChar = s.charAt(i) - 'a';
        // Check if current character can be picked:
        // 1. prevChar == 26 means no character has been picked yet.
        // 2. Math.abs(currChar - prevChar) <= k satisfies the ideal string condition.
        if (prevChar == 26 || Math.abs(currChar - prevChar) <= k) {
            include = 1 + solve(i + 1, currChar, s, k);
        }
        // Store and return the maximum length possible from current state
        return memo[i][prevChar] = Math.max(include, exclude);
    }
}