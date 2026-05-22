class Solution {
    public long beautifulSubarrays(int[] nums) {
        int n = nums.length;
        long ans = 0;
        Map<Integer,Integer> mp = new HashMap<>();
        int prefix = 0;
        mp.put(0 , 1);
        for(int num : nums){
           prefix = prefix ^ num;
           if(mp.containsKey(prefix)){
            ans += mp.get(prefix);
           }
           mp.put(prefix , mp.getOrDefault(prefix , 0) + 1);
        }
        return ans;
    }
}