class Solution {
    private int K;
    private int[] prodTree;
    private long[][] cntTree;
    private int n;

    static class Result {
        int prod;
        long[] cnt;
        Result(int prod, long[] cnt) {
            this.prod = prod;
            this.cnt = cnt;
        }
    }

    public int[] resultArray(int[] nums, int k, int[][] queries) {
        this.K = k;
        this.n = nums.length;
        prodTree = new int[4 * n];
        cntTree = new long[4 * n][];
        build(1, 0, n - 1, nums);

        int m = queries.length;
        int[] result = new int[m];

        for (int i = 0; i < m; i++) {
            int idx = queries[i][0];
            int val = queries[i][1] % k;
            int start = queries[i][2];
            int x = queries[i][3];

            update(1, 0, n - 1, idx, val);

            Result r = query(1, 0, n - 1, start, n - 1);
            result[i] = (r == null) ? 0 : (int) r.cnt[x];
        }

        return result;
    }

    private void build(int u, int l, int r, int[] nums) {
        if (l == r) {
            int v = nums[l] % K;
            prodTree[u] = v;
            long[] cnt = new long[K];
            cnt[v]++;
            cntTree[u] = cnt;
            return;
        }
        int mid = (l + r) >>> 1;
        build(u * 2, l, mid, nums);
        build(u * 2 + 1, mid + 1, r, nums);
        pushUp(u);
    }

    private void pushUp(int u) {
        int lc = u * 2, rc = u * 2 + 1;
        int aProd = prodTree[lc];
        int bProd = prodTree[rc];
        prodTree[u] = (aProd * bProd) % K;

        long[] merged = cntTree[lc].clone();
        long[] bCnt = cntTree[rc];
        for (int v = 0; v < K; v++) {
            if (bCnt[v] != 0) {
                merged[(aProd * v) % K] += bCnt[v];
            }
        }
        cntTree[u] = merged;
    }

    private void update(int u, int l, int r, int pos, int val) {
        if (l == r) {
            prodTree[u] = val;
            long[] cnt = new long[K];
            cnt[val]++;
            cntTree[u] = cnt;
            return;
        }
        int mid = (l + r) >>> 1;
        if (pos <= mid) update(u * 2, l, mid, pos, val);
        else update(u * 2 + 1, mid + 1, r, pos, val);
        pushUp(u);
    }

    private Result merge(Result a, Result b) {
        if (a == null) return b;
        if (b == null) return a;
        int prod = (a.prod * b.prod) % K;
        long[] cnt = a.cnt.clone();
        for (int v = 0; v < K; v++) {
            if (b.cnt[v] != 0) {
                cnt[(a.prod * v) % K] += b.cnt[v];
            }
        }
        return new Result(prod, cnt);
    }

    private Result query(int u, int l, int r, int ql, int qr) {
        if (qr < l || r < ql) return null;
        if (ql <= l && r <= qr) {
            return new Result(prodTree[u], cntTree[u]);
        }
        int mid = (l + r) >>> 1;
        Result leftRes = query(u * 2, l, mid, ql, qr);
        Result rightRes = query(u * 2 + 1, mid + 1, r, ql, qr);
        return merge(leftRes, rightRes); 
    }
}