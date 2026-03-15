class Solution {
    public int dijkstra(int n , Map<Integer , List<int[]>> adj ){
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        int[] dist = new int[n];
        Arrays.fill(dist , Integer.MAX_VALUE);

        pq.add(new int[]{ 0 , 0});
        dist[0] = 0;

        while(!pq.isEmpty()){
            int[] t = pq.poll();
            int d = t[0];
            int u = t[1];

            if(u == n - 1)return d;
            if(dist[u] < d)continue;

            for(int[] neig : adj.get(u)){
                int dis = neig[1];
                int v = neig[0];

                if(dist[v] > d + dis){
                    dist[v] = d + dis;
                    pq.add(new int[]{dist[v] , v});
                }
            }
        }
        return -1;
     }
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        Map<Integer , List<int[]>> adj = new HashMap<>();
        for(int i = 0;i < n - 1;i++){
            adj.computeIfAbsent(i , k -> new ArrayList<>()).add(new int[]{i + 1 , 1});
        }
        int m = queries.length;
        int[] res = new int[m];
        for(int i = 0;i < m;i++){
            adj.computeIfAbsent(queries[i][0] , k -> new ArrayList<>()).add(new int[]{queries[i][1] , 1});
            res[i] = dijkstra(n , adj);
        }
        return res;
    }
}