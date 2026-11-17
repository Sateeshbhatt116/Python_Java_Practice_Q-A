import java.util.ArrayDeque;

class Solution {
    public long countNonDecreasingSubarrays(int[] nums, int k) {
        int n = nums.length;
        long ans = 0;
        long cost = 0;
        int j = n - 1;

        // blocks {value, count}; front = right end of window, back = left end
        ArrayDeque<int[]> dq = new ArrayDeque<>();

        for (int i = n - 1; i >= 0; i--) {
            int num = nums[i];
            int count = 1;

            while (!dq.isEmpty() && dq.peekLast()[0] < num) {
                int[] block = dq.pollLast();
                count += block[1];
                cost += (long) (num - block[0]) * block[1];
            }
            dq.offerLast(new int[]{num, count});

            while (cost > k) {
                int[] front = dq.pollFirst();
                cost -= front[0] - nums[j];
                j--;
                if (front[1] > 1) {
                    front[1]--;
                    dq.offerFirst(front);
                }
            }

            ans += j - i + 1;
        }

        return ans;
    }
}