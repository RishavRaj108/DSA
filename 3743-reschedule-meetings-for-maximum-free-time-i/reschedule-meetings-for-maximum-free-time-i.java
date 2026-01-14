class Solution {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        // event occurs from time t = 0 to time t = eventTime.
        // start and end time of n non-overlapping meetings
        // reschedule at most k meetings by moving their start time while maintaining the same duration,
        //  to maximize the longest continuous period of free time during the event.

        // how 
        // i have to reduce the problem statement to just gaps array and each time check for a given window sum of gaps and return maximum value;

        
        int n = startTime.length;
        int[] gap = new int[n + 1];
        gap[0] = startTime[0];
        for(int i = 1;i < n;i++){
            gap[i] = startTime[i] - endTime[i - 1];
        }
        gap[n] = eventTime - endTime[n - 1]; 


        // now i am having gaps array and now i have to find max gap
        // sliding window
        // i have studied sliding window of two types 
        // fixed size and variable size earlier i was thinking of varible size but we can use fixed size also

        int maxSum = 0, windowSize = k + 1;
        int currSum = 0;
        // gaps = 1,1,0
        // window = 2;
        for(int i = 0;i < n + 1;i++){
            currSum += gap[i];
            if(i >= windowSize){
                currSum -= gap[i - windowSize];
            }
            if(i >= windowSize - 1){
                maxSum = Math.max(currSum ,maxSum);
            }
        }
        return maxSum;
    }
}