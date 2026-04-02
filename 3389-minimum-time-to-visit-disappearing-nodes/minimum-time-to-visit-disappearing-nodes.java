class Solution {
    class Pair {
        int node, time;
        Pair(int node, int time) {
            this.node = node;
            this.time = time;
        }
    }

    public int[] minimumTime(int n, int[][] edges, int[] disappear) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], t = edge[2];
            adj.get(u).add(new int[]{v, t});
            adj.get(v).add(new int[]{u, t});
        }

        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.time - b.time);
        pq.add(new Pair(0, 0));

        while (!pq.isEmpty()) {
            Pair cur = pq.poll();
            int node = cur.node, time = cur.time;

            

            // ✅ Disappear check
            if (time >= disappear[node]) continue;
            // ✅ Skip stale states (MAIN FIX)
            if (ans[node] != -1 && time >= ans[node]) continue;

            ans[node] = time;

            for (int[] nei : adj.get(node)) {
                int next = nei[0];
                int newTime = time + nei[1];

                if (newTime < disappear[next]) {
                    pq.add(new Pair(next, newTime));
                }
            }
        }

        return ans;
    }
}