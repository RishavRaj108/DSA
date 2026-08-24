class Solution {
    public long bowlSubarrays(int[] nums) {
        int n = nums.length;
        long cnt = 0L;

        Stack<Integer> st = new Stack<>();

        int[]left = new int[n];
        int[] right = new int[n];
        Arrays.fill(left , -1);
        Arrays.fill(right , n);

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
        for(int i = n -1;i >= 0;i--){
            int num = nums[i];
            while(!st.isEmpty() && nums[st.peek()] < num){
                st.pop();
            }
            if(!st.isEmpty()){
                right[i] = st.peek();
            }
            st.push(i);
        }

        for(int i = 0;i < n;i++){
            if(left[i] != -1 && i - left[i] + 1 >= 3){
                cnt++;
            }
            if(right[i] != n && right[i] - i + 1 >= 3){
                cnt++;
            }
        }
        return cnt;
    }
}