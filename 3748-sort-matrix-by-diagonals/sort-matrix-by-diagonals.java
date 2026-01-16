class Solution {
    public int[][] sortMatrix(int[][] grid) {
        // for black arrow sort in decresing order
        // for blue arrow sort in incresing order
        // how

        // we need to traverse all diagonals
        // then while travesal store all the elements and then call
        // sort function to sort the list according to the value 
        // value should be determined for sort order
        // then again traverse the diagonal to place the values

        int m = grid.length, n = grid[0].length;
        // first sort for blue part
        int i = 0;
        for(int j = 1;j < n;j++){
            List<Integer> ls = new ArrayList<>();
            int row = i;
            int col = j;
            while(row < m && col < n){
                ls.add(grid[row][col]);
                row++;
                col++;
            }
            Collections.sort(ls);
            row = i;col = j;
            int ind = 0;
            while(row < m && col < n){
                grid[row][col] = ls.get(ind);
                ind++;
                row++;
                col++;
            }
        }
        // sort the rest black part
        int j = 0;
        for(i = 0;i < m;i++){
            List<Integer> ls = new ArrayList<>();
            int row = i;
            int col = j;
            while(row < m && col < n){
                ls.add(grid[row][col]);
                row++;
                col++;
            }
            Collections.sort(ls,Collections.reverseOrder());
            row = i;col = j;
            int ind = 0;
            while(row < m && col < n){
                grid[row][col] = ls.get(ind);
                ind++;
                row++;
                col++;
            }
        }


        return grid;
    }
}