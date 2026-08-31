class Solution {
    long[][] dp;
    public long rob(int[] nums, int[] colors) {
        int n = nums.length;
        dp = new long[n][2];
        for(long[] arr : dp){
            Arrays.fill(arr , -1L);
        }
        return find(0,0,nums,colors);
    }
    public long find(int ind,int prev,int[] nums,int[] colors){
        if(ind >= nums.length)return 0L;
        if(dp[ind][prev] != -1)return dp[ind][prev];

        long profit = 0L;

        if(prev == 0){
            // we can just take currect or skip it
            profit = Math.max(nums[ind] + find(ind + 1,1,nums,colors) , find(ind + 1,0,nums,colors));
        }else{
            if(colors[ind - 1] != colors[ind]){
               profit = nums[ind] + find(ind + 1,1,nums,colors);
            }
            profit = Math.max(profit , find(ind + 1,0,nums,colors));
        }
        return dp[ind][prev] = profit;
    }
}