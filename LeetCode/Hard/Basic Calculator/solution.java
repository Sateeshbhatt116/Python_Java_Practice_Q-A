import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int calculate(String s) {
        Deque<Integer> signs = new ArrayDeque<>();
        signs.push(1);          // sign of the outermost level

        int result = 0;
        int sign = 1;           // sign of the next number at the current level
        int i = 0;
        int n = s.length();

        while (i < n) {
            char c = s.charAt(i);

            if (c == ' ') {
                i++;
            } else if (c == '+') {
                sign = signs.peek();
                i++;
            } else if (c == '-') {
                sign = -signs.peek();
                i++;
            } else if (c == '(') {
                signs.push(sign);   // the group inherits the sign in front of it
                i++;
            } else if (c == ')') {
                signs.pop();
                i++;
            } else {
                int num = 0;
                while (i < n && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + (s.charAt(i) - '0');
                    i++;
                }
                result += sign * num;
            }
        }

        return result;
    }
}