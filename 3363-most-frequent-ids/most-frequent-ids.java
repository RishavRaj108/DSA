class Solution {
    public long[] mostFrequentIDs(int[] nums, int[] freq) {
        // track freq of ids
        // nums[i] rep id and freq[i] rep no of times that id should be added or removed

        // at each index we need to find the cnt of most frequent id
        // inorder to get maximum we use priority queue
        int n = nums.length;
        long[] ans = new long[n];
        PriorityQueue<long[]> q = new PriorityQueue<>((a,b) -> Long.compare(b[0] , a[0]));

        Map<Long , Long> mp = new HashMap<>();

        for(int i = 0;i < n;i++){
            long num = nums[i];
            long f = freq[i]; 
            mp.put(num, mp.getOrDefault(num , 0L) + f);
            q.add(new long[]{mp.get(num) , num});

            while(!q.isEmpty() && mp.get(q.peek()[1]) != q.peek()[0]){
                q.poll();
            }
            ans[i] = q.peek()[0];
        }
        return ans;
    }
}