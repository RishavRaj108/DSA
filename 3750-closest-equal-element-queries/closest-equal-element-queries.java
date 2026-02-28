class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
       Map<Integer , List<Integer>> mp = new HashMap<>();
       int n = nums.length;
       for(int i = 0;i < n;i++){
        mp.computeIfAbsent(nums[i] , k -> new ArrayList<>()).add(i);
       } 

       int[] ans = new int[n];
       Arrays.fill(ans , -1);
       
       for(List<Integer> ls : mp.values()){
        if(ls.size() == 1)continue;
        int size = ls.size();
        // 0 
        for(int i = 0;i < size;i++){
            int curr = ls.get(i);
            int next = ls.get((i + 1)% size);
            
            int diff = (next - curr + n) % n;
            if(ans[curr] == -1){
                ans[curr] = diff;
            }else{
                ans[curr] = Math.min(diff , ans[curr]);
            }
            if(ans[next] == -1){
                ans[next] = diff;
            }else{
                ans[next] = Math.min(diff , ans[next]);
            }
        }
       }
       int m = queries.length;
       List<Integer> res = new ArrayList<>();
       for(int i = 0;i < m;i++){
         res.add(ans[queries[i]]);
       }
       return res;
    }
}