class Solution {
    private int val = 0;
    private int[][] grid;
    public int[][] specialGrid(int N) {
        int n = (int)Math.pow(2,N);
        grid = new int[n][n];
        solve(0,0,n);
        return grid;
    }
    public void solve(int row ,int col,int size){
        if(size == 1){
            grid[row][col] = val;
            val++;
            return;
        }
        int subsize = size / 2;
        // top right
        solve(row , col + subsize,subsize);
        // bottom right
        solve(row + subsize , col + subsize,subsize);
        // bottom left
        solve(row + subsize , col,subsize);
        // top left
        solve(row , col , subsize);
    }
}