class Solution {
    public boolean hasMatch(String s, String p) {
        int index = p.indexOf("*");
        if(p.length() == 1)return true;

        int first = s.indexOf(p.substring(0,index));
        int second = s.indexOf(p.substring(index + 1), first + index);

        if(first != -1 && second != -1)return true;
        return false;
    }
}