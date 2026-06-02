class Solution {
    public long bowlSubarrays(int[] nums) {
        int n = nums.length;

        int[] left = new int[n];
        int[] right = new int[n];

        Arrays.fill(left , -1);
        Arrays.fill(right , n);
        Stack<Integer> st = new Stack<>();

        for(int i = 0;i < n;i++){
            int num = nums[i];
            while(!st.isEmpty() && nums[st.peek()] < num){
                st.pop();
            }

            if(!st.isEmpty()){
                left[i] = st.peek();
            }
            st.push(i);
        }
        st.clear();

        for(int i = n - 1;i >= 0;i--){
            while(!st.isEmpty() && nums[st.peek()] < nums[i]){
                st.pop();
            }
            if(!st.isEmpty()){
                right[i] = st.peek();
            }
            st.push(i);
        }

        long cnt = 0;
        for(int i = 0;i < n;i++){
            if(left[i] != -1 && i - left[i] >= 2){
                cnt++;
            }
            if(right[i] != n && right[i] - i >= 2){
                cnt++;
            }
        }
        return cnt;
    }
}