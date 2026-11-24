class Solution {
    public int maxLength(int[] nums) {
        int n = nums.length;
        int best = 0;

        for (int i = 0; i < n; i++) {
            long prod = 1;
            long g = 0;
            long l = 1;

            for (int j = i; j < n; j++) {
                prod *= nums[j];
                g = gcd(g, nums[j]);
                l = l / gcd(l, nums[j]) * nums[j];

                // lcm * gcd is at most 2520 * 10, and prod only grows from here
                if (prod > 25200) break;

                if (prod == l * g) {
                    best = Math.max(best, j - i + 1);
                }
            }
        }

        return best;
    }

    private long gcd(long a, long b) {
        while (b != 0) {
            long t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
}