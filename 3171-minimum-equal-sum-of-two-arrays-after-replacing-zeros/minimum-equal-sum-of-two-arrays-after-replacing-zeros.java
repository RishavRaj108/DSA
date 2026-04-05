class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        long s1 = 0;
        long z1 = 0;
        long s2 = 0;
        long z2 = 0;
        for(int num : nums1){
            if(num == 0){
                z1++;
            }else{
                s1 += num;
            }
        }
        for(int num : nums2){
            if(num == 0){
                z2++;
            }else{
                s2 += num;
            }
        }
        
        if(z1 == 0 && (s1 < s2 + z2 ))return -1;
        if(z2 == 0 && (s1 + z1 >  s2 ))return -1;

        if(z1 > 1){
            s1 += z1 - 1;
            z1 = 1;
        }
        if(z2 > 1){
            s2 += z2 - 1;
            z2 = 1;
        }
        // now b0th are having 1 zero in each at max or none
        long ans = Math.max(s1 , s2);
        if(ans == s1 && z1 == 0)return s1;
        if(ans == s2 && z2 == 0)return s2;
        return ans + 1;
    }
}