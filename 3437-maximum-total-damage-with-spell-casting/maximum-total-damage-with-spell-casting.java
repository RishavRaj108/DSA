class Solution {
    Map<Integer, Long> mp;
    public long maximumTotalDamage(int[] power) {
        mp = new HashMap<>();
        for(int p : power){
            mp.put(p , mp.getOrDefault(p , 0L) + p);
        }
        // now get the unique vals and put it in an array
        int n = mp.size();
        int[] vals = new int[n];
        int ind = 0;
        for(int val : mp.keySet()){
            vals[ind++] = val;
        }

        Arrays.sort(vals);

        int[] next = new int[n];
        int j = 0;
        for (int i = 0; i < n; i++) {
            while (j < n && vals[j] - vals[i] <= 2) {
                j++;
            }
            next[i] = j;
        }

        long[] dp = new long[n];
        Arrays.fill(dp , -1);
        return solve(0,vals , next, dp);

    }
    public long solve(int ind , int[] vals , int[] next ,long[] dp){
        if(ind >= vals.length)return 0;
        if(dp[ind] != -1)return dp[ind];

        // now 2 possiblity take and not take
        long take = mp.get(vals[ind]) + solve(next[ind] , vals, next,dp);
        long notake = solve(ind + 1 , vals,next,dp);
        return dp[ind] = Math.max(take, notake);
    }
}