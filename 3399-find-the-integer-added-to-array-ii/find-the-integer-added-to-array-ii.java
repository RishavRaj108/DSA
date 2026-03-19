class Solution {
    public int minimumAddedInteger(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int ans = Integer.MAX_VALUE;
        for(int i = 0;i < 3;i++){
            int skip = 0;
            int diff = nums2[0] - nums1[i];
            int k = 0;
            for(int j =0;j < nums1.length;j++){
                if(k < nums2.length && nums2[k] - diff == nums1[j]){
                    k++;
                }else{
                    skip++;
                }
            }

            if(skip == 2){
                ans = Math.min(ans , diff);
            }
        }
        return ans;
    }
}