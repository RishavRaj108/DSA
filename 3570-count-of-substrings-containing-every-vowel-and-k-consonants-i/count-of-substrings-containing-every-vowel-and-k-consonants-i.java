class Solution {
    public int countOfSubstrings(String word, int k) {
        return atLeast( word , k) - atLeast(word , k+ 1);
    }
    public int atLeast(String word , int k){
        if( k < 0)return 0;

        Map<Character , Integer> vowels = new HashMap<>();

        int consonants = 0;
        int res = 0;
        int left = 0;
        int n = word.length();
        for(int right = 0;right < word.length();right++){
            char ch = word.charAt(right);
            if("aeiou".indexOf(ch) >= 0){
                vowels.put(ch , vowels.getOrDefault(ch , 0) + 1);
            }else{
                consonants++;
            }
            
            // main logic how are we going to count the string which is having k or more than k  consonants
            while(vowels.size() == 5 && consonants >= k){
                res += (n - right);
                char leftCh = word.charAt(left);
                if("aeiou".indexOf(leftCh) >= 0){
                    vowels.put(leftCh , vowels.get(leftCh) - 1);
                    if(vowels.get(leftCh) == 0)vowels.remove(leftCh);
                }else{
                    consonants--;
                }
                left++;
            }
        }
        return res;
    }
}