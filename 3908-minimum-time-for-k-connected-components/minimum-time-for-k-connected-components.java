class Solution {
    public int minTime(int n, int[][] edges, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0;i < n;i++)adj.add(new ArrayList<>());
        int low = 0;
        int high = Integer.MIN_VALUE;
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int t = edge[2];
            high = Math.max(high , t);
            adj.get(u).add(new int[]{v, t});
            adj.get(v).add(new int[]{u, t});
        }
        int res = 0;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(isPossible(adj , mid , k)){
                res = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return res;
    }
    public boolean isPossible(List<List<int[]>> adj,int time , int comp){
        int cnt = 0;
        int n = adj.size();
        boolean[] vis = new boolean[n];
        for(int i = 0;i < n;i++){
            if(!vis[i]){
                cnt++;
                dfs(adj,time,i,vis);
            }
        }
        return cnt >= comp;
    }
    public void dfs(List<List<int[]>> adj,int time , int node,boolean[] vis){
        vis[node] = true;
        for(int[] neig : adj.get(node)){
            int ng = neig[0];
            int t = neig[1];
            if(!vis[ng] && t > time){
                dfs(adj,time,ng,vis);
            }
        }
    }
}