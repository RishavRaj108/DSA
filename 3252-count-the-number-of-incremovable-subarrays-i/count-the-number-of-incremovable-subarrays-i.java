class Solution {
    public int incremovableSubarrayCount(int[] nums) {
        int n = nums.length;
        int cnt = 0;
        for(int i = 0;i < n;i++){
            for(int j = i;j < n;j++){
                // now for each i and j remove it
                boolean check = true;
                int prev = -1;
                for(int k = 0;k < n;k++){
                    if(k >= i && k <= j){
                        continue;
                    }
                    if(nums[k] <= prev){
                        check = false;
                        break;
                    }
                    prev = nums[k];
                }
                if(check){
                    cnt++;
                }
            }
        }
        return cnt;
    }
}