class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // window size k
        // use monotonic deque for getting and tracking the largest no that we can get at each window

        int n = nums.length; 
        int[] res = new int[n - k + 1];
        int ind = 0;

        Deque<Integer> q = new LinkedList<>();
        for(int i = 0;i < n;i++){
            int num = nums[i];
            if(!q.isEmpty() && q.peekLast() == i - k){
                q.pollLast();
            }
            while(!q.isEmpty() && nums[q.peekFirst()] < num){
                q.pollFirst();
            }
            q.addFirst(i);
            if(i >= k - 1){
              res[ind++] = nums[q.peekLast()];
            }
        }
        return res;
    }
}