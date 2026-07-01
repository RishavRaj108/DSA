class Solution {
    public int minimizedMaximum(int n, int[] quan) {
        int m = quan.length;
        int low = 0;
        int high = Integer.MIN_VALUE;
        for(int num : quan){
            high = Math.max(high , num);
        }
        int res = -1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(isPossible(mid,n , quan)){
              res = mid;
              high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return res;
    }
    public boolean isPossible(int maxi,int n, int[] quan){
        if(maxi == 0)return false;
        boolean check = true;
        
        int cnt = 0;
        for(int i = 0;i < quan.length;i++){
            cnt += (quan[i] + maxi - 1)/maxi;
            if(cnt > n)return false;
        }
        

        return true;
    }
}