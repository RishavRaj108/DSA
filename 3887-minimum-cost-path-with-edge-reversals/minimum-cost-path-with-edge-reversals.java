class Solution {
    public int minCost(int n, int[][] edges) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0;i < n;i++)adj.add(new ArrayList<>());
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            adj.get(u).add(new int[]{v,w});
            adj.get(v).add(new int[]{u, 2 * w});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);

        int[] dist = new int[n];
        Arrays.fill(dist , Integer.MAX_VALUE);

        pq.add(new int[]{0,0});
        dist[0] = 0;
        while(!pq.isEmpty()){
            int[] vals = pq.poll();
            int node = vals[0];
            int w = vals[1];
            if(dist[node] < w)continue;
            if(node == n - 1)return w;

            for(int[] negi : adj.get(node)){
                int nnode = negi[0];
                int wt = negi[1];
                int tw = wt + w;
                if(dist[nnode] > tw){
                    pq.add(new int[]{nnode , tw});
                    dist[nnode] = tw;
                }
            }
        }
        return -1;
    }
}