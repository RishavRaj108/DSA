class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0;i < n;i++)adj.add(new ArrayList<>());

        for(int[] edge : edges){
            int a = edge[0];
            int b = edge[1];
            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        List<List<Integer>> compo = new ArrayList<>();
        boolean[] vis = new boolean[n];
        

        for(int i = 0;i < n;i++){
            if(!vis[i]){
              List<Integer> ls = new ArrayList<>();
              Queue<Integer> q = new LinkedList<>();
              q.add(i);
              vis[i] = true;

              while(!q.isEmpty()){
                int node = q.poll();
                
                ls.add(node);
                for(int neig : adj.get(node)){
                    if(!vis[neig]){
                        vis[neig] = true;
                        q.add(neig);
                    }
                }
              }
              compo.add(ls);
            }
        }


        int cnt = 0;

        for(List<Integer> ls : compo){
            boolean check = true;
            
            for(int i = 0;i < ls.size();i++){
                for(int j = 0;j < ls.size();j++){
                    if(i == j)continue;
                    if(!adj.get(ls.get(j)).contains(ls.get(i))){
                        check = false;
                        break;
                    }
                }
                if(!check)break;
            }

            if(check )cnt++;
        }
        return cnt;
    }
}