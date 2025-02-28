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
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null) return head;
        
        var smaller = new ListNode(-1);
        var larger = new ListNode(-1);

        var temp = head;
        var sm = smaller;
        var lg = larger;
        while(temp != null) {
            if(temp.val < x) {
                sm.next = temp;
                sm = sm.next;
            }else {
                lg.next = temp;
                lg = lg.next;
            }

            temp = temp.next;
            sm.next = null;
            lg.next = null;
        }

        if(sm == smaller) {
            return larger.next;
        }

        if(lg == larger) {
            return smaller.next;
        }

        sm.next = larger.next;
        return smaller.next;
    }
}