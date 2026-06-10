class Allocator {
    int[] memory;
    Map<Integer , List<Integer>> mp;
    public Allocator(int n) {
        memory = new int[n];
        mp = new HashMap<>();
    }
    public int allocate(int size, int mID) {
        int ind = -1;
        int cnt = 0;
        for(int i = 0;i < memory.length;i++){
           if(memory[i] == 0){
            if(ind == -1)ind = i;
            cnt++;
            if(cnt == size){
                break;
            }
           }else{
            // reset
            ind = -1;
            cnt = 0;
           }
        }
        if(cnt < size)ind = -1;
        if(ind != -1 ){
            if(!mp.containsKey(mID))mp.put(mID , new ArrayList<>());
            for(int i = ind;i < ind + size;i++){
                memory[i] = mID;
            }
            mp.get(mID).add(ind);
        }
        return ind;
    }
    
    public int freeMemory(int mID) {
        if(!mp.containsKey(mID))return 0;
        int cnt = 0;
        for(int ind : mp.get(mID)){
            while(ind < memory.length && memory[ind] == mID){
                memory[ind] = 0;
                ind++;
                cnt++;
            }
        }
        mp.remove(mID);
        return cnt;
    }
}

/**
 * Your Allocator object will be instantiated and called as such:
 * Allocator obj = new Allocator(n);
 * int param_1 = obj.allocate(size,mID);
 * int param_2 = obj.freeMemory(mID);
 */