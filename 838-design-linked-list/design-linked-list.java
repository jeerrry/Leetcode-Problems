class MyLinkedList {
    private Node head;
    private Node tail;
    private int size;

    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }
    
    public int get(int index) {
        if(index >= size) return -1;

        return getNode(index).val;
    }
    
    public void addAtHead(int val) {
        var node = new Node(val, null, null);
        if(size == 0) {
            head = node;
            tail = node;
        }else {
            node.next = head;
            head.prev = node;
            head = node;
        }
        size++;
    }
    
    public void addAtTail(int val) {
        var node = new Node(val, null, null);
        if(size == 0) {
            head = node;
            tail = node;
        }else {
            node.prev = tail;
            tail.next = node;
            tail = node;
        }

        size++;
    }
    
    public void addAtIndex(int index, int val) {
        if(index > size) return;

        if(index == 0) {
            addAtHead(val);
            return;
        }
        
        if(index == size) {
            addAtTail(val);
            return;
        }
        
        var node = getNode(index);

        var temp = new Node(val, node, node.prev);
        node.prev.next = temp;
        temp.next.prev = temp;
        size++;
    }
    
    public void deleteAtIndex(int index) {
        if(index >= size) return;
        if(size == 1) {
            head = null;
            tail = null;
            size = 0;
            return;
        }

        if(index == 0) {
            head = head.next;
            head.prev = null;
            size--;
            return;
        }

        if(index == size - 1) {
            tail = tail.prev;
            tail.next = null;
            size--;

            return;
        }

        var node = getNode(index);
        node.prev.next = node.next;
        node.next.prev = node.prev;
        size--;
    }

    private Node getNode(int index) {
        var node = head;
        for(int i=0; i<index; i++) {
            node = node.next;
        }

        return node;
    }

    private class Node {
        public int val;
        public Node next;
        public Node prev;

        public Node(int val, Node next, Node prev) {
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */