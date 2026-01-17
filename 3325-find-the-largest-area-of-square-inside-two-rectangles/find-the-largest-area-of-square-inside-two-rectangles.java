class Solution {
    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        int n = bottomLeft.length;
        int side = 0;
        for(int i = 0;i < n;i++){
            for(int j = i + 1;j < n;j++){
               // find from bottom max and from top min
               int maxX = Math.max(bottomLeft[i][0],bottomLeft[j][0]);
               int maxY = Math.max(bottomLeft[i][1],bottomLeft[j][1]);
               int minX = Math.min(topRight[i][0],topRight[j][0]);
               int minY = Math.min(topRight[i][1],topRight[j][1]);
               if(minX > maxX && minY > maxY){
                  side = Math.max(side, Math.min(minX - maxX , minY - maxY));
               }
            }
        }
        return (long)side * side;
    }
}