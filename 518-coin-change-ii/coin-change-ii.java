class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount + 1];
        for (int i = 0; i < coins.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        return find(0,amount,coins,dp);
    }

    public int find(int ind,int amount, int[] coins,int[][] dp){
        if(amount == 0)return 1;
        if(amount < 0 || ind == coins.length)return 0;

        if(dp[ind][amount] != -1)return dp[ind][amount];
        
        int take = find(ind ,amount - coins[ind] , coins,dp);

        int notTake = find(ind + 1,amount , coins,dp);

        return dp[ind][amount] = take + notTake;
    }
}