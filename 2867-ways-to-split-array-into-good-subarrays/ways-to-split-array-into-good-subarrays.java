class Solution {
    public int numberOfGoodSubarraySplits(int[] nums) {
        long mod = 1000000007;
        long ans = 1;
        int prev = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                // first 1
                if (prev == -1) {
                    prev = i;
                }
                else {
                    // choices between consecutive 1s
                    ans = (ans * (i - prev)) % mod;
                    prev = i;
                }
            }
        }
        // no 1 present
        if (prev == -1) return 0;
        return (int) ans;
    }
}