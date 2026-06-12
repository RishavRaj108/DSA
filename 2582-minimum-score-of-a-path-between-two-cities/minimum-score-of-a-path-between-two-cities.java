class Solution {
    public int minScore(int n, int[][] roads) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0;i <= n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] road : roads){
            int a = road[0];
            int b = road[1];
            int dis = road[2];
            adj.get(a).add(new int[]{b, dis});
            adj.get(b).add(new int[]{a , dis});
        }
        boolean[] vis = new boolean[n + 1];
        int[] val = {Integer.MAX_VALUE};
        find(1,adj,vis,val);
        return val[0];
    }
    public void find(int node,List<List<int[]>> adj,boolean[] vis,int[] val){
        vis[node] = true;
        for(int[] ngro : adj.get(node)){
            int ng = ngro[0];
            int dis = ngro[1];
            val[0] = Math.min(val[0] ,dis);
           if(!vis[ng]){
            find(ng,adj,vis,val);
           }
        }
    }
}