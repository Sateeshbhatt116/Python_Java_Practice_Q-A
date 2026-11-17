import java.util.Arrays;

class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int count = 0;

        for (int a : arr1) {
            int idx = lowerBound(arr2, a - d);
            if (idx == arr2.length || arr2[idx] > a + d) {
                count++;
            }
        }

        return count;
    }

    // first index with arr[idx] >= target
    private int lowerBound(int[] arr, int target) {
        int lo = 0, hi = arr.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] < target) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }
}