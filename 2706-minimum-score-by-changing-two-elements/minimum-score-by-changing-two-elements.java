class Solution {
    public int minimizeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        int maxi1 = nums[n - 1] - nums[2];
        int maxi2 = nums[n - 3] - nums[0];
        int maxi = nums[n - 2] - nums[1];
        return Math.min(maxi1 , Math.min(maxi, maxi2));
    }
}