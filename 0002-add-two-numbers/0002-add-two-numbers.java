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
        ListNode result = new ListNode(-1);
        ListNode resultHead = result;
        int carry = 0;
        
        while(l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            carry = sum / 10;
            sum %= 10;
            var temp = new ListNode(sum, null);
            result.next = temp;
            result = result.next;
            
            l1 = l1.next;
            l2 = l2.next;
        }
        
        while(l1 != null) {
            int sum = l1.val + carry;
            carry = sum / 10;
            sum = sum%10;
            
            var temp = new ListNode(sum, null);
            result.next = temp;
            result = result.next;
            
            l1 = l1.next;
        }
        
        while(l2 != null) {
            int sum = l2.val + carry;
            carry = sum / 10;
            sum = sum%10;
            
            var temp = new ListNode(sum, null);
            result.next = temp;
            result = result.next;
            
            l2 = l2.next;
        }
        
        if(carry > 0) {
            var temp = new ListNode(carry, null);
            result.next = temp;
            result = result.next;
        }
        
        return resultHead.next;
    }
}