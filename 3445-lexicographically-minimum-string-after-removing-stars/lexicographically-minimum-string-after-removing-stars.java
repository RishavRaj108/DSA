class Solution {
    public String clearStars(String s) {
        int n = s.length();
        PriorityQueue<Character> pq = new PriorityQueue<>();
        Map<Character , Deque<Integer>> mp = new HashMap<>();
        boolean[] check = new boolean[n];

        for(int i = 0;i < n;i++){
            char ch = s.charAt(i);
            if(ch == '*'){
               char small = pq.poll();
               int index = mp.get(small).pollLast();
               check[index] = true;
               check[i] = true;
            }else{
                pq.add(ch);
                mp.putIfAbsent(ch , new ArrayDeque<>());
                mp.get(ch).add(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i< n;i++){
            if(!check[i]){
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}