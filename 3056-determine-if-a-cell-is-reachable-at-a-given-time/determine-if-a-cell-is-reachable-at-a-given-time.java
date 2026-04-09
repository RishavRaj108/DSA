class Solution {
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
       if(sx == fx && sy == fy && t == 1)return false;
       int x = Math.abs(sx - fx);
       int y = Math.abs(fy - sy);
       
       int mini = Math.min(x, y);
       int time = mini;
       x -= mini;
       y -= mini;
       time += x + y;
       return time <= t;
    }
}