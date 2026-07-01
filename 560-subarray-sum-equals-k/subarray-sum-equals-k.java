class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer , Integer> mp = new HashMap<>();
        mp.put(0,1);
        int sum = 0;
        int cnt = 0;
        for(int num : nums){
           sum += num;
           int rem = sum - k;
           if(mp.containsKey(rem)){
               cnt += mp.get(rem);
           }
           mp.put(sum , mp.getOrDefault(sum , 0) + 1);
        }
        return cnt;
    }
}