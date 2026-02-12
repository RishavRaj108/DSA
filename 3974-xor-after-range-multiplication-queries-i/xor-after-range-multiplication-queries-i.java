class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        int n = nums.length;

        int q = queries.length;

        for(int[] quer : queries){
            int l = quer[0];
            int r = quer[1];
            int k = quer[2];
            int v = quer[3];
            for(int i = l;i <= r;){
               nums[i] = (int)((1L * nums[i] * v) % (1000000007));
               i += k;
            }
        }
        int xor = nums[0];
        for(int i = 1;i < n;i++){
            xor = xor ^ nums[i];
        }
        return xor;
    }
}