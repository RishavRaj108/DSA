class Solution {
    public int minOperations(int[] nums, int[] target) {
        int n = nums.length;
        HashSet<Integer> st = new HashSet<>();
        for(int i = 0;i < n;i++){
            if(nums[i] != target[i] && !st.contains(nums[i])){
               st.add(nums[i]);
            }
        }
        return st.size();
    }
}