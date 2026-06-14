class Solution {
    public int minTime(int n, int[][] edges, int k) {
        // build graph
        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0;i < n;i++){
            adj.add(new ArrayList<>());
        }
        int maxT = 0;
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int time = edge[2];
            adj.get(u).add(new int[]{v,time});
            adj.get(v).add(new int[]{u,time});
            maxT = Math.max(maxT , time);
        }

        int start = 0;
        int end = maxT;
        while(start <= end){
            int mid = start + (end - start)/ 2;

            if(isPossible(adj,mid, k)){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return start;
    }
    public boolean isPossible(List<List<int[]>> adj,int t,int k){
        int cnt = 0;
        int n = adj.size();
        boolean[] vis = new boolean[n];
        for(int i = 0;i < adj.size();i++){
            if(!vis[i]){
                cnt++;
                dfs(i,adj,t,vis);
            }
        }
        return cnt >= k;
    }
    public void dfs(int node , List<List<int[]>> adj,int t,boolean[] vis){
        vis[node] = true;

        for(int[] neg : adj.get(node)){
            int n = neg[0];
            int time = neg[1];
            if(!vis[n] && time > t){
                dfs(n , adj , t,vis);
            }
        }
    }
}