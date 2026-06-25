class TaskManager {
    Map<Integer, int[]> mp; // taskId -> {userId, priority}
    PriorityQueue<int[]> pq;
    public TaskManager(List<List<Integer>> tasks) {
        mp = new HashMap<>();
        pq = new PriorityQueue<>((a, b) -> {
            if (a[2] != b[2]) return b[2] - a[2];
            return b[1] - a[1];
        });

        for (List<Integer> t : tasks) {
            add(t.get(0), t.get(1), t.get(2));
        }
    }
    public void add(int userId, int taskId, int priority) {
       mp.put(taskId, new int[]{userId, priority});
        pq.add(new int[]{userId, taskId, priority});
    }
    public void edit(int taskId, int newPriority) {
        int userId = mp.get(taskId)[0];
        mp.put(taskId, new int[]{userId, newPriority});
        pq.add(new int[]{userId, taskId, newPriority});
    }
    public void rmv(int taskId) {
        mp.remove(taskId);
    }
    public int execTop() {
       while(!pq.isEmpty()){
         int[] cur = pq.poll();
         int uId = cur[0];
         int tId = cur[1];
         int prio = cur[2];

         if(mp.containsKey(tId)){
            int[] latest = mp.get(tId);
            if(latest[0] == uId && latest[1] == prio){
                mp.remove(tId);
                return uId;
            }
         }
       }
       return -1;
    }
}

/**
 * Your TaskManager object will be instantiated and called as such:
 * TaskManager obj = new TaskManager(tasks);
 * obj.add(userId,taskId,priority);
 * obj.edit(taskId,newPriority);
 * obj.rmv(taskId);
 * int param_4 = obj.execTop();
 */