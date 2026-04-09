class Solution {
    int[][] dp;
    public int maxOperations(int[] nums) {
        int n = nums.length;
        List<Integer> ls = new ArrayList<>();
        ls.add(nums[0] + nums[1]);
        ls.add(nums[n - 1] + nums[n - 2]);
        ls.add(nums[0] + nums[n - 1]);
        
        int maxi = 0;
        for(int target : ls){
            dp = new int[n][n];
            // Fill with -1
            for (int i = 0; i < n; i++) {
                Arrays.fill(dp[i], -1);
            }
            int val = find(0,n - 1,target,nums);
            maxi = Math.max(maxi , val);
        }
        return maxi;
    }
    public int find(int i , int j ,int target,int[] nums){
        if(j - i + 1 < 2)return 0;
        if(dp[i][j] != -1)return dp[i][j];

        int take = 0;
        // first 2
        if(i + 1 <= j && nums[i] + nums[i + 1] == target){
            take = 1 + find(i + 2,j,target,nums);
        }
        // last 2
        if(j + 1 >= i && nums[j] + nums[j - 1] == target){
            take = Math.max(take , 1 + find(i , j - 2,target,nums));
        }
        // take first and last
        if(nums[i] + nums[j] == target){
            take = Math.max(take , 1 + find(i + 1,j - 1,target,nums));
        }
        return dp[i][j] = take;
    }
}