class Solution {
    public int maximumJumps(int[] nums, int target) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        for(int[] row : dp){
            Arrays.fill(row , -1);
        }
        int val = find(0,1,target, nums,dp);
        return val == Integer.MIN_VALUE/2 ? -1 : val;
    }
    public int find(int ind,int j , int target , int[] nums , int[][] dp){
        if(ind == nums.length - 1){
            return 0;
        }
        if(ind >= nums.length || j >= nums.length){
            return Integer.MIN_VALUE/2;
        }
        if(dp[ind][j] != -1)return dp[ind][j];


        int take = Integer.MIN_VALUE/2;
        int notake = 0;
        if(Math.abs(nums[ind] - nums[j]) <= target){
            int val = find(j, j + 1,target , nums ,dp);
            if(val != Integer.MIN_VALUE/2){
                take = 1 + val;
            }
        }
        int noTake = find(ind , j + 1,target,nums,dp);
        return dp[ind][j] = Math.max(take ,noTake);
    }
}