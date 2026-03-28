class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int n = colors.length;
        int[] extend = new int[n + k - 1];
        for(int i = 0;i < n;i++){
            extend[i] = colors[i];
        }
        for(int i = 0;i < k - 1;i++){
            extend[i + n] = colors[i];
        }

        // now normal sliding window
        int left = 0;
        int cnt = 0;
        for(int right = 1;right < extend.length;right++){
           if(extend[right - 1] == extend[right]){
            left = right;
           }
           if(right - left + 1 == k){
            cnt++;
            left++;
           }
        }
        return cnt;
    }
}