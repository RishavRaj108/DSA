class Solution {
    public int maxAdjacentDistance(int[] nums) {
        // check all adjacent element diff 
        // at the end check for last - first 
        // return the max
        int max =Integer.MIN_VALUE;
        for(int i = 1;i < nums.length;i++){
            int diff = Math.abs(nums[i] - nums[i - 1]);
            if(diff > max)max = diff;
        }
        int last = Math.abs(nums[nums.length - 1] - nums[0]);
        if( last > max)return last;
        return max;

    }
}