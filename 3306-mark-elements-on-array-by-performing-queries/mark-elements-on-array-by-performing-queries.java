class Solution {
    public long[] unmarkedSumArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int m = queries.length;

        int[] marked = new int[n];
        long total = 0;
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b) ->{
        if(a[0] != b[0]){
            return a[0] - b[0];
        }return a[1] - b[1];
        } );

        // int[] formate num , ind

        for(int i = 0;i < n;i++){
            int num = nums[i];
            total += num;
            q.add(new int[]{num , i});
        }
        long prefix = 0;
        long[] res = new long[m];
        int i = 0;
        for(int[] quer : queries){
            int ind = quer[0];
            int k = quer[1];
            if(marked[ind] == 0){
                marked[ind] = 1;
            prefix += nums[ind];
            }
            while(!q.isEmpty() && k > 0){
               int[] vals = q.poll();
               int num = vals[0];
               ind = vals[1];
               if(marked[ind] == 0){
                k--;
                prefix += num;
                marked[ind] = 1;
               }
               if(prefix == total)break;
            }
            if(prefix == total)break;
            res[i++] = total - prefix;
        }
        return res;
    }
}