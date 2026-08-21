class Solution {
    public long[] unmarkedSumArray(int[] nums, int[][] quer) {
        int n = nums.length;
        int m = quer.length;
        boolean[] marked = new boolean[n];
        long sum = 0L;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> {
            if(a[0] != b[0])return a[0] - b[0];
            else return a[1] - b[1]; 
        });

        for(int i = 0;i < n;i++){
            int num = nums[i];
            sum += num;
            pq.add(new int[]{num , i});
        }

        long[] res = new long[m];
        int i = 0;
        for(int[] q : quer){
            int ind = q[0];
            int k = q[1];
            if(!marked[ind]){
                sum -= nums[ind];
                marked[ind] = true;
            }

            while(k-- > 0){
                while(!pq.isEmpty() && marked[pq.peek()[1]] == true){
                   pq.poll();
                }
                if(pq.isEmpty()){
                    break;
                }
                int[] vals = pq.poll();
                sum -= vals[0];
                marked[vals[1]] = true;
            }
            res[i++] = sum; 
        }
        return res;
    }
}