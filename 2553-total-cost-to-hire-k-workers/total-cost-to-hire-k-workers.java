class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        int n = costs.length;
        PriorityQueue<Integer> left = new PriorityQueue<>();
        PriorityQueue<Integer> right = new PriorityQueue<>();

        int l = 0;
        int r = n -1;
        while(l < n && left.size() < candidates){
            left.add(costs[l++]);
        }
        while(r >= l && right.size() < candidates){
            right.add(costs[r--]);
        }
        long ans = 0;

        while(k-- > 0){
            if(!left.isEmpty() && (right.isEmpty() || left.peek() <= right.peek()) ){
                ans += left.poll();
                if(l <= r ){
                    left.add(costs[l++]);
                }
            }else{
                ans += right.poll();
                if(r >= l){
                    right.add(costs[r--]);
                }
            }
        }
        return ans;
    }
}