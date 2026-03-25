class Solution {
    public int minimumPushes(String word) {
        int n = word.length();
        int[] chars = new int[26];
        for(int i = 0;i < n;i++){
            chars[word.charAt(i) - 'a']++;
        }
        Arrays.sort(chars);
        // 8 possiblity for each num
        int cnt = 0;
        int val = 1;
        int occur = 1;
        for(int i = 25;i >= 0;i--){
           if(occur > 8){
            val++;
            occur = 1;
           }
           cnt += chars[i] * val;
           occur++;
        }
        return cnt;
    }
}