class Solution {
    public long countSubarrays(int[] nums, long k) {
        int n = nums.length;
        TreeMap<Integer , Integer> mp = new TreeMap<>();

        long cnt = 0L;
        int left = 0;

        for(int right = 0;right < n;right++){
            int no = nums[right];
            mp.put(no , mp.getOrDefault(no , 0) + 1);

            while((1L * (mp.lastKey() - mp.firstKey()) * (right - left + 1)) > k){
                int noL = nums[left];
                mp.put(noL , mp.get(noL) - 1);
                if(mp.get(noL) == 0){
                    mp.remove(noL);
                }
                left++;
            }
            cnt += right - left + 1;
        }
        return cnt;
    }
}