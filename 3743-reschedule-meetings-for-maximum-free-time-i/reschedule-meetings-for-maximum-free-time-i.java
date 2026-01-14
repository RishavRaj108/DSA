class Solution {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int n = startTime.length;
        int[] gap = new int[n + 1];
        gap[0] = startTime[0];
        for(int i = 1;i < n;i++){
            gap[i] = startTime[i] - endTime[i - 1];
        }
        gap[n] = eventTime - endTime[n - 1];
        
        int maxTime = 0, currTime = 0;
        int windowSize = k + 1;
        for(int i = 0;i <= n;i++){
           currTime += gap[i];
           if(i >= windowSize){
             currTime -= gap[i - windowSize];
           }
           if(i >= windowSize - 1){
            maxTime = Math.max(maxTime , currTime);
           }
        }
        return maxTime;
    }
}