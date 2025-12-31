class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        findAll(0,nums,new ArrayList<>(), result);
        return result;
    }

    public void findAll(int ind,int[] nums,List<Integer> temp ,List<List<Integer>>result){
      result.add(new ArrayList<>(temp));

      for(int i = ind;i < nums.length;i++){
        temp.add(nums[i]);

        findAll(i + 1 , nums, temp,result);
        temp.remove(temp.size() - 1);
      }  
    }
}