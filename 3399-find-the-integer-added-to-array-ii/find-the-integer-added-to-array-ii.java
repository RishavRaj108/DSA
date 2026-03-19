class Solution {
    public int minimumAddedInteger(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int ans = Integer.MAX_VALUE;

        // Try removing nums1[0], nums1[1], nums1[2] possibilities
        for (int i = 0; i < 3; i++) {
            int x = nums2[0] - nums1[i];

            int skip = 0;
            int j = 0;

            for (int k = 0; k < nums1.length; k++) {
                if (j < nums2.length && nums1[k] + x == nums2[j]) {
                    j++;
                } else {
                    skip++;
                }
            }

            if (skip == 2) {
                ans = Math.min(ans, x);
            }
        }

        return ans;
    }
}