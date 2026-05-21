class Solution {
    public int maximizeGreatness(int[] nums) {
        int cnt = 0;
        Arrays.sort(nums);

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int n = nums.length;
        for(int num : nums){
            pq.add(num);
        }

        for(int i = 0;i < n;i++){
            int num = nums[i];
            while(!pq.isEmpty() && pq.peek() <= num){
                pq.poll();
            }
            if(pq.isEmpty())break;
            cnt++;
            pq.poll();
        }
        return cnt;
    }
}