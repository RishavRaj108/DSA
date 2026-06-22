class Solution {
    public long[] findMaxSum(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int[][] vec = new int[n][3]; //vec[i] = {nums1[i], i, nums2[i]}
        for (int i = 0; i < n; i++) { //O(n)
            vec[i][0] = nums1[i];
            vec[i][1] = i;
            vec[i][2] = nums2[i];
        }

        Arrays.sort(vec , (a,b) -> a[0] - b[0]);
        long[] ans = new long[n];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long sum = 0;

        for(int i = 0;i < n;i++){
            if(i > 0 && vec[i - 1][0] == vec[i][0]){
                ans[vec[i][1]] = ans[vec[i - 1][1]];
            }else{
                ans[vec[i][1]] = sum;
            }
            pq.add(vec[i][2]);
            sum += vec[i][2];
            if(pq.size() > k){
                sum -= pq.poll();
            }
        }
        return ans;
    }
}









