class Solution {
    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        int n = reward1.length;
        int[][] vals = new int[n][2];

        for(int i = 0;i < reward2.length;i++){
            vals[i][0] = i;
            // if reward1 is more then - other wise +
            vals[i][1] = reward1[i] - reward2[i];
        }

        Arrays.sort(vals , (a,b) -> b[1] - a[1]);
        int ans = 0;
        for(int i = 0;i < n;i++){
            int ind = vals[i][0];
            if(k > 0){
               ans += reward1[ind];
               k--;
               continue;
            }else{
               ans += reward2[ind];
            }
        }
        return ans;
    }
}