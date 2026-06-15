class Solution {
    public long maxArea(int[][] coords) {
        // 
        int minx = Integer.MAX_VALUE;
        int maxx = Integer.MIN_VALUE;
        int miny = Integer.MAX_VALUE;
        int maxy = Integer.MIN_VALUE;
        Map<Integer , int[]> mpx = new HashMap<>();
        Map<Integer , int[]> mpy = new HashMap<>();

        for(int[] coord : coords){
            int x = coord[0];
            int y = coord[1];
            mpx.putIfAbsent(x, new int[]{y,y});
            mpx.get(x)[0] = Math.min(mpx.get(x)[0] , y);
            mpx.get(x)[1] = Math.max(mpx.get(x)[1] , y);


            mpy.putIfAbsent(y, new int[]{x,x});
            mpy.get(y)[0] = Math.min(mpy.get(y)[0] , x);
            mpy.get(y)[1] = Math.max(mpy.get(y)[1] , x);
            minx = Math.min(minx , x);
            miny = Math.min(miny , y);
            maxx = Math.max(maxx , x);
            maxy = Math.max(maxy, y);
        }
        long maxArea = -1;
        for(int val : mpx.keySet()){
            int[] arr = mpx.get(val);
            long base = arr[1] - arr[0];
            long height = Math.max(maxx - val , val - minx);
            if(base > 0){
                maxArea = Math.max( maxArea , base * height);
            }
        }
        for(int val : mpy.keySet()){
            int[] arr = mpy.get(val);
            long base = arr[1] - arr[0];
            long height = Math.max(maxy - val , val - miny);
            if(base > 0){
                maxArea = Math.max( maxArea , base * height);
            }
        }
        return maxArea == 0? -1 : maxArea;
    }
}









