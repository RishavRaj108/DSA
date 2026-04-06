class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        long ans = 0;
        int maxDiff = 0;
        int maxi = 0;
        for(int i = 0;i < n;i++){
            ans = Math.max(ans ,1L * maxDiff * nums[i]);
            maxDiff = Math.max(maxDiff , maxi - nums[i]);
            maxi = Math.max(maxi , nums[i]);
        }
        return ans;
    }
}