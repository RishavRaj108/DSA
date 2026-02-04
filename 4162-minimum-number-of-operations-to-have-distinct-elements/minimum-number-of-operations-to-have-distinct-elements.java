class Solution {
    public int minOperations(int[] nums) {
        Map<Integer,Integer> mp = new HashMap<>();
        int n = nums.length;
        for(int i = 0;i < n;i++){
            mp.put(nums[i] , mp.getOrDefault(nums[i] , 0) + 1);
        }

        int ind = 0;
        int cnt = 0;
        while(ind < n){
            if(mp.size() == n - ind)return cnt;

            cnt++;

            for(int i = 0;i < 3 && ind < n ;i++){
               int num = nums[ind++];
               mp.put(num , mp.get(num) - 1);
               if(mp.get(num) == 0)mp.remove(num);
            }
        }
        return cnt;
    }
}