import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;

        int cols = matrix[0].length;
        int[] heights = new int[cols];
        int best = 0;

        for (char[] row : matrix) {
            for (int j = 0; j < cols; j++) {
                heights[j] = (row[j] == '1') ? heights[j] + 1 : 0;
            }
            best = Math.max(best, largestRectangleArea(heights));
        }

        return best;
    }

    // same as problem 84
    private int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Deque<Integer> stack = new ArrayDeque<>();
        int best = 0;

        for (int i = 0; i <= n; i++) {
            int h = (i == n) ? 0 : heights[i];

            while (!stack.isEmpty() && heights[stack.peek()] > h) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                best = Math.max(best, height * width);
            }

            stack.push(i);
        }

        return best;
    }
}