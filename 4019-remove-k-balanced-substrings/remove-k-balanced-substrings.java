class Solution {
    public String removeSubstring(String s, int k) {
        int n = s.length();

        char[] stack = new char[n];
        int[] run = new int[n];
        int top = 0;

        for (char ch : s.toCharArray()) {

            stack[top] = ch;

            if (top > 0 && stack[top - 1] == ch) {
                run[top] = run[top - 1] + 1;
            } else {
                run[top] = 1;
            }

            top++;

            // Check whether suffix is k '(' followed by k ')'
            if (top >= 2 * k && stack[top - 1] == ')') {

                int closeCount = run[top - 1];

                if (closeCount >= k) {

                    int openEnd = top - k - 1;

                    if (openEnd >= 0 &&
                        stack[openEnd] == '(' &&
                        run[openEnd] >= k) {

                        // Remove the whole k-balanced substring
                        top -= 2 * k;
                    }
                }
            }
        }

        return new String(stack, 0, top);
    }
}