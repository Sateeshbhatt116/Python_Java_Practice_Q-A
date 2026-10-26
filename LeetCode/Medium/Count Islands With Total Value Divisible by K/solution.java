import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int countIslands(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int[] dirs = {-1, 0, 1, 0, -1};
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0) {
                    long sum = 0;
                    Deque<Integer> stack = new ArrayDeque<>();
                    stack.push(i * n + j);
                    sum += grid[i][j];
                    grid[i][j] = 0; // mark visited

                    while (!stack.isEmpty()) {
                        int cell = stack.pop();
                        int r = cell / n, c = cell % n;

                        for (int d = 0; d < 4; d++) {
                            int nr = r + dirs[d], nc = c + dirs[d + 1];
                            if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] > 0) {
                                sum += grid[nr][nc];
                                grid[nr][nc] = 0; // mark visited when pushed
                                stack.push(nr * n + nc);
                            }
                        }
                    }

                    if (sum % k == 0) count++;
                }
            }
        }

        return count;
    }
}