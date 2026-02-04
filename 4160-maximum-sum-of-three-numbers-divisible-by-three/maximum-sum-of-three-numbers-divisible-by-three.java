class Solution {
    public int maximumSum(int[] nums) {
        // four cases are 0 0 0 
        // 0 1 2
        // 1 1 1
        // 2 2 2
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        List<Integer> c = new ArrayList<>();
        for(int num : nums){
            int rem = num % 3;
            if(rem == 0)a.add(num);
            else if(rem == 1)b.add(num);
            else c.add(num);
        }
        Collections.sort(a , Collections.reverseOrder());
        Collections.sort(b , Collections.reverseOrder());
        Collections.sort(c , Collections.reverseOrder());
        int maxi = 0;
        if(a.size() >= 3){
           maxi = Math.max(maxi , a.get(0) + a.get(1) + a.get(2));
        }
        if(b.size() >= 3){
           maxi = Math.max(maxi , b.get(0) + b.get(1) + b.get(2));
        }
        if(c.size() >= 3){
           maxi = Math.max(maxi , c.get(0) + c.get(1) + c.get(2));
        }
        if(a.size() >= 1 && b.size() >= 1 && c.size() >= 1){
            maxi = Math.max(maxi , a.get(0) + b.get(0) + c.get(0));
        }
        return maxi;
    }
}