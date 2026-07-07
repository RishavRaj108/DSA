class Solution {
    public long calculateScore(String s) {
        long score = 0;
        ArrayDeque<Integer>[] mp = new ArrayDeque[26];
        for (int i = 0; i < 26; i++) {
            mp[i] = new ArrayDeque<>();
        }
        for (int i = 0; i < s.length(); i++) {
            int ch = s.charAt(i) - 'a';
            int mirror = 25 - ch;
            if (!mp[mirror].isEmpty()) {
                int j = mp[mirror].pollLast();
                score += i - j;
            } else {
                mp[ch].addLast(i);
            }
        }
        return score;
    }
}