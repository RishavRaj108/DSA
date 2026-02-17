import java.util.*;

class Solution {

    class DisjointSet {
        List<Integer> parent = new ArrayList<>();
        List<Integer> size = new ArrayList<>();

        public DisjointSet(int n) {
            for (int i = 0; i < n; i++) {
                parent.add(i);
                size.add(1);
            }
        }

        public int findUPar(int node) {
            if (node == parent.get(node)) return node;
            int up = findUPar(parent.get(node));
            parent.set(node, up); // Path compression
            return up;
        }

        public void unionBySize(int u, int v) {
            int pu = findUPar(u);
            int pv = findUPar(v);

            if (pu == pv) return;

            if (size.get(pu) < size.get(pv)) {
                parent.set(pu, pv);
                size.set(pv, size.get(pv) + size.get(pu));
            } else {
                parent.set(pv, pu);
                size.set(pu, size.get(pu) + size.get(pv));
            }
        }
    }

    public int[] processQueries(int c, int[][] connections, int[][] queries) {

        // Step 1: Create DSU (0-based)
        DisjointSet dsu = new DisjointSet(c);

        // Step 2: Build connected components
        for (int[] edge : connections) {
            int u = edge[0] - 1;  // convert to 0-based
            int v = edge[1] - 1;
            dsu.unionBySize(u, v);
        }

        // Step 3: root → TreeSet of active nodes
        Map<Integer, TreeSet<Integer>> map = new HashMap<>();

        for (int i = 0; i < c; i++) {
            int root = dsu.findUPar(i);
            map.computeIfAbsent(root, k -> new TreeSet<>()).add(i);
        }

        List<Integer> result = new ArrayList<>();

        // Step 4: Process queries
        for (int[] q : queries) {
            int type = q[0];
            int node = q[1] - 1;  // convert to 0-based
            int root = dsu.findUPar(node);
            TreeSet<Integer> set = map.get(root);

            if (type == 1) {
                if (set.contains(node)) {
                    result.add(node + 1);  // convert back to 1-based
                } else {
                    result.add(set.isEmpty() ? -1 : set.first() + 1);
                }
            } else {
                set.remove(node);
            }
        }

        return result.stream().mapToInt(i -> i).toArray();
    }
}