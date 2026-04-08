class Solution {
    public int countWays(List<Integer> nums) {
        Collections.sort(nums);
        int n = nums.size();
        int count = 0;

        // k = 0 case
        if (nums.get(0) > 0) count++;

        // k = 1 to n-1
        for (int k = 1; k < n; k++) {
            if (nums.get(k - 1) < k && nums.get(k) > k) {
                count++;
            }
        }

        // k = n case
        if (nums.get(n - 1) < n) count++;

        return count;
    }
}