class Solution {
    public long calculateScore(String s) {
        // At each step we must put valuse to map for each char
        // mirror to find mirror of a char 'a' - > 'z'  26 - ch
        // b -> y and 26 - ch + 'a'

        Map<Integer , List<Integer>> mp = new HashMap<>();

        long score = 0;
        int n = s.length();
        for(int i = 0;i < n;i++){
            char ch = s.charAt(i);
            int mirror = 'z' - ch;
            if(mp.containsKey(mirror)){
                List<Integer> vals = mp.get(mirror);
                score += i - vals.get(vals.size() - 1);
                vals.remove(vals.size() - 1);
                if(vals.size() == 0){
                    mp.remove(mirror);
                }
                continue;
            }
            mp.computeIfAbsent(ch - 'a' , k -> new ArrayList<>()).add(i);
        } 
        return score;
    }
}