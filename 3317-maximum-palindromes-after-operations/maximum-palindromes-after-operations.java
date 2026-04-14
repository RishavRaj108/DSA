class Solution {
    public int maxPalindromesAfterOperations(String[] words) {
        int[] chars = new int[26];
        for(String str : words){
            for(char ch : str.toCharArray()){
                chars[ch - 'a']++;
            }
        }
        int pairs = 0;
        int odds = 0;
        for(int val : chars){
            pairs += val / 2;
            odds += val % 2;
        }
        Arrays.sort(words , (a,b) -> a.length() - b.length());
        int cnt = 0;
        
        for(String str : words){
            int len = str.length();
            int pair = len / 2;
            if(pairs < pair)break;

            pairs -= pair;

            if(len % 2 == 1){
                if(odds > 0){
                    odds--;
                }else{
                    if(pairs > 0){
                        pairs--;
                        odds++;
                    }
                }
            }
            cnt++;
        }
        return cnt;
      
    }
}