class Solution {
    public int maxOperations(String s) {
        int n = s.length();
        
        int cntOnes = 0;
        int opr = 0;
        for(int i = 0;i < n;i++){
            char ch = s.charAt(i);
            if(ch == '1'){
                cntOnes++;
            }else{
                opr += cntOnes;
                while(i < n && s.charAt(i) == '0'){
                    i++;
                }
                i--;
            }
        }
        return opr;
    }
}