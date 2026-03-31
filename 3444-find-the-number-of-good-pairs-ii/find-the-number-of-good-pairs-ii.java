class Solution {
    public long numberOfPairs(int[] nums1, int[] nums2, int k) {
          // Step 1: Store frequency of nums2 elements
        // Why? Because nums2 can have duplicates
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums2) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        long ans = 0;

        // Step 2: Traverse nums1
        for (int x : nums1) {

            // IMPORTANT: If x is not divisible by k, skip
            // Because x % (y * k) can never be 0
            if (x % k != 0) continue;

            // Reduce problem
            int val = x / k;

            // Step 3: Find all divisors of val
            // Only divisors can satisfy val % y == 0
            for (int d = 1; d * d <= val; d++) {

                if (val % d == 0) {

                    // First divisor = d
                    if (freq.containsKey(d)) {
                        ans += freq.get(d); // add its frequency
                    }

                    // Second divisor = val / d
                    int other = val / d;

                    // Avoid double counting when d == other
                    if (other != d && freq.containsKey(other)) {
                        ans += freq.get(other);
                    }
                }
            }
        }

        return ans;
    }
}