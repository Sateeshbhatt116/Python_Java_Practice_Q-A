import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Deque<Integer> stack = new ArrayDeque<>(); // indices, heights increasing
        int best = 0;

        for (int i = 0; i <= n; i++) {
            int h = (i == n) ? 0 : heights[i]; // sentinel at the end

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