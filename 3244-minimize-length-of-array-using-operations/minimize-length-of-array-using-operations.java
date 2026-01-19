class Solution {
    public int minimumArrayLength(int[] nums) {
        int m = nums[0];
        for(int n : nums) m = Math.min(m,n);
        for(int n : nums) if(n % m > 0)return 1;
        int cnt = 0;
        for(int n : nums) if(n == m)cnt++;
        return (cnt + 1)/ 2; 
    }
}