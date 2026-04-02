class Solution {
    class Pair {
        int node;
        int time;
        Pair(int node, int time) {
            this.node = node;
            this.time = time;
        }
    }

    public int[] minimumTime(int n, int[][] edges, int[] disappear) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        // ✅ FIX 1: Undirected graph
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], t = edge[2];
            adj.get(u).add(new int[]{v, t});
            adj.get(v).add(new int[]{u, t}); // IMPORTANT
        }

        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.time - b.time);
        pq.add(new Pair(0, 0));

        while (!pq.isEmpty()) {
            Pair cur = pq.poll();
            int node = cur.node, time = cur.time;

            // ✅ FIX 2: correct condition
            if (time >= disappear[node]) continue;

            // If already visited with better time
            if (ans[node] != -1 && ans[node] <= time) continue;

            ans[node] = time;

            for (int[] nei : adj.get(node)) {
                int next = nei[0];
                int newTime = time + nei[1];

                // Only push if node still exists
                if (newTime < disappear[next]) {
                    pq.add(new Pair(next, newTime));
                }
            }
        }

        return ans;
    }
}