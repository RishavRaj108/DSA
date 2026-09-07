class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        int n = costs.length;
        PriorityQueue<Integer> left = new PriorityQueue<>();
        PriorityQueue<Integer> right = new PriorityQueue<>();

        int i = 0;
        int j = n - 1;

        long res = 0;

        while(k-- > 0){
           while(left.size() != candidates && i <= j){
            left.add(costs[i++]);
           }
           while(right.size() != candidates && j >= i){
            right.add(costs[j--]);
           }

           int leftVal = left.isEmpty()? Integer.MAX_VALUE : left.peek();
           int rightVal = right.isEmpty()? Integer.MAX_VALUE : right.peek();

           if(leftVal <= rightVal){
            res += leftVal;
            left.poll();
           }else{
            res += rightVal;
            right.poll();
           }
        }
        return res;
    }
}