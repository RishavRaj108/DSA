class Solution {
    class Tuple{
        int node;
        int count;
        long wt;

        Tuple(int node, int count, long wt) {
            this.node = node;
            this.count = count;
            this.wt = wt;
        }
    }
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0;i < n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            adj.get(u).add(new int[]{v , wt});
        }

        Long[][] dist = new Long[n][k + 1];
        for(Long[] arr : dist){
            Arrays.fill(arr, Long.MAX_VALUE);
        }
       
        dist[0][1] = 0L;
        PriorityQueue<Tuple> pq = new PriorityQueue<>((a,b) -> Long.compare(a.wt , b.wt));
        // tuple char ,k , node ,wt
        pq.add(new Tuple(0,1,0));

        while(!pq.isEmpty()){
            Tuple t = pq.poll();
            int node = t.node;
            int count = t.count;
            long wt = t.wt;

            if(node == n - 1){
                return (int)wt;
            }

            for(int[] neig : adj.get(node)){
                int next = neig[0];
                long edgeWt = neig[1];

                int newCount;
                if(labels.charAt(node) == labels.charAt(next)){
                    newCount = count + 1;
                }else{
                    newCount = 1;
                }

                if(newCount > k)continue;

                long newWt = wt + edgeWt;
                if(newWt < dist[next][newCount]){
                    dist[next][newCount] = newWt;
                    pq.offer(new Tuple(next , newCount , newWt));
                }
            }
        }
        return -1;
    }
}