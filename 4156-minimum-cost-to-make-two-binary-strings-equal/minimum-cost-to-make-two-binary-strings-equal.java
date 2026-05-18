class Solution {
    public long minimumCost(String s, String t, int flipCost, int swapCost, int crossCost) {
        long a = 0, b = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == t.charAt(i)) continue;

            if (s.charAt(i) == '0') a++;
            else b++;
        }

        long pairs = Math.min(a, b);

        long ans = pairs * Math.min(swapCost, 2L * flipCost);

        long rem = Math.abs(a - b);

        ans += (rem / 2) *
               Math.min(
                   crossCost + swapCost,
                   2L * flipCost
               );

        if (rem % 2 == 1)
            ans += flipCost;

        return ans;
    }
}