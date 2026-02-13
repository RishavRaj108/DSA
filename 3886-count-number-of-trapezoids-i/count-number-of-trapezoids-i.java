class Solution {
    static final int M = (int)1e9 + 7;

    public int countTrapezoids(int[][] points) {
        // Map y -> count of points having that y-coordinate
        Map<Integer, Integer> mp = new HashMap<>();
        for (int[] point : points) {
            int y = point[1];
            mp.put(y, mp.getOrDefault(y, 0) + 1);
        }

        long result = 0;
        long prevHorizontalLines = 0;

        // Iterate over the hashmap
        for (int count : mp.values()) {

            long horizontalLines = (long) count * (count - 1) / 2;  // C(n, 2)

            result = (result + horizontalLines * prevHorizontalLines) % M;

            prevHorizontalLines += horizontalLines;
        }

        return (int)(result % M);
    }
}