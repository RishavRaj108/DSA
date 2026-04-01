class Solution {
    public long largestPerimeter(int[] nums) {
        int n = nums.length;
        long sum = 0;
        for(int num : nums){
            sum += num;
        }

        // now try each possiblity
        Arrays.sort(nums);
        for(int i = n - 1;i >= 0;i--){
            // now here we are going to sub the val at this pos from sum if sum > that val then this is possible
            if(i < 2){
                return -1;
            }
            long val = nums[i];
            long other = sum - val;
            if(other > val){
                return sum;
            }else{
                sum -= val;
            }
        }
        return sum;
    }
}