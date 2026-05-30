class Solution {
    public String removeSubstring(String s, int k) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        int open = 0;

        for(char ch : s.toCharArray()){
            sb.append(ch);
            if(ch == '('){
                open++;
            }else if(open >= k && sb.length() >= 2 * k){
                boolean valid = true;
                int len = sb.length();
                for(int i = len - (2 * k);i < len - k;i++){
                    if(sb.charAt(i) != '('){
                        valid = false;
                        break;
                    }
                }

                for(int i = len - k;i < len;i++){
                    if(sb.charAt(i) != ')'){
                        valid = false;
                        break;
                    }
                }
                if(valid){
                    sb.delete(len - (2 * k) , len );
                    open -= k;
                }
            }

        }
        return sb.toString();
    }
}