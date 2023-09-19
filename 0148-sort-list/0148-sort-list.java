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
        
        ListNode left = head;
        ListNode right = midNode(head);
        ListNode temp = right.next;
        right.next = null;
        right = temp;
        
        left = sortList(left);
        right = sortList(right);
        
        return mergeHalfs(left, right);
    }
    
    private ListNode midNode(ListNode head) {
        ListNode lead = head.next;
        ListNode follow = head;
        
        while(lead != null && lead.next != null) {
            lead = lead.next.next;
            follow = follow.next;
        }
        
        return follow;
    }
    
    private ListNode mergeHalfs(ListNode left, ListNode right) {
        ListNode result = new ListNode();
        ListNode tail = result;
        
        while(left != null && right != null) {
            if(left.val <= right.val){
                tail.next = left;
                left = left.next;
            }else {
                tail.next = right;
                right = right.next;
            }
            tail = tail.next;
        }
        
        if(left != null) {
            tail.next = left;
        }
        
        if(right != null) {
            tail.next = right;
        }
        
        return result.next;
    }
}