class Solution {
    public int sortPermutation(int[] nums) {
        int ans = 0;
        int n = nums.length;
        Set<Integer> s = new HashSet<>();
        for(int i = 0;i < n;i++){
           if(nums[i] != i){
            s.add(nums[i]);
           }
        }
        if(s.size() == 0)return 0;
        int maxi = 0;
        for(int i = 0;i < 32;i++){
            boolean valid = true;
            for(int num : s){
                if((num & (1 << i)) == 0){
                  valid = false;
                  break;
                }
            }
            if(valid){
                maxi +=  (1 << i);
            }
        }
        return maxi;
    }
}