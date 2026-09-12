class Solution {
    public long[] findMaxSum(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int[][] values = new int[n][3];
        for(int i = 0;i < n;i++){
            values[i][0] = i;
            values[i][1] = nums1[i];
            values[i][2] = nums2[i];
        } 
        Arrays.sort(values , (a,b) -> a[1] - b[1]);

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        long[] res = new long[n];
        long sum = 0;
        for(int i = 0;i < n;i++){
            if(i > 0 && values[i][1] == values[i - 1][1]){
                res[values[i][0]] = res[values[i - 1][0]];
            }else{
                res[values[i][0]] = sum;
            }
            pq.add(values[i][2]);
            sum += values[i][2];
            if(pq.size() > k){
                sum -= pq.poll();
            }
        }
        return res;
    }
}