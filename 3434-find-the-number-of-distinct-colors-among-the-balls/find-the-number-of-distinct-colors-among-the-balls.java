class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        // approch
        // will maintain a map for each color and its occurence
        // while processing query if ball is uncolored do necessary stuff for map
        // if already colored then decrece that color on map and increse the query color.

        Map<Integer, Integer> mp = new HashMap<>();
        int n = queries.length;
        int[] res = new int[n];
        Map<Integer , Integer> balls = new HashMap<>();
        int ind = 0;
        for (int[] quer : queries) {
            int ball = quer[0];
            int color = quer[1];
            if (balls.containsKey(ball)) {
                // already colored ball
                mp.put(balls.get(ball), mp.get(balls.get(ball)) - 1);
                if (mp.get(balls.get(ball)) == 0) {
                    mp.remove(balls.get(ball));
                }
            }
            balls.put(ball , color);
            mp.put(color, mp.getOrDefault(color , 0) + 1);
            res[ind++] = mp.size();
        }
        return res;
    }
}