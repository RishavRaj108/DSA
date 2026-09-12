class Solution {
    public int minDays(int[] blmD, int m, int k) {
        int n = blmD.length;
        int s = Integer.MAX_VALUE;
        int e = 0;
        if(n < m* k)return -1;

        for(int num : blmD){
            s = Math.min(s , num);
            e = Math.max(e , num);
        }

        int res = -1;
        while(s <= e){
          int mid = s + (e - s)/2;
          if(isPoss(blmD , mid , m , k)){
            res = mid;
            e = mid - 1;
          }else{
            s = mid + 1;
          }
        }
        return res;
    }
    public boolean isPoss(int[] blmD , int day,int m,int k){
        int n = blmD.length;
        int cnt = 0;
        int curr = 0;
        for(int i = 0;i < n;i++){
         int d = blmD[i];
         if(d > day){
            curr = 0;
         }else{
            curr++;
         }
         if(curr == k){
            cnt++;
            curr = 0;
         }
         if(cnt == m)return true;
        }
        return false;
    }
}




