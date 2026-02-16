import java.util.*;

class Solution {

    // DFS to mark all nodes of one connected component
    private void dfs(int node,
                     List<Integer>[] adj,
                     int compId,
                     int[] nodeId,
                     Map<Integer, TreeSet<Integer>> componentMap,
                     boolean[] visited) {

        visited[node] = true;

        // Store which component this node belongs to
        nodeId[node] = compId;

        // Add node to its component's TreeSet (initially all are online)
        componentMap
                .computeIfAbsent(compId, k -> new TreeSet<>())
                .add(node);

        // Visit all neighbours
        for (int neighbour : adj[node]) {
            if (!visited[neighbour]) {
                dfs(neighbour, adj, compId, nodeId, componentMap, visited);
            }
        }
    }

    public int[] processQueries(int c, int[][] connections, int[][] queries) {

        // Step 1: Build adjacency list (1-based indexing)
        List<Integer>[] adj = new ArrayList[c + 1];
        for (int i = 1; i <= c; i++) {
            adj[i] = new ArrayList<>();
        }

        // Add edges (bidirectional)
        for (int[] edge : connections) {
            int u = edge[0];
            int v = edge[1];
            adj[u].add(v);
            adj[v].add(u);
        }

        // Step 2: Find connected components using DFS
        boolean[] visited = new boolean[c + 1];
        int[] nodeId = new int[c + 1];  // nodeId[i] = component id of node i

        // Map: componentId → TreeSet of active nodes (sorted)
        Map<Integer, TreeSet<Integer>> componentMap = new HashMap<>();

        for (int node = 1; node <= c; node++) {
            if (!visited[node]) {
                // Use the starting node itself as component id
                dfs(node, adj, node, nodeId, componentMap, visited);
            }
        }

        // Step 3: Process queries
        List<Integer> result = new ArrayList<>();

        for (int[] query : queries) {
            int type = query[0];
            int node = query[1];

            int compId = nodeId[node];
            TreeSet<Integer> set = componentMap.get(compId);

            if (type == 1) {
                // Maintenance query

                // If node is still online (present in TreeSet)
                if (set.contains(node)) {
                    result.add(node);
                }
                // If offline, return smallest active node in same component
                else if (!set.isEmpty()) {
                    result.add(set.first());  // smallest element
                }
                // If no active node exists
                else {
                    result.add(-1);
                }

            } else {
                // type == 2 → node goes offline

                // Remove node from active set
                set.remove(node);
            }
        }

        // Convert List<Integer> to int[]
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }
}