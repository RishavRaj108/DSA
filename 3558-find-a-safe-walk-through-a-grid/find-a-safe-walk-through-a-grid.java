class Solution {
    class Pair{
        int row;
        int col;
        int hel;
        Pair(int row , int col , int hel){
            this.row = row;
            this.col = col;
            this.hel = hel;
        }
    }
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m = grid.size();
        int n = grid.get(0).size();
        int[][] best = new int[m][n];
        for(int[] arr : best){
            Arrays.fill(arr , -1);
        }
        Queue<Pair> q = new LinkedList<>();
        if(grid.get(0).get(0) == 1)health--;
        best[0][0] = health;
        q.add(new Pair(0,0,health));
        int[][] dirs = {{-1,0},{0,-1},{0,1},{1,0}};
        while(!q.isEmpty()){
            Pair p = q.poll();
            int r = p.row;
            int c = p.col;
            int hel = p.hel;

            for(int[] dir : dirs){
                int nr = r + dir[0];
                int nc = c + dir[1];
                int val = hel;
                if(nr >= m || nr < 0 || nc >= n || nc < 0)continue;
                if(grid.get(nr).get(nc) == 1)val--;
                if(best[nr][nc] >= val)continue;
                best[nr][nc] = val;
                if(val > 0){
                    if(nr == m - 1 && nc == n - 1)return true;
                    q.add(new Pair(nr,nc , val));
                }
            }
        }

        return false;
    }
}











