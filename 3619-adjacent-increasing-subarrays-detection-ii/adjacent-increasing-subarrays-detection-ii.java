class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int n = nums.size();
        int ans = 0;
        int curr =1;
        int prev= 0;
        for(int i = 1;i < n;i++){
            if(nums.get(i) > nums.get(i - 1))curr++;
            else{
                ans = Math.max(ans , curr /2);
                ans = Math.max(ans , Math.min(curr , prev));
                prev = curr;
                curr = 1;
            }
        }
        ans = Math.max(ans , curr /2);
                ans = Math.max(ans , Math.min(curr , prev));
                return ans;
    }
}