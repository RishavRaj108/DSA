class Solution {
    public int sumFourDivisors(int[] nums) {
        int res = 0;
        for(int n : nums){
            // 4 divisors possible only when 
            // 1 a b ab(n)
            // 1 a a*a a*a*a
            int sum = 0;
            int count = 0;
            for(int i = 1;i * i <= n;i++){
                if(n % i == 0){
                    int d1 = i;
                    int d2 = n/i;

                    if(d1 == d2){
                        count++;
                        sum += d1;
                    }else{
                        count += 2;
                        sum += d1 + d2;
                    }

                    if(count > 4)break;
                }
            }
            if(count == 4) res += sum;
        }
        return res;
    }
}