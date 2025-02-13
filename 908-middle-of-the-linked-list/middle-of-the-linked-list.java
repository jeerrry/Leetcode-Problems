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
    public ListNode middleNode(ListNode head) {
        var lead = head;
        var follow = head;

        while(lead != null && lead.next != null) {
            lead = lead.next.next;
            follow = follow.next;
        }
        

        return follow;
    }
}