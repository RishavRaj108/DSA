class Solution {
    public int largestMagicSquare(int[][] grid) {
        int R = grid.length;
        int C = grid[0].length;
        int maxSize = 1;
        for(int i = 0;i < R;i++){
            for(int j = 0;j < C;j++){
               int maxPossible = Math.min(R - i,C - j);
               for(int size = 2;size <= maxPossible;size++){
                if(isMagic(i,j,size, grid)){
                    maxSize = Math.max(maxSize , size);
                }
               }
            }
        }
        return maxSize;
    }
    public boolean isMagic(int r, int c, int size , int[][] grid){
        int target = 0;
        for(int i = 0;i < size;i++){
            target += grid[r][c + i];
        }

        // check for row
        for(int i = 0;i < size;i++){
            int val = 0;
            for(int j = 0;j < size;j++){
               val += grid[r + i][c + j];
            }
            if(val != target)return false;
        }

        // check for col
        for(int j = 0;j < size;j++){
            int val = 0;
            for(int i = 0;i < size;i++){
                val += grid[r + i][c + j];
            }
            if(val != target)return false;
        }

        // for diagonal
        int diag = 0;
        for(int k = 0;k < size;k++){
            diag += grid[r + k][c + k];
        }
        if(diag != target)return false;

        int antiD = 0;
        for(int k = 0;k < size;k++){
            antiD += grid[r + k][ size - k + c - 1];
        }
        if(antiD != target)return false;
        return true;
    }
}