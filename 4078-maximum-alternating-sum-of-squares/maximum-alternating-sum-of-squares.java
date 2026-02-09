class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        for(int i = 0;i < n;i++){
            nums[i] = Math.abs(nums[i]);
        }
        Arrays.sort(nums);
        long ans = 0;
        int curOpr = 0;// 0 for large and then conver it to 1 for sub the smaller
        int left = 0;
        int right = n - 1;
        while(left <= right){
            if(curOpr == 0){
               curOpr = 1;
               int num = nums[right];
               right--;
               ans += (long)num * num;
            }else{
               curOpr = 0;
               int num = nums[left];
               left++;
               ans -= (long)num * num;
            } 
        }
        return ans;
    }
}