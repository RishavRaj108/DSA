class Solution {

    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);

        long count = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {

            int left = lowerBound(nums, i + 1, n, lower - nums[i]);

            int right = lowerBound(nums, i + 1, n, upper - nums[i] + 1);

            count += (right - left);
        }

        return count;
    }

    // First index >= target
    private int lowerBound(int[] nums, int l, int r, int target) {

        while (l < r) {
            int mid = l + (r - l) / 2;

            if (nums[mid] < target)
                l = mid + 1;
            else
                r = mid;
        }

        return l;
    }
}