class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int[] group = new int[n];
        int curr = 1;
        for(int i = 1;i < n;i++){
           int n1 = nums[i - 1];
           int n2 = nums[i];

           int diff = Math.abs(n1 - n2);
           if(diff <= maxDiff){
            if(i == 1)group[0] = curr;
            group[i] = curr;
           }else{
            curr++;
            group[i] = curr;
           }
        }
        boolean[] res = new boolean[queries.length];
        int ind = 0;
        for(int[] q : queries){
          if(group[q[0]] == group[q[1]]){
            res[ind++] = true;
          }else{
            res[ind++] = false;
          }
        }
        return res;
    }
}