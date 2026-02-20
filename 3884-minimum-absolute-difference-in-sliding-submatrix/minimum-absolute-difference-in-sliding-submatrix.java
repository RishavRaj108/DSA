class Solution {
    public int[][] minAbsDiff(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] ans = new int[m - k + 1][n - k + 1];

        for (int i = 0; i < m - k + 1; i++) {
            for (int j = 0; j < n - k + 1; j++) {
                int val = findMin(i, j, k,grid);
                ans[i][j] = val;
            }
        }
        return ans;
    }

    public int findMin(int r, int c,int k , int[][] grid) {
        int val = Integer.MAX_VALUE;
        List<Integer> ls = new ArrayList<>();

        for (int p = r; p < r + k; p++) {
            for (int q = c; q < c + k; q++) {
                ls.add(grid[p][q]);
            }
        }
        Collections.sort(ls);

        for(int i = 0;i < ls.size() - 1;i++){
            if(!ls.get(i).equals(ls.get(i + 1))){
               val = Math.min(val,ls.get(i + 1) - ls.get(i));
            }
        }
        return val == Integer.MAX_VALUE ? 0 : val;
    }
}