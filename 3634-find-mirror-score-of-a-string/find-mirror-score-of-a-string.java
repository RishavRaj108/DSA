class Solution {
    public long calculateScore(String s) {
        long score = 0;
        String first = "abcdefghijklmnopqrstuvwxyz";
        String second ="zyxwvutsrqponmlkjihgfedcba";

        Map<Character, List<Integer>> mp = new HashMap<>();
        int n = s.length();
        
        for(int i = 0;i < n;i++){
            char ch = s.charAt(i);
            int ind = ch - 'a';
            char mirror = second.charAt(ind);
            if(mp.containsKey(mirror)){
               List<Integer> ls = mp.get(mirror);
               score += i - ls.get(ls.size() - 1);
               ls.remove(ls.size() - 1);
               if(ls.size() == 0){
                mp.remove(mirror);
               }
               continue;
            }
            mp.computeIfAbsent(ch ,k -> new ArrayList<>()).add(i);
        }
        return score;
    }
}