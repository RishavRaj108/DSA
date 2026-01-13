class Solution {
    public int countPartitions(int[] nums) {
        // split the array into 2 non empty subarray
        // return number of partitions 
        // where the difference between the sum of the left and right subarrays is even.
        // find the total sum each time we are having sum of subarray then sum of other subsrray is total - sum.
        // sum1 + sum2 = total
        // sum1 - sum2 = even
        int n = nums.length;
        int total = 0;
        for(int i = 0;i < n;i++){
           total += nums[i];
        }
        // for subarray
        int cnt = 0;
        int sum = 0;
        for(int i = 0;i < n - 1;i++){
            sum += nums[i];
            int sum2 = total - sum;
            if((sum2 - sum) % 2 == 0)cnt++;
        }
        return cnt;
    }
}