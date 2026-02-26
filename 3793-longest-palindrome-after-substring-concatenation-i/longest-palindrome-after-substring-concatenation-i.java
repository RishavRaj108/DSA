class Solution {
    public int longestPalindrome(String s, String t) {
        // compute all palindrom string from one string and store it in a set
        // also compute val of maximum
        // then compute the palindrom for each substring

        // how to check all substring
        int n = s.length();
        int m = t.length();
        int maxi = -1;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                String str1 = s.substring(i, j + 1);
                for (int k = 0; k < m; k++) {
                    for (int l = k; l < m; l++) {
                        String str2 = t.substring(k, l + 1);
                        // check str1 , str2 check str1 + str2
                        if(palindrom(str1)){
                            maxi = Math.max(maxi , str1.length());
                        }
                        if(palindrom(str2)){
                            maxi = Math.max(maxi , str2.length());
                        }
                        String str3 = str1 + str2;
                        if(palindrom(str3)){
                            maxi = Math.max(maxi , str3.length());
                        }
                    }
                }
            }
        }

        return maxi;
    }

    public boolean palindrom(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        return s.equals(sb.reverse().toString());
    }
}