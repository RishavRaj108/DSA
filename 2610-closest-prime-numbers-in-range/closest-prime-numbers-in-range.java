class Solution {
    public int[] closestPrimes(int left, int right) {
        int[] res = {-1,-1};
        int prev = -1;
        if(left == 1)left++;
        int diffMax = Integer.MAX_VALUE;
        for(int i = left;i <= right;i++){
           if(isPrime(i)){
            if(prev == -1){
                prev = i;
                continue;
            }
            int diff = i - prev;
            if(diff < diffMax){
                diffMax = diff;
                res[0] = prev;
                res[1] = i;
            }
            prev = i;
           }
        }
        return res;
    }
    public boolean isPrime(int num){
        for(int i = 2;i * i <= num;i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }
}