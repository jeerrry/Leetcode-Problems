/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return head;
        
        Node ptr = head;
        while(ptr != null) {
            Node node = new Node(ptr.val);
            
            node.next = ptr.next;
            ptr.next = node;
            ptr = node.next;
        }
        
        ptr = head;
        
        while(ptr != null) {
            Node node = ptr.next;
            
            node.random = ptr.random != null ? ptr.random.next : null;
            ptr = node.next;
        }
        
        ptr = head;
        Node newHead = ptr.next;
        Node ptr2 = newHead;
        
        while(ptr != null) {
            ptr.next = ptr2.next;
            ptr = ptr.next;
            
            ptr2.next = ptr != null ? ptr.next : null;
            ptr2 = ptr2.next;
        }
        
        return newHead;
    }
}