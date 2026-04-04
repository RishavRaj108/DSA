class Solution {
    public long[] mostFrequentIDs(int[] nums, int[] freq) {
        Map<Long , Long> mp = new HashMap<>();

        PriorityQueue<Long[]> pq = new PriorityQueue<>((a,b) -> Long.compare(b[0] , a[0]));

        int n = nums.length;
        long[] result = new long[n];
        for(int i = 0;i < n;i++){
            long num = nums[i];
            long f = freq[i];
            
            mp.put(num , mp.getOrDefault(num , 0L) + f);
            pq.add(new Long[]{mp.get(num) , num});
            while(!pq.isEmpty() && mp.get(pq.peek()[1]) != pq.peek()[0]){
                pq.poll();
            }
            result[i] = pq.peek()[0];
        }
        return result;
    }
}