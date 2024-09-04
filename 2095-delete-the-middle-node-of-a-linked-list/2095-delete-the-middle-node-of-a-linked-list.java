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
    public ListNode deleteMiddle(ListNode head) {
        ListNode follow = null;
        ListNode fast = head;
        ListNode slow = head;
        
        while(fast != null && fast.next != null) {
            follow = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        if(follow == null) return head.next;
        follow.next = slow.next;
        
        return head;
    }
}