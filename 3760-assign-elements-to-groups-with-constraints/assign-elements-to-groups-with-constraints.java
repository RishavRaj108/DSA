class Solution {
    public int[] assignElements(int[] groups, int[] elements) {

        int n = groups.length;
        int[] ans = new int[n];

        // value -> smallest index
        Map<Integer, Integer> indexMap = new HashMap<>();

        for (int i = 0; i < elements.length; i++) {
            indexMap.putIfAbsent(elements[i], i);
        }

        for (int i = 0; i < n; i++) {
            int g = groups[i];
            int best = Integer.MAX_VALUE;

            for (int d = 1; d * d <= g; d++) {
                if (g % d == 0) {
                    // divisor d
                    if (indexMap.containsKey(d)) {
                        best = Math.min(best, indexMap.get(d));
                    }
                    // paired divisor g/d
                    int other = g / d;
                    if (other != d && indexMap.containsKey(other)) {
                        best = Math.min(best, indexMap.get(other));
                    }
                }
            }

            ans[i] = (best == Integer.MAX_VALUE) ? -1 : best;
        }

        return ans;
    }
}
