class Solution {
    public boolean isPossibleToRearrange(String s, String t, int k) {
        int n = s.length();
        int m = t.length();
        if(n != m)return false;
        if(n % k != 0)return false;
        Map<String , Integer> mp = new HashMap<>();
        int size = n / k;
        for(int i = 0;i < n;i++){
            StringBuilder sb = new StringBuilder();
            int p = size;
            while(p-- > 0){
                sb.append(s.charAt(i));
                i++;
            }
            String str = sb.toString();
            mp.put(str, mp.getOrDefault(str , 0) + 1);
            i--;
        }
        for(int i = 0;i < n;i++){
            StringBuilder sb = new StringBuilder();
            int p = size;
            while(p-- > 0 ){
                sb.append(t.charAt(i));
                i++;
            }
            i--;
            String str = sb.toString();
            if(mp.containsKey(str)){
              mp.put(str , mp.get(str) - 1);
              if(mp.get(str) == 0){
                mp.remove(str);
              }
            }else{
                return false;
            }
        }
        return true;
    }
}