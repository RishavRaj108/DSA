class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int ans = 0;
        int n = nums.length;
        for(int i = 0;i < n;i++){
            int cnt = 0;
            for(int j = i;j < n;j++){
               int num = nums[j];
               if(num == target){
                cnt++;
               }
               if((j - i + 1)/ 2 < cnt)ans++;
            }
        }
        return ans;
    }
}