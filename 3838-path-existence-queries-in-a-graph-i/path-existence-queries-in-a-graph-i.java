class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        // we can create an array to track which node is present on which 
        // component
        int[] group = new int[n];
        int curr = 0;
        for(int i = 1;i < n;i++){
            if(Math.abs(nums[i] - nums[i - 1]) > maxDiff)curr++;
            group[i] = curr;
        }
        boolean[] ans = new boolean[queries.length];
        int ind = 0;
        for(int[] quer : queries){
            int u = quer[0];
            int v = quer[1];
            if(group[u] == group[v])ans[ind] = true;
            ind++;
        }
        return ans;
    }
}