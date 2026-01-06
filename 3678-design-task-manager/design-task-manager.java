class TaskManager {
    class Task{
        int userId, taskId, priority;
        Task(int userId , int taskId,int priority){
            this.userId = userId;
            this.taskId = taskId;
            this.priority = priority;
        }
    }
    PriorityQueue<Task> pq;
    Map<Integer, Task> map;
    public TaskManager(List<List<Integer>> tasks) {
        pq = new PriorityQueue<>((a,b) ->{
           if(a.priority != b.priority) return b.priority - a.priority;
        return b.taskId - a.taskId;
        } 
        );
        map = new HashMap<>();
        for(List<Integer> task : tasks){
            add(task.get(0), task.get(1),task.get(2));
        }
    }
    
    public void add(int userId, int taskId, int priority) {
        Task task = new Task(userId,taskId,priority);
        pq.add(task);
        map.put(taskId, task);
    }
    
    public void edit(int taskId, int newPriority) {
        Task task = map.get(taskId);
         Task updated = new Task(task.userId, taskId, newPriority);
    map.put(taskId, updated);
    pq.add(updated);
    }
    
    public void rmv(int taskId) {
        map.remove(taskId);
    }
    
    public int execTop() {
        while(!pq.isEmpty()){
            Task task = pq.poll();

            if(!map.containsKey(task.taskId))continue;

            if (map.get(task.taskId) != task) continue;

            rmv(task.taskId);
            return task.userId;
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