class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        findAll(nums,used,new ArrayList<>(), result);
        return result;
    }

    public void findAll(int[] nums,boolean[] used,List<Integer> temp , List<List<Integer>> result){
        if(temp.size() == nums.length){
            result.add(new ArrayList<>(temp));
            return;
        }

        for(int i = 0;i < nums.length;i++){
            if(used[i])continue;

            used[i] = true;
            temp.add(nums[i]);

            findAll(nums,used,temp,result);

            used[i] = false;
            temp.remove(temp.size() - 1);
        }
    }
}