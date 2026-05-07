class Solution {
    class Cell{
        int r;
        int c;
        int val;
        Cell(int r,int c,int val){
            this.r = r;
            this.c = c;
            this.val = val;
        }
    }
    public int[][] colorGrid(int n, int m, int[][] sources) {
        Queue<Cell> q = new LinkedList<>();
        int[][] color = new int[n][m];
        for(int[] cell : sources){
            q.add(new Cell(cell[0],cell[1],cell[2]));
            color[cell[0]][cell[1]] = cell[2];
        }
        int[][] dirs = {{0,-1},{-1,0},{0,1},{1,0}};
        while(!q.isEmpty()){
           int size = q.size();
           PriorityQueue<Cell> pq = new PriorityQueue<>((a,b) -> b.val - a.val);
           while(!q.isEmpty()){
            pq.add(q.poll());
           }
           for(int i = 0;i < size;i++){
            Cell cell = pq.poll();
            int r = cell.r;
            int c = cell.c;
            int val = cell.val;

            for(int[] dir : dirs){
                int nr = r + dir[0];
                int nc = c + dir[1];
                if(nr >= 0 && nc >= 0 && nr < n && nc < m && color[nr][nc] == 0){
                    color[nr][nc] = val;
                    q.add(new Cell(nr,nc,val));
                }
            }
           }
        }
        return color;
    }
}













