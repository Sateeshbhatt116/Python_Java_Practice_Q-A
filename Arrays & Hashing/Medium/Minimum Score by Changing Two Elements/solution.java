import java.util.Arrays;

class Solution {
    public int minimizeSum(int[] nums) {
        int n = nums.length;
        if (n <= 3) return 0;

        Arrays.sort(nums);

        int removeTwoSmallest = nums[n - 1] - nums[2];
        int removeSmallestAndLargest = nums[n - 2] - nums[1];
        int removeTwoLargest = nums[n - 3] - nums[0];

        return Math.min(removeTwoSmallest,
               Math.min(removeSmallestAndLargest, removeTwoLargest));
    }
}