class Solution {
    public int countWays(int[][] ranges) {
        
        Arrays.sort(ranges , (a,b) -> a[0] - b[0]);
        long mod = 1000000007;
        long cnt = 1;
        int prev = -1;
        for(int[] range : ranges){
           int start = range[0];
           int end = range[1];
           // if start > prev end new group
           // else same group
           if( start > prev){
            cnt = (cnt * 2) % mod;
            
           }
           prev = Math.max(end , prev);
        }
        if(cnt == 1)return 2;
        return (int)cnt;
    }
}