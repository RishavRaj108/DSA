class Solution {
    public int minCost(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int INF = (int)1e9;

        // cost[i][j] = min cost to reach bottom-right from (i,j)
        int[][] cost = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(cost[i], INF);
        }

        // store all cells
        int[][] cells = new int[n * m][2];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                cells[idx++] = new int[]{i, j};
            }
        }

        // sort cells by grid value
        Arrays.sort(cells, (a, b) ->
            Integer.compare(grid[a[0]][a[1]], grid[b[0]][b[1]])
        );

        // repeat for each teleport usage
        for (int step = 0; step <= k; step++) {

            // ---- TELEPORT RELAXATION ----
            int best = INF;

            for (int i = 0; i < cells.length; i++) {
                int r = cells[i][0];
                int c = cells[i][1];

                best = Math.min(best, cost[r][c]);

                // skip same-value cells until last one
                if (i + 1 < cells.length &&
                    grid[r][c] == grid[cells[i + 1][0]][cells[i + 1][1]]) {
                    continue;
                }

                // propagate best to all same-value cells
                int back = i;
                while (back >= 0 &&
                       grid[cells[back][0]][cells[back][1]] == grid[r][c]) {
                    cost[cells[back][0]][cells[back][1]] = best;
                    back--;
                }
            }

            // ---- NORMAL MOVES DP ----
            for (int i = n - 1; i >= 0; i--) {
                for (int j = m - 1; j >= 0; j--) {

                    if (i == n - 1 && j == m - 1) {
                        cost[i][j] = 0;
                        continue;
                    }

                    if (i + 1 < n) {
                        cost[i][j] = Math.min(
                            cost[i][j],
                            cost[i + 1][j] + grid[i + 1][j]
                        );
                    }

                    if (j + 1 < m) {
                        cost[i][j] = Math.min(
                            cost[i][j],
                            cost[i][j + 1] + grid[i][j + 1]
                        );
                    }
                }
            }
        }

        return cost[0][0];
    }
}
