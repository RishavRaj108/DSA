class Solution {
    public int countOfSubstrings(String word, int k) {
        return atLeast(word, k) - atLeast(word, k + 1);
    }
    
    private int atLeast(String word, int k) {
        Map<Character, Integer> vowels = new HashMap<>();
        int left = 0, consonants = 0, count = 0;
        int n = word.length();
        
        for (int right = 0; right < n; right++) {
            char ch = word.charAt(right);
            if ("aeiou".indexOf(ch) >= 0) {
                // vowels.merge(ch, 1, Integer::sum);
                vowels.put(ch , vowels.getOrDefault(ch , 0) + 1);
            } else {
                consonants++;
            }
            
            // Shrink while window is valid (has all vowels AND >= k consonants)
            while (vowels.size() == 5 && consonants >= k) {
                count += (n - right);  // All extensions of this window are valid
                char leftChar = word.charAt(left);
                if ("aeiou".indexOf(leftChar) >= 0) {
                    // vowels.merge(leftChar, -1, Integer::sum);
                    vowels.put(leftChar , vowels.get(leftChar) - 1);
                    if (vowels.get(leftChar) == 0) vowels.remove(leftChar);
                } else {
                    consonants--;
                }
                left++;
            }
        }
        return count;
    }
}