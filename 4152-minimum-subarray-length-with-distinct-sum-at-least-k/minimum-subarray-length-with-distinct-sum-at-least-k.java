class Solution {
    public int minLength(int[] nums, int k) {
        int n = nums.length;
        int mini = Integer.MAX_VALUE;
        int left = 0;
        Map<Integer,Integer> mp = new HashMap<>();
        int sum = 0;
        for(int right = 0;right < n;right++){
            int num = nums[right];
           if(!mp.containsKey(num)){
             mp.put(num, 1);
             sum += num;
           }else{
            mp.put( num , mp.get(num) + 1);
           }
           while(sum >= k){
            num = nums[left];
            mp.put(num , mp.get(num) - 1);
            if(mp.get(num) == 0){
                sum -= num;
                mp.remove(num);
            }
            mini = Math.min(mini , right - left + 1);
            left++;
           }
        }
        return mini == Integer.MAX_VALUE? -1 : mini;
    }
}