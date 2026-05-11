class Solution {
    public long countSubarrays(int[] nums, long k) {
        int n = nums.length;

        Deque<Integer> maxD = new LinkedList<>();
        Deque<Integer> minD = new LinkedList<>();

        long ans = 0;

        int left = 0;
        for(int right = 0;right < n;right++){

            // for max
            while(!maxD.isEmpty() && nums[maxD.peekLast()] <= nums[right]){
                maxD.pollLast();
            }
            maxD.add(right);

            // for min
            while(!minD.isEmpty() && nums[minD.peekLast()] >= nums[right]){
                minD.pollLast();
            }
            minD.add(right);

            while(left <= right){
                int mini = nums[minD.peek()];
                int maxi =nums[ maxD.peek()];

                long cost =1L * (maxi - mini) * ( right - left + 1);

                if(cost <= k){
                    break;
                }

                if(maxD.peek() == left){
                    maxD.poll();
                }
                if(minD.peek() == left){
                    minD.poll();
                }
                left++;
            }
            ans += right - left + 1;
        }
        return ans;
    }
}