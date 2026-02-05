class Solution {
    public int largestPrime(int n) {
        // return largest prime no less than or equal to n
        // that can be expressed as the sum of one or more consecutive prime numbers starting from 2. If no such number exists, return 0.
        int sum = 0;
        int largest = 0;
        for(int i = 2;i <= n;i++){
            if(checkPrime(i)){
                sum += i;
                if(sum > n)break;
                if(checkPrime(sum)){
                    largest = sum;
                }
            }
        }
        return largest;
    }
    public boolean checkPrime(int num){
        for(int i = 2;i * i <= num; i++){
            if(num % i == 0)return false;
        }
        return true;
    }
}