class Solution {

    // Updates the 'vec' array based on the set bits in the number.
    private void update(int number, List<Integer> vec, int val) {
        for (int i = 0; i < 32; i++) { // O(32)
            if ((number >> i & 1) == 1) {
                vec.set(i, vec.get(i) + val);
            }
        }
    }

    // Converts the binary representation stored in 'vec' back to a decimal integer.
    private int getDecimalFromBinary(List<Integer> vec) {
        int num = 0;
        for (int i = 0; i < 32; i++) { // O(32)
            if (vec.get(i) > 0) { // ith position has a set bit
                num |= (1 << i);
            }
        }
        return num;
    }

    public int minimumSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        int result = Integer.MAX_VALUE;

        // Initialize 'vec' with 32 zeros to store bit counts
        List<Integer> vec = new ArrayList<>(Collections.nCopies(32, 0));

        int left = 0;

        for (int right = 0; right < n; right++) {// O(n)

            update(nums[right], vec, 1);  // Add nums[j] to the current window

            while (left <= right && getDecimalFromBinary(vec) >= k) {
                result = Math.min(result, right - left + 1);
                update(nums[left], vec, -1); // Remove nums[i] from the window
                left++;
            }
        }


        return result == Integer.MAX_VALUE ? -1 : result;
    }
}