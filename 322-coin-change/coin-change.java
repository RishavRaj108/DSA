class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, - 1);

        int ans = solve(amount , coins, dp);
        return ans == Integer.MAX_VALUE? -1 : ans;
    }

    public int solve(int amount ,int[] coins,int[] dp){
        if(amount == 0)return 0;
        if(amount < 0)return Integer.MAX_VALUE;

        if(dp[amount] != -1)return dp[amount];

        int minCoins = Integer.MAX_VALUE;

        for(int coin : coins){
            int res = solve(amount - coin,coins,dp);

            if(res != Integer.MAX_VALUE){
                minCoins = Math.min(minCoins , res + 1);
            }
        }

        return dp[amount] = minCoins;
    }
}