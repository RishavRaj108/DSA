class Solution {
    int[] dp;
    public int climbStairs(int n, int[] costs) {
        dp = new int[n + 1];
        Arrays.fill(dp , -1);
        return find( 0 , costs);
    }
    public int find(int ind , int[] costs){
        int n = costs.length;
        if(ind == n)return 0;
        if(ind > n)return 100000000;
        if(dp[ind] != -1)return dp[ind];
        int first = 10000000,second = 10000000,third = 10000000;
        
        if(ind + 1  <= n){
            first = costs[ind] + 1 +find(ind + 1 , costs);
        }
        if(ind + 2  <= n){
            second = costs[ind + 1] + 4 +find(ind + 2 , costs);
        }
        if(ind + 3  <= n){
            third = costs[ind + 2] + 9 +find(ind + 3 , costs);
        }
        return dp[ind] = Math.min(first , Math.min(second , third));
    }
}