class Solution {
    public int assignEdgeWeights(int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        int n = edges.length + 1;

        for(int i = 0;i <= n;i++)adj.add(new ArrayList<>());
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] vis = new boolean[n + 1];
        Queue<Integer> q = new LinkedList<>();
         vis[1] = true;
        q.add(1);
        

        int len = 0;
        while(!q.isEmpty()){
            int size = q.size();
            len++;
            for(int i = 0; i < size;i++){
                int node = q.poll();
              
               for(int neig : adj.get(node)){
                if(!vis[neig]){
                    vis[neig] = true;
                    q.add(neig);
                }
               }
            }
        }
        len--;
        int mod = 1000000007;
        long ways = 1;
        for(int i = 1;i < len;i++){
            ways = (1L * ways * 2) % mod;
        }
        return (int)ways;

    }
}