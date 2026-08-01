class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m = grid.size();
        int n = grid.get(0).size();
        int[][][] dp = new int[m][n ][health + 1];
        for(int[][] arr : dp){
            for(int[] row : arr){
                Arrays.fill(row , -1);
            }
        }
        boolean[][] vis = new boolean[m][n];
        return find(0,0,grid,health , dp , vis);
    }
    public boolean find(int r,int c,List<List<Integer>> grid, int health,int[][][] dp ,boolean[][] vis){
        int m = grid.size();
        int n = grid.get(0).size();
        if(r < 0 || r >= m || c < 0 || c >= n || health <= 0 || vis[r][c] == true)return false;
        if(r == m - 1 && c == n - 1){
            health -= grid.get(m - 1).get(n - 1);
            if(health > 0)return true;
            else return false;
        }
        if(grid.get(r).get(c) == 1){
            health--;
        }
        if(dp[r][c][health] != -1 ){
          if(dp[r][c][health] == 1)return true;
          else return false;
        } 
        vis[r][c] = true;
        
        // try going to all four directions
        boolean top = find(r - 1,c,grid,health , dp,vis);
        boolean down = find(r + 1,c,grid,health , dp,vis);
        boolean left = find(r ,c- 1,grid,health , dp,vis);
        boolean right =find(r ,c + 1,grid,health , dp,vis);
        vis[r][c] = false;
        if(top || down || left || right){
            dp[r][c][health] = 1;
            return true;
        }else{
            dp[r][c][health] = 0;
            return false;
        }
    }
}