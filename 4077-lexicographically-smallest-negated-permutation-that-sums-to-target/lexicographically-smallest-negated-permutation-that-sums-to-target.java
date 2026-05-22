class Solution {
    public int[] lexSmallestNegatedPerm(int n, long target) {
        // n 
        // dictionary order smallest
        // sum of elem == target
        // abs permutation of n 1 2 3 ...  n
        
        // get sum then sub then elem by reduction 
        // sum - target = redu 
        // remove it from sum

        long sum = (long)(n) * (n + 1) / 2;
        sum = sum - target;
        if(sum < 0 || sum % 2 != 0){
            return new int[]{};// empty array
        }
        sum = sum / 2;
        boolean[] nega = new boolean[n + 1];

        for(int i = n;i >= 1;i--){
            if(sum >= i){
                nega[i] = true;
                sum -= i;
            }
        }
        if(sum != 0)return new int[]{};
        int[] res = new int[n];
        int j = 0;
        for(int i = n;i >= 0;i--){
           if(nega[i]){
            res[j++] = (-1 * i); 
           }
        }
        for(int i = 1;i <= n;i++){
            if(!nega[i]){
                res[j++] = i;
            }
        }
        return res;

    }
}