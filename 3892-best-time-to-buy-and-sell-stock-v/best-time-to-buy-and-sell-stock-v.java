class Solution {
    long[][][] dp;
    public long maximumProfit(int[] prices, int k) {
        int n = prices.length;
        dp = new long[n][k][3];
        for(long[][] arr : dp){
           for(long[] row : arr){
                Arrays.fill(row , -1);
            }
        }
        return find(0,1,k,prices);
    }
    public long find(int day,int poss , int k,int[] prices){
        if(day == prices.length || k == 0){
            return poss == 1? 0: Long.MIN_VALUE/2;
        }
        if(dp[day][k - 1][poss] != -1)return dp[day][k-1][poss];

        // try nt and st
        long profit = Long.MIN_VALUE/2;
        // nt
        if(poss == 1){ // can buy at this day
          long buy = -prices[day] + find(day + 1,0,k,prices);
          long skip = find(day + 1,poss,k,prices);
          profit = Math.max(buy , skip);
        }else if(poss == 0){ // we can sell 
           long sell = prices[day] + find(day + 1 , 1,k - 1,prices);
           long hold = find(day + 1,poss , k , prices);
           profit = Math.max(sell , hold);
        }

        // st
        if(poss == 1){
            long sell = prices[day] + find(day + 1 , 2,k,prices);
            profit = Math.max(sell , profit);
        }else if(poss == 2){
            long buy = -prices[day] + find(day + 1,1,k - 1,prices);
            long hold = find(day + 1,poss,k,prices);
            profit = Math.max(profit , Math.max(buy , hold));
        }
        return dp[day][k - 1][poss] = profit;
    }
}