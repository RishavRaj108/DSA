class Solution {
    int total;
    public int findTargetSumWays(int[] nums, int target) {
        // at each index we can either take plus or minus at 
        // each index
        // i need to make it reach target
        // we need track of sum that we are having and that will be variable
        // so we need it in the dp
        int n = nums.length;
        total = 0;
        for(int no : nums){
            total += no;
        }
        int[][] dp = new int[n + 1][total * 2 + 1];

        for(int[] arr :dp){
            Arrays.fill(arr , -1);
        }

        return find(0,0,nums,target,dp);
    }
    public int find(int ind , int sum,int[] nums,int target,int[][] dp){
        if(ind == nums.length){
            if(sum == target){
                return 1;
            }else{
                return 0;
            }
        }
        int indexMod = sum + total;
        if(dp[ind][indexMod] != -1)return dp[ind][indexMod];
        
        // two poss at each step

        int plus = find(ind + 1, sum + nums[ind],nums,target,dp);
        int sub = find(ind + 1, sum - nums[ind] , nums,target,dp);


        return dp[ind][indexMod]= plus + sub;
    }
}