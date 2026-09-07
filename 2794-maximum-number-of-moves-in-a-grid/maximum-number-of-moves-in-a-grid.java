class Solution {
    int[][] dp;
    public int maxMoves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        dp = new int[m][n];
        for(int[] arr : dp){
            Arrays.fill(arr , -1);
        }
        int ans = 0;
        for(int i = 0;i < m;i++){
            ans = Math.max(ans , find(i , 0 , grid));
        }
        return ans;
    }
    public int find(int r,int c,int[][] grid){
        int m = grid.length;
        int n = grid[0].length;

        if(r >= m || c >= n)return 0;

        if(dp[r][c] != -1)return dp[r][c];

        int maxi = 0;

        if(r - 1 >= 0 && c + 1 < n && grid[r - 1][c + 1] > grid[r][c]){
            maxi = 1 + find(r -1 , c + 1,grid);
        }
        if(c + 1 < n && grid[r][c + 1] > grid[r][c]){
            maxi = Math.max(maxi , 1 + find(r , c + 1 , grid));
        }

        if(c + 1 < n && r + 1 < m && grid[r + 1][c + 1] > grid[r][c]){
            maxi = Math.max(maxi , 1 + find(r + 1,c + 1,grid));
        }
        return dp[r][c] = maxi;
    }
}