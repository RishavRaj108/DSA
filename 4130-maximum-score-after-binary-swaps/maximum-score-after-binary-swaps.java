class Solution {
    public long maximumScore(int[] nums, String s) {
        long score = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);
        for(int i = 0;i < nums.length;i++){
            pq.add(nums[i]);
            if(s.charAt(i) == '1'){
                score += pq.poll();
            }

        }
        return score;
    }
}