class Solution {
    public String getSmallestString(String s, int k) {
        if(k == 0)return s;

        // lexico that means every time we aim to make first index to as small as possible
        String str = "abcdefghijklmnopqrstuvwxyz";

        char[] chars = s.toCharArray();

        int ind = 0;
        while( k > 0 && ind < chars.length){
            // try to reduce the index to as low as possible
            char ch = chars[ind];
            int val = Math.min(ch - 'a' , Math.abs(ch - 'z' )+ 1);
            if(val <= k){
               chars[ind] = 'a';
               k -= val;
            }else{
               val = str.indexOf(ch);
               chars[ind] = str.charAt(val - k);
               break;
            }
            ind++;
        }
        return new String(chars);
    }
}