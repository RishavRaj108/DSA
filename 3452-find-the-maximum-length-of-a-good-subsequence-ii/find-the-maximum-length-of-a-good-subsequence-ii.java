import java.util.*;

class Solution {
    public int maximumLength(int[] nums, int k) {
        // dp[j] → map of value -> max length
        Map<Integer, Integer>[] dp = new HashMap[k + 1];
        for (int i = 0; i <= k; i++) {
            dp[i] = new HashMap<>();
        }

        int[] best = new int[k + 1];

        for (int num : nums) {
            // traverse backwards to avoid overwrite
            for (int j = k; j >= 0; j--) {

                int same = dp[j].getOrDefault(num, 0) + 1;

                int diff = 1;
                if (j > 0) {
                    diff = best[j - 1] + 1;
                }

                int curr = Math.max(same, diff);

                dp[j].put(num, Math.max(dp[j].getOrDefault(num, 0), curr));

                best[j] = Math.max(best[j], dp[j].get(num));
            }
        }

        int ans = 0;
        for (int j = 0; j <= k; j++) {
            ans = Math.max(ans, best[j]);
        }

        return ans;
    }
}