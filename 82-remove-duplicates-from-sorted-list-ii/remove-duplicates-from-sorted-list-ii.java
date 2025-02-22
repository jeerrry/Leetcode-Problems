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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode follow = null;
        ListNode lead = head;

        while(lead != null && lead.next != null) {
            if(lead.val != lead.next.val) {
                follow = lead;
                lead = lead.next;
            }else {
                while(lead.next != null && lead.next.val == lead.val) {
                    lead = lead.next;
                }

                if(follow != null) {
                    follow.next = lead.next;
                }else {
                    head = lead.next;
                }
                lead = lead.next;
            }
        }

        return head;

    }
}