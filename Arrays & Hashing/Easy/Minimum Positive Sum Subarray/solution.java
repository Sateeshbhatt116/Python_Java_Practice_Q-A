class Solution {
    public int minimumSumSubarray(java.util.List<Integer> nums, int l, int r) {
        int n = nums.size();
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums.get(i);
        }

        int best = Integer.MAX_VALUE;

        for (int len = l; len <= r; len++) {
            for (int i = 0; i + len <= n; i++) {
                int sum = prefix[i + len] - prefix[i];
                if (sum > 0) {
                    best = Math.min(best, sum);
                }
            }
        }

        return best == Integer.MAX_VALUE ? -1 : best;
    }
}