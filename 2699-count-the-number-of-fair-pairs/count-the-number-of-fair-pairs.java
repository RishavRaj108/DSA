class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        int n = nums.length;
        Arrays.sort(nums);
        return cntLessEqual(nums , upper) - cntLessEqual(nums , lower - 1); 
    }
    public long cntLessEqual( int[] nums , int total){
        int left = 0;
        int right = nums.length - 1;
        long cnt = 0;
        while(left < right){
            int sum = nums[left] + nums[right];

            if(sum <= total){
                cnt += right - left;
                left++;
            }else{
                right--;
            }
        }
        return cnt;
    }
}