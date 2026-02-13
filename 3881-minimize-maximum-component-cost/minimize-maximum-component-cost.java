class Solution {
    public int minCost(int n, int[][] edges, int k) {
        if (k >= n) return 0;

        // 1️⃣ Sort edges by weight (ascending)
        Arrays.sort(edges, (a, b) -> a[2] - b[2]);

        DisjointSet ds = new DisjointSet(n);
        List<Integer> mstEdges = new ArrayList<>();

        // 2️⃣ Build MST using Kruskal
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            if (ds.unionBySize(u, v)) {
                mstEdges.add(w);
            }
        }

        // 3️⃣ Remove (k - 1) largest edges
        int remainingEdges = mstEdges.size() - (k - 1);

        return mstEdges.get(remainingEdges - 1);
    }
}

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

    public boolean unionBySize(int u, int v) {
        int pu = findUPar(u);
        int pv = findUPar(v);

        if (pu == pv) return false;

        if (size.get(pu) < size.get(pv)) {
            parent.set(pu, pv);
            size.set(pv, size.get(pv) + size.get(pu));
        } else {
            parent.set(pv, pu);
            size.set(pu, size.get(pu) + size.get(pv));
        }
        return true;
    }
}