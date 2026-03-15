class Solution {
    int cntGood = 0;
    public int countGoodNodes(int[][] edges) {
        //
        // first of all we will bult the djcency matrix
        // the call dfs nd for each child node we are going to calculate the size
        List<List<Integer>> adj = new ArrayList<>();
        int n = edges.length + 1;
        for(int i = 0;i < n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        dfs(0 , adj , -1);
        return cntGood;
    }

    public int dfs(int node , List<List<Integer>> adj , int par){

        int sizeT = 1;
        int res = -1;
        boolean check = true;
        for(int neig : adj.get(node)){
            if(neig == par)continue;
            int size = dfs(neig , adj,node);
            
            if(res == -1){
                res = size;
            }else{
                if(size != res){
                    check = false;
                }
            }
            sizeT += size;
        }
        if(check)cntGood++;
        return sizeT;
    }
}