class Solution {
    public long minOperations(int[] nums1, int[] nums2, int k) {
        long cnt = 0;
        int n = nums1.length;

        long div = 0;

        
        long more = 0;
        long less = 0;
        for(int i = 0;i < n;i++){
            if(nums1[i] != nums2[i]){
                if(k == 0)return -1;
              if(nums1[i] > nums2[i]){
                more += nums1[i] - nums2[i];
                if(more % k != 0)return -1;
              }else{
                less += nums2[i] - nums1[i];
                if(less % k != 0)return -1;
              }
            }
        }
        if(k == 0) return 0;
        long md =  more / k;
        long ld = less / k;
        if(md == ld){
            return md;
        }
        return -1;
    }
}