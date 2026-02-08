class Solution {
    public int minimumDistance(int[] nums) {
        Map<Integer, List<Integer>> mp = new HashMap<>();
        int n = nums.length;
        // basically here we are creating a map which will store all the occurence of a number 
        for(int i = 0;i < n;i++){
            mp.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        
        int ans = Integer.MAX_VALUE;
        for(List<Integer> list : mp.values()){
            if(list.size() < 3)continue;
            for(int i = 0;i + 2 < list.size();i++){
                // now the formula since k > j > i always
                // formula can be reduced into
                // (j - i + k - j + k - i) - > results into 2(k - i)
                ans = Math.min(ans, 2 * ( list.get(i + 2) - list.get(i)));
            }
        }
        return ans == Integer.MAX_VALUE? -1 : ans;
    }
}