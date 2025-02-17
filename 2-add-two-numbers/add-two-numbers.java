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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        var result = new ListNode(-1);
        var head = result;
        int carry = 0;
        while(l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            int val = sum % 10;
            carry = sum / 10;

            var nnode = new ListNode(val);
            result.next = nnode;
            result = nnode;
            l1 = l1.next;
            l2 = l2.next;
        }

        while(l1 != null) {
            int val = l1.val + carry;
            int nval = val % 10;
            carry = val / 10;

            var nnode = new ListNode(nval);
            result.next = nnode;
            result = nnode;
            l1 = l1.next;
        }

        while(l2 != null) {
            int val = l2.val + carry;
            int nval = val % 10;
            carry = val / 10;

            var nnode = new ListNode(nval);
            result.next = nnode;
            result = nnode;
            l2 = l2.next;
        }

        if(carry > 0) {
            result.next= new ListNode(carry);
        }

        return head.next;
    }
}