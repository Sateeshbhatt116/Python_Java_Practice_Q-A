import java.util.*;

class Solution {
    public int minimumChanges(String s, int k) {
        int n = s.length();
        final int INF = 1_000_000;
        char[] c = s.toCharArray();

   
        List<List<Integer>> divs = new ArrayList<>();
        for (int len = 0; len <= n; len++) divs.add(new ArrayList<>());
        for (int len = 2; len <= n; len++) {
            for (int d = 1; d < len; d++) {
                if (len % d == 0) divs.get(len).add(d);
            }
        }

        
        int[][] cost = new int[n][n];
        for (int i = 0; i < n; i++) {
            cost[i][i] = INF; 
            for (int j = i + 1; j < n; j++) {
                int len = j - i + 1;
                int best = INF;
                for (int d : divs.get(len)) {
                    int changes = 0;
                    int steps = len / d;
                    for (int r = 0; r < d; r++) {
                        int lo = i + r;
                        int hi = i + r + (steps - 1) * d;
                        while (lo < hi) {
                            if (c[lo] != c[hi]) changes++;
                            lo += d;
                            hi -= d;
                        }
                    }
                    best = Math.min(best, changes);
                }
                cost[i][j] = best;
            }
        }

        // dp[j][i] = min cost to split first i chars into j parts
        int[][] dp = new int[k + 1][n + 1];
        for (int[] row : dp) Arrays.fill(row, INF);
        dp[0][0] = 0;

        for (int j = 1; j <= k; j++) {
            for (int i = 1; i <= n; i++) {
                for (int p = 0; p < i; p++) {
                    if (dp[j - 1][p] >= INF) continue;
                    dp[j][i] = Math.min(dp[j][i], dp[j - 1][p] + cost[p][i - 1]);
                }
            }
        }

        return dp[k][n];
    }
}