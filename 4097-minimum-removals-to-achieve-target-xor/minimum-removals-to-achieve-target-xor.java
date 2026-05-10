class Solution {
    public int minRemovals(int[] nums, int target) {
        int n = nums.length;
        // dp states index and elem & xor
        int[][][] dp = new int[n][n][20050];
        for(int[][] arr: dp){
            for(int[] row : arr){
                Arrays.fill(row , - 1);
            }
        }
        int val = find(0,0,0,nums,target,dp);
        if(val == Integer.MIN_VALUE){
            return -1;
        }
        return n - val;
    }
    public int find(int i,int ele,int xor,int[] nums , int target,int[][][] dp){
        if(i == nums.length){
          if(xor == target){
            return ele;
          }else{
            return Integer.MIN_VALUE;
          }
        }
         
        if(dp[i][ele][xor] != -1)return dp[i][ele][xor];

        // take 
        int take = find(i + 1,ele + 1,xor ^ nums[i],nums,target,dp);
        int noTake = find(i + 1,ele,xor,nums,target,dp);

        return dp[i][ele][xor]= Math.max(take , noTake);
    }
}