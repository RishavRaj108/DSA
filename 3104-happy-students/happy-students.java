class Solution {
    public int countWays(List<Integer> nums) {
        // task is to make all student happy
        // if selected students > nums[i] then we can select this std
        // if selected student < nums[i] then not selected
        // if at any spot no of elements including it > nums[i] this is selection block but next should not be selected

        // we can select any group present in nums in any order

        Collections.sort(nums);
        int n = nums.size();

        int cnt = 0;
        if(nums.get(0) > cnt){
            cnt++;
        }
        // 0 2 3 3 6 6 7 7
        // t std > nums[i] then i selected
        // t std < nums[i] then i not selected
        for(int i = 1;i < n;i++){
           if(nums.get(i - 1) < i && nums.get(i) > i){
            cnt++;
           }
        }
        if(nums.get(n - 1) < n){
            cnt++;
        }
        return cnt;

    }
}