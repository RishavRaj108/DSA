class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
       int n =  intervals.length;
       int cnt = 0;

       Arrays.sort(intervals , (a,b) -> {
        if(a[1] != b[1]) return a[1] - b[1];
        else return a[0] - b[0];
       });
       int[] prev = intervals[0];
       for(int i = 1;i < n;i++){
        int[] inter =intervals[i];
        if(inter[0] >= prev[1]){
            prev = inter;
        }else{
            cnt++;
        }
       }
       return cnt;
    }
}