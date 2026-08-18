class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;

        int[] nse = findNSE(heights);
        int[] pse = findPSE(heights);

        int area = 0;

        for(int i = 0;i < n;i++){
            area = Math.max(area , heights[i] * (nse[i] - pse[i] - 1));
        }
        return area;
    }
    public int[] findPSE(int[] heights){
        int n = heights.length;
        int[] pse = new int[n];
        Arrays.fill(pse , -1);
        Stack<Integer> st = new Stack<>();
        for(int i = n -1;i >= 0;i--){
            int curr = heights[i];
            while(!st.isEmpty() && heights[st.peek()] > curr){
                pse[st.pop()] = i;
            }
            st.push(i);
        }
        return pse;
    }
    public int[] findNSE(int[] heights){
        int n = heights.length;
        int[] nse = new int[n];
        Arrays.fill(nse , n);
        Stack<Integer> st = new Stack<>();

        for(int i = 0;i < n;i++){
            int curr = heights[i];
            while(!st.isEmpty() && heights[st.peek()] > curr){
                nse[st.pop()] = i;
            }
            st.push(i);
        }
        return nse;
    }
}