class Solution {
    public int maxTotalReward(int[] rewardVal) {
        int n = rewardVal.length;
        Arrays.sort(rewardVal);
        int[][] dp = new int[n][2000 + 2000];
        for(int[] row : dp){
            Arrays.fill(row , -1);
        }
        return solve(0,0,rewardVal , dp);
    }
    public int solve(int ind , int total , int[] vals , int[][] dp){
        if(ind >= vals.length)return 0;

        if(dp[ind][total] != -1)return dp[ind][total];
        int take = 0;
        // now take and notake possibltiy
        if(vals[ind] > total){
            take = vals[ind] + solve(ind + 1 , total + vals[ind] , vals, dp);
        }
        int notake = solve(ind + 1, total , vals , dp);
        return dp[ind][total] = Math.max(take , notake);
    }
}