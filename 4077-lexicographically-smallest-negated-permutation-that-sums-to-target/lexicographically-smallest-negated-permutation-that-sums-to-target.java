class Solution {
    public int[] lexSmallestNegatedPerm(int n, long target) {
        long total = (long)(n) * (n+1)/2;
        long req = total - target;

        if(req < 0 || req % 2 != 0){
            return new int[]{};
        }
        long negativeSum = req/2;
        boolean isNegative[] = new boolean[n+1];
        for(int i=n; i>=1; i--){
            if(negativeSum  >= i){
                isNegative[i] = true;
                negativeSum -= i;
            }
        }
        if(negativeSum != 0) return new int[]{};
        int ans[] = new int[n];
        int idx = 0;
        for(int i=n; i>=1; i--){
            if(isNegative[i]){
                ans[idx] = -i;
                idx++;
            }
        }
        for(int i=1; i<=n; i++){
            if(!isNegative[i]){
                ans[idx] = i;
                idx++;
            }
        }
        return ans;
    }
}