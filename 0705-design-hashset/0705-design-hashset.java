class MyHashSet {
    private final int size = 1000;
    private final LinkedList<Integer>[] data;

    public MyHashSet() {
        data = new LinkedList[size];
    }
    
    public void add(int key) {
        int index = getIndex(key);
        
        if(data[index] == null) {
            data[index] = new LinkedList<Integer>();
        }
        
        if(contains(key)) return;
        
        data[index].add(key);
        
    }
    
    public void remove(int key) {
        int index = getIndex(key);
        
        if(data[index] == null) {
            return;
        }
        
        data[index].removeIf(x -> x == key);
    }
    
    public boolean contains(int key) {
        int index = getIndex(key);
        
        if(data[index] == null) {
            return false;
        }
        
        boolean res = data[index].stream().filter(x -> x == key).findFirst().isPresent();
        
        return res;
    }
    
    private int getIndex(int key) {
        return key % size;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */