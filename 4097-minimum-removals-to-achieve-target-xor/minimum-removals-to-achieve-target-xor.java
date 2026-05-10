class Solution {
    public int minRemovals(int[] nums, int target) {
        int n = nums.length;
        // dp states index and elem & xor
        int[][] dp = new int[n][20000];
        for(int[] arr: dp){
            Arrays.fill(arr, - 1);
        }
        int val = find(0,0,nums,target,dp);
        if(val < 0){
            return -1;
        }
        return n - val;
    }
    public int find(int i,int xor,int[] nums , int target,int[][] dp){
        if(i == nums.length){
          if(xor == target){
            return 0;
          }else{
            return -10000;
          }
        }
         
        if(dp[i][xor] != -1)return dp[i][xor];

        // take 
        int take = 1 + find(i + 1,xor ^ nums[i],nums,target,dp);
        int noTake = find(i + 1,xor,nums,target,dp);

        return dp[i][xor]= Math.max(take , noTake);
    }
}