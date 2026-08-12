class Solution {
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        int[] freqArr = new int[101];
        for(int i = 0;i <= k - 1;i++){
            int num = nums[i];
            // so index - 50
            int pos = num + 50;
            freqArr[pos]++;
        }
        int ind = 0;
        for(int i = k;i < n;i++){
           int find = findXthNeg(freqArr , x);
           res[ind++] = find;
           int pos = nums[i - k] + 50;
           freqArr[pos]--;
           pos = nums[i] + 50;
           freqArr[pos]++;
        }
        int find = findXthNeg(freqArr , x);
        res[ind++] = find;
        return res;
    }
    public int findXthNeg(int[] freq , int x){
       int count = 0;

        for (int i = 0; i < 50; i++) {

            count += freq[i];

            if (count >= x) {
                return i - 50;
            }
        }

        return 0;
    }
}