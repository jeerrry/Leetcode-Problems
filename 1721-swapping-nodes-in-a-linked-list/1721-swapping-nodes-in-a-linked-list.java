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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode temp = new ListNode(0);
        temp.next = head;
        ListNode fast = temp;
        ListNode slow = temp;
        ListNode first = temp;
        ListNode second = temp;
        
        for(int i=k; i>0; i--) fast = fast.next;
        
        first = fast;
        
        while(fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        
        second = slow;
        
        int tVal = first.val;
        first.val = second.val;
        second.val = tVal;
        
        return head;
    }
}