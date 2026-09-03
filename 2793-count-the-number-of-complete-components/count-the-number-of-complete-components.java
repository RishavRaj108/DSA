class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0;i < n;i++)adj.add(new ArrayList<>());
        for(int[] edge : edges){
            int a = edge[0];
            int b = edge[1];
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        boolean[] vis = new boolean[n];
        int cnt = 0;
        for(int i = 0;i < n;i++){
            if(!vis[i]){
              Queue<Integer> q = new LinkedList<>();
              q.add(i);
              vis[i] = true;
              int vertices = 0;
              int edgesCnt = 0;
              while(!q.isEmpty()){
                int node = q.poll();
                vertices++;
                edgesCnt += adj.get(node).size();
                for(int neig : adj.get(node)){
                    if(!vis[neig]){
                        vis[neig] = true;
                        q.add(neig);
                    }
                }
              }
              edgesCnt = edgesCnt/2;
              if( (vertices * (vertices - 1))/ 2 == edgesCnt )cnt++;
            }
        }


        

      
        return cnt;
    }
}