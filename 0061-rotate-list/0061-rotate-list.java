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
    public ListNode rotateRight(ListNode head, int k) {
        int length = getLength(head);
        if(length == 0) return head;
        k = k % length;
        
        if(k == 0) return head;
        
        var lead = head;
        for(int i=0; i<k && lead != null; i++) lead = lead.next;
        
        var follow = head;
        while(lead.next != null) {
            follow = follow.next;
            lead = lead.next;
        }
        
        var next = follow.next;
        follow.next = null;
        lead.next = head;
        head = next;
        
        return head;
    }
    
    private int getLength(ListNode node) {
        var temp = node;
        int length = 0;
        while(temp != null) {
            temp = temp.next;
            length++;
        }
        
        return length;
    }
}