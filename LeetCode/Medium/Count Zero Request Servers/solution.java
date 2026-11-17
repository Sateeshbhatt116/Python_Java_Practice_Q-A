import java.util.*;

class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        Arrays.sort(logs, (a, b) -> Integer.compare(a[1], b[1]));

        int q = queries.length;
        Integer[] order = new Integer[q];
        for (int i = 0; i < q; i++) order[i] = i;
        Arrays.sort(order, (a, b) -> Integer.compare(queries[a], queries[b]));

        int[] freq = new int[n + 1];
        int active = 0;
        int add = 0, remove = 0;
        int[] ans = new int[q];

        for (int idx : order) {
            int hi = queries[idx];
            int lo = hi - x;

            while (add < logs.length && logs[add][1] <= hi) {
                if (freq[logs[add][0]]++ == 0) active++;
                add++;
            }
            while (remove < logs.length && logs[remove][1] < lo) {
                if (--freq[logs[remove][0]] == 0) active--;
                remove++;
            }

            ans[idx] = n - active;
        }

        return ans;
    }
}