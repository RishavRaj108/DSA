class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        // calculate one normal form
        // then check for both cases 
        long ans = Integer.MAX_VALUE;
        long min = Math.min(need1 , need2);
        long max = Math.max(need1 , need2);

        ans = (long)cost1 * need1 + (long)cost2 * need2;
        ans = Math.min(ans , (long)min * costBoth + (long)((need1 - min) * cost1) + (long)((need2 - min ) * cost2));
        ans = Math.min(ans ,(long) max * costBoth);
        return ans;
    }
}