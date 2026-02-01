class Solution {
    public int minimumCost(int[] nums) {
        int first = nums[0];
        int second = 100000000;
        int third = 100000000;
        for(int i = 1;i < nums.length;i++){
            if(second > nums[i]){
                third = second;
                second = nums[i];
            }else if(third > nums[i]){
                third = nums[i];
            }
        }
        return first + second + third;
    }
}