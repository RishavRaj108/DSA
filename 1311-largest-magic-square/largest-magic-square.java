class Solution {
    public int largestMagicSquare(int[][] mat) {
        int R = mat.length;
        int C = mat[0].length;
        int maxSize = 1; // smallest magic square is 1x1

        // Try every cell as top-left corner
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                // maximum size square starting here
                int maxPossible = Math.min(R - r, C - c);

                for (int size = 2; size <= maxPossible; size++) {
                    if (isMagic(mat, r, c, size)) {
                        maxSize = Math.max(maxSize, size);
                    }
                }
            }
        }
        return maxSize;
    }

    // Check if square of given size starting at (r,c) is magic
    private boolean isMagic(int[][] mat, int r, int c, int size) {
        int target = 0;
        // sum of first row in the square
        for (int j = 0; j < size; j++) target += mat[r][c + j];

        // check all rows
        for (int i = 0; i < size; i++) {
            int rowSum = 0;
            for (int j = 0; j < size; j++) rowSum += mat[r + i][c + j];
            if (rowSum != target) return false;
        }

        // check all columns
        for (int j = 0; j < size; j++) {
            int colSum = 0;
            for (int i = 0; i < size; i++) colSum += mat[r + i][c + j];
            if (colSum != target) return false;
        }

        // check main diagonal
        int diag1 = 0;
        for (int k = 0; k < size; k++) diag1 += mat[r + k][c + k];
        if (diag1 != target) return false;

        // check anti-diagonal
        int diag2 = 0;
        for (int k = 0; k < size; k++) diag2 += mat[r + k][c + size - 1 - k];
        return diag2 == target;
    }
}
