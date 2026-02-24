class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
         // group[i] will store which connected component index i belongs to
        int[] group = new int[n];
        
        int currentGroup = 0;  // ID of current connected component
        
        // Traverse array and divide into connected groups
        for (int i = 1; i < n; i++) {
            
            // If difference between consecutive elements is greater than maxDiff,
            // then connection breaks → new group starts
            if (nums[i] - nums[i - 1] > maxDiff) {
                currentGroup++;
            }
            
            // Assign current group number to this index
            group[i] = currentGroup;
        }
        
        boolean[] result = new boolean[queries.length];
        
        // Process each query
        for (int i = 0; i < queries.length; i++) {
            int u = queries[i][0];
            int v = queries[i][1];
            
            // If both nodes belong to same group,
            // then path exists
            result[i] = (group[u] == group[v]);
        }
        
        return result;
    }
}