class Node {
    public int value;
    public Node next;

    public Node(){}
    public Node(int value){
        this.value = value;
    }
}

class MyCircularQueue {
    private Node head;
    private Node tail;
    private int count;
    private final int SIZE;

    public MyCircularQueue(int k) {
        head = null;
        tail = null;
        count = 0;
        SIZE = k;
    }

    public boolean enQueue(int value) {
        if(count == SIZE) return false;

        Node temp = new Node(value);
        if(count == 0){
            tail = head = temp;
            count += 1;

            return true;
        }

        tail.next = temp;
        tail = temp;
        count += 1;

        return true;
    }

    public boolean deQueue() {
        if(count == 0) return false;

        if(count == 1) {
            head = tail = null;
            count = 0;
            return true;
        }

        head = head.next;

        count -= 1;

        return true;
    }

    public int Front() {
        if(count == 0) return -1;

        return head.value;
    }

    public int Rear() {
        if(count == 0) return -1;

        return tail.value;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == SIZE;
    }
}