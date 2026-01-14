class Solution {
    public String findValidPair(String s) {
        // use hashmap
        // 
        int n = s.length();
        HashMap<Integer,Integer> mp = new HashMap<>();
        for(int i = 0;i < n;i++){
            int num = s.charAt(i) - '0';
            mp.put(num , mp.getOrDefault(num , 0) + 1) ;
        }
          
        // now traverse the string once again and check all pairs
        for(int i = 1;i < n;i++){
            int num1 = s.charAt(i - 1) - '0';
            int num2 = s.charAt(i) - '0';
            if(num1 != num2 && mp.get(num1) == num1 && mp.get(num2) == num2){
                return ""+ num1 + num2;
            }
        }
        return "";
    }
}