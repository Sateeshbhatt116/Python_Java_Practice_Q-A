# Daily Temperatures

| Field | Value |
|-------|-------|
| **Platform** | LeetCode |
| **Difficulty** | Medium |
| **Language** | java |
| **Solved On** | October 28, 2026 |
| **Tags** | Array, Stack, Monotonic Stack |
| **Link** | [View Problem](https://leetcode.com/problems/daily-temperatures/) |
| **Runtime** | 24 ms |
| **Memory** | 102.8 MB |

## Problem Description

<p>Given an array of integers <code>temperatures</code> represents the daily temperatures, return <em>an array</em> <code>answer</code> <em>such that</em> <code>answer[i]</code> <em>is the number of days you have to wait after the</em> <code>i<sup>th</sup></code> <em>day to get a warmer temperature</em>. If there is no future day for which this is possible, keep <code>answer[i] == 0</code> instead.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<pre><strong>Input:</strong> temperatures = [73,74,75,71,69,72,76,73]
<strong>Output:</strong> [1,1,4,2,1,1,0,0]
</pre><p><strong class="example">Example 2:</strong></p>
<pre><strong>Input:</strong> temperatures = [30,40,50,60]
<strong>Output:</strong> [1,1,1,0]
</pre><p><strong class="example">Example 3:</strong></p>
<pre><strong>Input:</strong> temperatures = [30,60,90]
<strong>Output:</strong> [1,1,0]
</pre>
<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;=&nbsp;temperatures.length &lt;= 10<sup>5</sup></code></li>
	<li><code>30 &lt;=&nbsp;temperatures[i] &lt;= 100</code></li>
</ul>


##  Top Community Optimal Approach

<details>
<summary>Click to expand</summary>

**Title**: 🚀🚀🚀 EASY 🔥 STACK 🚀🚀🚀 FRiENDLY EXPLAiNED ✅✅✅
**Author**: [@prodonik](https://leetcode.com/prodonik/)
**Upvotes**: 356 👍
**Link**: [View Original Post](https://leetcode.com/problems/daily-temperatures/solutions/4651723/)

---

# Intuition
The goal is to find the number of days one has to wait until a warmer day for each given day\'s temperature. This can be efficiently solved using a stack.

# Approach
- Initialize an array `results` to store the number of days until a warmer day for each day\'s temperature.
- Initialize an empty stack to keep track of indices.
- Iterate through each temperature in the array.
  - While the stack is not empty and the current temperature is greater than the temperature at the index on the top of the stack:
    - Update the result for the index at the top of the stack with the difference between the current index and the index on the top of the stack.
    - Pop the index from the stack.
  - Push the current index onto the stack.
- After the iteration, the `results` array contains the number of days until a warmer day for each given day.

# Complexity
- Time complexity: $$O(n)$$, where n is the number of temperatures.
- Space complexity: $$O(n)$$, as the stack can have at most n elements.

![image.png](https://assets.leetcode.com/users/images/528e6b5d-4a40-4ca1-994d-4ce7c77aeb4b_1706662264.1096313.png)

## UPVOTE iF THiS WAS HELPFUL :)

# Code
```java []
class Solution {
    public int[] dailyTemperatures(int[] temps) {
        int[] results = new int[temps.length];
        Stack<Integer> stack = new Stack<>();
        /// UPVOTE !
        for (int i = 0; i < temps.length; i++) {
            while (!stack.isEmpty() && temps[stack.peek()] < temps[i]) {
                results[stack.peek()] = i - stack.pop();
            }
            stack.push(i);
        }

        return results;
    }
}
```
```C++ []
class Solution {
public:
    std::vector<int> dailyTemperatures(std::vector<int>& temps) {
        std::vector<int> results(temps.size());
        std::stack<int> stack;
        /// UPVOTE !
        for (int i = 0; i < temps.size(); i++) {
            while (!stack.empty() && temps[stack.top()] < temps[i]) {
                results[stack.top()] = i - stack.top();
                stack.pop();
            }
            stack.push(i);
        }

        return results;
    }
};
```
```Python []
class Solution:
    def dailyTemperatures(self, temps):
        results = [0] * len(temps)
        stack = []
        # UPVOTE !
        for i, temp in enumerate(temps):
            while stack and temps[stack[-1]] < temp:
                index = stack.pop()
                results[index] = i - index
            stack.append(i)

        return results
```
```C# []
public class Solution {
    public int[] DailyTemperatures(int[] temps) {
        int[] results = new int[temps.Length];
        Stack<int> stack = new Stack<int>();
        /// UPVOTE !
        for (int i = 0; i < temps.Length; i++) {
            while (stack.Count > 0 && temps[stack.Peek()] < temps[i]) {
                int index = stack.Pop();
                results[index] = i - index;
            }
            stack.Push(i);
        }

        return results;
    }
}
```
```Go []
func dailyTemperatures(temps []int) []int {
	results := make([]int, len(temps))
	stack := make([]int, 0)
    /// UPVOTE !
	for i, temp := range temps {
		for len(stack) > 0 && temps[stack[len(stack)-1]] < temp {
			index := stack[len(stack)-1]
			stack = stack[:len(stack)-1]
			results[index] = i - index
		}
		stack = append(stack, i)
	}

	return results
}
```
```Ruby []
class Solution
  def daily_temperatures(temps)
    results = Array.new(temps.length, 0)
    stack = []
    # UPVOTE !
    temps.each_with_index do |temp, i|
      while !stack.empty? && temps[stack.last] < temp
        index = stack.pop
        results[index] = i - index
      end
      stack.push(i)
    end

    results
  end
end
```
![image.png](https://assets.leetcode.com/users/images/8db6b1e2-86f8-4e76-9ba5-21b62eba8bbc_1706662296.5743473.png)


</details>
