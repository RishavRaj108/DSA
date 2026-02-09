class Solution {
    public String maxSumOfSquares(int num, int sum) {
        StringBuilder sb = new StringBuilder();

        // get the max val from the sum
        while(sum > 0){
            int digit = sum > 9? 9 : sum;
            sb.append(digit);
            sum -= digit;
        }
        int n = sb.length();
        if(n < num){
            n = num - n;
            for(int i = 0;i < n;i++){
               sb.append(0);
            }
        }
        if(sb.length() > num)return "";
        return sb.toString();
    }
}