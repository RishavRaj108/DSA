class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        // dag acyclic
        // so topo
        // all ancistors done
        // add the current and all the ansistors of the current node
        List<List<Integer>> adj = new ArrayList<>();
        List<Set<Integer>> res = new ArrayList<>();
        for(int i = 0;i < n;i++){
            adj.add(new ArrayList<>());
            res.add(new HashSet<>());
        }
        int[]indegree = new int[n];
        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            indegree[edge[1]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0;i < n;i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        
        while(!q.isEmpty()){
            int node = q.poll();

            for(int neig : adj.get(node)){
                
                res.get(neig).addAll(res.get(node));
                    res.get(neig).add(node);

                indegree[neig]--;
                if(indegree[neig] == 0){
                    
                    q.add(neig);
                }
            }
        }
        List<List<Integer>> result = new ArrayList<>();

        for(Set<Integer> ls : res){
            result.add(new ArrayList<>(ls));
            Collections.sort(result.get(result.size() - 1));
        }

        return result;
    }
}