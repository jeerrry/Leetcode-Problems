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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode result = new ListNode();
        ListNode current = result;
        
        while(head != null) {
            ListNode tempHead = head;
            for(int i=1; i<k && head != null; i++){
                head = head.next;
            }
            
            if(head == null){
                current.next = tempHead;
                break;
            }
            
            ListNode tempTail = head;
            head = head.next;
            tempTail.next = null;
            
            // Reverse Seperated List
            current.next = reverseNodes(tempHead);
            current = tempHead;
        }
        
        return result.next;
    }
    
    private ListNode reverseNodes(ListNode head) {
        ListNode p = null;
        ListNode q = head;
        
        while(q != null){
            ListNode temp = q.next;
            q.next = p;
            p = q;
            q = temp;
        }
        
        return p;
    }
}