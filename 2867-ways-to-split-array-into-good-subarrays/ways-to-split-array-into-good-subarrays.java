class Solution {
    public int numberOfGoodSubarraySplits(int[] nums) {
        int n = nums.length;
        long mod = 1000000007;
        long ans = 1;
        int prev= -1;
        for(int i = 0;i < n;i++){
           if(nums[i] == 1){
            if(prev == -1){
                prev = i;
            }else{
                ans = (ans * (i - prev)) % mod;
                prev = i;
            }
           }
        }
        if(prev == -1)return 0;
        return (int) ans;
    }
}