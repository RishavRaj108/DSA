class Solution {
    public int minTimeToReach(int[][] moveT) {
        // start from 0 , 0
        // time - 0
        // moving b/w adjacent rooms take one second
        // can move horizontally and vertically

        // dijikstras 
        // use pq sort on basis of time 
        // can move adj
        // first 1 then 2
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[3] - b[3]);
        
        // if type is 1 add 1 if type is 2 add 2
        pq.add(new int[]{0,0,1,0});
        int n = moveT.length;
        int m = moveT[0].length;
        int[][] dist = new int[n][m];
        for(int[] arr : dist){
            Arrays.fill(arr , Integer.MAX_VALUE);
        }
        dist[0][0] = 0;
        int[][] dirs = {{0,-1},{-1,0},{0,1},{1,0}};
        while(!pq.isEmpty()){
           int[] vals = pq.poll();
           int r = vals[0];
           int c = vals[1];
           int type = vals[2];
           int cost = vals[3];
           if(r == n -1 && c == m -1) return cost;

           for(int[] dir : dirs){
            int nr = r + dir[0];
            int nc = c + dir[1];
            int nCost = type;
            if(nr >= 0 && nr < n && nc >= 0 && nc < m){
                int gridVal = moveT[nr][nc];
                nCost += Math.max(gridVal , cost);
                int nType = type == 1? 2 : 1;
                if(dist[nr][nc] > nCost){
                   dist[nr][nc] = nCost;
                   pq.add(new int[]{nr,nc,nType,nCost});
                }
            }
           }
        }
        return -1;
    }
}