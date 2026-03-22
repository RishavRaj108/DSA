class Solution {
    public String[] shortestSubstrings(String[] arr) {
        int n = arr.length;
        String[] ans = new String[n];

        for (int i = 0; i < n; i++) {
            String s = arr[i];
            String best = "";

            int m = s.length();

            for (int len = 1; len <= m; len++) { // length priority
                for (int j = 0; j + len <= m; j++) {
                    String sub = s.substring(j, j + len);

                    boolean found = false;
                    for (int k = 0; k < n; k++) {
                        if (k == i) continue;
                        if (arr[k].contains(sub)) {
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        if (best.equals("") || sub.compareTo(best) < 0) {
                            best = sub;
                        }
                    }
                }
                if (!best.equals("")) break; // shortest found → stop
            }

            ans[i] = best;
        }

        return ans;
    }
}