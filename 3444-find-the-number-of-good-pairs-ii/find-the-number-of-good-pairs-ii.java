class Solution {
    public long numberOfPairs(int[] nums1, int[] nums2, int k) {
        Map<Integer, Integer> mp = new HashMap<>();
        for(int num : nums2){
            mp.put(num , mp.getOrDefault(num , 0) + 1);
        }

        long ans = 0;
        for(int i = 0;i < nums1.length;i++){
            int num = nums1[i];
            if(num % k != 0)continue;

            int val = num / k;
            // now this val must be divisible by nums2 numbers
            for(int d = 1;d * d <= val;d++){
                if(val % d == 0){
                    if(mp.containsKey(d)){
                        ans += mp.get(d);
                    }
                    int other = val / d;
                    if(other != d && mp.containsKey(other)){
                        ans += mp.get(other);
                    }
                }
            }
        }
        return ans;
    }
}