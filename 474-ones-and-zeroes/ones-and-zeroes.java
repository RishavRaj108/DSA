class Solution {
    public int findMaxForm(String[] strs, int m, int nn) {
        int n = strs.length;
        int[][] arr = new int[n][2];
        int i = 0;
        for(String s : strs){
            int one= 0;
            int zero = 0;
            for(char ch : s.toCharArray()){
               if(ch == '0')zero++;
               else one++;
            }
            arr[i][0] = zero;
            arr[i++][1] = one;
        }
        int[][][] dp = new int[n][m + 1][nn + 1];
        for(int[][] arrr : dp){
            for(int[] a : arrr){
                Arrays.fill(a , -1);
            }
        }
        return find(0,m,nn,arr,dp);
    }
    public int find(int ind,int m,int n,int[][] arr,int[][][] dp){
        if(ind >= arr.length)return 0;
        if(m < 0 || n < 0)return Integer.MIN_VALUE/2;
        if(dp[ind][m][n] != -1)return dp[ind][m][n];
        int one = arr[ind][1];
        int zero = arr[ind][0];
        int take = Integer.MIN_VALUE;
        if(m >= zero && n >= one){
          take = 1 + find(ind + 1,m - zero , n - one,arr,dp);
        }
        int noTake = find(ind + 1 , m , n,arr ,dp);
        return dp[ind][m][n] = Math.max(take , noTake);
    }
}