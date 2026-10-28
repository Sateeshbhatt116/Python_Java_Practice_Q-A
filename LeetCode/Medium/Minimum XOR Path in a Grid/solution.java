class Solution {
    public int minCost(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        
        int maxVal = 0;
        for (int[] row : grid) {
            for (int v : row) maxVal = Math.max(maxVal, v);
        }
        int size = 1;
        while (size <= maxVal) size <<= 1;

        boolean[][][] dp = new boolean[m][n][size];
        dp[0][0][grid[0][0]] = true;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) continue;

                int val = grid[i][j];
                for (int x = 0; x < size; x++) {
                    boolean reachable = (i > 0 && dp[i - 1][j][x])
                                     || (j > 0 && dp[i][j - 1][x]);
                    if (reachable) {
                        dp[i][j][x ^ val] = true;
                    }
                }
            }
        }

        for (int x = 0; x < size; x++) {
            if (dp[m - 1][n - 1][x]) return x;
        }
        return -1; 
    }
}