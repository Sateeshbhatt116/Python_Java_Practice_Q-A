class Solution {
    public int distinctSubseqII(String s) {
        final int MOD = 1_000_000_007;
        long[] last = new long[26];  
        long dp = 1; 

        for (char c : s.toCharArray()) {
            int idx = c - 'a';
            long newDp = (2 * dp) % MOD;
            newDp = (newDp - last[idx] + MOD) % MOD;
            last[idx] = dp; 
            dp = newDp;
        }
        return (int) ((dp - 1 + MOD) % MOD);
    }
}