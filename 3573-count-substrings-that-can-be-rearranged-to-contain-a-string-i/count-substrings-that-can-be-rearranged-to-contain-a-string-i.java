class Solution {
    public long validSubstringCount(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        long res = 0;
        int[] freq = new int[26];
        for(char ch : word2.toCharArray()){
           freq[ch - 'a']++;
        }
        // freq is the need
        int match = 0;
        int[] curr = new int[26];
        int left = 0;
        for(int right = 0;right < n;right++){
            int ch = word1.charAt(right) - 'a';
            curr[ch]++;
            if(curr[ch] <= freq[ch]){
                match++;
            }
            while(match == m){
                int leftCh = word1.charAt(left) - 'a';
                curr[leftCh]--;
                if(curr[leftCh] < freq[leftCh])match--;
                left++;
                res += n - right;
            }
        }
        return res;
    }
}








