class Solution {
    public long sumDigitDifferences(int[] nums) {
        int n = nums.length;
        int digits = 0;
        int num = nums[0];
        while(num > 0){
            digits++;
            num = num / 10;
        }

        long cnt = 0;
        
        while(digits > 0){
            int[] count = new int[10];
            for(int i = 0;i< n;i++){
                num = nums[i] % 10;
                nums[i] /= 10;
                count[num]++;
            }

            for(int c : count){
                cnt += 1L * c * (n - c);
            }
            digits--;
        }

        return cnt/2;
    }
}