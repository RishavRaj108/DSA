class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int[] need = new int[26];
        int[] curr = new int[26];
        if(s2.length() < s1.length())return false;
        for(char ch : s1.toCharArray()){
            need[ch - 'a']++;
        }
        for(int i = 0;i < n;i++){
            char ch = s2.charAt(i);
            curr[ch - 'a']++;
        }
        for(int i = n; i < s2.length();i++){
            if(check(need , curr))return true;
            int rmv = i - n;
            char ch = s2.charAt(rmv);
            curr[ch - 'a']--;
            ch = s2.charAt(i);
            curr[ch - 'a']++;
        }
        if(check(need , curr))return true;
        return false;
    }
    public boolean check(int[] need,int[] curr){
        for(int i = 0;i < 26;i++){
            if(need[i] != curr[i])return false;
        }
        return true;
    }
}