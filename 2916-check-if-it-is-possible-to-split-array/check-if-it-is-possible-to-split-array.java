class Solution {
    public boolean canSplitArray(List<Integer> nums, int m) {
        // array is good if len is 1 or sum is more than m

        // split no change in position
        // length of nums = 100

        // just return true

        // task is to split the array
        if(nums.size() == 2 ||nums.size() == 1 )return true;
        
        for(int i = 1;i < nums.size();i++){
            if(nums.get(i - 1) + nums.get(i) >= m){
                return true;
            }
        }
        return false;
    }
}