class Solution {
    public int minimizedMaximum(int n, int[] quan) {
        // ONE store one product type 
        int m = quan.length;
        int s = 1;
        int e = 0;
        for(int val : quan){
            e = Math.max(e , val);
        }

        int res = -1;
        while(s <= e){
            int mid = s + (e - s)/2;
            if(isPoss(mid , n , quan)){
                res = mid;
                e = mid - 1;
            }else{
                s = mid + 1;
            }
        }
        return res;
    }
    public boolean isPoss(int maxi,int n,int[] quan){
        long cnt = 0;
        for(int i = 0;i < quan.length;i++){
            cnt += (quan[i] + maxi - 1)/maxi;
        }
        return cnt <= n;
    }
}