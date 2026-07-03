class Solution {
    public int earliestFinishTime(int[] lst, int[] ld, int[] wst, int[] wd) {
        int minTime = Integer.MAX_VALUE;
        int n = lst.length;
        int m = wst.length;
        int mini = Integer.MAX_VALUE;
        // try first for land;
        for(int i = 0;i < n;i++){
           mini = Math.min(mini , lst[i] + ld[i]);
        }
        for(int j = 0;j < m;j++){
            int start = wst[j];
            int dur = wd[j];
            if(start <= mini){
                minTime = Math.min(minTime , mini + dur);
            }else{
                minTime = Math.min(minTime , mini + (start - mini) + dur);
            }
        }
        mini = Integer.MAX_VALUE;
        // try first for water
        for(int i = 0;i < m;i++){
           mini = Math.min(mini , wst[i] + wd[i]);
        }
        for(int j = 0;j < n;j++){
            int start = lst[j];
            int dur = ld[j];
            if(start <= mini){
                minTime = Math.min(minTime , mini + dur);
            }else{
                minTime = Math.min(minTime , mini + (start - mini) + dur);
            }
        }
        return minTime;
    }
}