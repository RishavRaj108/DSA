class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int zeroCnt = 0;
        int multi = 1;
        for(int num : nums){
            if(num == 0){
                zeroCnt++;
                if(zeroCnt > 1)return res;
            }else{
                multi *= num;
            }
        }

        for(int i = 0;i < n;i++){
            int num = nums[i];
            if(zeroCnt == 1){
               if(num == 0)res[i] = multi;
            }else{
                res[i] = multi/num;
            }
        }
        return res;
    }
}