class Solution {
    public int maxPossibleScore(int[] start, int d) {
        Arrays.sort(start);
        int n = start.length;
        long s = 0;
        long e = Integer.MAX_VALUE;

        long ans = 0;
        while(s <= e){
            long mid = s + (e - s)/2;

            if(isPoss(mid , start , d)){
              ans = mid;
              s = mid + 1;
            }else{
                e = mid - 1;
            }
        }
        return (int)ans;
    }
    public boolean isPoss(long desired,int[] start,int d){
        long curr = start[0];
        for(int i = 1;i < start.length;i++){
            curr = Math.max((long)start[i] , curr + desired);
            if(curr > (long)start[i] + d){
                return false;
            }
        }
        return true;
    }
}