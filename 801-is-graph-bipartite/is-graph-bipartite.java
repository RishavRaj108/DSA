class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];

        Arrays.fill(color , -1);

        for(int i = 0;i < n;i++){
            if(color[i] == -1){
               if(dfs(i , 0 , color , graph) == false)return false;
            }
        }
        return true;
    }
    public boolean dfs(int node , int col , int[] color,int[][] graph){
        color[node] = col;

        for(int neg : graph[node]){
            if(color[neg] == -1){
                if(dfs(neg , 1 - col,color,graph) == false)return false;;
            }else if(color[neg] == col){
                return false;
            }
        }
        return true;
    }
}