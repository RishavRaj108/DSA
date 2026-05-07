class Solution {
    public int minCost(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Integer[][][] dp = new Integer[n][m][2046];
        return find(0,0,0,grid,dp);
    } 
    public int find(int r,int c,int val,int[][] grid,Integer[][][] dp){
        int n = grid.length;
        int m = grid[0].length;

        if(r == n - 1 && c == m - 1){
            return val ^ grid[n - 1][m - 1];
        }
        if(r >= n || c >= m){
            return Integer.MAX_VALUE/2;
        }
        if(dp[r][c][val] != null)return dp[r][c][val];
        int curr = val ^ grid[r][c];
        int right = find(r , c + 1,curr , grid,dp);
        int down = find(r + 1, c ,curr , grid,dp);

        return dp[r][c][val] = Math.min(right , down);
    }
}