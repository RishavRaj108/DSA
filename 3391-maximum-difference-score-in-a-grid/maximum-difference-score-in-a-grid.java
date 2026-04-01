class Solution {
    int m , n;
    public int maxScore(List<List<Integer>> grid) {
        m = grid.size();
        n = grid.get(0).size();
        Integer[][] dp = new Integer[m][n];

        int ans = Integer.MIN_VALUE;
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                ans = Math.max(ans , helper(i , j, dp , grid));
            }
        }
        return ans;
    }
    public int helper(int r,int c,Integer[][] dp,List<List<Integer>> grid){
        if(dp[r][c] != null)return dp[r][c];
        int right = (int)(-1e9);
        int down = (int)(-1e9);
        // we can go right or down
        if(c < n - 1){
           right = grid.get(r).get(c + 1) - grid.get(r).get(c) + Math.max(0 , helper(r , c + 1,dp,grid));
        }
        if(r < m - 1){
            down = grid.get(r + 1).get(c) - grid.get(r).get(c) + Math.max(0 , helper(r + 1, c ,dp,grid));
        }
        return dp[r][c] = Math.max(right , down);
    }
}