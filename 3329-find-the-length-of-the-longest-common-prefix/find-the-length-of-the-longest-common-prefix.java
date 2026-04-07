class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
       Set<String> s = new HashSet<>();
       for(int num : arr1){
        String str = "" + num;
        for(int i = 0;i < str.length();i++){
            s.add(str.substring(0,i + 1));
        }
       } 
       int maxi = 0;
       for(int num : arr2){
        String str = "" + num;
        for(int i = 0;i < str.length();i++){
            String prefix = str.substring(0,i + 1);
            if(s.contains(prefix) && prefix.length() > maxi){
                maxi = prefix.length();
            } 
        }
       }
       return maxi;
    }
}