
import java.util.HashSet;

class Solution {
    public ListNode deleteDuplicates(ListNode head) {

        if (head == null) {
            return null;
        }

        HashSet<Integer> set = new HashSet<>();

        ListNode current = head;
        ListNode prev = null;

        while (current != null) {

            if (set.contains(current.val)) {

                // Skip duplicate node
                prev.next = current.next;

            } else {

                // Store value
                set.add(current.val);

                prev = current;
            }

            current = current.next;
        }

        return head;
    }
}

