class Solution {
    public int maximumLength(String s) {
        int n = s.length();
        
        // For each char, store list of block lengths
        List<Integer>[] groups = new ArrayList[26];
        for (int i = 0; i < 26; i++) {
            groups[i] = new ArrayList<>();
        }

        // Step 1: build blocks
        int i = 0;
        while (i < n) {
            int j = i;
            while (j < n && s.charAt(j) == s.charAt(i)) j++;
            
            int len = j - i;
            groups[s.charAt(i) - 'a'].add(len);
            i = j;
        }

        int ans = -1;

        // Step 2: process each character
        for (int c = 0; c < 26; c++) {
            List<Integer> list = groups[c];
            if (list.isEmpty()) continue;

            // Sort descending
            Collections.sort(list, Collections.reverseOrder());

            // Try top 3 largest blocks
            for (int k = 1; k <= list.get(0); k++) {
                int count = 0;
                for (int len : list) {
                    if (len >= k) count += (len - k + 1);
                }
                if (count >= 3) {
                    ans = Math.max(ans, k);
                }
            }
        }

        return ans;
    }
}