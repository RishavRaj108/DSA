class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;

        int maxi = nums[0];
        int right = 0;
        for(int i = 1;i < n;i++){
            if(nums[i] < maxi){
                right = i;
            }else{
                maxi = Math.max(nums[i] , maxi);
            }
        }
        if(right == 0)return 0;

        int mini = nums[n - 1];
        int left = n - 1;
        for(int i = n- 2;i >= 0;i--){
            if(nums[i] > mini){
                left = i;
            }else{
                mini = Math.min(mini , nums[i]);
            }
        }

        return right - left + 1;
    }
}