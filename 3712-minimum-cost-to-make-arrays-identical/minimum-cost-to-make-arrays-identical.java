class Solution {
    public long minCost(int[] arr, int[] brr, long k) {
        int n = arr.length;
        int[] arrClon = arr.clone();
        long raw = 0;
        for(int i = 0;i < n;i++){
            raw += Math.abs(arr[i] - brr[i]);
        }

        long cost = k;
        Arrays.sort(arrClon);
        Arrays.sort(brr);
        for (int i = 0; i < n; i++) {
            cost += Math.abs(arrClon[i] - brr[i]);
        }
        return Math.min(cost , raw);
    }
}