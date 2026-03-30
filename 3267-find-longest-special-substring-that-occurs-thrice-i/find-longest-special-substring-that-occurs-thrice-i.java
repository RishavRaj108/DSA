class Solution {
    public int maximumLength(String s) {
        int n = s.length();
        Map<String ,Integer> mp = new HashMap<>();

        for(int i = 0;i < n;i++){
            for(int j = i;j < n;j++){
                String str = s.substring(i , j + 1);
                mp.put(str, mp.getOrDefault(str , 0) + 1);
            }
        }

        int maxi = -1;
        for(String str : mp.keySet()){
            int count = mp.get(str);
            if(count >= 3 && isSpecial(str)){
                maxi = Math.max(maxi , str.length());
            }
        }   
        return maxi;
    }
    public boolean isSpecial(String s){
        for(int i = 1;i < s.length();i++){
          if(s.charAt(i) != s.charAt(i - 1)){
            return false;
          }
        }
        return true;
    }
}