class Solution {
    public int minimizedMaximum(int n, int[] quan) {
       int m = quan.length;
       int low = 0;
       int high = -1;
       for(int num : quan){
        high = Math.max(num , high);
       }

       int ans = 0;
       while(low <= high){
        int mid = low + (high - low)/2;
        if(isPossible(mid , quan , n)){
            ans = mid;
            high = mid - 1;
        }else{
            low = mid + 1;
        }
       }
       return ans;
    }
    public boolean isPossible(int cap , int[] quan , int n){
        if(cap == 0)return false;
        int cnt = 0;
        for(int num : quan){
            cnt += (num + cap - 1)/cap;
        }
        return cnt <= n;
    }
}