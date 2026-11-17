import java.util.*;

class Solution {
    public long minOperations(int[] nums, int x, int k) {
        int n = nums.length;

        int[] vals = Arrays.stream(nums).distinct().sorted().toArray();
        int m = vals.length;
        int[] rank = new int[n];
        for (int i = 0; i < n; i++) {
            rank[i] = Arrays.binarySearch(vals, nums[i]) + 1; // 1-indexed
        }

        long[] cnt = new long[m + 1];
        long[] sum = new long[m + 1];
        int top = Integer.highestOneBit(m);

        long[] cost = new long[n - x + 1];
        long windowSum = 0;

        for (int i = 0; i < n; i++) {
            update(cnt, sum, rank[i], 1, nums[i], m);
            windowSum += nums[i];

            if (i >= x) {
                update(cnt, sum, rank[i - x], -1, -nums[i - x], m);
                windowSum -= nums[i - x];
            }

            if (i >= x - 1) {
                // find the ((x+1)/2)-th smallest value in the window
                int rem = (x + 1) / 2;
                int pos = 0;
                for (int pw = top; pw > 0; pw >>= 1) {
                    if (pos + pw <= m && cnt[pos + pw] < rem) {
                        pos += pw;
                        rem -= cnt[pos];
                    }
                }
                long med = vals[pos];

                long cLE = 0, sLE = 0;
                for (int j = pos + 1; j > 0; j -= j & -j) {
                    cLE += cnt[j];
                    sLE += sum[j];
                }

                cost[i - x + 1] = med * cLE - sLE
                                + (windowSum - sLE) - med * (x - cLE);
            }
        }

        final long INF = Long.MAX_VALUE / 4;
        long[][] dp = new long[n + 1][k + 1];
        for (long[] row : dp) Arrays.fill(row, INF);
        for (int i = 0; i <= n; i++) dp[i][0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                dp[i][j] = dp[i - 1][j];
                if (i >= x && dp[i - x][j - 1] < INF) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - x][j - 1] + cost[i - x]);
                }
            }
        }

        return dp[n][k];
    }

    private void update(long[] cnt, long[] sum, int idx, int dc, long dv, int m) {
        for (; idx <= m; idx += idx & -idx) {
            cnt[idx] += dc;
            sum[idx] += dv;
        }
    }
}