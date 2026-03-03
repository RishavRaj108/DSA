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
            // remove this from map because it is outlier
            mp.put(num , mp.get(num) - 1);

            int rem = sum - num;

            if(rem % 2 == 0){
                int y = rem / 2;
                if(mp.getOrDefault(y , 0) > 0){
                    maxi = Math.max(maxi , num);
                }
            }
            mp.put(num , mp.get(num) + 1);
        }
        return maxi;
    }
}