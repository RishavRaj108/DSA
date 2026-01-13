class Solution {
    public int countPartitions(int[] nums) {
        int total = 0;
        for(int i = 0;i < nums.length;i++){
            total += nums[i];

        }
        if(total % 2 != 0)return 0;
        return nums.length - 1;
    }
}