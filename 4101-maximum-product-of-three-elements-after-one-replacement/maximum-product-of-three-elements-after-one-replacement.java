class Solution {
    public long maxProduct(int[] nums) {
        int ans = 0, max1 = 0,max2 = 0;
        for(int i = 0;i < nums.length;i++){
            int num = Math.abs(nums[i]);
            if(num > max1){
                max2 = max1;
                max1 = num; 
            }else if(num > max2)max2 = num;
        }
        return (long)100000 * (long)max1 * max2;
    }
}