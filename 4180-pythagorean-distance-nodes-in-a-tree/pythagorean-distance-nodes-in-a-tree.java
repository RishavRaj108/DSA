class Solution {
    List<List<Integer>> adj;
    public int specialNodes(int n, int[][] edges, int x, int y, int z) {
        adj = new ArrayList<>();
        for(int i = 0;i < n;i++)adj.add(new ArrayList<>());
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[][] dis = new int[n][3];

        find(0,x,dis);
        find(1,y,dis);
        find(2,z,dis);
        
        
        int cnt = 0;
        for(int[] d : dis){
            
            List<Integer> ls = new ArrayList<>();
            ls.add(d[0]);
            ls.add(d[1]);
            ls.add(d[2]);
            Collections.sort(ls);
            int a = ls.get(0);
            int b = ls.get(1);
            int c = ls.get(2);
            if( ((a*a) + (b * b)) == (c * c)){
                cnt++;
            }
        }
        return cnt;

    }
    public void find(int ind,int x,int[][] dis){
        Queue<Integer> q = new LinkedList<>();

        q.add(x);
        dis[x][ind] = 0;
        int d = 0;
        int[] vis = new int[dis.length];
        vis[x] = 1;
        while(!q.isEmpty()){
            int size = q.size();
            d++;
            for(int i = 0;i < size;i++){
                int node = q.poll();
                // now traverse all neighbors
                for(int neig : adj.get(node)){
                    if(vis[neig] != 1){
                        vis[neig] = 1;
                        dis[neig][ind] = d;
                        q.add(neig);
                    }
                }
            }
        }
    }
}