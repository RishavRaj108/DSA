class Solution {
    long[][] dp;
    public long maxTotal(int[] nums, String s) {
        // we can move the token to its next state i - 1
        int n = nums.length;
        // it can be in 2 states next and current
        dp = new long[n][2];
        // if zero prev not covered and if 1 prev covered
        for(long[] arr : dp){
            Arrays.fill(arr , -1);
        }
        return find(0,1,nums,s);
    }
    public long find(int ind,int prev,int[] nums,String s){
        if(ind == nums.length)return 0;

        if(dp[ind][prev] != -1)return dp[ind][prev];
        long profit = 0;
        char ch = s.charAt(ind);

        if(ch == '0'){
           profit = find(ind + 1,0,nums,s);
        }else{
            // if prev not covered
            // take current
            profit = nums[ind] + find(ind + 1,1,nums,s);

            if(prev == 0){
                profit = Math.max(profit , nums[ind - 1] + find(ind + 1 , 0,nums,s));
            }
        }
        return dp[ind][prev] = profit;
    }
}