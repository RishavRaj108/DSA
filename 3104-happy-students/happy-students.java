class Solution {
    public int countWays(List<Integer> nums) {
        // select a group of student
        // i th happy 
        // selected > nums[i]; selected
        // not selected and selected < nums[i]

        // 0 2 3 3 6 6 7 7 

        // if at any moment nums[i] < i + 1 && nums[i + 1] > selected

        int n = nums.size();

        int cnt = 0;

        Collections.sort(nums);

        if(nums.get(0) < 1 && (n == 1 || nums.get(1) > 1)){
            cnt++;
        }
        if(nums.get(0) > 0){
            cnt++;
        }
        if(n == 1)return cnt;
        for(int i = 1;i < n - 1;i++){
            if(nums.get(i) < i + 1 && nums.get(i + 1) > i + 1){
               cnt++;
            }
        }
        if(nums.get(n - 1) < n){
            cnt++;
        }
        return cnt;
    }
}