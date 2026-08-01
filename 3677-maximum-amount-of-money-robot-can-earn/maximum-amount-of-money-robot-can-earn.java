class Solution {
    public int maximumAmount(int[][] coins) {
        int m = coins.length;
        int n = coins[0].length;
        Integer[][][] dp = new Integer[m][n][3];
        return find(0,0,2,coins , dp);
    }
    public int find(int r,int c,int k,int[][] coins ,Integer[][][] dp){
        int m = coins.length;
        int n = coins[0].length;
        if(r >= m || c >= n )return Integer.MIN_VALUE/2;
        if(r == m - 1 && c == n - 1){
            int coin = coins[r][c];
            if(coin > 0)return coin;
            else if(k > 0)return 0;
            else{
                return coin;
            }
        }
        if(dp[r][c][k] != null)return dp[r][c][k];
        int coin = coins[r][c];
        int profit = Integer.MIN_VALUE;
        if(coin > 0){
            profit = coin + Math.max(find(r + 1,c,k,coins , dp) , find(r , c + 1,k,coins,dp));
        }else{
            if(k > 0){
                profit = Math.max(find(r + 1,c,k - 1,coins , dp) , find(r , c + 1,k- 1,coins,dp));
            }
            int noTake = coin + Math.max(find(r + 1,c,k,coins , dp) , find(r , c + 1,k,coins,dp));
            profit = Math.max(profit , noTake);    
        }
        return dp[r][c][k] = profit;
    }
}