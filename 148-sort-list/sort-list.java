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
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)return head;

        ListNode slow = head , fast = head.next;
        ListNode mid = slow;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        mid = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        return mergeLL(left , right);
    }
    public ListNode mergeLL(ListNode first , ListNode second){
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while(first != null && second != null){
            if(first.val < second.val){
              curr.next = first;
              curr = curr.next;
              first = first.next;
            }else{
                curr.next = second;
                curr = curr.next;
                second = second.next;
            }
        }
        if(first != null){
            curr.next = first;
        }
        if(second != null){
            curr.next = second;
        }
        return dummy.next;
    }
}