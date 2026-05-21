class Solution {
    public int findMaxVal(int n, int[][] restri, int[] diff) {
        // diff - > n - 1
        // a[0] = 0;
        // abs(a[i] - a[i + 1]) <= diff
        // a[i] - a[i + 1] <= diff
        // a[i + 1] - a[i] <= diff

        // a[ind] <= maxVal

        // approch
        int[] a = new int[n];
        Arrays.fill(a , Integer.MAX_VALUE);

        a[0] = 0;
        for(int[] vals : restri){
            a[vals[0]] = vals[1];
        }

        int maxi = 0;

        for(int i = 0;i < n - 1;i++){
            a[i + 1] = Math.min(a[i + 1] , a[i] + diff[i]);
        }
        for(int i = n - 2;i >= 0;i--){
            a[i] = Math.min(a[i] , a[i + 1] + diff[i]);
        }
        for(int num : a){
            maxi = Math.max(maxi , num);
        }
        return maxi;
    }
}