class Solution {
    int[][] dp;
    public int maxScore(List<List<Integer>> grid) {
        // at least one move
        int n = grid.size();
        int m = grid.get(0).size();
        dp = new int[n][m];
        for(int[] arr : dp){Arrays.fill(arr , -1);}

        int maxi = Integer.MIN_VALUE;
        for(int i = 0;i < n;i++){
            for(int j = 0;j < m;j++){
                maxi = Math.max(maxi , find(i , j , grid));
            }
        }
        return maxi;
    }
    public int find(int r,int c,List<List<Integer>> grid){
        int n = grid.size();
        int m = grid.get(0).size();
        if(dp[r][c] != -1)return dp[r][c];

        int down = Integer.MIN_VALUE;
        int right = Integer.MIN_VALUE;
        if(r != n -1){
           down = grid.get(r + 1).get(c) - grid.get(r).get(c) + Math.max(0,find(r + 1 , c , grid));
        }
        if(c != m - 1){
            right = grid.get(r ).get(c+ 1) - grid.get(r).get(c) +Math.max(0 ,find(r , c + 1 , grid) ) ;
        }
       return dp[r][c] = Math.max(down , right);
    }
}