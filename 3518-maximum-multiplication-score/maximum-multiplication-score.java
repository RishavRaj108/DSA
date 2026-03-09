class Solution {
    public long maxScore(int[] a, int[] b) {
        // we are given 2 arrays and at each step we can take an element from b or skip i t
        long[][] dp = new long[4][b.length];
        for(long[] row : dp){
            Arrays.fill(row,Long.MIN_VALUE);
        }
        return find(0,0 , a,b,dp);
    }
    public long find(int i , int j , int[] a , int[] b,long[][] dp){
        if(i >= a.length){
            return 0;
        }
        if(j >= b.length){
            return Long.MIN_VALUE/2;
        }
        if(dp[i][j] != Long.MIN_VALUE){
            return dp[i][j];
        }

        // at each step we can take the value or skip it 
        long take = (long)a[i] * b[j] + find(i + 1 , j + 1,a , b,dp);

        long notTake = find(i , j + 1,a,b,dp);

        return dp[i][j] = Math.max(take , notTake);
    }
}