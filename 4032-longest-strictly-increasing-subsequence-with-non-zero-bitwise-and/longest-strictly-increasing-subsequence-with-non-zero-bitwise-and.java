class Solution {
    public int longestSubsequence(int[] nums) {
        // bit wise and is not zero
        // num & (1 << bit)
        // generate list for each bit possible
        // then try to generate lis using binary search technique

        int ans = 0;
        for(int bit = 0;bit < 32;bit++){
            List<Integer> vals = new ArrayList<>();
            for(int num : nums){
                if((num & (1 << bit)) != 0){
                  vals.add(num);
                }
            }
            if(vals.size() == 0)continue;

            // now lis
            List<Integer> list = new ArrayList<>();
            for(int val : vals){

                int pos = Collections.binarySearch(list, val);

                if(pos < 0){
                    // - pos - 1
                    pos = - (pos + 1);
                }

                if(list.size()== pos){
                    list.add(val);
                }else{
                    list.set(pos , val);
                }
            }
            ans = Math.max(list.size() , ans);
        }
        return ans;
    }
}