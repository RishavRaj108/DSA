class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] arr = new int[n];
        for(int[] quer : queries){
            // for starting index place that value by adding to it means -1
            // and last + 1 will have sub -1
            int start = quer[0];
            int end = quer[1];
            arr[start]++ ;
            if(end + 1 < n){
                arr[end + 1]--;
            } 
        }

        // create cumulative array
        for(int i = 1;i < n;i++){
            arr[i] = arr[i] + arr[i - 1];
        }

        for(int i = 0;i < n;i++){
            if(arr[i] < nums[i]){
               return false;
            }
        }
        return true;
    }
}