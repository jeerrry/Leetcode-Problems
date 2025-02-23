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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode temp = new ListNode(-1);
        temp.next = head;
        var prev = temp;

        for(int i=0; i<left - 1; i++) prev = prev.next;

        var curr = prev.next;
        for(int i=0; i<right - left; i++) {
            var next = curr.next;
            curr.next = next.next;
            next.next = prev.next;
            prev.next = next;
        }

        return temp.next;
    }
}