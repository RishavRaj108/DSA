class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums);
        int cnt = 0;
        int prev= Integer.MIN_VALUE;
        for(int i = 0;i < nums.length;i++){
            int mini = nums[i] - k;
            int maxi = nums[i] + k;
            if(mini > prev){
                prev = mini;
                cnt++;
            }else if(prev < maxi){
                prev = prev + 1;
                cnt++;
            }
        }
        return cnt;
    }
}