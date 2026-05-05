class Solution {
    public int maximumBeauty(int[] nums, int k) {
        Arrays.sort(nums);

        int left = 0;
        int n = nums.length;
        int maxi = 0;
        for(int right = 0;right < n;right++){
            int num = nums[right];

            while(nums[right] - nums[left] > 2 * k){
                left++;
            }
            maxi = Math.max(maxi , right - left + 1);
        }
        return maxi;
    }
}