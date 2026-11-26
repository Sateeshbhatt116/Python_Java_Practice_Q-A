class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        // Step 1: insert a copy after each original node
        // A -> B -> C  becomes  A -> A' -> B -> B' -> C -> C'
        Node curr = head;
        while (curr != null) {
            Node copy = new Node(curr.val);
            copy.next = curr.next;
            curr.next = copy;
            curr = copy.next;
        }

        // Step 2: set random pointers of the copies
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        // Step 3: separate the two lists and restore the original
        Node dummy = new Node(0);
        Node copyTail = dummy;
        curr = head;
        while (curr != null) {
            Node copy = curr.next;
            curr.next = copy.next;   // restore original list
            copyTail.next = copy;    // attach copy to new list
            copyTail = copy;
            curr = curr.next;
        }

        return dummy.next;
    }
}