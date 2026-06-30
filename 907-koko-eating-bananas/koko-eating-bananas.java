class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int low = 1;
        int high = 0;
        for(int num : piles){
            high = Math.max(num , high);
        }
        int ans = -1;
        while(low <= high){
            int mid = low + (high - low)/ 2;
            if(check(mid , piles , h)){
                high = mid - 1;
                ans = mid;
            }else{
                low = mid + 1;
            }
        }
        return ans;
    }
    public boolean check(int amt , int[] piles , int time){
        long t = 0;
        for(int pile : piles){
            t += (pile + amt - 1)/ amt;
        }
        return t <= time;
    }
}