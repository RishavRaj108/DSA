class Solution {
    
    public int gcd(int a,int b){
        if(b == 0)return a;
        return gcd(b,a%b);
    }

    public int lcm(int a,int b){
        return (a/gcd(a,b)) * b;
    }

    public int maxLength(int[] nums) {
       // prod(arr) == lcm(arr) * gcd(arr)
       int n = nums.length;

       // gcd => gcd(a,b) => gcd(b,a % b)
       // lcm => lcm(a,b) => (a/gcd(a,b))*b;
       int maxLen = 1;
       for(int i = 0;i < n;i++){
        int product = nums[i];
        int g = nums[i];
        int l = nums[i];
        for(int j = i + 1;j < n;j++){
            product = product * nums[j];
            g = gcd(g, nums[j]);
            l = lcm(l,nums[j]);

            if(product == (g * l)){
                maxLen = Math.max(maxLen, j - i + 1);
            }
        }
       } 
       return maxLen;
    }
}