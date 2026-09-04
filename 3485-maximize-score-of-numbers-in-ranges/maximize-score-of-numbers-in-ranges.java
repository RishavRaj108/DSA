class Solution {
    public int maxPossibleScore(int[] start, int d) {
        // min absolute diff between 2 integers
        // s = 1 , e = maxi + d;
        Arrays.sort(start);
        int n = start.length;
        int ans = 0;
        int s = 1;
        int e = start[n - 1] + d;
        while(s <= e){
            int mid = s + (e - s)/2;
            if(isPoss(mid , start , d)){
                ans = mid;
                s = mid + 1;
            }else{
                e = mid - 1;
            }
        }
        return ans;
    }
    public boolean isPoss(int diff , int[] start,int d){
        long curr = start[0];
        for(int i = 1;i < start.length;i++){
            curr = Math.max(start[i] , curr + diff);
            if(curr > start[i] + d) return false;
        }
        return true;
    }
}