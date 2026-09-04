class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        // no of substrings
        int ans = 0;
        int[]freq = new int[3];
        int[] need = new int[3];
        int curr = 0;
        Arrays.fill(need , 1);
        int left = 0;
        for(int right = 0;right < n;right++){
            int ind = s.charAt(right) - 'a';
            if(ind < 3){
                freq[ind]++;
            }
            if(ind < 3 && freq[ind] <= need[ind])curr++;

            while(curr == 3){
                ans += n - right;
                int rmv = s.charAt(left) - 'a';
                if(rmv < 3){
                    freq[rmv]--;
                    if(freq[rmv] == 0)curr--;
                }
                left++;
            } 
        }
        return ans;
    }
}






