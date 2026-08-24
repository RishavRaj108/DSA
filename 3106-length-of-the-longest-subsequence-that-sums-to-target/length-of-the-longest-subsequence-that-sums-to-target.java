class Solution {
    int[][] dp;
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        int n = nums.size();
        dp = new int[n][target + 1];

        for(int[] arr : dp){
            Arrays.fill(arr , -1);
        }
        int value = find(0,target , nums);
        return  value <= 0 ? -1 : value;
    }
    public int find(int ind,int tar,List<Integer> nums){
        if(tar == 0)return 0;
        if(tar < 0 || ind >= nums.size()){
            return Integer.MIN_VALUE/2;
        }
        if(dp[ind][tar] != -1)return dp[ind][tar];

        int take = 1 + find(ind + 1,tar - nums.get(ind),nums);
        int noTake = find(ind + 1,tar,nums);

        return dp[ind][tar] = Math.max(take , noTake);
    }
}