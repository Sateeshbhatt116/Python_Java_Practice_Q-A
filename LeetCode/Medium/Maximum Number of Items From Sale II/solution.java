import java.util.ArrayList;
import java.util.List;

class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        int[] cntFactor = new int[n + 1];
        long mn = Long.MAX_VALUE;

        for (int[] it : items) {
            cntFactor[it[0]]++;
            mn = Math.min(mn, it[1]);
        }

        // multiples[f] = number of items whose factor is a multiple of f
        int[] multiples = new int[n + 1];
        for (int f = 1; f <= n; f++) {
            for (int m = f; m <= n; m += f) {
                multiples[f] += cntFactor[m];
            }
        }

        // double copies worth buying: {price, how many free copies it can unlock}
        List<long[]> doubles = new ArrayList<>();
        for (int[] it : items) {
            long price = it[1];
            long free = multiples[it[0]] - 1;       // exclude the item itself
            if (free > 0 && price < 2 * mn) {
                doubles.add(new long[]{price, free});
            }
        }
        doubles.sort((a, b) -> Long.compare(a[0], b[0]));

        long rest = budget;
        long total = 0;

        for (long[] d : doubles) {
            long price = d[0];
            long free = d[1];
            long t = Math.min(free, rest / price);
            total += 2 * t;                          // purchased copy + its free copy
            rest -= t * price;
            if (t < free) break;                     // cannot afford more at this price or higher
        }

        total += rest / mn;                          // leftover money buys single copies
        return (int) total;
    }
}