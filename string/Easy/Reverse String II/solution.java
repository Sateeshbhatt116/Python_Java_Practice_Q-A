class Solution {
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        int n = chars.length;

        for (int start = 0; start < n; start += 2 * k) {
            int left = start;
            int right = Math.min(start + k - 1, n - 1); 

            reverse(chars, left, right);
        }

        return new String(chars);
    }

    private void reverse(char[] chars, int left, int right) {
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
    }
}