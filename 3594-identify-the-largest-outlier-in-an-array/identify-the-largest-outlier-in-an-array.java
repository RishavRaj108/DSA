class Solution {
    public int getLargestOutlier(int[] nums) {
        int n = nums.length;
        int sum = 0;
        Map<Integer,Integer> mp = new HashMap<>();

        for(int i = 0;i < n;i++){
            sum += nums[i];
            mp.put(nums[i] , mp.getOrDefault(nums[i] , 0) + 1);
        }
        int maxi = Integer.MIN_VALUE;
        
        for(int num : nums){
            // check is this no outlier
            
            int res = sum - num;
            if(res % 2 != 0)continue;
            mp.put(num , mp.get(num) - 1);
            res = res / 2;
            if(mp.getOrDefault(res , 0) > 0){
               maxi = Math.max(maxi , num);
            }
            mp.put(num , mp.get(num) + 1);
        }
        return maxi;
    }
}