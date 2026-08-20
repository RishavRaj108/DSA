class Solution {
    int[]t;
    public int minExtraChar(String s, String[] dict) {
        int n = s.length();
        t = new int[n];
        Arrays.fill(t , -1);
        Set<String> set = new HashSet<>();
        for(String str : dict){
            set.add(str);
        }
        return find(0,set,s);
    }
    public int find(int i , Set<String> set,String s){
        if(i >= s.length())return 0;
        if(t[i] != -1)return t[i];

        int skip = 1 + find(i + 1,set,s);
        int take = Integer.MAX_VALUE;

        for(int j = i;j < s.length();j++){
            String sub = s.substring(i , j + 1);

            if(set.contains(sub)){
                take = Math.min(take , find(j + 1,set,s));
            }
        }
        return t[i] =  Math.min(take , skip);
    }
}