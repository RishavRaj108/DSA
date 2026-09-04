class Solution {
    public long validSubstringCount(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int[]req = new int[26];
        int[]curr = new int[26];
        for(char ch : word2.toCharArray()){
            int ind = ch - 'a';
            req[ind]++;
        }
        long ans = 0;
        int left = 0;
        int matched = 0;
        for(int right = 0;right < n;right++){
            int ind = word1.charAt(right) - 'a';
            curr[ind]++;
            if(curr[ind] <= req[ind]){
                matched++;
            }

            while(matched == m){
                ans += n - right;
                int rmv = word1.charAt(left) - 'a';
                curr[rmv]--;
                if(curr[rmv] < req[rmv]){
                    matched--;
                }
                left++;
            }

        }
        return ans;
    }
}









