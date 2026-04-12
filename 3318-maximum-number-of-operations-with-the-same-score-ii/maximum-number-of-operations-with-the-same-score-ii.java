class Solution {
    public int maxOperations(int[] nums) {
        // score is sum of deleted elements
        // find max no of opr that can be performed such that all 
        // opr score is same

        // their is 3 possiblity of score

        // pass it and use dp for computing all possiblity and get max
        // dp states n n
        int n = nums.length;
        List<Integer> ls = new ArrayList<>();
        ls.add(nums[0] + nums[1]);
        ls.add(nums[n - 1] + nums[n - 2]);
        ls.add(nums[0] + nums[n - 1]);
        int maxi = 1;
        
        for(int val : ls){
           Integer[][] dp = new Integer[n][n];
           maxi = Math.max(maxi , find(0,n - 1,nums, val , dp));
        }
        return maxi;
    }
    public int find(int i,int j,int[] nums,int val, Integer[][] dp){
        if(j - i + 1 < 2)return 0;
        if(dp[i][j] != null)return dp[i][j];

        // at each step we can choose any 3 possiblity
        int first = 0;
        int second = 0;
        int third = 0;
        if(nums[i] + nums[i+ 1] == val){
            first = 1 + find(i + 2,j,nums,val,dp);
        }
        if(nums[i] + nums[j] == val){
            second =1 + find(i + 1,j - 1,nums,val,dp);
        }
        if(nums[j] + nums[j - 1] == val){
            third = 1 + find(i , j - 2,nums,val,dp);
        }
        return dp[i][j]= Math.max(first , Math.max(second , third));
    }
}