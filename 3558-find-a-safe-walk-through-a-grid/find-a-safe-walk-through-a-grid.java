class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m = grid.size();
        int n = grid.get(0).size();
        int[][] dirs = {{0,-1},{-1,0},{0,1},{1,0}};
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[2] - a[2]);
        if(grid.get(0).get(0) == 1)health--;
        pq.add(new int[]{0,0,health});
        int[][] dist = new int[m][n];
        for(int[] row : dist){
            Arrays.fill(row , Integer.MIN_VALUE);
        }
        dist[0][0] = health; 
        while(!pq.isEmpty()){
            int[] vals = pq.poll();
            int r = vals[0];
            int c = vals[1];
            int hel = vals[2];
            
            for(int i = 0;i < 4;i++){
                int nr = r + dirs[i][0];
                int nc = c + dirs[i][1];
                if(nr >= 0 && nr < m && nc >= 0 && nc < n){
                    int newHel = hel - grid.get(nr).get(nc);
                    if(newHel <= 0)continue;
                    if(nr == m - 1 && nc == n - 1){
                        return true;
                    }
                    if(newHel > dist[nr][nc]){
                        dist[nr][nc] = newHel;
                        pq.add(new int[]{nr,nc , newHel});
                    }
                }
            }
        }
        return false;
    }
}









