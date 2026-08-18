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
        // get the middle point 
        // reverse the last one
        // create a new linkedlist

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = slow;
        
        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode second = prev.next;
        prev.next = null;
        ListNode first = head;
        
        // reverse second one
        prev = null;
        ListNode curr = second;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        second = prev;

        ListNode dumy = new ListNode(-1);
        curr = dumy;
        while(first != null || second != null){
            if(first != null){
               curr.next = first;
               first = first.next;
               curr = curr.next;
            }
            if(second != null){
                curr .next = second;
                second = second.next;
                curr = curr.next;
            }
        }
    }
}




