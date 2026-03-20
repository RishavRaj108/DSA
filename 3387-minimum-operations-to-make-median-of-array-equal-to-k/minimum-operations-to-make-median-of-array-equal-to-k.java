class Solution {
    public long minOperationsToMakeMedianK(int[] nums, int k) {
        int n = nums.length;

        Arrays.sort(nums);

        int mid = n/2;
        long cnt = 0;

        if(nums[mid] == k)return 0;
        
        cnt += Math.abs(nums[mid] - k);

        nums[mid] = k;
        for(int i = mid - 1;i >= 0;i--){
            int num = nums[i];
            // for left part it should be smaller or equal to k
            if(num <= k)break;
            cnt += num - k;
        }
        for(int i = mid + 1;i < n;i++){
            int num = nums[i];
            // for right part the num should be greater than or equal to k
            if(num >= k)break;
            cnt += k - num;
        }
        return cnt;
    }
}