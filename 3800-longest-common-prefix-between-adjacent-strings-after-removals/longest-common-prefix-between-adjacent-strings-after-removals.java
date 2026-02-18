class Solution {

    public int[] longestCommonPrefix(String[] words) {
        int n = words.length;
        int[] answer = new int[n];
        
        if (n == 1) return answer;

        int[] lcp = new int[n - 1];

        // Step 1: Compute adjacent LCP
        for (int i = 0; i < n - 1; i++) {
            lcp[i] = getLCP(words[i], words[i + 1]);
        }

        // Step 2: Prefix max
        int[] prefMax = new int[n - 1];
        prefMax[0] = lcp[0];
        for (int i = 1; i < n - 1; i++) {
            prefMax[i] = Math.max(prefMax[i - 1], lcp[i]);
        }

        // Step 3: Suffix max
        int[] suffMax = new int[n - 1];
        suffMax[n - 2] = lcp[n - 2];
        for (int i = n - 3; i >= 0; i--) {
            suffMax[i] = Math.max(suffMax[i + 1], lcp[i]);
        }

        // Step 4: Try removing each index
        for (int i = 0; i < n; i++) {

            int best = 0;

            if (i - 2 >= 0)
                best = Math.max(best, prefMax[i - 2]);

            if (i + 1 <= n - 2)
                best = Math.max(best, suffMax[i + 1]);

            if (i - 1 >= 0 && i + 1 < n)
                best = Math.max(best, getLCP(words[i - 1], words[i + 1]));

            answer[i] = best;
        }

        return answer;
    }

    private int getLCP(String a, String b) {
        int len = Math.min(a.length(), b.length());
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (a.charAt(i) == b.charAt(i))
                count++;
            else
                break;
        }
        return count;
    }
}