class Solution {
    public long countPairs(String[] words) {
        Map<String , Integer> mp = new HashMap<>();
        for(String word : words){
            String pattern = get(word);
            mp.put(pattern , mp.getOrDefault(pattern , 0) + 1);
        }
        long cnt = 0;
        for(int val : mp.values()){
            cnt += (1L * val * (val - 1))/2;
        }
        return cnt;
    }
    public String get(String s){
       int n = s.length();
       char[] chars = new char[n - 1];
       for(int i = 1;i < n;i++){
        int next = s.charAt(i);
        int prev = s.charAt(i - 1);
        int val = (next - prev + 26)% 26;
        chars[i - 1] = (char) (val + 'a');
       }
       return new String(chars);
    }
}








