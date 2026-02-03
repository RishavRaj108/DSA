class Solution {
    public int minLength(int[] nums, int k) {
        int n = nums.length;
        int left = 0;
        int curSum = 0;
        int minL = Integer.MAX_VALUE;
        HashMap<Integer, Integer> mp = new HashMap<>();
        int right = 0;
        for(;right < n;right++){
            
            mp.put(nums[right] , mp.getOrDefault(nums[right]  , 0) + 1);
            if(mp.get(nums[right]) == 1){
                curSum += nums[right];
            }
            while(curSum >= k){
               minL = Math.min(right - left + 1, minL);
               mp.put(nums[left] , mp.get(nums[left]) - 1);
               if(mp.get(nums[left]) == 0){
                curSum -= nums[left]; 
               }
               left++;
            }
        }
        if(minL == Integer.MAX_VALUE)return -1;
        return minL;
    }
}