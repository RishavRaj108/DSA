class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        // i have to find all fair pairs
        int n = nums.length;
        Arrays.sort(nums);
        long cnt = 0;
        for(int i = 0;i < n;i++){
            int num = nums[i];
            int nl = lower - num;
            int nu = upper - num;
            int left = lowerBound(nums , i + 1,n - 1,nl);
            int right = lowerBound(nums , i + 1,n - 1,nu + 1);
            cnt += right - left;
        }
        return cnt;
    }
    public int lowerBound(int[] nums , int s,int e,int target){
        while(s <= e){
            int mid = s + (e - s)/2;
            if(nums[mid] >= target){
                e = mid - 1;
            }else{
                s = mid + 1;
            }
        }
        return s;
    }
}