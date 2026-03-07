class Solution {
    public long gcd(long a , long b){
        if(b == 0)return a;
        return gcd(b, a % b);
    }
    public long lcm(long a , long b){
        return (a / gcd(a , b))* b;
    }
    public long maxScore(int[] nums) {
        long maxi = 0;
        int n = nums.length;
        long l = nums[0];
        long g = nums[0];
        for(int i = -1;i < n;i++){
            l = 1;
            g = 1;
            boolean started = false;
          for(int j = 0;j < n;j++){
            if(i == j)continue;
            if(!started){
                started = true;
                l = nums[j];
                g = nums[j];
            }
            l = lcm(l , nums[j]);
            g = gcd(g , nums[j]);
          }
          maxi = Math.max(maxi , l * g);
        }
        return maxi;
    }
}