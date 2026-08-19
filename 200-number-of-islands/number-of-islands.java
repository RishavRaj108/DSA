class Solution {
    public int numIslands(char[][] grid) {
        // return no of islands

        // can be done via both dfs and bfs

        int m = grid.length;
        int n = grid[0].length;

        int count = 0;
        boolean [][] vis = new boolean[m][n];
        int[][] dirs = {{-1,0},{0,1},{1,0},{0,-1}}; 
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
               if(vis[i][j] == false && grid[i][j] != '0'){
                // land found
                count++;
                Queue<int[]> q = new LinkedList<>();
                q.add(new int[]{i,j});
                vis[i][j] = true;
                
                while(!q.isEmpty()){
                    int[] vals = q.poll();
                    int r = vals[0];
                    int c = vals[1];

                    

                    for(int k = 0;k < 4;k++){
                        int nr = r + dirs[k][0];
                        int nc = c + dirs[k][1];

                        if(nr >= 0 && nc >= 0 && nr < m && nc < n && grid[nr][nc] == '1' && vis[nr][nc] == false){
                            vis[nr][nc] = true;
                            q.add(new int[]{nr,nc});
                        }
                    }
                }

               }
            }
        }


        return count;
    }
}