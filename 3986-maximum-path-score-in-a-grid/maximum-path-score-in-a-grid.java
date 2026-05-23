class Solution {
    int[][] grid;
    int[][][] dp;
    int k;
    public int maxPathScore(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        this.grid = grid;
        this.k = k;
        dp = new int[m][n][k + 1];

        for(int[][] arr : dp){
            for(int[] row : arr){
                Arrays.fill(row , -1);
            }
        }

        int val = find(0,0,0);
        return val < 0 ? -1 : val;
    }
    public int find(int r,int c,int cost){
        if(r >= grid.length || c >= grid[0].length || cost > k){
            return Integer.MIN_VALUE/2;
        }

        if(r == grid.length - 1 && c == grid[0].length - 1){
           if(grid[r][c] != 0){
            cost++;
           }
           if(cost > k){
                return Integer.MIN_VALUE/2;
            }
            return grid[r][c];
        }

        if(dp[r][c][cost] != -1)return dp[r][c][cost];
        int nc = cost;
        if(grid[r][c] != 0){
            nc++;
        }
        int right = grid[r][c] + find(r , c + 1,nc);
        int down = grid[r][c] + find( r + 1,c,nc);
        return dp[r][c][cost] = Math.max(right , down);
    }
}