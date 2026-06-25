class Solution {
    public String answerString(String word, int numFriends) {
        int n = word.length();
        if(numFriends == 1)return word;

        int maxLen = n - numFriends + 1;
        String res = "";
        for(int i = 0;i < n;i++){
            int size = Math.min(maxLen , n - i);
            String str = word.substring(i , i + size);
            if(res.compareTo(str) < 0){
              res = str;
            }
        }
        return res;
    }
}