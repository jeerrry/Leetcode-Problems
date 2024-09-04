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
    public ListNode oddEvenList(ListNode head) {
        ListNode odd = new ListNode(-1);
        ListNode even = new ListNode(-1);
        var tempOdd = odd;
        var tempEven = even;
        
        var temp = head;
        int flag = 1;
        while(temp != null) {
            var next = temp.next;
            if(flag > 0) {
                odd.next = temp;
                odd = odd.next;
            }else {
                even.next = temp;
                even = even.next;
            }
            
            temp.next = null;
            temp = next;
            flag = (flag + 1) % 2;
        }
        
        odd.next = tempEven.next;
        return tempOdd.next;
    }
}