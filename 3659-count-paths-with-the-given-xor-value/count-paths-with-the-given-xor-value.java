class Solution {
    int mod = (int) 1e9 + 7;
    int n , m;
    public int countPathsWithXorValue(int[][] grid, int k) {
        // first i will write recursion 
        
        n = grid.length;
        m = grid[0].length;
        int[][][] dp = new int[n][m][16];
        for(int[][] arr : dp){
            for(int[] row : arr){
                  Arrays.fill(row , -1);
            }
        }
        return findPath(0,0,0,grid,k,dp);
    }
    public int findPath(int r,int c,int val,int[][] grid,int k,int[][][] dp){
        if(r == n - 1 && c == m - 1 ){
            val = val ^ grid[r][c];
            if(val == k)return 1;
            return 0;
        } 
        

        if(r >= n || c >= m)return 0;
        if(dp[r][c][val] != -1)return dp[r][c][val];
        int num = grid[r][c];

        int right = findPath(r , c + 1,val ^ num , grid , k,dp);
        int down = findPath(r + 1,c,val ^ num,grid,k,dp);
        return dp[r][c][val] = (int)((right + down) % mod);
    }
}