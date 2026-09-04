class Solution {
    public long validSubstringCount(String word1, String word2) {
        int n = word1.length();
        int[] need = new int[26];
        int[] freq = new int[26];
        for (char c : word2.toCharArray()) {
            need[c - 'a']++;
        }
        int left = 0;
        int matched = 0;
        long ans = 0;
        for (int right = 0; right < n; right++) {
            int idx = word1.charAt(right) - 'a';
            freq[idx]++;
            // This character contributes to satisfying word2
            if (freq[idx] <= need[idx]) {
                matched++;
            }
            // Window is valid
            while (matched == word2.length()) {
                // Every substring starting at 'left'
                // and ending at right or later is valid
                ans += n - right;
                int remove = word1.charAt(left) - 'a';
                freq[remove]--;
                if (freq[remove] < need[remove]) {
                    matched--;
                }
                left++;
            }
        }
        return ans;
    }
}