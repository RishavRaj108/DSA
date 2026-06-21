class Solution {
    public int uniqueXorTriplets(int[] nums) {
        boolean[] pair = new boolean[2048];
        boolean[] ans = new boolean[2048];
        int n = nums.length;
        for(int i = 0;i < n;i++){
            for(int j = i;j < n;j++){
                pair[nums[i] ^ nums[j]] = true;
            }
        }

        for(int i = 0;i < 2048;i++){
            if(pair[i]){
                for(int num : nums){
                    ans[i ^ num] = true; 
                }
            }
        }
        int cnt = 0;
        for(boolean val : ans){
            if(val)cnt++;
        }
        return cnt;
    }
}