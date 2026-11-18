public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode tempA = headA;

        while (tempA != null) {

            ListNode tempB = headB;

            while (tempB != null) {

                // Check whether both point to same node
                if (tempA == tempB) {
                    return tempA;
                }

                tempB = tempB.next;
            }

            tempA = tempA.next;
        }

        return null;
    }
}