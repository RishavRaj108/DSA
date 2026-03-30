class Solution {
    int[] nums;
    int n;
    int[][][] dp;
    public int maximumLength(int[] nums, int k) {
        this.nums = nums;
        this.n = nums.length;
        this.dp = new int[n][n + 1][k + 1];
        for(int[][] mat: dp){
            for(int[] arr : mat){
                Arrays.fill(arr , -1);
            }
        }
        return find(0 , -1 , k);
    }
    public int find(int ind ,int prev , int k){
        if(ind >= n)return 0;
        int prevKey = prev + 1;
        if(dp[ind][prevKey][k] != -1)return dp[ind][prevKey][k];

        int skip = find(ind + 1, prev,k);
        int take = 0;
        // for take part
        if(prev == -1){
           take = 1 + find(ind + 1, ind , k);
        }else{
            if(nums[prev] == nums[ind]){
                take = 1 + find(ind + 1, ind , k);
            }else if(k > 0){
                take = 1 + find(ind + 1,ind , k - 1);
            }
        }
        return dp[ind][prevKey][k] = Math.max(take , skip);
    }
}