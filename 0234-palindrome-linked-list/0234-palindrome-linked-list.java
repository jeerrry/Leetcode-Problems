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
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        
        while(fast!=null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        
        ListNode reversed = reverseNode(slow);
        
        while(reversed != null && head != null) {
            if(reversed.val != head.val) return false;
            
            reversed = reversed.next;
            head = head.next;
        }
        
        return true;
        
    }
    
    public ListNode reverseNode(ListNode mid) {
        ListNode p = null;
        ListNode q = null;
        ListNode r = mid;
        
        while(r != null) {
            p = q;
            q = r;
            r = r.next;
            q.next = p;
        }
        
        return q;
    }
}