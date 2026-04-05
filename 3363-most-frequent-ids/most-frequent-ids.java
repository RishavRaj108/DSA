class Solution {
    public long[] mostFrequentIDs(int[] nums, int[] freq) {
        
        int n = nums.length;
        Map<Long,Long> mp = new HashMap<>();

        long[] res = new long[n];
        PriorityQueue<long[]> pq = new PriorityQueue<>((a,b) -> Long.compare(b[0] ,a[0]));
        for(int i = 0;i < n;i++){
            long num = nums[i];
            long f = freq[i];
            mp.put(num , mp.getOrDefault(num , 0L) + f);
            pq.add(new long[] {mp.get(num) , num});
            while(!pq.isEmpty() && pq.peek()[0] != mp.get(pq.peek()[1])){
                pq.poll();
            }
            res[i] = pq.peek()[0];
        }
        return res;
    }
}