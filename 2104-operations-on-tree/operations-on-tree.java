class LockingTree {

    int[] parent;
    List<Integer>[] children;
    int[] locked; // -1 = unlocked, else userId

    public LockingTree(int[] parent) {
        int n = parent.length;
        this.parent = parent;
        locked = new int[n];
        Arrays.fill(locked, -1);

        children = new ArrayList[n];
        for (int i = 0; i < n; i++) children[i] = new ArrayList<>();

        for (int i = 1; i < n; i++) {
            children[parent[i]].add(i);
        }
    }

    public boolean lock(int num, int user) {
        if (locked[num] != -1) return false;
        locked[num] = user;
        return true;
    }

    public boolean unlock(int num, int user) {
        if (locked[num] != user) return false;
        locked[num] = -1;
        return true;
    }

    public boolean upgrade(int num, int user) {
        // condition 1: node must be unlocked
        if (locked[num] != -1) return false;

        // condition 3: no locked ancestors
        int cur = parent[num];
        while (cur != -1) {
            if (locked[cur] != -1) return false;
            cur = parent[cur];
        }

        // condition 2: at least one locked descendant
        if (!hasLockedDescendant(num)) return false;

        // unlock all descendants
        unlockDescendants(num);

        // lock current node
        locked[num] = user;
        return true;
    }

    private boolean hasLockedDescendant(int node) {
        for (int child : children[node]) {
            if (locked[child] != -1 || hasLockedDescendant(child))
                return true;
        }
        return false;
    }

    private void unlockDescendants(int node) {
        for (int child : children[node]) {
            locked[child] = -1;
            unlockDescendants(child);
        }
    }
}


/**
 * Your LockingTree object will be instantiated and called as such:
 * LockingTree obj = new LockingTree(parent);
 * boolean param_1 = obj.lock(num,user);
 * boolean param_2 = obj.unlock(num,user);
 * boolean param_3 = obj.upgrade(num,user);
 */