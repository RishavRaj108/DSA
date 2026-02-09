class Solution {
    public int longestBalanced(String s) {
        
        int n = s.length();

        int maxL = 0;

        for(int i = 0; i < n; i++) {

            int[] freq = new int[26];
            
            for(int j = i; j < n; j++) {

                freq[s.charAt(j) - 'a']++;

                if(isBalanced(freq)) {
                    maxL = Math.max(maxL, j - i + 1);
                }
            }

            
        }

        return maxL;
    }

    public boolean isBalanced(int[] freq) {

        int val = -1;

        for(int i = 0; i < 26; i++) {

            if(freq[i] == 0) continue;

            if(val == -1) {
                val = freq[i];
            }

            if(freq[i] != val) {
                return false;
            }

        }

        return true;
    }
}