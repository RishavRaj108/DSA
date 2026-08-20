class Solution {
    int[][] dp;
    public int minPathCost(int[][] grid, int[][] moveCost) {
        int m = grid.length;
        int n = grid[0].length;
        dp = new int[m][n];
        
        for(int[] arr : dp){
            Arrays.fill(arr , -1);
        }

        int ans = Integer.MAX_VALUE;

        for(int i = 0;i < n;i++){
            int val =grid[0][i] + find(0,i,grid,moveCost);
            ans = Math.min(val , ans);
        }
        return ans;
    }
    public int find(int r,int c,int[][] grid,int[][] moveCost){
        int m = grid.length;
        int n = grid[0].length;
        if(r >= m - 1 )return 0;

        if(dp[r][c] != -1)return dp[r][c];

        int profit = Integer.MAX_VALUE;
        // iterate throught each cell in next row
        int nr = r + 1;
        for(int i = 0;i < n;i++){
           int cost = grid[nr][i] + moveCost[grid[r][c]][i] + find(nr,i,grid,moveCost);
           profit = Math.min(profit , cost);
        }
        return dp[r][c] = profit;
    }
}