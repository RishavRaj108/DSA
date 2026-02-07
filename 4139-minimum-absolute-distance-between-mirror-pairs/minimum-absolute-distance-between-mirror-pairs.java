class Solution {
    public int minMirrorPairDistance(int[] nums) {
        // so now i get the idea
        // what was the issue. 
        // i was not having proper clarity
        // trying to make things complex

        // write complete idea before coding 
        // then only start coding
        // use hashmap to store previous nums
        // for current num reverse it and check its presence in map
        // if yes then compute the distance
        Map<Integer, Integer> mp = new HashMap<>();
        int ans = Integer.MAX_VALUE;
        for(int i = 0;i < nums.length;i++){
            int rev = find(nums[i]);
            if(mp.containsKey(nums[i])){
                ans = Math.min(ans , i - mp.get(nums[i]));
            }
            mp.put(rev , i);
        }
        return ans == Integer.MAX_VALUE? -1 : ans;
    }
    public int find(int num){
        int rev = 0;
        // how to reverse it
        // 576 -> 675 
        // 576 % 10 = 6
        // 6 * 10 + 57 % 10 = 67
        // 67 * 10 + 5 % 10 = 675

        while(num > 0){
            rev = rev * 10 + num % 10;
            num = num / 10;
        }
        return rev;
    }
}