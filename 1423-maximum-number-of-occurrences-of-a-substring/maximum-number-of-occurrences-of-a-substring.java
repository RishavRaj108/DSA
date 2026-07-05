class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        HashMap<String, Integer> map = new HashMap<>(); 
        int maxOccurrences = 0; 
        int left = 0, right = minSize; //window size 
        while (right <= s.length()){
            //count substrings within a window of size minsize
            //all substrings larger than minsize must contain substrings of length equal to minsize, 
            //so there will be at least as many unique substrings of length minsize as any longer length
            String substr = s.substring(left, right); 
            map.put(substr, map.getOrDefault(substr, 0) + 1); 
            left++; right++; //shift window right
        }
           for (String substr : map.keySet()){    
            int count = map.get(substr); 
            if (count > maxOccurrences && isValidSubstring(substr, maxLetters))
                maxOccurrences = count;
        }
        return maxOccurrences;
    }
    public boolean isValidSubstring(String substr, int maxLetters){
        HashSet<Character> counts = new HashSet<>(); 
        for (int i = 0; i < substr.length(); i++){
            char c = substr.charAt(i);
            counts.add(c);
        }
        return counts.size() <= maxLetters;
    }
}