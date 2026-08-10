class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i= 0;i < n;i++){
            adj.add(new ArrayList<>());
        }
        int[] indegree = new int[n];
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            indegree[v]++;
        }

        List<Set<Integer>> anses = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();

        for(int i = 0;i < n;i++){
            anses.add(new HashSet<>());
            if(indegree[i] == 0)q.add(i);
        }
        while(!q.isEmpty()){
           int node = q.poll();

           for(int neig : adj.get(node)){
            anses.get(neig).add(node);
            anses.get(neig).addAll(anses.get(node));

            indegree[neig]--;
            if(indegree[neig] == 0){
                q.add(neig);
            }
           }
        }

        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0;i< n;i++){
            res.add(new ArrayList<>(anses.get(i)));
            Collections.sort(res.get(i));
        }
        return res;
    }
}










