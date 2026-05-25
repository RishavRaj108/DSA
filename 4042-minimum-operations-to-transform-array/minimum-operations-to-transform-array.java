class Solution {
    public long minOperations(int[] nums1, int[] nums2) {
        int n = nums1.length;

        long ans = 0;
        int num = nums2[n];

        int extra = Integer.MAX_VALUE;
        for(int i = 0;i < n;i++){
            ans += Math.abs(nums1[i] - nums2[i]);

            int mini = Math.min(nums1[i] , nums2[i]);
            int maxi = Math.max(nums1[i] , nums2[i]);
            if(num >= mini && num <= maxi) extra = 1;
            else{
                int opr = Math.min(Math.abs(num - nums1[i]) ,Math.abs(num - nums2[i])) + 1;
                extra = Math.min(extra , opr);
            }
        }
        return ans + extra;
    }
}