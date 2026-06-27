class Solution {
    int minimumTime = Integer.MAX_VALUE;

    public int findMinimumTime(List<Integer> strength, int k) {
        calculateMinimumTime(strength, 0, 1, k, 0);
        return minimumTime;
    }

    private void calculateMinimumTime(
        List<Integer> strength,
        int currentMask,
        int currentFactor,
        int k,
        int elapsedTime
    ) {
        int n = strength.size();

        if (currentMask == (1 << n) - 1) {
            minimumTime = Math.min(minimumTime, elapsedTime);
            return;
        }

        for (int i = 0; i < n; i++) {
            if ((currentMask & (1 << i)) != 0) continue;

            int additionalTime = (strength.get(i) + currentFactor - 1) / currentFactor;

            calculateMinimumTime(
                strength,
                currentMask | (1 << i),
                currentFactor + k,
                k,
                elapsedTime + additionalTime
            );
        }
    }
}