class Solution {
    public long countPairs(String[] words) {
        Map<String, Long> map = new HashMap<>();
        long ans = 0;

        for (String word : words) {
            String key = buildKey(word);
            long cnt = map.getOrDefault(key, 0L);
            ans += cnt;          // form pairs
            map.put(key, cnt + 1);
        }
        return ans;
    }

    private String buildKey(String s) {
        StringBuilder sb = new StringBuilder();
        char base = s.charAt(0);

        for (int i = 0; i < s.length(); i++) {
            int diff = (s.charAt(i) - base + 26) % 26;
            sb.append(diff).append('#');
        }
        return sb.toString();
    }
}
