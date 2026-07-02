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
        if (head == null) {
            return null;
        }
        
        // Step 1: Create duplicates and interweave them into the original list
        Node curr = head;
        while (curr != null) {
            Node nextOriginal = curr.next; // Track the true next node
            Node copyNode = new Node(curr.val);
            
            curr.next = copyNode;
            copyNode.next = nextOriginal;
            
            curr = nextOriginal; // Safely move to the next original node
        }
        
        // Step 2: Wire up the random pointers for the copied nodes
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }
        
        // Step 3: Unweave and extract the copied list, restoring the original
        curr = head;
        Node dummyHead = new Node(0);
        Node copyCurr = dummyHead;
        
        while (curr != null) {
            Node nextOriginal = curr.next.next;
            Node copyNode = curr.next;
            
            copyCurr.next = copyNode;
            copyCurr = copyNode;
            
            curr.next = nextOriginal; // Restore the original list structure
            curr = nextOriginal;
        }
        
        return dummyHead.next;
    }
}
