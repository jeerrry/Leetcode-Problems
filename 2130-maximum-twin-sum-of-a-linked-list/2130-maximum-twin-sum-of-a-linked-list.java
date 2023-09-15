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
    public int pairSum(ListNode head) {
        ListNode secondHalf = reverseSecondHalf(head);
        
        int maxSum = 0;
        
        while(secondHalf != null) {
            int sum = head.val + secondHalf.val;
            maxSum = Math.max(sum, maxSum);
            head = head.next;
            secondHalf = secondHalf.next;
        }
        
        return maxSum;
    }
    
    private ListNode reverseSecondHalf(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode tail = null;
        
        // Find Mid Node
        while(fast != null && fast.next != null) {
            tail = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        tail.next = null;
        
        // Reverse from Mid Node
        tail = null;
        while(slow != null) {
            ListNode temp = slow.next;
            slow.next = tail;
            tail = slow;
            slow = temp;
        }
        
        return tail;
    }
}