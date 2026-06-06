class Solution {
    public int minimumPartition(String s, int k) {
        int n = s.length();

        int cnt = 0;
        long num = 0;
        for (int i = 0; i < n; i++) {
            int digit = Integer.parseInt(s.substring(i, i + 1));
            if (k < digit || num > k)
                return -1;
            num = num * 10 + digit;
            if (num > k) {
                // cnt the previous no and make the curr dig to num
                cnt++;
                num = digit;
            }
            if (i + 1 == n && num <= k) {
                cnt++;
            }
        }
        return cnt;
    }
}