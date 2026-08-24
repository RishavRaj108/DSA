class Solution {
    public int longestNiceSubarray(int[] nums) {
        int n = nums.length;
        int left = 0;
        int best = 0;
        int curr = 0;
        for(int right = 0;right < n;right++){
            int num = nums[right];
            while((curr & num) != 0){
                curr = curr ^ nums[left++];
            }
            curr = curr ^ num;
            best = Math.max(best , right - left + 1);
        }
        return best;
    }
}