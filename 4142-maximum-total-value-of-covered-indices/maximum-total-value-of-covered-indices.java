class Solution {
    long[][] dp;
    public long maxTotal(int[] nums, String s) {
        int n = nums.length;
        dp = new long[n][2];
        for(long[] arr : dp){
            Arrays.fill(arr , -1);
        }
        return find(0,1,nums,s);
    }
    public long find(int i,int prevCov,int[] nums,String s){
        if(i == nums.length)return 0;
        if(dp[i][prevCov] != -1)return dp[i][prevCov];
        long val = 0;
        if(s.charAt(i) == '0'){
          val = find(i + 1,0,nums,s);
        }else{
           val =nums[i] + find(i + 1,1,nums,s);
           if(prevCov == 0){
            val = Math.max(val , nums[i - 1] + find(i + 1 , 0 , nums,s));
           }
        }
        return dp[i][prevCov] = val;
    }
}