class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        for(int i = 0;i < n;i++){
            list.add(Math.abs(nums[i]));
        }
        Collections.sort(list);
        long ans = 0;
        int curOpr = 0;// 0 for large and then conver it to 1 for sub the smaller
        while(list.size() != 0){
            if(curOpr == 0){
               curOpr = 1;
               int num = list.get(list.size() - 1);
               ans += (long)num * num;
               list.remove(list.size() - 1);
            }else{
               curOpr = 0;
               int num = list.get(0);
               ans -= (long)num * num;
               list.remove(0);
            } 
        }
        return ans;
    }
}