class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        // k - (k - 1)

        return find(nums,k) - find(nums,k - 1);
    }
    public int find(int[] nums,int k){
        int n = nums.length;

        int cnt = 0;
        int left = 0;
        int total = 0;
        for(int right = 0;right < n;right++){
            if(nums[right] % 2 == 1){
                total++;
            }
            while(total > k){
                int num = nums[left];
                if(num % 2 == 1){
                    total--;
                }
                left++;
            }
            cnt += right - left + 1;
        }
        return cnt;
    }
}