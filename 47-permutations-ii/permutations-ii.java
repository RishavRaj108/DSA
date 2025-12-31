class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        findAll(nums,used,new ArrayList<>(),result);
        return result;
    }
    public void findAll(int[] nums,boolean[] used,List<Integer> temp,List<List<Integer>> result){
        if(temp.size() == nums.length){
            result.add(new ArrayList<>(temp));
            return;
        }
        for(int i = 0;i < nums.length;i++){
            if(used[i])continue;

            // for duplicates 
            if(i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;

            temp.add(nums[i]);
            used[i] = true;

            findAll(nums,used,temp,result);

            used[i] = false;
            temp.remove(temp.size() - 1);
        }
    }
}