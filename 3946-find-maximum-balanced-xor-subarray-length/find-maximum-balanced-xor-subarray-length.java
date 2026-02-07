class Solution {
    public int maxBalancedSubarray(int[] nums) {
        Map<String , Integer> mp= new HashMap<>();

        int pXor = 0;
        int diff = 0;
        int ans = Integer.MIN_VALUE;
        mp.put("0#0", -1); // important base case

        for(int i = 0;i < nums.length;i++){
            int num = nums[i];
            pXor = pXor ^ num;
            if(num % 2 == 0){
                diff++;
            }else{
                diff--;
            }
            String str = "" + pXor + "#" + diff;
            if(mp.containsKey(str)){
               ans = Math.max(ans , i - mp.get(str));
            }else{
               mp.put(str, i);
            }
        }

        return ans == Integer.MIN_VALUE? 0 : ans;
    }
}