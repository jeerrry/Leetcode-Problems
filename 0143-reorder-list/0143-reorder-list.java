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
    public void reorderList(ListNode head) {
        ListNode middleNode = findMiddleNode(head);
        ListNode secondHalf = reverseLinkedListFromNode(middleNode);
        ListNode firstHalf = head;
        
        while(firstHalf != null && secondHalf != null) {
            ListNode firstTemp = firstHalf;
            ListNode secondTemp = secondHalf;
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
            
            firstTemp.next = secondTemp;
            if(secondTemp == firstHalf) {
                secondTemp.next = null;
                break;
            }
            secondTemp.next = firstHalf;
        }
    }
    
    private ListNode findMiddleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        
        return slow;
    }
    
    private ListNode reverseLinkedListFromNode(ListNode head) {
        ListNode p = head;
        ListNode q = null;
        ListNode r = null;
        
        while(p != null) {
            r = q;
            q = p;
            p = p.next;
            q.next = r;
        }
        
        return q;
    }
}