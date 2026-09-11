class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp , -1);
        return find(0 , arr , k , dp);
    }
    public int find(int ind,int[] arr,int k,int[] dp){
        if(ind >= arr.length)return 0;
        if(dp[ind] != -1)return dp[ind];

        int maxi = Integer.MIN_VALUE;
        int value = 0;
        for(int i = ind;i < arr.length && i < ind + k;i++){
            maxi = Math.max(maxi , arr[i]);
            value = Math.max(value , maxi * (i - ind + 1) + find(i + 1 ,arr , k , dp));
        }
        return dp[ind] = value;
    }
}