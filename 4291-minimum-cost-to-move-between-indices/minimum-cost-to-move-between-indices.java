class Solution {
    public int[] minCost(int[] nums, int[][] queries) {
        int n = nums.length;
        int m = queries.length;
        int[] close = new int[n];
        close[0] = 1;
        close[n - 1] = n -2;
        for(int i = 1;i < n-1;i++){
            int num = nums[i];
            int left = Math.abs(num - nums[i - 1]);
            int right = Math.abs(num - nums[i + 1]);
            if(left <= right){
                close[i] = i -1;
            }else{
                close[i] = i + 1;
            }
        }
        int[] left = new int[n];
        int[] right = new int[n];
        for(int i = 1; i< n;i++){
            int cost = 0;
            if(close[i -1] != i){
                cost = Math.abs(nums[i - 1] - nums[i]);
            }else{
                cost++;
            }
            cost += left[i - 1];
            left[i] = cost;
        }
        for(int i = n - 2;i >= 0;i--){
            int cost = 0;
            if(close[i + 1] != i){
                cost = Math.abs(nums[i + 1] - nums[i]);
            }else{
                cost++;
            }
            cost += right[i + 1];
            right[i] = cost;
        }

        int[] res = new int[m];
        int ind = 0;
        for(int[] quer : queries){
            int l = quer[0];
            int r = quer[1];
            int cost = 0;
            if(l < r){
                cost = left[r] - left[l];
            }else{
               cost =right[r] - right[l];
            }
            res[ind++] = cost;
        }
        return res;
    }
}