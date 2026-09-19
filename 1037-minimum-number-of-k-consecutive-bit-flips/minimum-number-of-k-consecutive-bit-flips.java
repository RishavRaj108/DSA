class Solution {
    public int minKBitFlips(int[] nums, int k) {
        int n = nums.length;
        int[] prefix = new int[n];
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            // Number of flips affecting index i
            if (i > 0) {
                prefix[i] += prefix[i - 1];
            }
            int no = nums[i];
            // Odd number of flips means current bit is reversed
            if (prefix[i] % 2 == 1) {
                no = 1 - no;
            }
            // Already 1 -> nothing to do
            if (no == 1) {
                continue;
            }
            // Need to start a k-length flip here
            if (i + k > n) {
                return -1;
            }
            cnt++;
            // This flip starts affecting from i
            prefix[i]++;
            // This flip stops affecting from i + k
            if (i + k < n) {
                prefix[i + k]--;
            }
        }
        return cnt;
    }
}