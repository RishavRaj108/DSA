class Solution {
    public long minCost(int[] arr, int[] brr, long k) {
        int n = arr.length;

        long raw = 0;
        for(int i = 0;i < n;i++){
            raw += Math.abs(arr[i] - brr[i]);
        }

        int[] tmp = arr.clone();
        int[] dist = brr.clone();

        Arrays.sort(tmp);
        Arrays.sort(dist);
        long cost = k;
        for(int i = 0;i < n;i++){
            cost += Math.abs(tmp[i] - dist[i]);
        }
        return Math.min(cost, raw);
    }
}