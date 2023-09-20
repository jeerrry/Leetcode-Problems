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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left == right) return head;
        
        ListNode start = head;
        ListNode preStart = null;
        
        for(int i=1; i<left; i++) {
            preStart = start;
            start = start.next;
        }
        
        ListNode reverseTail = start;
        ListNode follow = null;
        ListNode lead = start;
        for(int i=0; i<=right - left && lead != null; i++) {
            ListNode next = lead.next;
            lead.next = follow;
            follow = lead;
            lead = next;
        }
        
        if(preStart == null){
            head = follow;
            reverseTail.next = lead;
        }else{
            preStart.next = follow;
            reverseTail.next = lead;
        }
        
        return head;
    }
}