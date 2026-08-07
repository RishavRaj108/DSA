class Solution {
    public int minCost(int n, int[][] edges) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0;i < n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            adj.get(u).add(new int[]{v , wt});
            adj.get(v).add(new int[]{u , 2 * wt});
        }
        int[] dist = new int[n];
        Arrays.fill(dist , Integer.MAX_VALUE);
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);

        pq.add(new int[]{0,0});
        dist[0] = 0;
        while(!pq.isEmpty()){
            int[] vals = pq.poll();
            int u = vals[0];
            int wht = vals[1];
            if(u == n -1)return wht;

            for(int[] neighbors : adj.get(u)){
                int v = neighbors[0];
                int wt = neighbors[1];
                if(wt + wht < dist[v]){
                    
                    dist[v] = wt + wht;
                    pq.add(new int[]{v , wt + wht});
                }
            }
        }
        return -1;
    }
}





