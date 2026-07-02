class Solution {
    public int maxCapacity(int[] costs, int[] capa, int budget) {
        int n = costs.length;
        int[][] a = new int[n][2];
        for(int i = 0;i < n;i++){
            a[i][0] = costs[i];
            a[i][1] = capa[i];
        }
        Arrays.sort(a , (ab,b) -> ab[0] - b[0]);
        int[] best = new int[n];
        best[0] = a[0][1];
        for(int i = 1;i< n;i++){
          best[i] = Math.max(best[i - 1] , a[i][1]);
        }
        int ans = 0;
        // choose only one
        for(int i = 0;i < n;i++){
            if(a[i][0] < budget){
                ans = Math.max(ans , a[i][1]);
            }
        }
        // choose two value
        for(int i = 1;i < n;i++){
            // choose this index 
            int rem = budget - a[i][0] - 1;
            int ind = upperBound(rem , a , i - 1);
            if(ind < 0)continue;
            ans = Math.max(ans , best[ind] + a[i][1]);
        }
        return ans ;
    }
    public int upperBound(int cap , int[][] a , int hi){
       int res = -1;
       int l = 0;
       int r = hi;
       while(l <= r){
        int mid = l + (r - l)/ 2;
        if(a[mid][0] <= cap){
            res = mid;
            l = mid + 1;// try larger value;
        }else{
            r = mid - 1;
        }
       }
       return res;
    }
}