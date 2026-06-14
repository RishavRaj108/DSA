class Solution {
    public int minTime(int n, int[][] edges) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0;i < n;i++)adj.add(new ArrayList<>());
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int s = edge[2];
            int e = edge[3];
            adj.get(u).add(new int[]{v,s,e});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        pq.add(new int[]{0,0});
        int[] dur = new int[n];
        Arrays.fill(dur , Integer.MAX_VALUE);
        dur[0] = 0;
        while(!pq.isEmpty()){
            int[] val = pq.poll();
            int node = val[0];
            int time = val[1];
            if(node == n-1)return time;

            if(dur[node] < time)continue;

            for(int[] ngbr : adj.get(node)){
                int ngnode = ngbr[0];
                int s = ngbr[1];
                int e = ngbr[2];
                int t = time;
                if(time > e)continue;
                if(time < s) t = s;
                if(dur[ngnode] > t){
                    dur[ngnode] = t + 1;
                    pq.add(new int[]{ngnode , t + 1});
                }
            }
        }
        return -1;
    }
}





