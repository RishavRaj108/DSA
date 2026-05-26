class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        // i have to find all pairs under this range

        int n = nums.length;
        long cnt = 0;
        Arrays.sort(nums);
        for(int i = 0;i < n;i++){
           int num = nums[i];
           int nl = lower - num;
           int nu = upper - num + 1;
           int left = lowerBound(nums , i + 1, n - 1, nl);
           int right = lowerBound(nums , i + 1,n - 1, nu);
           cnt += right - left;
        }
        return cnt;
    }
    public int lowerBound(int[] nums , int l,int r,int target){
        while(l <= r){
            int mid = l + ( r - l)/ 2;

            if(nums[mid] >= target){
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return l;
    }
}