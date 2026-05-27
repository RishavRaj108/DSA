class Solution {
    public int monkeyMove(int n) {
        long mod = 1000000007;
        long ans = 1;
        long base = 2;
        while(n > 0){
          if(n % 2 == 1){
            ans = (ans * base) % mod;
          }
          base = (base * base) % mod;
          n = n / 2;
        }
        return (int)((ans - 2 + mod  ) % mod);
    }
}