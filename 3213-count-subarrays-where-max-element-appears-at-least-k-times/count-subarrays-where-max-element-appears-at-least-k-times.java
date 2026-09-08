class Solution {
    public long countSubarrays(int[] nums, int k) {
        int n = nums.length;
        int maxi = 0;
        for(int num : nums){
            maxi = Math.max(maxi , num);
        }
        int cnt = 0;

        long ans = 0;
        int left = 0;
        for(int right = 0;right < n;right++){
            int no = nums[right];
            if(no == maxi)cnt++;
            while(cnt == k){
                ans += n - right;
                int leftNo = nums[left];
                if(leftNo == maxi)cnt--;
                left++;
            }
        }
        return ans;
    }
}