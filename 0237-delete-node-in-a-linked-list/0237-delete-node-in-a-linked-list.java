/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        ListNode temp = node;
        ListNode follow = null;
        while(temp.next != null) {
            temp.val = temp.next.val;
            follow = temp;
            temp = temp.next;
        }
        
        follow.next = null;
    }
}