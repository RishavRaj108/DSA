class Solution {
    public double myPow(double x, int n) {
        double ans = 1.0;
        long power = n;
        if(power < 0){
            x = 1 / x;
            power = -1*power;
        }
        while(power != 0){
            if(power % 2 == 1){
                ans = ans * x;
                power--;
            }else{
                power = power / 2;
                x = x * x;
            }
        }
        return ans;
    }
}