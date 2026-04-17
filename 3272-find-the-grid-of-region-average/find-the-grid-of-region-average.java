class Solution {
    public int[][] resultGrid(int[][] image, int threshold) {
        int m = image.length;
        int n = image[0].length;

        int[][] sum = new int[m][n];
        int[][] cnt = new int[m][n];

        for (int i = 0; i < m - 2; i++) {
            for (int j = 0; j < n - 2; j++) {
                boolean valid = true;

                for (int x = i; x < i + 3 && valid; x++) {
                    for (int y = j; y < j + 3; y++) {
                        if (x + 1 < i + 3 && Math.abs(image[x][y] - image[x + 1][y]) > threshold) {
                            valid = false;
                            break;
                        }
                        if (y + 1 < j + 3 && Math.abs(image[x][y] - image[x][y + 1]) > threshold) {
                            valid = false;
                            break;
                        }
                    }
                }

                if (valid) {
                    int total = 0;
                    for (int x = i; x < i + 3; x++) {
                        for (int y = j; y < j + 3; y++) {
                            total += image[x][y];
                        }
                    }
                    int avg = total / 9;
                    for (int x = i; x < i + 3; x++) {
                        for (int y = j; y < j + 3; y++) {
                             sum[x][y] += avg;
                             cnt[x][y]++;
                        }
                    }
                }
            }
        }

        int[][] res = new int[m][n];
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                if(cnt[i][j] > 0){
                    res[i][j] = sum[i][j] / cnt[i][j];
                }else{
                    res[i][j] = image[i][j];
                }
            }
        }
        return res;
    }
}