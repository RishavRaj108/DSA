class Solution {
    public int m , n;
    boolean[][] vis;
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        // up , down , right , left 
        // till health remains positive
        // grid[i][j] == 1 reduce health by 1
        // return true if it is possible to reach 
         m = grid.size() ;
         n = grid.get(0).size();
        int[][][] dp = new int[m + 1][n + 1][health + 1];
        for(int[][] arr : dp){
            for(int[] row : arr){
                Arrays.fill(row , -1);
            }
        }
        vis = new boolean[m][n];
        return find(0,0 , grid , health , dp);
    }

    public boolean find(int row , int col ,List<List<Integer>> grid, int health , int[][][] dp){
        if(row == m - 1 && col == n - 1 )return health > grid.get(row).get(col);
        if(row >= m || col >= n || row < 0 || col < 0 || health <= 0 || vis[row][col] ){
            return false;
        }

        // now i can move in four directions
        

        int val = health;
        if(grid.get(row).get(col) == 1){
            val--;
        }
        if(dp[row][col][val] != -1){
            if(dp[row][col][val] == 0){
                return false;
            }else{
                return true;
            }
        }
        vis[row][col] = true;
        boolean top = find(row - 1, col , grid, val , dp);
        boolean down = find(row + 1 , col , grid, val,dp);
        boolean left = find(row , col - 1,grid , val,dp);
        boolean right = find(row , col + 1 , grid , val,dp);
        vis[row][col] = false;
        if(top || right || left || down){
            dp[row][col][val] = 1;
            return true;
        }
        dp[row][col][val] = 0;
        return false;
    } 
}