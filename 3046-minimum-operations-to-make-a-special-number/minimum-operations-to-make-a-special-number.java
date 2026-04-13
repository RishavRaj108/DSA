class Solution {
    public int minimumOperations(String num) {
        int n = num.length();
        int ans = n; // worst case delete all

        String[] targets = {"00", "25", "50", "75"};

        for(String t : targets) {
            int j = 1; // match from end of target
            int deletions = 0;

            for(int i = n - 1; i >= 0; i--) {
                if(num.charAt(i) == t.charAt(j)) {
                    j--;
                    if(j < 0) {
                        ans = Math.min(ans, deletions);
                        break;
                    }
                } else {
                    deletions++;
                }
            }
        }
        int zerocnt = 0;
        for(char ch : num.toCharArray()){
            if(ch == '0'){
             zerocnt++;
            }
        }
        if(zerocnt > 0){
            ans = Math.min(ans , n - 1);
        }
        return ans;
    }
}