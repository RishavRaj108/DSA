class Solution {

    public int bfs(int n , List<List<Integer>> adj){
        Queue<Integer> q = new LinkedList<>();
        int level = 0;
        q.add(0);
        boolean[] vis = new boolean[n];
        vis[0] = true;
        while(!q.isEmpty()){
            int size = q.size();
            
            for(int i = 0;i < size;i++){
                int node = q.poll();

                if(node == n - 1)return level;
                
                for(int neig : adj.get(node)){
                    if(vis[neig] == false){
                      q.add(neig);
                      vis[neig] = true;
                    }
                }
            }
            level++;
        }
        return -1;
    }
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        List<List<Integer>> adj = new ArrayList<>();
      
        for(int i = 0;i < n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0;i <= n - 2;i++){
            adj.get(i).add(i + 1);
        }

        int[] res = new int[queries.length];
        for(int i = 0;i < queries.length;i++){
            adj.get(queries[i][0]).add(queries[i][1]);
            res[i] = bfs(n , adj);
        }
      return res;
    }
}