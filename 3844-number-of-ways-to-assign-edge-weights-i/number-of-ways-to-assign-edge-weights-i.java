class Solution {
    static final int MOD = 1_000_000_007;
    public int assignEdgeWeights(int[][] edges) {
        
        List<List<Integer>> adj = new ArrayList<>();
        int n = edges.length + 1;
        for(int i = 0;i <= n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        boolean[] vis = new boolean[n + 1];
        vis[1] = true;
        int len = 0;
        while(!q.isEmpty()){
           int size = q.size();
           len++;
           for(int i = 0;i < size;i++){
            int node = q.poll();
            vis[node] = true;
            for(int ng : adj.get(node)){
                if(!vis[ng]){
                    q.add(ng);
                }
            }
           }
        }
        len = len - 1;
        long ways = 1;
        for(int i = 1;i < len;i += 1){
           ways = (ways * 2) % MOD;
        }
        return (int) ways;
    }
}