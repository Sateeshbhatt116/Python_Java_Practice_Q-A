class Solution {
    public boolean hasValidPath(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        int len = m + n - 1;

        if (len % 2 != 0) return false;
        if (grid[0][0] == ')' || grid[m - 1][n - 1] == '(') return false;

        int maxBalance = len / 2 + 1;
        boolean[][][] dp = new boolean[m][n][maxBalance + 1];
        dp[0][0][1] = true;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) continue;

                int delta = grid[i][j] == '(' ? 1 : -1;

                for (int b = 0; b <= maxBalance; b++) {
                    boolean fromTop = i > 0 && dp[i - 1][j][b];
                    boolean fromLeft = j > 0 && dp[i][j - 1][b];

                    if (fromTop || fromLeft) {
                        int nb = b + delta;
                        if (nb >= 0 && nb <= maxBalance) {
                            dp[i][j][nb] = true;
                        }
                    }
                }
            }
        }

        return dp[m - 1][n - 1][0];
    }
}