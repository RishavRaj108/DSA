class Solution {
    public int minimumDeletions(String word, int k) {
        int[] freq = new int[26];
        for(char ch: word.toCharArray()){
            freq[ch - 'a']++;
        }

        // freq[i] - freq[j] <= k
        // so freq[i] + k <= freq[j]
        // freq[j] - freq[i] - k >= 0;

        int ans = Integer.MAX_VALUE;
        for(int i = 0;i < 26;i++){
            int cnt = 0;
            for(int j = 0;j < 26;j++){
                if(i == j)continue;
                if(freq[j] < freq[i]){
                    cnt+= freq[j];
                }
                if(freq[j] - freq[i] - k >= 0){
                    cnt += freq[j] - freq[i] - k;
                }
            }
            ans = Math.min(ans , cnt);
        }
        return ans;
    }
}