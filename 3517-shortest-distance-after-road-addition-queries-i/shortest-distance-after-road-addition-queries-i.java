class Solution {
    public int dijkstra(int n , List<List<int[]>> adj){
        // for dijkstra stuff needed
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b) -> a[0] - b[0]);

        int[] dist = new int[n];
        Arrays.fill(dist , Integer.MAX_VALUE);

        dist[0] = 0;
        q.add(new int[]{0 , 0});

        while(!q.isEmpty()){
            int[] t = q.poll();
            int u = t[1];
            int d = t[0];
            if(u == n - 1)return d;
            if(dist[u] < d)continue;
            
            for(int[] neig : adj.get(u)){
                int v = neig[0];
                int dis = neig[1];
                if(dist[v] > d + dis){
                    dist[v] = d + dis;
                    q.add(new int[]{d + dis , v});
                }
            }
        }
        return -1;
    }
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0;i < n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0;i < n - 1;i++){
            adj.get(i).add(new int[]{i + 1, 1});
        }

        int[] res = new int[queries.length];
        for(int i = 0;i < queries.length;i++){
            adj.get(queries[i][0]).add(new int[]{queries[i][1],1});
            res[i] = dijkstra(n , adj);
        }
        return res;
    }
}