class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        
        int evenCount = 0, oddCount = 0;
        for (int num : nums) {
            if (num % 2 == 0) evenCount++;
            else oddCount++;
        }
        
        if (Math.abs(evenCount - oddCount) > 1)
            return -1;
        
        // If equal → try both
        if (evenCount == oddCount) {
            return Math.min(
                calculate(nums, 0),
                calculate(nums, 1)
            );
        }
        
        // If evens more → must start with even
        if (evenCount > oddCount) {
            return calculate(nums, 0);
        }
        
        // If odds more → must start with odd
        return calculate(nums, 1);
    }
    
    private int calculate(int[] nums, int startParity) {
        int swaps = 0;
        int index = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == startParity) {
                swaps += Math.abs(i - index);
                index += 2;
            }
        }
        
        return swaps;
    }
}