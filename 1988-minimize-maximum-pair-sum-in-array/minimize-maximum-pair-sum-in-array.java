class Solution {
    public int minPairSum(int[] nums) {
        // minimized maximum pair sum
        Arrays.sort(nums);
        int maxi = Integer.MIN_VALUE;
        int i = 0, j = nums.length - 1;
        while(i < j){
            maxi = Math.max(maxi , nums[i] + nums[j]);
            i++;
            j--;
        }
        return maxi;
    }
}