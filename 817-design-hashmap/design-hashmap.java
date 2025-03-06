class MyHashMap {
    private int size = 100;
    private LinkedList<int[]>[] data;
    public MyHashMap() {
        data = new LinkedList[size];
    }
    
    public void put(int key, int value) {
        var rootNode = getRootNode(key);
        if(rootNode.size() == 0) {
            rootNode.add(new int[]{key, value});
            return;
        }

        for(int i=0; i<rootNode.size(); i++) {
            var val = rootNode.get(i);
            if(val[0] == key) {
                rootNode.set(i, new int[]{key, value});
                return;
            }
        }

        rootNode.add(new int[]{key, value});
    }
    
    public int get(int key) {
        var rootNode = getRootNode(key);

        if(rootNode.size() == 0) return -1;

        for(int i=0; i<rootNode.size(); i++) {
            var val = rootNode.get(i);
            if(val[0] == key) {
                return val[1];
            }
        }

        return -1;
    }
    
    public void remove(int key) {
        var rootNode = getRootNode(key);

        if(rootNode.size() == 0) return;

        for(int i=0; i<rootNode.size(); i++) {
            var val = rootNode.get(i);
            if(val[0] == key) {
                rootNode.remove(i);
                return;
            }
        }
    }

    private LinkedList<int[]> getRootNode(int key) {
        int index = key % size;

        var node = data[index];
        if(node == null) {
            node = new LinkedList<int[]>();
            data[index] = node;
        }

        return node;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */