class Solution {
    public String removeSubstring(String s, int k) {
        StringBuilder str = new StringBuilder();
        int openCount = 0;

        for (char c : s.toCharArray()) {
            str.append(c);
            if (c == '(') {
                openCount++;
            } else {
                if (str.length() >= 2 * k && openCount >= k) {
                    int len = str.length();
                    boolean valid = true;

                    for (int i = len - 2 * k; i < len - k; i++) {
                        if (str.charAt(i) != '(') {
                            valid = false;
                            break;
                        }
                    }
                    for (int i = len - k; i < len; i++) {
                        if (str.charAt(i) != ')') {
                            valid = false;
                            break;
                        }
                    }

                    if (valid) {
                        str.setLength(str.length() - 2 * k);
                        openCount -= k;
                    }
                }
            }
        }

        return str.toString();
    }
}