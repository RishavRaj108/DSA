class Solution {
    public int maximumJumps(int[] nums, int target) {
        int n = nums.length;

        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        int val = find(0,target, dp,nums);
        return val == Integer.MIN_VALUE? -1:val;
    }
    public int find(int ind , int target , int[] dp , int[] nums){
        if(ind == nums.length - 1)return 0;

        if(ind >= nums.length)return Integer.MIN_VALUE;

        if(dp[ind] != -1)return dp[ind];
        int maxi = Integer.MIN_VALUE;
        for(int i = ind + 1;i < nums.length;i++){
            int val = Integer.MIN_VALUE;
            if(Math.abs(nums[ind] - nums[i]) <= target){
                val = find(i , target, dp,nums);
                if(val != Integer.MIN_VALUE){
                   val++;
                }
            }
            maxi = Math.max(maxi , val);
        }
        return dp[ind] = maxi;
    }
}