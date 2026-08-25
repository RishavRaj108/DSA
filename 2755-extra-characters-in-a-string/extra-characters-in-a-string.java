class Solution {
    int[] dp;
    public int minExtraChar(String s, String[] dict) {
        int n = s.length();
        dp = new int[n];
        Arrays.fill(dp , -1);
        Set<String> set = new HashSet<>();
        for(String str : dict){
           set.add(str);
        }
        return find(0,s,set);
    }
    public int find(int i,String s,Set<String> set){
        int n = s.length();
        if(i >= s.length())return 0;
        if(dp[i] != -1)return dp[i];

        int extra = 1 + find(i + 1,s,set);

        int poss = Integer.MAX_VALUE/2;
        for(int j = i;j < n;j++){
            String str = s.substring(i , j + 1);
            if(set.contains(str)){
                poss = Math.min(poss , find(j + 1 , s,set));
            }
        }
        return dp[i] = Math.min(extra , poss);
    }
}