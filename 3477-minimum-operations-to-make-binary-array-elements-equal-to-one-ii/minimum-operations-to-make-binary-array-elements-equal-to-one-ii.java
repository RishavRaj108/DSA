class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int cnt = 0;

        int prefix = 0;

        for(int i = 0;i < n;i++){
            int no = nums[i];
            
            if(prefix % 2 != 0){
                no = no == 0?1: 0; 
            }

            if(no == 0){
                prefix++;
                cnt++;
            }
        }
        return cnt;
    }
}