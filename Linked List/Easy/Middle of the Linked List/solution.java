
class Solution {
    public ListNode middleNode(ListNode head) {

        int count = 0;

        ListNode temp = head;

        
        while (temp != null) {
            count++;
            temp = temp.next;
        }

        // Step 2: Find middle position
        int mid = count / 2;

        // Step 3: Reach middle node
        temp = head;

        for (int i = 0; i < mid; i++) {
            temp = temp.next;
        }

        return temp;
    }
}
