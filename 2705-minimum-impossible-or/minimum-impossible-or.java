class Solution {
    public int minImpossibleOR(int[] nums) {
        Set<Integer> s = new HashSet<>();

        for(int num : nums){
            s.add(num);
        }
        int val = 1;
        while(s.contains(val)){
           val = val << 1;
        }
        return val;
    }
}