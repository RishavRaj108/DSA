class Solution {
    public int[] asteroidCollision(int[] aster) {
        int n = aster.length;

        Stack<Integer> st = new Stack<>();

        for(int i = 0;i < n;i++){
            int val = aster[i];
            boolean check = false;
            while(!st.isEmpty() && ((st.peek() > 0 && val < 0) )){
                if(Math.abs(val) > Math.abs(st.peek()))st.pop();
                else if(Math.abs(val) == Math.abs(st.peek())){
                    check = true;
                    st.pop();
                    break;
                }
                else{
                    check = true;
                    break;
                }
            }
            if(check)continue;
            st.push(val);
        }

        Stack<Integer> s = new Stack<>();
        int size = 0;
        while(!st.isEmpty()){
            size++;
            s.push(st.pop());
        }
        int[] res = new int[size];
        int ind = 0;
        while(!s.isEmpty()){
          res[ind++] = s.pop();
        }
        return res;
    }
}