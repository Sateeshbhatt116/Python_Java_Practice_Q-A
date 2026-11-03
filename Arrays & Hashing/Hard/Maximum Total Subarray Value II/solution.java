import java.util.*;

class Solution {
    private int[][] mx, mn;

    public long maxTotalValue(int[] nums, int k) {
        int n = nums.length;
        int levels = 32 - Integer.numberOfLeadingZeros(n);

        mx = new int[levels][n];
        mn = new int[levels][n];
        for (int i = 0; i < n; i++) {
            mx[0][i] = nums[i];
            mn[0][i] = nums[i];
        }
        for (int j = 1; j < levels; j++) {
            for (int i = 0; i + (1 << j) <= n; i++) {
                int half = 1 << (j - 1);
                mx[j][i] = Math.max(mx[j - 1][i], mx[j - 1][i + half]);
                mn[j][i] = Math.min(mn[j - 1][i], mn[j - 1][i + half]);
            }
        }

        // entries: {value, l, r}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
        for (int l = 0; l < n; l++) {
            pq.offer(new int[]{range(l, n - 1), l, n - 1});
        }

        long ans = 0;
        while (k-- > 0 && !pq.isEmpty()) {
            int[] top = pq.poll();
            ans += top[0];
            int l = top[1], r = top[2];
            if (r - 1 >= l) {
                pq.offer(new int[]{range(l, r - 1), l, r - 1});
            }
        }
        return ans;
    }

    private int range(int l, int r) {
        int j = 31 - Integer.numberOfLeadingZeros(r - l + 1);
        int hi = Math.max(mx[j][l], mx[j][r - (1 << j) + 1]);
        int lo = Math.min(mn[j][l], mn[j][r - (1 << j) + 1]);
        return hi - lo;
    }
}