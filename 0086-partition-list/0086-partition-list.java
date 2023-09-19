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
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null) return head;
        
        ListNode small = new ListNode();
        ListNode big = new ListNode();
        ListNode smallHead = small;
        ListNode bigHead = big;
        
        while(head != null) {
            var temp = head.next;
            head.next = null;
            if(head.val < x) {
                small.next = head;
                small = small.next;
            }else {
                big.next = head;
                big = big.next;
            }
            head = temp;
        }
        
        if(smallHead.next == null){
            return bigHead.next;
        }
        
        if(bigHead.next == null) {
            return smallHead.next;
        }
        
        small.next = bigHead.next;
        
        return smallHead.next;
    }
}