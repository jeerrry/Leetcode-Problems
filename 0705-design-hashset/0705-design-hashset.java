class MyHashSet {
    private final List<Integer> data;

    public MyHashSet() {
        data = new ArrayList<Integer>();
    }
    
    public void add(int key) {
        if(!contains(key)) {
            data.add(key);
        }
    }
    
    public void remove(int key) {
        data.removeIf(x -> x == key);
    }
    
    public boolean contains(int key) {
        return data.contains(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */