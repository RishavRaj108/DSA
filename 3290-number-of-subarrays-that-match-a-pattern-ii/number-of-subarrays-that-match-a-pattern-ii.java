class Solution {
    public int countMatchingSubarrays(int[] nums, int[] pattern) {
        int n = nums.length;
        int m = pattern.length;

        // Step 1: Build diff array
        int[] diff = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            if (nums[i + 1] > nums[i]) diff[i] = 1;
            else if (nums[i + 1] == nums[i]) diff[i] = 0;
            else diff[i] = -1;
        }

        // Step 2: Build LPS (KMP)
        int[] lps = new int[m];
        for (int i = 1, len = 0; i < m;) {
            if (pattern[i] == pattern[len]) {
                lps[i++] = ++len;
            } else {
                if (len != 0) len = lps[len - 1];
                else i++;
            }
        }

        // Step 3: KMP search
        int i = 0, j = 0, count = 0;

        while (i < diff.length) {
            if (diff[i] == pattern[j]) {
                i++; j++;
            }

            if (j == m) {
                count++;
                j = lps[j - 1];
            } else if (i < diff.length && diff[i] != pattern[j]) {
                if (j != 0) j = lps[j - 1];
                else i++;
            }
        }

        return count;
    }
}