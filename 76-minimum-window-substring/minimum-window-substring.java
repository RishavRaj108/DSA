class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();
        String best = "";
        int[] freq = new int[128];
        for(char ch : t.toCharArray()){
            freq[ch]++;
        }
        int[] curr = new int[128];
        int match = 0;
        int left = 0;
        for(int right = 0;right < n;right++){
           curr[s.charAt(right)]++;
           if(curr[s.charAt(right)] <= freq[s.charAt(right)])match++;
           while(match == m){
            String str = s.substring(left , right + 1);
            if(best == "" || best.length() > str.length()){
                best = str;
            }
            curr[s.charAt(left)]--;
            if(curr[s.charAt(left)] < freq[s.charAt(left)])match--;
            left++;
           }
        }
        return best;
    }
}





