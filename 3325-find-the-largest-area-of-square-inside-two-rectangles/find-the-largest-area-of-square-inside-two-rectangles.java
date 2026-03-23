class Solution {
    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        // bottom left is the point of rectangle from this we get smallest x and smallest y for that specific rectangle
        // top right is the point of rectangle from this we get largest x and largest y that this rectangle has
        
        // now thaught process we have to find the largest square that exist in two rectangle

        // now how to find intersection 
        // we have min x and min y of both the rectangle
        // we are going to choose the maximum
        // similarly for maxi x and y we are going to choose the smallest
        long side = 0;
        int n = bottomLeft.length;
        for(int i = 0;i < n;i++){
            for(int j = i + 1;j < n;j++){
                int maxx = Math.max(bottomLeft[i][0]  , bottomLeft[j][0]);
                int minx = Math.min(topRight[i][0]  , topRight[j][0]);
                int maxy = Math.max(bottomLeft[i][1]  , bottomLeft[j][1]);
                int miny = Math.min(topRight[i][1]  , topRight[j][1]);
                if(minx > maxx && miny > maxy){
                    side = Math.max(side , Math.min(minx - maxx , miny - maxy));
                }

            }
        }
        return 1L * side * side;
    }
}










