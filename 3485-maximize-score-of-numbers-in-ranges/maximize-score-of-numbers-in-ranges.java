class Solution {
    public int maxPossibleScore(int[] start, int d) {
        Arrays.sort(start);
        int n = start.length;
        long low = 0;
        // Upper bound is the maximum possible spread divided by (n - 1)
        long high = Integer.MAX_VALUE;
        long ans = 0;
        while (low <= high) {
            long mid = low + (high - low) / 2;
            if (canAchieve(start, d, mid)) {
                ans = mid;
                low = mid + 1;  // Try to find a larger score
            } else {
                high = mid - 1; // Score too large, reduce the gap
            }
        }
        return (int) ans;
    }
    private boolean canAchieve(int[] start, int d, long mid) {
        long curr = start[0];
        for (int i = 1; i < start.length; i++) {
            // Next point must be at least curr + mid, or start[i], whichever is larger
            curr = Math.max((long) start[i], curr + mid);
            // Check if it exceeds the interval [start[i], start[i] + d]
            if (curr > (long) start[i] + d){
                return false;
            }
        }
        return true;
    }
}