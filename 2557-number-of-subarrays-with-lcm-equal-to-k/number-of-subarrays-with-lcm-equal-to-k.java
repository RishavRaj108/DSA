class Solution {
    public int subarrayLCM(int[] nums, int k) {
        int cnt = 0;
        for(int i = 0;i < nums.length;i++){
            int currLcm = 1;
            for(int j = i;j < nums.length;j++){
                currLcm = lcm(currLcm , nums[j]);
                if(currLcm == k) cnt++;

                if(currLcm > k || k % currLcm != 0)break;
            }
        }
        return cnt;
    }
    public int lcm(int a,int b){
        return (a/gcd(a,b)) * b;
    }
    public int gcd(int a , int b){
        return b == 0? a : gcd(b , a%b);
    }
}