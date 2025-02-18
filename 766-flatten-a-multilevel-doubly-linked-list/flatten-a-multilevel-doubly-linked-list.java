/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        var temp = head;

        while(temp != null) {
            if(temp.child == null) {
                temp = temp.next;
                continue;
            }

            Node tail = temp.child;
            while(tail.next != null) tail = tail.next;

            tail.next = temp.next;
            if(temp.next != null) temp.next.prev = tail;

            temp.next = temp.child;
            temp.child.prev = temp;
            temp.child = null;
        }

        return head;
    }
}