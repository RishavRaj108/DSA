class Solution {
    public long minimumTime(int[] time, int totalTr) {
        int n = time.length;
        long low = 1;
        long high =1L * time[n - 1] * totalTr;
        long ans = -1;
        while(low <= high){
           long mid = low + (high - low)/2;

           if(isPossible(mid, time , totalTr)){
            ans = mid;
            high = mid - 1;
           }else{
            low = mid + 1;
           }
        }
        return ans;
    }
    public boolean isPossible(long t , int[] time , int totalTr){
        long cnt = 0;
        int n = time.length;
        for(int i = 0;i < n;i++){
            long num = time[i];
            cnt += t / num;
            if(cnt >= totalTr)return true;
        }
        return false;
    }
}



