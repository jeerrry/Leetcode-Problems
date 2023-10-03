class LockingTree {
    private final int[] locks;
    private final int[] parent;
    private final HashMap<Integer, List<Integer>> childs;

    public LockingTree(int[] parent) {
        this.parent = parent;
        this.locks = new int[parent.length];
        childs = new HashMap<>();
        
        
        // Initialize
        for(int i=0; i<parent.length; i++) {
            childs.put(i, new ArrayList<Integer>());
        }
        
        // Set Childs
        for(int i=1; i<parent.length; i++) {
            childs.get(parent[i]).add(i);
        }
    }
    
    public boolean lock(int num, int user) {
        if(locks[num] > 0) return false;
        locks[num] = user;
        return true;
    }
    
    public boolean unlock(int num, int user) {
        if(locks[num] == 0) return false;
        if(locks[num] != user) return false;
        
        locks[num] = 0;
        return true;
    }
    
    public boolean upgrade(int num, int user) {
        int i = num;
        while(i > -1) {
            if(locks[i] > 0) return false;
            i = parent[i];
        }

        // Have 1 locked Descendant by any user
        int lockedCount = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(num);
        
        while(queue.size() > 0) {
            int value = queue.remove();
            if(locks[value] > 0) {
                lockedCount++;
                locks[value] = 0;
            }
            
            queue.addAll(childs.get(value));
        }
        
        // Lock current and unlock descendants.
        if(lockedCount > 0) {
            locks[num] = user; 
        }
        
        return lockedCount > 0;
    }
}

/**
 * Your LockingTree object will be instantiated and called as such:
 * LockingTree obj = new LockingTree(parent);
 * boolean param_1 = obj.lock(num,user);
 * boolean param_2 = obj.unlock(num,user);
 * boolean param_3 = obj.upgrade(num,user);
 */