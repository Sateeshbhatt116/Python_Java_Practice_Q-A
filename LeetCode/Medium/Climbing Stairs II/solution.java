import java.util.Arrays;

class Solution {
    public int climbStairs(int n, int[] costs) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int j = 1; j <= n; j++) {
            for (int step = 1; step <= 3; step++) {
                int i = j - step;
                if (i < 0) break;
               
                dp[j] = Math.min(dp[j], dp[i] + costs[j - 1] + step * step);
            }
        }

        return dp[n];
    }
}