# Asteroid Collision

| Field | Value |
|-------|-------|
| **Platform** | LeetCode |
| **Difficulty** | Medium |
| **Language** | java |
| **Solved On** | October 29, 2026 |
| **Tags** | Array, Stack, Simulation |
| **Link** | [View Problem](https://leetcode.com/problems/asteroid-collision/) |
| **Runtime** | 1 ms |
| **Memory** | 46.2 MB |

## Problem Description

<p>We are given an array <code>asteroids</code> of integers representing asteroids in a row. The indices of the asteroid in the array represent their relative position in space.</p>

<p>For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.</p>

<p>Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> asteroids = [5,10,-5]
<strong>Output:</strong> [5,10]
<strong>Explanation:</strong> The 10 and -5 collide resulting in 10. The 5 and 10 never collide.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> asteroids = [8,-8]
<strong>Output:</strong> []
<strong>Explanation:</strong> The 8 and -8 collide exploding each other.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> asteroids = [10,2,-5]
<strong>Output:</strong> [10]
<strong>Explanation:</strong> The 2 and -5 collide resulting in -5. The 10 and -5 collide resulting in 10.
</pre>

<p><strong class="example">Example 4:</strong></p>

<pre><strong>Input:</strong> asteroids = [3,5,-6,2,-1,4]​​​​​​​
<strong>Output:</strong> [-6,2,4]
<strong>Explanation:</strong> The asteroid -6 makes the asteroid 3 and 5 explode, and then continues going left. On the other side, the asteroid 2 destroys -1. Since 2 and 4 are both moving right, they never collide.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>2 &lt;= asteroids.length &lt;= 10<sup>4</sup></code></li>
	<li><code>-1000 &lt;= asteroids[i] &lt;= 1000</code></li>
	<li><code>asteroids[i] != 0</code></li>
</ul>


##  Top Community Optimal Approach

<details>
<summary>Click to expand</summary>

**Title**: TO THE POINT EXPLANATION|| JAVA C++ PYTHON ||O(N)
**Author**: [@Abhishekkant135](https://leetcode.com/Abhishekkant135/)
**Upvotes**: 92 👍
**Link**: [View Original Post](https://leetcode.com/problems/asteroid-collision/solutions/5470817/)

---

# BOISS JUST UPVOTE , I WORK SO HARD WRITNG THIS OUT AND YOU SHAMELESS PEOPLE SONT EVEN LIKE THE POST . PLS UPVOTE IT.

# Intuition

1. **Stack-based Approach**: Use a stack to keep track of the asteroids as they move.
2. **Collision Handling**: When a new asteroid is about to collide with the top of the stack, determine the outcome based on their sizes.
3. **Preserve Order**: The order of remaining asteroids should be preserved.

# Steps of Approach

1. **Initialize an empty stack** to keep track of moving asteroids.
2. **Iterate through each asteroid** in the input list:
   - If the asteroid is moving to the right (positive value), push it onto the stack.
   - If the asteroid is moving to the left (negative value), check for collisions:
     - If the stack is empty or the top of the stack is also moving left, push the current asteroid onto the stack.
     - Otherwise, compare the absolute values of the top of the stack and the current asteroid to handle the collision.
3. **Return the stack** as the final state of the asteroids.

### Python Solution with Comments
```python
class Solution(object):
    def asteroidCollision(self, asteroids):
        """
        :type asteroids: List[int]
        :rtype: List[int]
        """
        stack = []
        
        for asteroid in asteroids:
            while stack and asteroid < 0 < stack[-1]:
                if stack[-1] < -asteroid:
                    stack.pop()
                    continue
                elif stack[-1] == -asteroid:
                    stack.pop()
                break
            else:
                stack.append(asteroid)
        
        return stack
```

### C++ Solution with Comments
```cpp
class Solution {
public:
    vector<int> asteroidCollision(vector<int>& asteroids) {
        stack<int> stack;
        
        for (int asteroid : asteroids) {
            bool alive = true;
            while (!stack.empty() && asteroid < 0 && stack.top() > 0) {
                if (stack.top() < -asteroid) {
                    stack.pop();
                    continue;
                } else if (stack.top() == -asteroid) {
                    stack.pop();
                }
                alive = false;
                break;
            }
            if (alive) {
                stack.push(asteroid);
            }
        }
        
        vector<int> result(stack.size());
        for (int i = stack.size() - 1; i >= 0; --i) {
            result[i] = stack.top();
            stack.pop();
        }
        
        return result;
    }
};
```

### Java Solution with Comments
```java
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        
        for (int asteroid : asteroids) {
            boolean alive = true;
            while (!stack.isEmpty() && asteroid < 0 && stack.peek() > 0) {
                if (stack.peek() < -asteroid) {
                    stack.pop();
                    continue;
                } else if (stack.peek() == -asteroid) {
                    stack.pop();
                }
                alive = false;
                break;
            }
            if (alive) {
                stack.push(asteroid);
            }
        }
        
        int[] result = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; --i) {
            result[i] = stack.pop();
        }
        
        return result;
    }
}
```

# Explanation:

- **Stack Usage**: The stack helps in simulating the movement and collision of asteroids.
- **Collision Handling**: When a new asteroid collides with the top of the stack, handle the collision based on the sizes and directions of the asteroids.
- **Order Preservation**: The final state of the asteroids is preserved by returning the contents of the stack.

**Time Complexity**: O(n), where n is the length of the input list. Each asteroid is processed once.
**Space Complexity**: O(n), for storing asteroids in the stack.

</details>
