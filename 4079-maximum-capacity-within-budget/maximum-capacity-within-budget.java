import java.util.*;

class Solution {
    public int maxCapacity(int[] costs, int[] capacity, int budget) {
        int n = costs.length;
        // Store cost and capacity together
        // a[i][0] = cost
        // a[i][1] = capacity
        int[][] a = new int[n][2];
        for (int i = 0; i < n; i++) {
            a[i][0] = costs[i];
            a[i][1] = capacity[i];
        }
        // Sort by cost so binary search can be applied later
        Arrays.sort(a, (x, y) -> x[0] - y[0]);

        // best[i] = maximum capacity available from index [0...i]
        // Helps us quickly get best possible partner item
        int[] best = new int[n];
        best[0] = a[0][1];
        for (int i = 1; i < n; i++) {
            best[i] = Math.max(best[i - 1], a[i][1]);
        }

        int ans = 0;
        // ---------------------------------------------------
        // Case 1: Choose only one item
        // ---------------------------------------------------
        for (int i = 0; i < n; i++) {
            // Cost must be strictly less than budget
            if (a[i][0] < budget) {
                ans = Math.max(ans, a[i][1]);
            }
        }
        // ---------------------------------------------------
        // Case 2: Choose two items
        // ---------------------------------------------------
        for (int j = 1; j < n; j++) {
            // Remaining money allowed for first item
            // total cost must stay < budget
            int rem = budget - a[j][0] - 1;
            // Find rightmost item having cost <= rem
            int i = upperBound(a, rem, j - 1);
            // If valid partner exists
            if (i >= 0) {
                // best[i] gives maximum capacity till index i
                ans = Math.max(ans, best[i] + a[j][1]);
            }
        }
        return ans;
    }

    // Binary search:
    // Returns rightmost index having cost <= val
    private int upperBound(int[][] a, int val, int hi) {
        int l = 0, r = hi;
        int ans = -1;
        while (l <= r) {
            int m = (l + r)/2;
            if (a[m][0] <= val) {
                ans = m;
                l = m + 1; // try finding bigger valid index
            } else {
                r = m - 1;
            }
        }
        return ans;
    }
}