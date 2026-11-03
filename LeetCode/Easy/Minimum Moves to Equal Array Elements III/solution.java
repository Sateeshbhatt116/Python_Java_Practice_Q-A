class Solution {
    public int minMoves(int[] nums) {
        int max = Integer.MIN_VALUE;
        long sum = 0;

        for (int num : nums) {
            max = Math.max(max, num);
            sum += num;
        }

        return (int) ((long) max * nums.length - sum);
    }
}