class Solution {
    public long countGood(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> mp = new HashMap<>();
        long pairs = 0;
        long count = 0;
        int left = 0;
        for(int right = 0;right < n;right++){
            int no = nums[right];
            mp.put(no , mp.getOrDefault(no , 0) + 1);
            if(mp.get(no) >= 2){
                int cnt = mp.get(no);
                pairs -= (1L * (cnt - 2) * (cnt - 1))/2;
                pairs += (1L * cnt * (cnt - 1))/2;
            }
            while(pairs >= k){
                count += n - right;
                int leftNo = nums[left];
                int cnt = mp.get(leftNo);
                long prevCnt = (1L * cnt * (cnt - 1))/2;
                pairs -= prevCnt;
                cnt--;
                prevCnt = (1L * cnt * (cnt - 1))/2;
                pairs += prevCnt;
                mp.put(leftNo , mp.get(leftNo) - 1);
                left++;
            }
        }
        return count;
    }
}