class Solution {
    public int climbStairs(int n) {
        // create a dp of size n to keep track on no of ways to reach each step
        // use this val to reduce recursion calls
        int[] dp = new int[n + 1];

        return findWays(n, dp);
    }
    public int findWays(int n , int[] dp){
        if(n == 1)return 1;
        if(n == 2)return 2;
        if(n == 0)return 0;

        if(dp[n] != 0)return dp[n];

        return dp[n] = findWays(n - 1,dp) + findWays(n - 2, dp);
    }
}