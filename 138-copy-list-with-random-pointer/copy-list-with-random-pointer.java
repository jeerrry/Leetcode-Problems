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
        Node temp = head;

        while(temp != null) {
            var next = temp.next;
            var nnode = new Node(temp.val);
            temp.next = nnode;
            nnode.next = next;
            temp = next;
        }

        temp = head;
        while(temp != null) {
            if(temp.random != null) {
                temp.next.random = temp.random.next;
            }

            temp = temp.next.next;
        }

        temp = head;
        var result = new Node(-1);
        var lead = result;
        while(temp != null) {
            var next = temp.next.next;
            var copy = temp.next;

            copy.next = null;
            lead.next = copy;
            temp.next = next;
            lead = copy;
            temp = next;
        }

        return result.next;
    }
}