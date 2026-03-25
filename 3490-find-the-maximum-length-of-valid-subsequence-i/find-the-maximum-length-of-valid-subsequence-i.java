class Solution {
    public int maximumLength(int[] nums) {
        int n = nums.length;
        int even = 0;
        int odd = 0;
        for(int i = 0;i < n;i++){
            if(nums[i] % 2 == 0){
                even++;
            }else{
                odd++;
            }
        }
        int alt = 1;
        int prev = nums[0] % 2;
        for(int i = 1;i < n;i++){
            int curr = nums[i] % 2;
            if(curr != prev){
                alt++;
                prev = curr;
            }
        }
        return Math.max(alt , Math.max(even ,odd));
    }
}