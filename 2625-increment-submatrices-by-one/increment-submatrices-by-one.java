class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] mat = new int[n][n];

        for(int[] quer : queries){
            int r1 = quer[0];
            int c1 = quer[1];
            int r2 = quer[2];
            int c2 = quer[3];

            for(int i = r1;i <= r2;i++){
                for(int j = c1;j <= c2;j++){
                    mat[i][j]++;
                }
            }
        }
        return mat;
    }
}