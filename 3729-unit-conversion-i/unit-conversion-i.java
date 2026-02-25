class Solution {
    public int[] baseUnitConversions(int[][] conve) {
        int n = conve.length + 1;
        int mod = (int)1e9 + 7;
        Map<Integer , List<int[]>>graph = new HashMap<>();

        for(int[] con : conve){
            int s = con[0];
            int t = con[1];
            int cf = con[2];
            graph.computeIfAbsent(s , k -> new ArrayList<>()).add(new int[]{t,cf});
        }

        Queue<Integer> q = new LinkedList<>();

        q.add(0);
        int[] ans = new int[n];
        ans[0] = 1;
        while(!q.isEmpty()){
            int node = q.poll();
            if(!graph.containsKey(node))continue;

            for(int[] next : graph.get(node)){
                int t = next[0];
                int cf = next[1];
                ans[t] = (int)((1L * cf * ans[node]) % mod);
                q.add(t);
            }
        }
        return ans;
    }
}