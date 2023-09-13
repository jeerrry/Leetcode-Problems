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
    public ListNode removeElements(ListNode head, int val) {
        ListNode follow = null;
        ListNode lead = head;
        
        while(lead != null) {            
            if(lead.val == val) {
                if(follow == null) {
                    lead = lead.next;
                    head = lead;
                }else {
                    lead = lead.next;
                    follow.next = lead;
                }
                
                continue;
            }
            
            follow = lead;
            lead = lead.next;
        }
        
        return head;
    }
}