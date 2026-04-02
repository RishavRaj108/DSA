class Solution {
    public int incremovableSubarrayCount(int[] nums) {
        int n = nums.length;
        int cnt = 0;
        for(int i = 0;i < n;i++){
            for(int j = i;j < n;j++){
                // now for each i and j remove it
                List<Integer> ls = new ArrayList<>();
                for(int k = 0;k < n;k++){
                    if(k >= i && k <= j){
                        continue;
                    }
                    ls.add(nums[k]);
                }
                if(check(ls)){
                    cnt++;
                }
            }
        }
        return cnt;
    }
    public boolean check(List<Integer> ls){
        for(int i = 1;i < ls.size();i++){
            if(ls.get(i) <= ls.get(i - 1)){
                return false;
            }
        }
        return true;
    }
}