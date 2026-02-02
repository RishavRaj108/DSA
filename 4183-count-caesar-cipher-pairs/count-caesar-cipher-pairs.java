class Solution {
    public long countPairs(String[] words) {
        int n = words.length;
        Map<String , Long> mp = new HashMap<>();
        long ans = 0;
        for(String word : words){
            String str = build(word);
            long cnt = mp.getOrDefault(str, 0L);
            ans += cnt;
            mp.put(str, cnt + 1);
        }
        return ans;
    }
    public String build(String word){
        StringBuilder sb = new StringBuilder();
        char base = word.charAt(0);
        for(int i = 0;i < word.length();i++){
            int val = (word.charAt(i) - base + 26)% 26;
            sb.append(val).append('#');  
        }
        return sb.toString();
    }
}