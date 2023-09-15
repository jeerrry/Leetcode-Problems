/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || head.next == null) return null;
        ListNode temp = new ListNode(0);
        temp.next = head;
        ListNode fastNode = temp;
        ListNode slowNode = temp;
        
        while(n > 0) {
            fastNode = fastNode.next;
            n--;
        }
        
        while(fastNode.next != null) {
            fastNode = fastNode.next;
            slowNode = slowNode.next;
        }
        
        slowNode.next = slowNode.next.next;
        
        return temp.next;
    }
}