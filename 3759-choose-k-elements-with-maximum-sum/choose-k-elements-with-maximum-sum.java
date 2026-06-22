class Solution {
    public long[] findMaxSum(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int[][] arr = new int[n][3];
        for(int i = 0;i < n;i++){
            arr[i][0] = i;
            arr[i][1] = nums1[i];
            arr[i][2] = nums2[i]; 
        }

        Arrays.sort(arr, (a,b) -> a[1] - b[1]);

        long[] res = new long[n];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long sum = 0;
        for(int i = 0;i < n;i++){
            if(i > 0 && arr[i][1] == arr[i - 1][1]){
                res[arr[i][0]] = res[arr[i - 1][0]];
            }else{
                res[arr[i][0]] = sum;
            }

            pq.add(arr[i][2]);
            sum += arr[i][2];
            if(pq.size() > k){
                sum -= pq.poll();
            }
        }
        return res;
    }
}