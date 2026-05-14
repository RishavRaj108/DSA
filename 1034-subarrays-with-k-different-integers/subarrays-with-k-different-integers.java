class Solution {

    public int subArr(int[] nums,int k){
        int n = nums.length;
        int left = 0;
        int cnt = 0;
        Map<Integer, Integer> mp = new HashMap<>();
        for (int right = 0; right < n; right++) {
            mp.put(nums[right], mp.getOrDefault(nums[right], 0) + 1);

            while (mp.size() > k) {
                mp.put(nums[left], mp.get(nums[left]) - 1);
                if (mp.get(nums[left]) == 0)
                    mp.remove(nums[left]);
                left++;
            }
            cnt += right - left + 1;
        }
        return cnt;
    }

    public int subarraysWithKDistinct(int[] nums, int k) {
        return subArr(nums, k ) - subArr(nums, k -1);
    }
}