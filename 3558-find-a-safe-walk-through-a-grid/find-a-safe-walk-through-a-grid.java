class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        // just go for bfs approch
        int m = grid.size();
        int n = grid.get(0).size();

        int[][] best = new int[m][n];
        for(int[] row : best){
            Arrays.fill(row , - 1);
        }

        Queue<int[]> q = new LinkedList<>();
        int start = health - grid.get(0).get(0);
        if(start <= 0) return false;

        q.offer(new int[]{0,0,start});

        best[0][0] = start;

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];
            int h = cur[2];

            if(r == m - 1 && c == n - 1)return true;

            for(int[] d: dirs){
                int nr = r + d[0];
                int nc = c + d[1];

                if(nr >= m || nc >= n || nr < 0 || nc < 0)continue;

                int newHeal = h - grid.get(nr).get(nc);
                if(newHeal <= 0)continue;

                if(best[nr][nc] >= newHeal)continue;

                best[nr][nc] = newHeal;
                q.offer(new int[]{nr,nc ,newHeal});
            }
        } 
        return false;
    }
}