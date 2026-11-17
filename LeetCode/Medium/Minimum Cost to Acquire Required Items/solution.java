class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        // Case 1: only single-type items
        long onlySingles = (long) need1 * cost1 + (long) need2 * cost2;

        int lo = Math.min(need1, need2);
        int hi = Math.max(need1, need2);

        // Case 2: type 3 items cover the smaller need, singles cover the remainder
        long mixed = (long) lo * costBoth
                   + (long) (need1 - lo) * cost1
                   + (long) (need2 - lo) * cost2;

        // Case 3: only type 3 items
        long onlyBoth = (long) hi * costBoth;

        return Math.min(onlySingles, Math.min(mixed, onlyBoth));
    }
}