class Solution {
    public List<Integer> relocateMarbles(int[] nums, int[] moveFrom, int[] moveTo) {
        Set<Integer> s = new HashSet<>();

        for(int num : nums){
            s.add(num);
        }
        int n = moveFrom.length;
        for(int i = 0;i < n;i++){
            int from = moveFrom[i];
            int to = moveTo[i];
            s.remove(from);
            s.add(to);
        }
        List<Integer> ls = new ArrayList<>();
        for(int val : s){
            ls.add(val);
        }
        Collections.sort(ls);
        return ls;
    }
}