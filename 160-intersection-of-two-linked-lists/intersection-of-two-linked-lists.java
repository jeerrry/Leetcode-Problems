/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        var first = headA;
        var secnd = headB;

        while(first != secnd) {
            first = first == null ? headB : first.next;
            secnd = secnd == null ? headA : secnd.next;
        }

        return first;
    }
}