class Solution {
    public long maximumSumOfHeights(int[] heights) {
        int n = heights.length;
        long ans = 0;

        for (int peak = 0; peak < n; peak++) {

            long sum = heights[peak];

            // LEFT SIDE
            int prev = heights[peak];
            for (int i = peak - 1; i >= 0; i--) {
                prev = Math.min(prev, heights[i]);
                sum += prev;
            }

            // RIGHT SIDE
            prev = heights[peak];
            for (int i = peak + 1; i < n; i++) {
                prev = Math.min(prev, heights[i]);
                sum += prev;
            }

            ans = Math.max(ans, sum);
        }

        return ans;
    }
}