class Solution {
    public int minOperations(int k) {
        if(k == 1)return 0;
        int mini = Integer.MAX_VALUE;
        for(int i = 1;i < k;i++){
            int val = (k + i - 1)/i;
            mini = Math.min(mini , val - 1 + i - 1);
             // ceil multiplication
        }
        return mini;
    }
}