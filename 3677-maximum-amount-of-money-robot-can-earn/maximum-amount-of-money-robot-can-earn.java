class Solution {
    public int maximumAmount(int[][] coins) {
        // m * n  grid starts from (0,0) 
        // want to reach the bottom-right corner (m - 1, n - 1)
        // robot can move either right or down at any point in time.
        // return max profit robot can gain.
        // robot has a special ability to neutralize robbers in at most 2 cells on its path
        // logic 
        // use recursion can move to right or down pass row , col ,nutri , coins
        // aim to reach (m - 1)(n - 1)
        int m = coins.length;
        int n = coins[0].length;
        int[][][] dp = new int[m + 1][n + 1][2 + 1];
        for(int[][] mat:dp){
            for(int[] row : mat){
                Arrays.fill(row,Integer.MIN_VALUE);
            }
        }

        return maxProfit(0,0,2,coins,dp);
    }
    public int maxProfit(int r,int c,int n,int[][] coins,int[][][] dp){
        if(r == coins.length - 1 && c == coins[0].length - 1){
            if(coins[r][c] > 0){
                return coins[r][c];
            }else{
                if(n > 0)return 0;
                else return coins[r][c];
            }
        }
        if(r == coins.length || c == coins[0].length){
            return Integer.MIN_VALUE;
        }
        if(dp[r][c][n] != Integer.MIN_VALUE)return dp[r][c][n];
        
        int right = Integer.MIN_VALUE, down = Integer.MIN_VALUE;
        if(coins[r][c] < 0 && n > 0){
            right =maxProfit(r , c + 1,n - 1,coins,dp);
            down = maxProfit(r + 1, c,n - 1,coins,dp);
        }

        int rightNN = maxProfit(r , c + 1,n,coins,dp);
        int downNN = maxProfit(r + 1, c,n,coins,dp);
        // now i need to figure out which is max and if it use nutri or not
        int total = 0;
        int maxiNN = Math.max(rightNN , downNN);
        int maxi = Math.max(right,down);
        if(maxiNN + coins[r][c] > maxi){
            total = maxiNN + coins[r][c];
        }else{
            total = maxi;
        }
        return dp[r][c][n] = total;
    }
}