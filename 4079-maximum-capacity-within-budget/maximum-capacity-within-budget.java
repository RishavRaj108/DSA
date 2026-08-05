class Solution {
    public int maxCapacity(int[] costs, int[] capa, int budget) {
        int n = costs.length;
        budget--;
        int[][] vals = new int[n][2];
        for(int i = 0;i < n;i++){
            vals[i][0] = costs[i];
            vals[i][1] = capa[i];
        }
        Arrays.sort(vals , (a,b) -> a[0] - b[0]);

        int[] best = new int[n];
        best[0] = vals[0][1];
        for(int i = 1;i < n;i++){
            int curr = vals[i][1];
            best[i] = Math.max(best[i - 1] , vals[i][1]);
        }
        int maxi = 0;
        // choose one
        for(int i = 0;i < n;i++){
            if(vals[i][0] <= budget)
            maxi = Math.max(maxi , vals[i][1]);
        }
        // choose two 
        for(int i = 0;i < n;i++){
            int rem = budget - vals[i][0];
            if(rem < 0)break;
            int ind = find(vals, rem , i - 1);
            if(ind == -1)continue;
            maxi = Math.max(maxi , best[ind] + vals[i][1]);
        }
        return maxi;
    }
    public int find(int[][] vals , int capa , int h){
        int l = 0;
        int ans = -1;
        while(l <= h){
            int mid = l + (h - l)/2;
            if(vals[mid][0] <= capa){
                ans = mid;
                l = mid + 1;
            }else{
                h = mid - 1;
            }
        }
        return ans;
    }
}