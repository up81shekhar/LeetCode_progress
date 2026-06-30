/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        if(head == null) return head;

        Node curr = head;

        while(curr != null){
            if(curr.child != null){
                Node pointTONext = curr.next;
                curr.next = flatten(curr.child);
                curr.next.prev = curr;
                curr.child = null;

                while(curr.next != null){
                    curr = curr.next;
                }

                if(pointTONext != null){
                    curr.next = pointTONext;
                    pointTONext.prev = curr;
                }
            }
            curr = curr.next;
        }

        return head;
    }
}