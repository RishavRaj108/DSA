class Solution {
    long mod = 1000000007;
    public int uniquePaths(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m + 1][n + 1];
        for(int[] row : dp){
            Arrays.fill(row , -1);
        }
        return find(0,0,dp,grid);
    }
    public int find(int r ,int c,int[][] dp,int[][] grid){
        if(r == grid.length - 1 && c == grid[0].length - 1)return 1;
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length)return 0;
        int m = grid.length;
        int n = grid[0].length;
        if(dp[r][c] != -1)return dp[r][c];
         
        long down = 0;
        long right = 0;
        // for down
        if(r + 1 < m && grid[r + 1][c] == 1){
           // the down cell is mirror then find then next step
           // dir true down else right
           boolean dir = true;
           boolean valid = true;
           int row = r + 1;
           int col = c;
           while(grid[row][col] != 0){
              if(dir){
                // move right
                col++;
                dir = !dir;
              }else{
                row++;
                dir = !dir;
              }
              if(row >= m || col >= n){
                    valid = false;
                    break;
              }
           }
           if(valid){
            down = find(row , col , dp,grid);
           }
        }else{
            down = find(r + 1,c,dp,grid);
        }
        // for right
        if(c + 1 < n && grid[r][c + 1] == 1){
            // the down cell is mirror then find then next step
           // dir true down else right
           boolean dir = false;
           boolean valid = true;
           int row = r;
           int col = c + 1;
           while(grid[row][col] != 0){
              if(dir){
                // move right
                col++;
                dir = !dir;
              }else{
                row++;
                dir = !dir;
              }
              if(row >= m || col >= n){
                    valid = false;
                    break;
              }
           }
           if(valid){
            right = find(row , col , dp,grid);
           }
        }else{
            right = find(r,c + 1,dp,grid);
        }
        long val = (down + right) % mod;
        return dp[r][c] = (int)val;
    }
}