class Solution {
    public boolean makeStringsEqual(String s, String target) {

        int n = s.length();
        int tone = 0;
        int tzero = 0;
        int one = 0;
        int zero = 0;

        for (int i = 0; i < n; i++) {

            if (s.charAt(i) != target.charAt(i)) {
                if (s.charAt(i) == '0') {
                    zero++;
                } else {
                    one++;
                }
            } else {
                if (s.charAt(i) == '0') {
                    tzero++;
                } else {
                    tone++;
                }
            }
        }

        boolean poss = true;
        if (zero > 0) {
            if (tone == 0 && one == 0) {
                return false;
            }else{
                tone += zero;
            }
        }
        // for managing one we need 2 ones
        if (one > 0) {
            if (tone == 0) {
                return false;
            }
        }

        return poss;
    }
}