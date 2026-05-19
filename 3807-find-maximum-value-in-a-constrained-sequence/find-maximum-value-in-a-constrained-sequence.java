class Solution {
    public int findMaxVal(int n, int[][] restrictions, int[] diff) {
        int[] arr = new int[n];
        
        Arrays.fill(arr, Integer.MAX_VALUE);

        for(int[] vals : restrictions){
            int ind = vals[0];
            int maxV = vals[1];
            arr[ind] = maxV;
        }
        arr[0] = 0;
        for(int i = 0;i < n - 1;i++){
            if(arr[i] != Integer.MAX_VALUE)
           arr[i + 1] = Math.min(arr[i + 1] , arr[i] + diff[i]);
        }

        for(int i = n - 2;i >= 0;i--){
            if(arr[i + 1] != Integer.MAX_VALUE)
            arr[i] = Math.min(arr[i] , arr[i + 1] + diff[i]);
        }

        int ans = 0;
        for(int i = 0;i < n;i++){
            if(arr[i] > ans){
                ans = arr[i];
            }
        }
        return ans;
    }
}