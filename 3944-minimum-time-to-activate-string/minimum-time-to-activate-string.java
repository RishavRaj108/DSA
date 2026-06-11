class Solution {
    public int minTime(String s, int[] order, int k) {
        int n = s.length();

        long total = 1L * n * (n + 1) / 2;

        if (total < k) return -1;

        int low = 0, high = n - 1;
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isActive(mid, order, n, total, k)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    private boolean isActive(int t, int[] order, int n,
                             long total, int k) {

        boolean[] star = new boolean[n];

        for (int i = 0; i <= t; i++) {
            star[order[i]] = true;
        }

        long invalid = 0;
        int len = 0;

        for (int i = 0; i < n; i++) {
            if (!star[i]) {
                len++;
            } else {
                invalid += 1L * len * (len + 1) / 2;
                len = 0;
            }
        }

        invalid += 1L * len * (len + 1) / 2;

        long valid = total - invalid;

        return valid >= k;
    }
}