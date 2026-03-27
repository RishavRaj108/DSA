class Solution {
    public long maximumTotalDamage(int[] power) {
        // Step 1: frequency map
        Map<Integer, Long> map = new HashMap<>();
        for (int p : power) {
            map.put(p, map.getOrDefault(p, 0L) + p);
        }

        // Step 2: sort unique values
        int n = map.size();
        int[] vals = new int[n];
        int idx = 0;
        for (int key : map.keySet()) vals[idx++] = key;
        Arrays.sort(vals);

        // Step 3: precompute next non-conflicting index
        int[] next = new int[n];
        for (int i = 0; i < n; i++) {
            int j = i + 1;
            while (j < n && vals[j] - vals[i] <= 2) j++;
            next[i] = j;
        }

        // Step 4: memo
        long[] dp = new long[n];
        Arrays.fill(dp, -1);

        return solve(0, vals, map, next, dp);
    }

    private long solve(int i, int[] vals, Map<Integer, Long> map, int[] next, long[] dp) {
        if (i >= vals.length) return 0;

        if (dp[i] != -1) return dp[i];

        // Option 1: skip
        long skip = solve(i + 1, vals, map, next, dp);

        // Option 2: take
        long take = map.get(vals[i]) + solve(next[i], vals, map, next, dp);

        return dp[i] = Math.max(skip, take);
    }
}