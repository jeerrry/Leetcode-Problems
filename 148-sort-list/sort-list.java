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
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode mid = getMid(head);
        ListNode right = mid.next;
        ListNode left = head;
        mid.next = null;

        left = sortList(left);
        right = sortList(right);

        return mergeNode(left, right);
    }

    private ListNode mergeNode(ListNode left, ListNode right) {
        var head = new ListNode(-1);
        var temp = head;

        while(left != null && right != null) {
            if(left.val <= right.val) {
                temp.next = left;
                left = left.next;
            } else {
                temp.next = right;
                right = right.next;
            }

            temp = temp.next;
        }

        if(left != null) {
            temp.next = left;
        }else {
            temp.next = right;
        }

        return head.next;
    }

    private ListNode getMid(ListNode node) {
        ListNode lead = node.next;
        ListNode follow = node;

        while(lead != null && lead.next != null) {
            lead = lead.next.next;
            follow = follow.next;
        }

        return follow;
    }
}