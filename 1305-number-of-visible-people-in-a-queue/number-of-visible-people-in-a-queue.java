class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        int n = heights.length;
        int[] res = new int[n];

        Stack<Integer> st = new Stack<>();
        for(int i = n - 1;i >= 0;i--){
            int no = heights[i];
            int count = 0;
            while(!st.isEmpty() && st.peek() < no){
                count++;
                st.pop();
            }
            if(!st.isEmpty()){
                count++;
            }
            res[i] = count;
            st.push(no);
        }
        return res;
    }
}