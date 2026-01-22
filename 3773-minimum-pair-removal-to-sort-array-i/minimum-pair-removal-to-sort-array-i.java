class Solution {
    public int minimumPairRemoval(int[] nums) {
        // 
        if(nums.length == 1)return 0;
        int[] first = new int[2];
        int cnt = 0;
        ArrayList<Integer> ls = new ArrayList<>();
        for(int num : nums)ls.add(num);
        while(!check(ls)){
            int n = ls.size();
            if(n == 1)return cnt;
            int min = Integer.MAX_VALUE;
            for(int i = 1;i < n;i++){
                int sum = ls.get(i - 1) + ls.get(i);
                if(sum < min){
                    min = sum;
                    first[0] = ls.get(i - 1);
                    first[1] = i-1;
                }
            }
            // so first will be having the first value of the pair
            int second = ls.remove(first[1] + 1);
            int firs = ls.remove(first[1]);
            ls.add(first[1] , firs + second);
            cnt++;
        }
        return cnt;
    }
    public boolean check(ArrayList<Integer> ls){
        if(ls.size() == 1)return false;
        for(int i = 1;i < ls.size();i++){
             if(ls.get(i - 1) > ls.get(i)){
                return false;
             }
        }
        return true;
    }
}