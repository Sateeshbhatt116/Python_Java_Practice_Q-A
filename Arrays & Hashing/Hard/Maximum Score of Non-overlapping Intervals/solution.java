import java.util.*;

class Solution {
    static class State {
        long score;
        List<Integer> indices; // kept sorted ascending by original index
        State(long score, List<Integer> indices) {
            this.score = score;
            this.indices = indices;
        }
    }

    public int[] maximumWeight(List<List<Integer>> intervals) {
        int n = intervals.size();
        Integer[] order = new Integer[n];
        for (int i = 0; i < n; i++) order[i] = i;
        // sort by right endpoint ascending
        Arrays.sort(order, (a, b) -> intervals.get(a).get(1) - intervals.get(b).get(1));

        int[] L = new int[n], R = new int[n], W = new int[n], orig = new int[n];
        for (int i = 0; i < n; i++) {
            List<Integer> iv = intervals.get(order[i]);
            L[i] = iv.get(0);
            R[i] = iv.get(1);
            W[i] = iv.get(2);
            orig[i] = order[i];
        }

        // p[i] = number of usable earlier intervals (0-based count) for interval i
        int[] p = new int[n];
        for (int i = 0; i < n; i++) {
            int lo = 0, hi = i - 1, res = -1;
            while (lo <= hi) {
                int mid = (lo + hi) / 2;
                if (R[mid] < L[i]) { res = mid; lo = mid + 1; }
                else hi = mid - 1;
            }
            p[i] = res + 1;
        }

        State[][] dp = new State[n + 1][5];
        for (int k = 0; k <= 4; k++) dp[0][k] = new State(0, new ArrayList<>());

        for (int i = 1; i <= n; i++) {
            for (int k = 0; k <= 4; k++) {
                State best = dp[i - 1][k]; // skip
                if (k >= 1) {
                    State prev = dp[p[i - 1]][k - 1];
                    List<Integer> newIdx = new ArrayList<>(prev.indices);
                    insertSorted(newIdx, orig[i - 1]);
                    State take = new State(prev.score + W[i - 1], newIdx);
                    if (better(take, best)) best = take;
                }
                dp[i][k] = best;
            }
        }

        State ans = dp[n][4];
        int[] result = new int[ans.indices.size()];
        for (int i = 0; i < result.length; i++) result[i] = ans.indices.get(i);
        return result;
    }

    private boolean better(State a, State b) {
        if (a.score != b.score) return a.score > b.score;
        int len = Math.min(a.indices.size(), b.indices.size());
        for (int i = 0; i < len; i++) {
            if (!a.indices.get(i).equals(b.indices.get(i))) {
                return a.indices.get(i) < b.indices.get(i);
            }
        }
        return a.indices.size() < b.indices.size();
    }

    private void insertSorted(List<Integer> list, int val) {
        int pos = 0;
        while (pos < list.size() && list.get(pos) < val) pos++;
        list.add(pos, val);
    }
}