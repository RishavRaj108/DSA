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
            int ind1 = list.get(0);
            int ind2 = list.get(1);
            int ind3 = list.get(2);
            ans = Math.min(ans, Math.abs(ind1 - ind2) + Math.abs(ind2 - ind3) + Math.abs(ind3 - ind1));
            for(int i = 3;i < list.size();i++){
                // now the formula
                ind1 = ind2;
                ind2 = ind3;
                ind3 = list.get(i);
                ans = Math.min(ans, Math.abs(ind1 - ind2) + Math.abs(ind2 - ind3) + Math.abs(ind3 - ind1));
            }
        }
        return ans == Integer.MAX_VALUE? -1 : ans;
    }
}