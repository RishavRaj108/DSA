class ExamTracker {
    List<Long> times;
    List<Long> pre; 
    public ExamTracker() {
        times = new ArrayList<>();
        pre = new ArrayList<>();
        pre.add(0L);   // IMPORTANT: base prefix sum
        times.add(0L); // IMPORTANT: dummy time
    }
    
    public void record(int time, int score) {
        pre.add(pre.get(pre.size() - 1) + score);
        times.add((long)time);
    }
    
    public long totalScore(int startTime, int endTime) {
        int i = Collections.binarySearch(times , (long)startTime);
        if(i < 0)i = -i - 1;
        int j = Collections.binarySearch(times , (long)endTime);
        if(j < 0)j = -j - 1;
        else j++;
        return pre.get(j - 1) - pre.get(i - 1);
    }
}

/**
 * Your ExamTracker object will be instantiated and called as such:
 * ExamTracker obj = new ExamTracker();
 * obj.record(time,score);
 * long param_2 = obj.totalScore(startTime,endTime);
 */