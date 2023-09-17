class Node {
    public int key;
    public int value;
    public Node next;
    public Node prev;
    
    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class LRUCache {
    private final HashMap<Integer, Node> map;
    private Node head = null;
    private Node tail = null;
    private final int CAPACITY;
    
    public LRUCache(int capacity) {
        map = new HashMap<>();
        CAPACITY = capacity;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) {
            return -1;
        }
        
        Node current = map.get(key);
        repositionNode(current);
        return current.value;
    }
    
    public void put(int key, int value) {
        if(!map.containsKey(key)) {
            insertNode(new Node(key, value));
            return;
        }
        
        Node current = map.get(key);
        current.value = value;
        repositionNode(current);
    }
    
    private void insertNode(Node node) {
        if(head == null) {
            node.next = null;
            node.prev = null;
            
            tail = node;
        }else {
            head.prev = node;
            node.next = head;
            node.prev = null;
        }
        
        head = node;
        map.put(node.key, node);
        
        if(map.size() > CAPACITY) {
            // Remove Tail Node;
            Node last = tail;
            map.remove(last.key);
            last.prev.next = null;
            tail = last.prev;
            last = null;
        }
    }
    
    private void repositionNode(Node node) {
        if(head == node) {
            return;
        }
        
        if(tail == node) {
            tail = node.prev;
            tail.next = null;
        }else{
            node.next.prev = node.prev;
            node.prev.next = node.next;
        }
        
        
        node.next = head;
        node.prev = null;
        head.prev = node;
        
        head = node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */