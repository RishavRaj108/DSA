class Solution {
    public int longestString(int x, int y, int z) {
        int length = 0;
        int left = 0;
        while(x > 0 && y > 0){
           length += 4;
           x--;
           y--;
           if(x == 0){
            left = y;
           }else if(y == 0){
            left = x;
           }
        }
        if(left > 0 && z > 0){
            length += 4;
            left--;
            z--;
        }
        while(z > 0){
            length += 2;
            z--;
        }
        return length;
    }
}