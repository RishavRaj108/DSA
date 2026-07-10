/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        // deep copy of lnked list
        // first of all i will create a copy for ech node in linkedlist
        Node curr = head;
        while(curr != null){
            int value = curr.val;
            Node nwNode = new Node(value);
            Node next = curr.next;
            curr.next = nwNode;
            nwNode.next = next;
            curr = curr.next.next;
        }

        // now point random pointers
        curr = head;
        while(curr != null){
            if(curr.random != null)
            curr.next.random = curr.random.next;
            curr = curr.next.next;
        }

        // seperate list
        curr = head;
        Node dumy = new Node(-1);
        Node ptr = dumy;
        while(curr != null){
           ptr.next = curr.next;
           ptr = ptr.next;
           curr.next = curr.next.next;
           curr = curr.next;
        }
        return dumy.next;
    }
}















