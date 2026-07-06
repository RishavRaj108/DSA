class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        Map<String  , Integer> mp = new HashMap<>();
        
        for(int i = 0;i <= s.length() - minSize;i++){
            String str = s.substring(i , i + minSize);
            mp.put(str , mp.getOrDefault(str , 0) + 1);
        }
        int maxi = 0;
        for(String str : mp.keySet()){
            if(isValid(str , maxLetters)){
                maxi = Math.max(maxi , mp.get(str));
            }
        }
        return maxi;
    }
    public boolean isValid(String s , int cnt){
        Set<Character> st = new HashSet<>();
        for(char ch : s.toCharArray()){
            st.add(ch);
        }
        return st.size() <= cnt;
    }
}