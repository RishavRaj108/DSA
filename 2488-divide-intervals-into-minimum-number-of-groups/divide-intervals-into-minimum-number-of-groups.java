class Solution {
    public int minGroups(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        // Iterate through the intervals
        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];
            // If the top of the queue (smallest end time) is smaller than the current start time
            // we can merge the interval into an existing group, so we pop the earliest end time
            if (!pq.isEmpty() && pq.peek() < start) {
                pq.poll();
            }

            // Add the current interval's end time to the queue (new or updated group)
            pq.offer(end);
        }

        // The size of the priority queue will give the number of groups needed
        return pq.size();
    }
}