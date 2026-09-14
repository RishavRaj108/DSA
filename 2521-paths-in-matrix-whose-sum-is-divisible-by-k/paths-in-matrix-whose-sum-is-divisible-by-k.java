class Solution {
    int mod = 1000000007;
    int[][][] dp;
    public int numberOfPaths(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        dp = new int[m][n][k];
        for(int[][] arr : dp){
            for(int[] row : arr){
                Arrays.fill(row , -1);
            }
        }
        return find(0 , 0,0, grid,k);
    }
    public int find(int r,int c,int rem , int[][] grid,int k){
        int m = grid.length;
        int n = grid[0].length;
        if(r >= m || c >= n)return 0;
        int no = grid[r][c];
        rem =((no + rem)  % k);
        if(r == m -1 && c == n -1){
            if(rem == 0){
                return 1;
            }else{
                return 0;
            }
        }
        if(dp[r][c][rem] != -1)return dp[r][c][rem];
        
        int right = find(r , c + 1, rem , grid,k);
        int down = find(r + 1,c ,rem,grid,k);

        long val = (right + down)%mod;
        return dp[r][c][rem] = (int)val;
    }
}