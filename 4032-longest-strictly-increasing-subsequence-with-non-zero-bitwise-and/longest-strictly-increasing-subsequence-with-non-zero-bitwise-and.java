class Solution {
    public int longestSubsequence(int[] nums) {
        // lis
        // with non zero bit wise and

        // approch
        // for all no the bit wise and should not be zero
        // 
        int ans = 0;
        for(int i = 0;i < 32;i++){
            List<Integer> vals = new ArrayList<>();
            for(int num : nums){
                if((num & (1 << i)) != 0){
                    vals.add(num);
                }
            }
            if(vals.size() == 0)continue;
            List<Integer> ls = new ArrayList<>();
            // now lis using binary search
            for(int num : vals){
                int pos = Collections.binarySearch(ls, num);
                if(pos < 0)pos = -(pos + 1);
                if(pos == ls.size()){
                    ls.add(num);
                }else{
                    ls.set(pos , num);
                }
            }
            ans = Math.max(ans , ls.size());
        }
        return ans;
    }
}