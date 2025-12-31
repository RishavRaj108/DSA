class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();

        char[][] board = new char[n][n];
        for (char[] row : board) Arrays.fill(row, '.');

        boolean[] cols = new boolean[n];
        boolean[] diag1 = new boolean[2 * n]; // row + col
        boolean[] diag2 = new boolean[2 * n]; // row - col + n

        backtrack(0, board, cols, diag1, diag2, result);
        return result;
    }

    private void backtrack(int row, char[][] board,
                           boolean[] cols, boolean[] diag1, boolean[] diag2,
                           List<List<String>> result) {

        if (row == board.length) {
            result.add(constructBoard(board));
            return;
        }

        for (int col = 0; col < board.length; col++) {
            int d1 = row + col;
            int d2 = row - col + board.length;

            if (cols[col] || diag1[d1] || diag2[d2]) continue;

            // place queen
            board[row][col] = 'Q';
            cols[col] = diag1[d1] = diag2[d2] = true;

            // explore next row
            backtrack(row + 1, board, cols, diag1, diag2, result);

            // remove queen
            board[row][col] = '.';
            cols[col] = diag1[d1] = diag2[d2] = false;
        }
    }

    private List<String> constructBoard(char[][] board) {
        List<String> res = new ArrayList<>();
        for (char[] row : board) res.add(new String(row));
        return res;
    }
}