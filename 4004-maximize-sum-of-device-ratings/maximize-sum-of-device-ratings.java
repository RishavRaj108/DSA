class Solution {
    public long maxRatings(int[][] units) {
        int m = units.length;
        int n = units[0].length;
        long sum = 0;
        if(n == 1) {
            for(int i=0; i < m; i++) sum += units[i][0];
            return sum;
        }
        int minFirst = Integer.MAX_VALUE;
        long secondSum = 0;
        for(int i=0; i<m; i++) {
            Arrays.sort(units[i]);
            minFirst = Math.min(minFirst, units[i][0]);
            secondSum += units[i][1];
        }
        for(int i=0; i<m; i++) {
            long curr = secondSum - units[i][1] + minFirst;
            sum = Math.max(sum, curr);
        }
        return sum;
    }
}