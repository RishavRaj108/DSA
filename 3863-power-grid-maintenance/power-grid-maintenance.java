class Solution {
    public void dfs(int node,List<Integer>[] adj,int compId,int[] nodeId,
    Map<Integer , TreeSet<Integer>> componentMap,boolean[] visited){
        visited[node] = true;

        nodeId[node] = compId;
        componentMap.computeIfAbsent(compId , k -> new TreeSet<>()).add(node);
        for(int neigh : adj[node]){
            if(!visited[neigh]){
                dfs(neigh, adj,compId, nodeId, componentMap,visited);
            }
        }
    }

    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        List<Integer>[] adj = new ArrayList[c + 1];
        for(int i = 1;i <= c;i++){
            adj[i] = new ArrayList<>();
        }
        for(int[] edge : connections){
            int u = edge[0];
            int v = edge[1];
            adj[u].add(v);
            adj[v].add(u);
        }

        // build the components 
        // keep track of which node is in which component
        // for dfs keep track of 

        int[] nodeId = new int[c + 1];
        Map<Integer , TreeSet<Integer>> componentMap = new HashMap<>();
        boolean[] visited = new boolean[c + 1];

        for(int node = 1;node <= c;node++){
            if(!visited[node]){
                dfs(node , adj,node , nodeId , componentMap,visited);
            }
        }

        List<Integer> result = new ArrayList<>();

        for(int[] query : queries){
            int type = query[0];
            int node = query[1];
            int compId = nodeId[node];
            TreeSet<Integer> set = componentMap.get(compId);

            if(type == 1){
                if(set.contains(node)){
                    result.add(node);
                }else if(!set.isEmpty()){
                    result.add(set.first());
                }else{
                    result.add(-1);
                }
            }else{
                set.remove(node);
            }
        }
        int[] answer = new int[result.size()];
        for(int i = 0;i < result.size();i++){
            answer[i] = result.get(i);
        }
        return answer;
    }
}