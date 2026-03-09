class Solution {
    public int[] resultsArray(int[] nums, int k) {
        Deque<Integer> dq = new LinkedList<>();
        int n = nums.length;
        int[] result = new int[n - k + 1];
        int ind = 0;
        for(int i = 0;i < n;i++){
            if(dq.size() == k){
                dq.pollFirst();
            }
            
            // check if current is valid or not
            if(!dq.isEmpty() && dq.peekLast() != nums[i] - 1){
                dq.clear();
            }

            dq.offerLast(nums[i]);

            if( i >= k - 1){
                if(dq.size() == k){
                    result[ind++] = dq.peekLast();
                }else{
                    result[ind++] = -1;
                }
            }

        }
        return result;
    }
}