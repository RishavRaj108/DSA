class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int n = nums.length;
        
        // Step 1: store all indices of each value
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        
        // Step 2: process each value group
        for (List<Integer> list : map.values()) {
            if (list.size() == 1) continue;  // only one occurrence
            
            int size = list.size();
            
            for (int i = 0; i < size; i++) {
                int curr = list.get(i);
                int next = list.get((i + 1) % size);
                
                int dist = (next - curr + n) % n;
                if (dist == 0) dist = n;
                
                if (ans[curr] == -1)
                    ans[curr] = dist;
                else
                    ans[curr] = Math.min(ans[curr], dist);
                    
                if (ans[next] == -1)
                    ans[next] = dist;
                else
                    ans[next] = Math.min(ans[next], dist);
            }
        }
        
        // Step 3: answer queries
        List<Integer> result = new ArrayList<>();
        for (int q : queries) {
            result.add(ans[q]);
        }
        
        return result;
    }
}