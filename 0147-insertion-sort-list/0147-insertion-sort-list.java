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
    public ListNode insertionSortList(ListNode head) {
        if(head == null) return head;
        
        ListNode result = new ListNode();
        ListNode current = result.next;
        while(head != null) {
            if(current == null) {
                current = head;
                head = head.next;
                current.next = null;
            }else if(head.val <= current.val){
                ListNode temp = head.next;
                head.next = current;
                current = head;
                head = temp;
            }else {
                ListNode prev = null;
                ListNode pontr = current;
                while(current != null && head.val > current.val){
                    prev = current;
                    current = current.next;
                }
                
                ListNode tNext = head.next;
                prev.next = head;
                if(current == null) {
                    head.next = null;
                }else {
                    head.next = current;
                }
                
                head = tNext;
                current = result.next;
                
                continue;
            }
            
            result.next = current;
        }
        
        return result.next;
    }
}