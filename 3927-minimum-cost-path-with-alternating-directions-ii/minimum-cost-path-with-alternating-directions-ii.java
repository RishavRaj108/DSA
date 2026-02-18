class Solution {
    int mr , nc; 
    
    public long minCost(int m, int n, int[][] waitCost) {
        mr = m;
        nc = n;
        long[][] dp = new long[m][n];
        
        for(long[] row : dp)
            Arrays.fill(row, -1);
        
        return findMin(0, 0, waitCost, dp);
    }

    public long findMin(int row, int col, int[][] waitCost, long[][] dp) {
        
        if(row >= mr || col >= nc)
            return Long.MAX_VALUE;
        
        long entryCost = (long)(row + 1) * (col + 1);
        
        if(row == mr - 1 && col == nc - 1)
            return entryCost;
        
        if(dp[row][col] != -1)
            return dp[row][col];
        
        long right = findMin(row, col + 1, waitCost, dp);
        long down = findMin(row + 1, col, waitCost, dp);
        
        long minNext = Math.min(right, down);
        
        if(minNext == Long.MAX_VALUE)
            return dp[row][col] = Long.MAX_VALUE;
        
        long total = entryCost + minNext;
        
        // Don't add wait for starting cell
        if(!(row == 0 && col == 0))
            total += waitCost[row][col];
        
        return dp[row][col] = total;
    }
}