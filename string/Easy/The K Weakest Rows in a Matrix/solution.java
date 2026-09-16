import java.util.Arrays;

class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;

      
        long[] strength = new long[m];

        for (int i = 0; i < m; i++) {
            int soldiers = countSoldiers(mat[i]);
            strength[i] = ((long) soldiers << 32) | i;
        }

        Arrays.sort(strength);

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = (int) (strength[i] & 0xFFFFFFFFL);
        }

        return result;
    }

    private int countSoldiers(int[] row) {
        int lo = 0, hi = row.length;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (row[mid] == 1) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}