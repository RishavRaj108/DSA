class Solution {
    public long flowerGame(int n, int m) {
        long cnt = 0;
        int odd1 = 0;
        int even1 = 0;
        for(int i = 1;i <= n;i++){
            if(i % 2 == 0){
                even1++;
            }else{
                odd1++;
            }
        }
        int odd2 = 0;
        int even2 = 0;
        for(int i = 1;i <= m;i++){
            if(i % 2 == 0){
                even2++;
            }else{
                odd2++;
            }
        }
        cnt = (1L * even1 * odd2) + (1L * even2 * odd1);
        return cnt;
    }
}