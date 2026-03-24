class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int n = colors.length;
        int[] extended = new int[n + k - 1];
        for(int i = 0;i < n;i++){
            extended[i] = colors[i];
        }
        for(int i = 0;i < k - 1;i++){
            extended[i + n] = colors[i];
        }

        int cnt = 0;
        int left = 0;
        for(int right = 1;right < extended.length;right++){
            // now check if it is valid or not 
            if(extended[right] == extended[right - 1]){
                left = right;
                continue;
            }

            if(right - left + 1 == k){
                cnt++;
                left++;
            }

        }
        return cnt;
    }
}