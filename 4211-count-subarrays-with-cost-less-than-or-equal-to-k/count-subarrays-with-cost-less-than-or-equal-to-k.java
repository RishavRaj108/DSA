class Solution {
    public long countSubarrays(int[] nums, long k) {
        TreeMap<Integer, Integer> mp = new TreeMap<>();
        long ans = 0;
        int i = 0;
        int n = nums.length;
        for (int j = 0; j < n; j++) {
            // Add nums[j]
            mp.put(nums[j], mp.getOrDefault(nums[j], 0) + 1);
            // Shrink window while cost > k
            while (1L * (mp.lastKey() - mp.firstKey()) * (j - i + 1) > k) {
                mp.put(nums[i], mp.get(nums[i]) - 1);
                if (mp.get(nums[i]) == 0) {
                    mp.remove(nums[i]);
                }
                i++;
            }
            // All subarrays [i..j], [i+1..j], ... [j..j]
            ans += j - i + 1;
        }
        return ans;
    }
}