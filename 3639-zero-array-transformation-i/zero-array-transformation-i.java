class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] arr = new int[n];

        for(int[] quer : queries){
            int start = quer[0];
            int end = quer[1];
            arr[start]++;
            if(end + 1 < n){
                arr[end + 1]--;
            }
        }

        // now cumulate the values
        for(int i = 1;i < n;i++){
          arr[i] = arr[i] + arr[i - 1];
        }

        for(int i = 0;i < n;i++){
            if(nums[i] > arr[i])return false;
        }
        return true;
    }
}