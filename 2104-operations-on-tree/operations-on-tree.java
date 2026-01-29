class LockingTree {
    // write the states that are needed and provided
    // we are going to need parent , children and lock status for each tree node
    // learn to break problems in parts
    int[] parent;
    int[] locked;
    List<Integer>[] children;
    public LockingTree(int[] parent) {
        this.parent = parent;
        int n = parent.length;
        locked = new int[n];
        Arrays.fill(locked , - 1);
        children = new ArrayList[n];
        for(int i = 0;i < n;i++)children[i] = new ArrayList<>();
        for(int i = 1;i < n;i++){
            children[parent[i]].add(i);
        }
    }
    
    public boolean lock(int num, int user) {
        if(locked[num] != -1)return false;
        locked[num] = user;
        return true;
    }
    
    public boolean unlock(int num, int user) {
        if(locked[num] != user)return false;
        locked[num] = -1;
        return true;
    }
    
    public boolean upgrade(int num, int user) {
        // for upgrade 
        if(locked[num] != -1)return false;

        // check for the parents of num
        int par = parent[num];
        while(par != -1){
            if(locked[par] != -1)return false;
            par = parent[par];
        }

        // check for at least one decendent
        if(!hasAtLeastOne(num))return false;
        
        // unlock all descendant
        unlockAll(num);
        locked[num] = user;
        return true;
    }
    public void unlockAll(int num){
        for(int child : children[num]){
            locked[child] = -1;
            unlockAll(child);
        }
    }

    public boolean hasAtLeastOne(int num){
        for(int child : children[num]){
            if(locked[child] != -1 || hasAtLeastOne(child)){
                return true;
            }
        }
        return false;
    }
}

/**
 * Your LockingTree object will be instantiated and called as such:
 * LockingTree obj = new LockingTree(parent);
 * boolean param_1 = obj.lock(num,user);
 * boolean param_2 = obj.unlock(num,user);
 * boolean param_3 = obj.upgrade(num,user);
 */