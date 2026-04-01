class Solution {
    public int maxPointsInsideSquare(int[][] points, String s) {
        
        // distance -> list of tags (NOT set)
        Map<Integer, List<Character>> map = new HashMap<>();

        for (int i = 0; i < points.length; i++) {
            int r = Math.max(Math.abs(points[i][0]), Math.abs(points[i][1]));
            char tag = s.charAt(i);

            map.putIfAbsent(r, new ArrayList<>());
            map.get(r).add(tag);
        }

        List<Integer> distances = new ArrayList<>(map.keySet());
        Collections.sort(distances);

        Set<Character> used = new HashSet<>();
        int ans = 0;

        for (int r : distances) {

            List<Character> list = map.get(r);

            // Step 1: check duplicates inside same layer
            Set<Character> temp = new HashSet<>();
            for (char ch : list) {
                if (temp.contains(ch)) {
                    return ans; // duplicate inside same radius
                }
                temp.add(ch);
            }

            // Step 2: check with previous layers
            for (char ch : list) {
                if (used.contains(ch)) {
                    return ans;
                }
            }

            // Step 3: add all
            for (char ch : list) {
                used.add(ch);
                ans++;
            }
        }

        return ans;
    }
}