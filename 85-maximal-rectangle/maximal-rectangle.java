class Solution {
    public int maximalRectangle(char[][] matrix) {
        // too many things to do
        // create a grid of same size as of matrix
        // at each level we add prefix sum if val 1 increase else 0
        // after this our grid is ready for comparision
        // now at each row we should find pse and nse for each index
        // and on basis of that calculate area row * col
        int m = matrix.length, n = matrix[0].length;
        int[][] grid = new int[m][n];
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                if(i == 0){
                    grid[i][j] = matrix[i][j] - '0';
                }else{
                    if(matrix[i][j] == '1'){
                        grid[i][j] = grid[i - 1][j] + 1;
                    }
                }
            }
        }
        int maxA = 0;
        for(int[] row: grid){
           int[] NSE = findNSE(row);
           int[] PSE = findPSE(row);
           for(int i = 0;i < n;i++){
            int area = (NSE[i] - PSE[i] -1) * row[i];
            maxA = Math.max(maxA, area);
           }
        }
        return maxA;
    }

    public int[] findNSE(int[] arr){
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int[] res = new int[n];
        for(int i = n - 1;i >= 0;i--){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }
            res[i] = st.isEmpty()? n : st.peek();
            st.push(i);
        }
        return res;
    }
    public int[] findPSE(int[] arr){
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int[] res = new int[n];
        for(int i = 0;i < n;i++){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }
            res[i] = st.isEmpty()? -1 : st.peek();
            st.push(i);
        }
        return res;
    }
}