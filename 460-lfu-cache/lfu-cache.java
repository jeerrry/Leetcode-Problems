class LFUCache {
    class Node {
        int key;
        int value;
        int freq;

        public Node(int key, int value, int freq) {
            this.key = key;
            this.value = value;
            this.freq = freq;
        }
    }

    private Map<Integer, Node> map;
    private Map<Integer, Set<Integer>> lfuMap;
    private int capacity;
    private int minFreq;
    public LFUCache(int capacity) {
        map = new HashMap();
        lfuMap = new HashMap();
        minFreq = 1;
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(map.size() == 0) return -1;
        if(!map.containsKey(key)) return -1;

        var node = map.get(key);
        updateNodeFrequency(node);

        return node.value;
    }
    
    public void put(int key, int value) {
        if(capacity == 0) return;

        if(map.containsKey(key)) {
            var node = map.get(key);
            node.value = value;
            updateNodeFrequency(node);
        }else {

            // Remove LFU Element
            if(map.size() == capacity) {
                int tKey = lfuMap.get(minFreq).iterator().next();
                map.remove(tKey);

                lfuMap.get(minFreq).remove(tKey);
                if(lfuMap.get(minFreq).isEmpty()) {
                    lfuMap.remove(minFreq);
                }
            }

            var node = new Node(key, value, 1);
            map.put(key, node);
            lfuMap.putIfAbsent(1, new LinkedHashSet());
            lfuMap.get(1).add(key);

            minFreq = 1;
        }
    }

    private void updateNodeFrequency(Node node) {
        var f = node.freq;
        lfuMap.get(f).remove(node.key);

        if(lfuMap.get(f).isEmpty()) {
            lfuMap.remove(f);

            if(f == minFreq)
                minFreq++;
        }

        lfuMap.putIfAbsent(f + 1, new LinkedHashSet());
        lfuMap.get(f + 1).add(node.key);

        node.freq++;
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */