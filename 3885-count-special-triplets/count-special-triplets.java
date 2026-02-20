class Solution {
    public int specialTriplets(int[] nums) {
        int mod = (int)1e9 + 7;
        int n = nums.length;
        Map<Integer,Integer> left = new HashMap<>();
        Map<Integer, Integer> right = new HashMap<>();

        int ans = 0;

        for(int i = 0;i < n;i++){
            right.put(nums[i], right.getOrDefault(nums[i] , 0) + 1);
        }

        for(int i = 0;i < n;i++){
            right.put(nums[i] , right.get(nums[i]) - 1);
            int target = nums[i] * 2;
            int lef = left.getOrDefault(target , 0);
            int righ = right.getOrDefault(target , 0);

            ans = (int)(ans + (1L * lef * righ) % mod)% mod;
            left.put(nums[i] , left.getOrDefault(nums[i] , 0) + 1);
        }
        return ans;
    }
}