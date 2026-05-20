class Solution {
    public long maximumScore(int[] nums, String s) {
        long ans=0;
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<s.length();i++)
            {
                pq.offer(nums[i]);
                if(s.charAt(i)=='1')
                {
                    int top=pq.poll();
                    ans+=top;
                }
            }
        return ans;
    }
}