class Solution {
    public int minCost(int n, int[][] edges, int k) {
        if (k >= n) return 0;

        // Sort edges by weight
        Arrays.sort(edges, (a, b) -> a[2] - b[2]);

        DSU dsu = new DSU(n);
        List<Integer> mstEdges = new ArrayList<>();

        // Build MST using Kruskal
        for (int[] edge : edges) {
            if (dsu.union(edge[0], edge[1])) {
                mstEdges.add(edge[2]);
            }
        }

        // Sort MST edges (already sorted, but safe)
        Collections.sort(mstEdges);

        // Remove (k-1) largest edges
        int remainingEdges = mstEdges.size() - (k - 1);

        return mstEdges.get(remainingEdges - 1);
    }
}

class DSU {
    int[] parent, rank;

    DSU(int n) {
        parent = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++)
            parent[i] = i;
    }

    int find(int x) {
        if (parent[x] != x)
            parent[x] = find(parent[x]);
        return parent[x];
    }

    boolean union(int x, int y) {
        int px = find(x);
        int py = find(y);

        if (px == py) return false;

        if (rank[px] < rank[py])
            parent[px] = py;
        else if (rank[px] > rank[py])
            parent[py] = px;
        else {
            parent[py] = px;
            rank[px]++;
        }

        return true;
    }
}