class Solution {
    public int minimumDeletions(String word, int k) {
        int[] freq = new int[26];

        for(char ch : word.toCharArray()){
            freq[ch - 'a']++;
        }

        int res= Integer.MAX_VALUE;

        for(int i = 0;i < 26;i++){
            int dele = 0;
            for(int j = 0;j < 26;j++){
                if(i == j)continue;
                if(freq[j] < freq[i]){
                    dele += freq[j];
                }else if(Math.abs(freq[j] - freq[i]) > k){
                    dele += Math.abs(freq[j] - freq[i] -k);
                }
            }
            res = Math.min(res , dele);
        }
        return res;
    }
}