class Solution {
    public long countPairs(String[] words) {
        Map<String, Integer> gapMap = new HashMap<>();
        for (String word : words) {
            String gaps = gap(word);
            gapMap.put(gaps, gapMap.getOrDefault(gaps, 0) + 1);
        }
        long pairs = 0;
        for (int count : gapMap.values()) {
            pairs += (long) count * (count - 1) / 2;
        }
        return pairs;
    }
    private String gap(String word) {
        int n = word.length();
        char[] gaps = new char[n - 1];
        for (int i = 1; i < n; i++) {
            int curr = word.charAt(i);
            int prev = word.charAt(i - 1);
            int diff = (curr - prev + 26) % 26;
            gaps[i - 1] = (char) (diff + 'a');
        }
        return new String(gaps);
    }
}