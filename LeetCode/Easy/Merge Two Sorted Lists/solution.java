import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ArrayList<Integer> values = new ArrayList<>();

        // Step 1: Store values of first list
        while (list1 != null) {
            values.add(list1.val);
            list1 = list1.next;
        }

        // Step 2: Store values of second list
        while (list2 != null) {
            values.add(list2.val);
            list2 = list2.next;
        }

        // Step 3: Sort the values
        Collections.sort(values);

        // Step 4: Create new linked list
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        for (int val : values) {
            current.next = new ListNode(val);
            current = current.next;
        }

        return dummy.next;
    }
}
