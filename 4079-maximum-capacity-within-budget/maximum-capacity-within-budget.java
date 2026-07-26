class Solution {
    public int maxCapacity(int[] costs, int[] capacity, int budget) {
        int n = costs.length;
        int[][] a = new int[n][2];
        for(int i = 0;i < n;i++){
            a[i][0] = costs[i];
            a[i][1] = capacity[i];
        }
        budget--;
        Arrays.sort(a , (x,y) -> x[0] - y[0]);
        int[] best = new int[n];
        best[0] = a[0][1];
        for(int i = 1;i < n;i++){
           best[i] = Math.max(best[i - 1] , a[i][1]);
        }

        int ans = 0;
        // choose one 
        for(int i = 0;i < n;i++){
           if(a[i][0] <= budget){
            ans = best[i];
           }else{
            break;
           }
        }
        for(int i = 1;i < n;i++){
            int rem = budget - a[i][0];
            if(rem < 0)break;
            int second = find(a , rem , i - 1);
            if(second == -1)continue;
            ans = Math.max(ans , a[i][1] + best[second]);
        }
        return ans;
    }
    public int find(int[][] a , int cost , int h){
        int l = 0;
        int res = -1;

        while(l <= h){
            int mid = l + (h - l)/ 2;
            if(a[mid][0] > cost){
                h = mid - 1;
            }else{
                res = mid;
                l = mid + 1;
            }
        }
        return res;
    }
}