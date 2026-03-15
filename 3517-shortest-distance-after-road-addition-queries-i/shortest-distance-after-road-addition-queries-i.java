class Solution {
    public int bfs(int n , Map<Integer , List<Integer>> adj){
        Queue<Integer> q = new LinkedList<>();
        // we don't want to add already visited node to queue so we maintain a visited array
        boolean[] visited = new boolean[n];
        q.add(0);// node
        visited[0] = true;
        int level = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0;i < size;i++){
                int node = q.poll();
                if(node == n - 1)return level;

                for(int neig : adj.get(node)){
                    if(visited[neig] == false){
                       visited[neig] = true;
                       q.add(neig);
                    }
                }
            }
            level++;
        }
        return -1;
    }

    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        Map<Integer , List<Integer>> adj = new HashMap<>();

        for(int i = 0;i < n - 1;i++){
            adj.computeIfAbsent(i , k -> new ArrayList<>()).add(i + 1);
        }
        int m = queries.length;
        int[] res = new int[m];
        for(int i = 0;i < m;i++){
            adj.computeIfAbsent(queries[i][0] , k -> new ArrayList<>()).add(queries[i][1]);
            res[i] = bfs(n , adj);
        }
        return res;
    }
}