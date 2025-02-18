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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode result = new ListNode(-1);
        var lead = result;

        while(head != null) {
            var temp = head;
            for(int i=1; i<k && head != null; i++) {
                head = head.next;
            }

            if(head == null) {
                lead.next = temp;
                break;
            }

            var next = head.next;
            head.next = null;
            head = next;
            
            var rev = reverseLL(temp);
            lead.next = rev;
            lead = temp;
        }

        return result.next;
    }

    private ListNode reverseLL(ListNode head) {
        ListNode lead = head;
        ListNode follow = null;

        while(lead != null) {
            var next = lead.next;
            lead.next = follow;
            follow = lead;
            lead = next;
        }

        return follow;
    }
}