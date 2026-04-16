class Solution {
    public int[][] resultGrid(int[][] image, int threshold) {
        int m = image.length, n = image[0].length;
        // To store total of region averages for each cell
        int[][] sum = new int[m][n];
        // To count how many regions include this cell
        int[][] count = new int[m][n];

        // Traverse all possible 3x3 subgrids
        for (int i = 0; i <= m - 3; i++) {
            for (int j = 0; j <= n - 3; j++) {
                // Step 1: Check if this 3x3 region is valid
                boolean isValid = true;
                // Check all adjacent pairs inside 3x3
                for (int x = i; x < i + 3 && isValid; x++) {
                    for (int y = j; y < j + 3; y++) {
                        // Check right neighbor
                        if (y + 1 < j + 3) {
                            if (Math.abs(image[x][y] - image[x][y + 1]) > threshold) {
                                isValid = false;
                                break;
                            }
                        }
                        // Check down neighbor
                        if (x + 1 < i + 3) {
                            if (Math.abs(image[x][y] - image[x + 1][y]) > threshold) {
                                isValid = false;
                                break;
                            }
                        }
                    }
                }

                // Step 2: If valid, compute region average
                if (isValid) {
                    int total = 0;

                    // Sum all 9 cells
                    for (int x = i; x < i + 3; x++) {
                        for (int y = j; y < j + 3; y++) {
                            total += image[x][y];
                        }
                    }

                    int avg = total / 9; // floor automatically

                    // Step 3: Add this avg to all 9 cells
                    for (int x = i; x < i + 3; x++) {
                        for (int y = j; y < j + 3; y++) {
                            sum[x][y] += avg;
                            count[x][y]++;
                        }
                    }
                }
            }
        }

        // Step 4: Build result grid
        int[][] result = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // If belongs to at least one region
                if (count[i][j] > 0) {
                    result[i][j] = sum[i][j] / count[i][j];
                } else {
                    // Otherwise keep original
                    result[i][j] = image[i][j];
                }
            }
        }
        return result;
    }
}