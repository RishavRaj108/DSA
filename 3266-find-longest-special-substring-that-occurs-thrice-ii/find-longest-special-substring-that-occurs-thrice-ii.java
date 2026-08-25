class Solution {
    public int maximumLength(String s) {
        int[][] best = new int[26][3];

        for (int i = 0; i < s.length();) {
            int j = i;

            while (j < s.length() && s.charAt(j) == s.charAt(i)) {
                j++;
            }

            int c = s.charAt(i) - 'a';
            int len = j - i;

            // Store the 3 largest runs
            if (len > best[c][0]) {
                best[c][2] = best[c][1];
                best[c][1] = best[c][0];
                best[c][0] = len;
            } else if (len > best[c][1]) {
                best[c][2] = best[c][1];
                best[c][1] = len;
            } else if (len > best[c][2]) {
                best[c][2] = len;
            }

            i = j;
        }

        int ans = -1;

        for (int c = 0; c < 26; c++) {
            int x = best[c][0];
            int y = best[c][1];
            int z = best[c][2];

            // 3 occurrences from one run
            int candidate1 = x - 2;

            // 2 occurrences from first run + 1 from second
            int candidate2 = Math.min(x - 1, y);

            // 1 occurrence from each of three runs
            int candidate3 = z;

            int candidate = Math.max(
                candidate1,
                Math.max(candidate2, candidate3)
            );

            if (candidate >= 1) {
                ans = Math.max(ans, candidate);
            }
        }

        return ans;
    }
}