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
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode lead = head.next;
        ListNode follow = head;
        ListNode tail = null;
        head = lead;
        
        while(lead != null) {
            ListNode temp = lead.next;
            lead.next = follow;
            follow.next = temp;
            if(tail != null){
                tail.next = lead;
            }
            tail = follow;
            follow = temp;
            lead = temp != null ? temp.next : null;
        }
        
        return head;
    }
}