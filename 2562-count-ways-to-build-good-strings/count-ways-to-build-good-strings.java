class Solution {
    long mod = 1000000007;
    int[] dp;
    public int countGoodStrings(int low, int high, int zero, int one) {
        dp = new int[high + 1];
        Arrays.fill(dp , -1);
        long val = find(0 , zero , one , low , high);
        return (int)(val % mod);
    }
    public long find(int len , int zero,int one,int low,int high){
        if(len > high)return 0;
        if(dp[len] != -1)return dp[len];
        long cnt = 0;
        if(len >= low)cnt++;
        cnt+= find(len + zero , zero,one,low,high);
        cnt += find(len + one , zero,one,low,high);
        return dp[len] = (int)(cnt % mod);
    }
}