class Solution {
    int[][] dirs = {{-1,1},{0,1},{1,1}};
    int[][] dp;
    public int maxMoves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
         
        dp = new int[m][n];
        for(int [] row : dp){
            Arrays.fill(row , - 1);
        }
        int maxi = 0;
        for(int i = 0;i < m;i++){
            int[][] vis = new int[m][n];
            maxi = Math.max(maxi , find(i,0,grid,vis));
        }
        return maxi;
    }
    public int find(int r , int c,int[][] grid,int[][] vis){
        if(r >= grid.length || c >= grid[0].length || r < 0 || c < 0|| vis[r][c] == 1){
            return 0;
        }
        if(dp[r][c] != -1)return dp[r][c];
        int maxi = 0;
        for(int[] dir : dirs){
            int nr = dir[0] + r;
            int nc = dir[1] + c;
            if(nr >= 0 && nc >= 0 && nr < grid.length && nc < grid[0].length && grid[nr][nc] > grid[r][c]){
                int val = find(nr,nc,grid,vis);
                maxi = Math.max( maxi , 1 + val);
            }
        }
        return dp[r][c] = maxi;
    }
}