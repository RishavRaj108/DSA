class Solution {
    private Map<Integer, Long> totalDamageMap;
    private List<Integer> vals;
    private Long[] memo;
    public long maximumTotalDamage(int[] power) {
        // Step 1: Count total accumulated damage for each unique value
        totalDamageMap = new HashMap<>();
        for (int p : power) {
            totalDamageMap.put(p, totalDamageMap.getOrDefault(p, 0L) + p);
        }
        // Step 2: Sort unique spell values
        vals = new ArrayList<>(totalDamageMap.keySet());
        Collections.sort(vals);
        int n = vals.size();
        memo = new Long[n];
        // Solve recursively starting from the last index down to 0
        return solve(n - 1);
    }
    private long solve(int i) {
        // Base case: no elements left
        if (i < 0) {
            return 0;
        }
        // Return memoized result if already computed
        if (memo[i] != null) {
            return memo[i];
        }
        // Choice 1: Skip vals.get(i)
        long skip = solve(i - 1);
        // Choice 2: Take vals.get(i)
        // Find the largest index `prev` where vals.get(prev) < vals.get(i) - 2
        int prev = findLastValidIndex(i);
        long take = totalDamageMap.get(vals.get(i)) + solve(prev);
        return memo[i] = Math.max(take, skip);
    }

    // Binary search to find largest index with value < vals.get(index) - 2
    private int findLastValidIndex(int index) {
        int target = vals.get(index) - 2;
        int low = 0, high = index - 1;
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (vals.get(mid) < target) {
                ans = mid;      // Possible valid index, try to find a larger one
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
}