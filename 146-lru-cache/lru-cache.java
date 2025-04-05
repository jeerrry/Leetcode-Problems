public class Node {
    int key;
    int val;
    Node prev;
    Node next;

    public Node(int key, int val, Node next, Node prev) {
        this.key = key;
        this.val = val;
        this.next = next;
        this.prev = prev;
    }
}

class LRUCache {
    private final int CAPACITY;
    private Map<Integer, Node> map;
    private Node head;
    private Node tail;
    public LRUCache(int capacity) {
        map = new HashMap<>();
        head = null;
        tail = null;
        CAPACITY = capacity;
    }
    
    public int get(int key) {
        if(map.size() == 0) return -1;
        if(!map.containsKey(key)) return -1;

        var node = map.get(key);
        repositionNode(node);

        return node.val;
    }
    
    public void put(int key, int value) {
        var node = map.getOrDefault(key, null);
        if(node != null) {
            node.val = value;
            repositionNode(node);
            return;
        }

        node = new Node(key, value, null, null);
        map.put(key, node);
        
        repositionNode(node);

        if(map.size() > CAPACITY) {
            var lastNode = map.get(tail.key);
            map.remove(lastNode.key);
            tail.prev.next = null;
            tail = tail.prev;
        }
    }

    private void repositionNode(Node node) {
        if(head == node) return;
        if(head == null) {
            head = node;
            tail = node;
            return;
        }

        if(node == tail) {
            tail = node.prev;
            node.prev.next = null;
        }

        if(node.next != null && node.prev != null) {
            // Node lies in the middle.
            node.prev.next = node.next;
            node.next.prev = node.prev;
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