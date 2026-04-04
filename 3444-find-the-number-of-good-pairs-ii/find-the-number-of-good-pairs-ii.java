class Solution {
    public long numberOfPairs(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        long cnt = 0;
        Map<Integer, Integer> mp = new HashMap<>();
        for(int num : nums2){
            mp.put(num , mp.getOrDefault(num , 0) + 1);
        }

        for(int num : nums1){
            if(num % k != 0)continue;
            int val = num / k;

            for(int i = 1;i * i <= val;i++){
                if(val % i == 0 ){
                    if(mp.containsKey(i)){
                      cnt += mp.get(i);
                    }
                    int other = val / i;
                    if(other != i && mp.containsKey(other)){
                        cnt += mp.get(other);
                    }
                    
                }
            }
        }
        return cnt;
    }
}