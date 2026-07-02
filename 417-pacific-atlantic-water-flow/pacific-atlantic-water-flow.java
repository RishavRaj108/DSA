class Solution {
    int[][] dirs = {{-1,0},{0,1},{0,-1},{1,0}};
    public void bfs( Queue<int[]> q,boolean[][] vis,int[][] heig){
        int m = heig.length;
        int n = heig[0].length;
        while(!q.isEmpty()){
           int[] cord = q.poll();
           int x = cord[0];
           int y = cord[1];
           vis[x][y] = true;
           for(int[] dir : dirs){
              int nx = dir[0] + x;
              int ny = dir[1] + y;
              if(nx >= 0 && nx < m && ny >= 0 && ny < n && vis[nx][ny] == false && heig[nx][ny] >= heig[x][y]){
                vis[nx][ny] = true;
                q.add(new int[]{nx,ny});
              }
           }
        }
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        Queue<int[]> q1 = new LinkedList<>();
        Queue<int[]> q2 = new LinkedList<>();
        int m = heights.length;
        int n = heights[0].length;
        for(int i = 0;i < m;i++){
           q1.add(new int[]{i , 0});
           q2.add(new int[]{i,n - 1});
        }
        for(int i = 0;i < n;i++){
            q1.add(new int[]{0,i});
            q2.add(new int[]{m - 1,i});
        }
        boolean[][] vis1 = new boolean[m][n];
        boolean[][] vis2 = new boolean[m][n];
        bfs(q1 , vis1, heights);
        bfs(q2 , vis2, heights);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
               if(vis1[i][j] && vis2[i][j]){
                List<Integer> ls = new ArrayList<>();
                ls.add(i);
                ls.add(j);
                ans.add(ls);
               }
            }
        }

        return ans;

    }
}