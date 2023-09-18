class Node {
    public int value;
    public Node next = null;
    public Node prev = null;
    
    public Node(int value) {
        this.value = value;
    }
}

class MyLinkedList {
    private Node head;
    private Node tail;
    private int length;

    public MyLinkedList() {
        head = null;
        tail = null;
        length = 0;
    }
    
    public int get(int index) {
        if(index >= length) return -1;
        
        Node ptr = head;
        for(int i=0; i<index && ptr != null; i++) {
            ptr = ptr.next;
        }
        
        return ptr.value;
    }
    
    public void addAtHead(int val) {
        length += 1;
        Node nNode = new Node(val);
        if(head == null) {
            head = nNode;
            tail = nNode;
            return;
        }
        
        head.prev = nNode;
        nNode.next = head;
        
        head = nNode;
        
    }
    
    public void addAtTail(int val) {
        length += 1;
        Node nNode = new Node(val);
        
        if(tail == null) {
            head = nNode;
            tail = nNode;
            return;
        }
        
        tail.next = nNode;
        nNode.prev = tail;
        tail = nNode;
    }
    
    public void addAtIndex(int index, int val) {
        if(index > length) return;
        
        if(index == length) {
            addAtTail(val);
            return;
        }
        
        if(index == 0) {
            addAtHead(val);
            return;
        }
        
        Node ptr = head;
        for(int i=0; i<index; i++) {
            ptr = ptr.next;
        }
        
        Node nNode = new Node(val);
        nNode.next = ptr;
        nNode.prev = ptr.prev;
        ptr.prev.next = nNode;
        ptr.prev = nNode;
        length += 1;
    }
    
    public void deleteAtIndex(int index) {
        if(index >= length) return;
        
         if(length == 1) {
            head = tail = null;
            length -= 1;
            
            return;
        }
        
        Node ptr = head;
        for(int i=0; i<index; i++) {
            ptr = ptr.next;
        }
        
        
        if(ptr == head) {
            head = head.next;
            head.prev = null;
        }else if(ptr == tail) {
            tail = tail.prev;
            tail.next = null;
        }else {
            if(ptr.next != null){
                ptr.next.prev = ptr.prev;
            }
            ptr.prev.next = ptr.next;
        }
        
        length -= 1;
        
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