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
        // find the middle amd also count the no of node
        ListNode slow = head;
        ListNode fast = head;
        int cnt = 1;
        ListNode prev= slow;
        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
            cnt += 2;
        }
        if(fast == null)cnt--;
        if(cnt % 2 == 1){
          prev= slow.next;
          slow.next = null;
          slow = prev;
        } else{
           prev.next = null;
        } 
        ListNode mid = slow;
        ListNode first = head;
        ListNode second = mid;
        
        prev = null;
        while(second != null){
            ListNode next = second.next;
            second.next = prev;
            prev = second;
            second = next;
        }
        second = prev;

        ListNode dumy = new ListNode(-1);
        ListNode curr = dumy;
        while(first != null || second != null){
          if(first != null){
            curr.next = first;
            first = first.next;
            curr = curr.next;
          }
          if(second != null){
            curr.next = second;
            second = second.next;
            curr = curr.next;
          }
        }
        head = dumy.next;
    }
}
















