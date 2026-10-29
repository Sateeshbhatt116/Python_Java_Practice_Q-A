import java.util.Arrays;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int[] stack = new int[asteroids.length];
        int top = -1;

        for (int a : asteroids) {
            boolean alive = true;

            // collision only happens when the top moves right and the incoming moves left
            while (alive && a < 0 && top >= 0 && stack[top] > 0) {
                if (stack[top] < -a) {
                    top--;               // top explodes, incoming keeps going
                } else if (stack[top] == -a) {
                    top--;               // both explode
                    alive = false;
                } else {
                    alive = false;       // incoming explodes
                }
            }

            if (alive) {
                stack[++top] = a;
            }
        }

        return Arrays.copyOf(stack, top + 1);
    }
}