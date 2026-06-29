class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
       int maxi = Integer.MIN_VALUE;
       for(int num : nums)maxi = Math.max(num ,maxi);

       int[] freq = new int[maxi + k + 1];
       for(int num : nums)freq[num]++;
       for(int i = 1;i < freq.length;i++){
          freq[i] = freq[i] + freq[i - 1];
       }

       int result = 0;

       for(int target = 0;target < freq.length;target++){
        if(freq[target] == 0)continue;

        int left = Math.max(0 , target - k);
        int right = Math.min(target + k , freq.length - 1);

        int totalCnt = freq[right] - (left > 0? freq[left - 1] : 0);
        int totalTarget = freq[target] - (target > 0? freq[target - 1] : 0);
        int need = totalCnt - totalTarget;
        result = Math.max(result ,totalTarget + Math.min(need ,numOperations));
       } 
       return result;
    }
}