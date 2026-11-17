class Solution {
    public int numOfSubarrays(int[] arr) {
        final int MOD = 1_000_000_007;

        long ans = 0;
        int even = 1;   // the empty prefix has an even sum
        int odd = 0;
        int parity = 0; // parity of the current prefix sum

        for (int x : arr) {
            parity = (parity + (x & 1)) & 1;

            if (parity == 1) {
                ans += even;
                odd++;
            } else {
                ans += odd;
                even++;
            }
            ans %= MOD;
        }

        return (int) ans;
    }
}