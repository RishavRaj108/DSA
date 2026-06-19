class Solution {
    public int minOperations(int[] nums) {
        int opr = 0;
        Stack<Integer> st = new Stack<>();

        for(int num : nums){
           while(!st.isEmpty() && st.peek() > num){
            opr++;
            st.pop();
           }
           if(st.isEmpty() || st.peek() != num)st.push(num);
        }
        while(!st.isEmpty()){
            int num = st.pop();
            if(num != 0)
            opr++;
        }
        return opr;
    }
}