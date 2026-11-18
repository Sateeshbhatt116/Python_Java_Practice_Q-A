class Solution {
    public boolean isPalindrome(ListNode head) {

        ArrayList<Integer> list = new ArrayList<>();

        // Step 1: Store all node values
        ListNode temp = head;

        while (temp != null) {
            list.add(temp.val);
            temp = temp.next;
        }

        // Step 2: Compare from both ends
        int left = 0;
        int right = list.size() - 1;

        while (left < right) {

            if (!list.get(left).equals(list.get(right))) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}