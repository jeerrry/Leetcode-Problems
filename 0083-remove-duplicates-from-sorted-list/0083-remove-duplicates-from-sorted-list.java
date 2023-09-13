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
        ListNode follow = null;
        ListNode lead = head;
        
        while(lead != null) {
            if(follow != null && follow.val == lead.val) {
                while(lead != null && lead.val == follow.val) {
                    lead = lead.next;
                }
                
                follow.next = lead;
                continue;
            }
            
            follow = lead;
            lead = lead.next;
        }
        
        return head;
    }
}