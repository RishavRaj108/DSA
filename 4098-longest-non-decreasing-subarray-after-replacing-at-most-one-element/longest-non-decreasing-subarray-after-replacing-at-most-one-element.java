class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;

        int[] incL = new int[n];
        int[] incR = new int[n];

        // longest non-decreasing ending at i
        incL[0] = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] >= nums[i - 1]) {
                incL[i] = incL[i - 1] + 1;
            } else {
                incL[i] = 1;
            }
        }

        // longest non-decreasing starting at i
        incR[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] <= nums[i + 1]) {
                incR[i] = incR[i + 1] + 1;
            } else {
                incR[i] = 1;
            }
        }

        int ans = 1;

        // already non-decreasing case
        for (int x : incL) {
            ans = Math.max(ans, x);
        }

        // try replacing every index
        for (int i = 0; i < n; i++) {

            int left = (i > 0) ? incL[i - 1] : 0;
            int right = (i < n - 1) ? incR[i + 1] : 0;

            // can merge both sides
            if (i > 0 && i < n - 1 && nums[i - 1] <= nums[i + 1]) {
                ans = Math.max(ans, left + 1 + right);
            } else {
                ans = Math.max(ans, Math.max(left + 1, right + 1));
            }
        }

        return ans;
    }
}