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
    public ListNode mergeKLists(ListNode[] lists) {
        int size = lists.length;
        int interval = 1;
        
        while(interval < size){
            for(int i=0; i<size - interval; i+= 2 * interval){
                lists[i] = mergeNodes(lists[i], lists[i + interval]);
            }
            
            interval *= 2;
        }
        
        return size > 0 ? lists[0] : null;
    }
    
    private ListNode mergeNodes(ListNode list1, ListNode list2){
        ListNode result = new ListNode();
        ListNode current = result;
        
        while(list1 != null && list2 != null) {
            if(list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            }else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }
        
        while(list1 != null) {
            current.next = list1;
            list1 = list1.next;
            current = current.next;
        }
        
        while(list2 != null){
            current.next = list2;
            list2 = list2.next;
            current = current.next;
        }
        
        return result.next;
    }
}