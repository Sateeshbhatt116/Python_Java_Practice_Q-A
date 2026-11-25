import java.util.Arrays;
import java.util.Random;

class Solution {
    private static final long M1 = 1_000_000_007L;
    private static final long M2 = 998_244_353L;

    private int n;
    private long[] h1, h2, p1, p2;

    public int smallestUniqueSubarray(int[] nums) {
        n = nums.length;

        Random rnd = new Random(System.nanoTime());
        long b1 = 200_000 + rnd.nextInt(900_000_000);
        long b2 = 200_000 + rnd.nextInt(900_000_000);

        h1 = new long[n + 1];
        h2 = new long[n + 1];
        p1 = new long[n + 1];
        p2 = new long[n + 1];
        p1[0] = 1;
        p2[0] = 1;
        for (int i = 0; i < n; i++) {
            h1[i + 1] = (h1[i] * b1 + nums[i]) % M1;
            h2[i + 1] = (h2[i] * b2 + nums[i]) % M2;
            p1[i + 1] = p1[i] * b1 % M1;
            p2[i + 1] = p2[i] * b2 % M2;
        }

        int lo = 1, hi = n; // the whole array is always unique
        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            if (hasUnique(mid)) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }

    private boolean hasUnique(int len) {
        int cnt = n - len + 1;
        long[] keys = new long[cnt];

        for (int i = 0; i < cnt; i++) {
            long a = ((h1[i + len] - h1[i] * p1[len]) % M1 + M1) % M1;
            long b = ((h2[i + len] - h2[i] * p2[len]) % M2 + M2) % M2;
            keys[i] = (a << 32) | b;
        }

        Arrays.sort(keys);

        for (int i = 0; i < cnt; i++) {
            boolean diffPrev = (i == 0) || keys[i] != keys[i - 1];
            boolean diffNext = (i == cnt - 1) || keys[i] != keys[i + 1];
            if (diffPrev && diffNext) return true;
        }
        return false;
    }
}