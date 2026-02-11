class Solution {
    public int minArrivalsToDiscard(int[] arr, int w, int m) {

        int n = arr.length;
        Map<Integer, Integer> freq = new HashMap<>();
        boolean[] kept = new boolean[n];

        int left = 0;
        int discard = 0;

        for (int right = 0; right < n; right++) {

            int val = arr[right];

            // Remove elements outside window
            while (right - left + 1 > w) {
                if (kept[left]) {
                    int old = arr[left];
                    freq.put(old, freq.get(old) - 1);
                }
                left++;
            }

            // Check if keeping causes violation
            if (freq.getOrDefault(val, 0) >= m) {
                discard++;
                kept[right] = false;
            } else {
                freq.put(val, freq.getOrDefault(val, 0) + 1);
                kept[right] = true;
            }
        }

        return discard;
    }
}
