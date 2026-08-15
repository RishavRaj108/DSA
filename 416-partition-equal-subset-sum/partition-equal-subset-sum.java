class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        // sum is same in two subsets then only return true;

        int total = 0;
        for(int no : nums){
            total += no;
        }

        if(total % 2 == 1)return false;
        int half = total / 2;

        int[][]dp = new int[n][half + 1];

        for(int[] arr : dp){
            Arrays.fill(arr , -1);
        }
        
        return find(0,half,nums,dp);
    }
    public boolean find(int ind , int sum,int[] nums,int[][] dp){
        if(sum == 0)return true;
        if(ind >= nums.length)return false;

        if(dp[ind][sum] != -1){
            if(dp[ind][sum] == 0){
                return false;
            }else{
                return true;
            }
        } 
        boolean take = false;
        if(nums[ind] <= sum){
           take = find(ind + 1 , sum - nums[ind],nums,dp);
        }
        boolean skip = find(ind + 1 , sum,nums,dp);
        if(take || skip){
            dp[ind][sum] = 1;
            return true;
        }else{
            dp[ind][sum] = 0; 
            return false;
        }
    }
}





