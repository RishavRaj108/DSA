class Solution {
    public int maximumCandies(int[] candies, long k) {
        int n = candies.length;
        int s = 1;
        int e = 0;
        for(int can : candies)e = Math.max(can , e);

        int ans = 0;
        while(s <= e){
            int mid = s + (e - s)/2;
            if(isPoss(mid , candies , k)){
                ans = mid;
                s = mid + 1;
            }else{
                e = mid - 1;
            }
        }
        return ans;
    }
    public boolean isPoss(int candi,int[] candies,long k){
        long cnt = 0;
        int i = 0;
        int n = candies.length;
        while(i < n){
            int curr = candies[i];
            int count = 0;
            if(curr >= candi){
               count = curr/candi;
            }
            cnt += count;
            if(cnt >= k)return true;
            i++;
        }
        return false;
    }
}



