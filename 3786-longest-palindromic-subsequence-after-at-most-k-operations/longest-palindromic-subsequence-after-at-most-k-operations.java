class Solution {
    int[][][] dp;
    public int longestPalindromicSubsequence(String s, int k) {
        int n = s.length();
        dp = new int[n][n][k + 1];
        for(int[][] arr : dp){
            for(int[] row : arr){
                Arrays.fill(row , -1);
            }
        }

        return find(0,n - 1,s,k);
    }
    public int find(int l,int r,String s,int k){
        if(l > r)return 0;
        if(l == r)return 1;
        if(dp[l][r][k] != -1)return dp[l][r][k];

        if(s.charAt(l) == s.charAt(r)){
            return dp[l][r][k] =2 + find(l + 1,r - 1,s,k);
        }

        int ans = Math.max(find(l + 1,r,s,k) , find(l , r - 1,s,k));

        int diff = Math.abs(s.charAt(l) - s.charAt(r));
        int cost = Math.min(diff , 26 - diff);
        if(cost <= k){
            ans = Math.max(ans , 2 + find(l + 1,r - 1,s,k - cost));
        }
        return dp[l][r][k] = ans;
    }
}






