class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        Map<Integer,Integer> mp = new HashMap<>();

        int cnt = 0;
        int left = 0;
        for(int right = 0;right < n;right++){
            int num = nums[right];
            mp.put(num , mp.getOrDefault(num , 0) + 1);
            while(mp.getOrDefault(num , 0) > k){
                int extra = nums[left];
                mp.put(extra , mp.get(extra) - 1);
                if(mp.get(extra) == 0){
                    mp.remove(extra);
                }
                left++;
            }

            
            cnt = Math.max(cnt , right - left + 1);
        }
        return cnt;
    }
}