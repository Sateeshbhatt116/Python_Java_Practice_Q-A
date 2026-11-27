class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int[] f = new int[budget + 1]; // f[s] = best copies using at most s on first purchases
        int mn = Integer.MAX_VALUE;

        for (int[] item : items) {
            int factor = item[0];
            int price = item[1];
            mn = Math.min(mn, price);

            // copies obtained by first-buying this item (itself plus free copies)
            int cnt = 0;
            for (int[] other : items) {
                if (other[0] % factor == 0) cnt++;
            }

            // 0-1 knapsack, iterate budget downward so each item is used once
            for (int s = budget; s >= price; s--) {
                f[s] = Math.max(f[s], f[s - price] + cnt);
            }
        }

        int ans = 0;
        for (int s = 0; s <= budget; s++) {
            ans = Math.max(ans, f[s] + (budget - s) / mn);
        }
        return ans;
    }
}