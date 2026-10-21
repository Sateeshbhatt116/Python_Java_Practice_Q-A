# Valid Parentheses

| Field | Value |
|-------|-------|
| **Platform** | LeetCode |
| **Difficulty** | Easy |
| **Language** | java |
| **Solved On** | October 21, 2026 |
| **Tags** | String, Stack, Bracket Sequences |
| **Link** | [View Problem](https://leetcode.com/problems/valid-parentheses/) |
| **Runtime** | 3 ms |
| **Memory** | 43.1 MB |

## Problem Description

<p>Given a string <code>s</code> containing just the characters <code>'('</code>, <code>')'</code>, <code>'{'</code>, <code>'}'</code>, <code>'['</code> and <code>']'</code>, determine if the input string is valid.</p>

<p>An input string is valid if:</p>

<ol>
	<li>Open brackets must be closed by the same type of brackets.</li>
	<li>Open brackets must be closed in the correct order.</li>
	<li>Every close bracket has a corresponding open bracket of the same type.</li>
</ol>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = "()"</span></p>

<p><strong>Output:</strong> <span class="example-io">true</span></p>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = "()[]{}"</span></p>

<p><strong>Output:</strong> <span class="example-io">true</span></p>
</div>

<p><strong class="example">Example 3:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = "(]"</span></p>

<p><strong>Output:</strong> <span class="example-io">false</span></p>
</div>

<p><strong class="example">Example 4:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = "([])"</span></p>

<p><strong>Output:</strong> <span class="example-io">true</span></p>
</div>

<p><strong class="example">Example 5:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = "([)]"</span></p>

<p><strong>Output:</strong> <span class="example-io">false</span></p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 10<sup>4</sup></code></li>
	<li><code>s</code> consists of parentheses only <code>'()[]{}'</code>.</li>
</ul>


##  Top Community Optimal Approach

<details>
<summary>Click to expand</summary>

**Title**: ✔️✔️Easy Solutions in Java ✔️✔️, Python ✔️, and C++ ✔️🧐Look at once 💻 with Exaplanation
**Author**: [@Vikas-Pathak-123](https://leetcode.com/Vikas-Pathak-123/)
**Upvotes**: 2798 👍
**Link**: [View Original Post](https://leetcode.com/problems/valid-parentheses/solutions/3399077/)

---

# Intuition
<!-- Describe your first thoughts on how to solve this problem. -->
The problem requires us to determine if the given string of brackets is valid or not. We can use a stack data structure to keep track of opening brackets encountered and check if they match with the corresponding closing brackets.

# Approach
<!-- Describe your approach to solving the problem. -->
Here is the step-by-step approach of the algorithm:
1. Initialize an empty stack.

2. Traverse the input string character by character.

3. If the current character is an opening bracket (i.e., \'(\', \'{\', \'[\'), push it onto the stack.

4. If the current character is a closing bracket (i.e., \')\', \'}\', \']\'), check if the stack is empty. If it is empty, return false, because the closing bracket does not have a corresponding opening bracket. Otherwise, pop the top element from the stack and check if it matches the current closing bracket. If it does not match, return false, because the brackets are not valid.

5. After traversing the entire input string, if the stack is empty, return true, because all opening brackets have been matched with their corresponding closing brackets. Otherwise, return false, because some opening brackets have not been matched with their corresponding closing brackets.

# Complexity
- Time complexity:
<!-- Add your time complexity here, e.g. $$O(n)$$ -->
The time complexity of the solution is $$O(n)$$, where n is the length of the input string. This is because we traverse the string once and perform constant time operations for each character.

- Space complexity:
<!-- Add your space complexity here, e.g. $$O(n)$$ -->
The space complexity of the solution is $$O(n)$$, where n is the length of the input string. This is because the worst-case scenario is when all opening brackets are present in the string and the stack will have to store them all.

![image.png](https://assets.leetcode.com/users/images/b427e686-2e5d-469a-8e7a-db5140022a6b_1677715904.0948765.png)


# Please Upvote\uD83D\uDC4D\uD83D\uDC4D
```
Thanks for visiting my solution.\uD83D\uDE0A Keep Learning
Please give my solution an upvote! \uD83D\uDC4D
It\'s a simple way to show your appreciation and
keep me motivated. Thank you! \uD83D\uDE0A
```

# Code
```java []
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>(); // create an empty stack
        for (char c : s.toCharArray()) { // loop through each character in the string
            if (c == \'(\') // if the character is an opening parenthesis
                stack.push(\')\'); // push the corresponding closing parenthesis onto the stack
            else if (c == \'{\') // if the character is an opening brace
                stack.push(\'}\'); // push the corresponding closing brace onto the stack
            else if (c == \'[\') // if the character is an opening bracket
                stack.push(\']\'); // push the corresponding closing bracket onto the stack
            else if (stack.isEmpty() || stack.pop() != c) // if the character is a closing bracket
                // if the stack is empty (i.e., there is no matching opening bracket) or the top of the stack
                // does not match the closing bracket, the string is not valid, so return false
                return false;
        }
        // if the stack is empty, all opening brackets have been matched with their corresponding closing brackets,
        // so the string is valid, otherwise, there are unmatched opening brackets, so return false
        return stack.isEmpty();
    }
}

```
```java []
class Solution {
    public boolean isValid(String s) {
        // Create an empty stack to keep track of opening brackets
        Stack<Character> stack = new Stack<Character>();
        
        // Loop through every character in the string
        for (char c : s.toCharArray()) {
            // If the character is an opening bracket, push it onto the stack
            if (c == \'(\' || c == \'[\' || c == \'{\') {
                stack.push(c);
            } else { // If the character is a closing bracket
                // If the stack is empty, there is no matching opening bracket, so return false
                if (stack.isEmpty()) {
                    return false;
                }
                // Otherwise, get the top of the stack and check if it\'s the matching opening bracket
                char top = stack.peek();
                if ((c == \')\' && top == \'(\') || (c == \']\' && top == \'[\') || (c == \'}\' && top == \'{\')) {
                    // If it is, pop the opening bracket from the stack
                    stack.pop();
                } else { // Otherwise, the brackets don\'t match, so return false
                    return false;
                }
            }
        }
        // If the stack is empty, all opening brackets have been closed, so return true
        // Otherwise, there are unmatched opening brackets, so return false
        return stack.isEmpty();
    }
}

```
```python []
class Solution(object):
    def isValid(self, s):
        stack = [] # create an empty stack to store opening brackets
        for c in s: # loop through each character in the string
            if c in \'([{\': # if the character is an opening bracket
                stack.append(c) # push it onto the stack
            else: # if the character is a closing bracket
                if not stack or \\
                    (c == \')\' and stack[-1] != \'(\') or \\
                    (c == \'}\' and stack[-1] != \'{\') or \\
                    (c == \']\' and stack[-1] != \'[\'):
                    return False # the string is not valid, so return false
                stack.pop() # otherwise, pop the opening bracket from the stack
        return not stack # if the stack is empty, all opening brackets have been matched with their corresponding closing brackets,
                         # so the string is valid, otherwise, there are unmatched opening brackets, so return false
```
```c++ []
class Solution {
public:
    bool isValid(string s) {
        stack<char> st; // create an empty stack to store opening brackets
        for (char c : s) { // loop through each character in the string
            if (c == \'(\' || c == \'{\' || c == \'[\') { // if the character is an opening bracket
                st.push(c); // push it onto the stack
            } else { // if the character is a closing bracket
                if (st.empty() || // if the stack is empty or 
                    (c == \')\' && st.top() != \'(\') || // the closing bracket doesn\'t match the corresponding opening bracket at the top of the stack
                    (c == \'}\' && st.top() != \'{\') ||
                    (c == \']\' && st.top() != \'[\')) {
                    return false; // the string is not valid, so return false
                }
                st.pop(); // otherwise, pop the opening bracket from the stack
            }
        }
        return st.empty(); // if the stack is empty, all opening brackets have been matched with their corresponding closing brackets,
                           // so the string is valid, otherwise, there are unmatched opening brackets, so return false
    }
};
```

```javascript []
/**
 * @param {string} s
 * @return {boolean}
 */
var isValid = function(s) {
    let stack = []; // create an empty stack to store opening brackets
    for (let c of s) { // loop through each character in the string
        if (c === \'(\' || c === \'{\' || c === \'[\') { // if the character is an opening bracket
            stack.push(c); // push it onto the stack
        } else { // if the character is a closing bracket
            if (!stack.length || // if the stack is empty or 
                (c === \')\' && stack[stack.length - 1] !== \'(\') || // the closing bracket doesn\'t match the corresponding opening bracket at the top of the stack
                (c === \'}\' && stack[stack.length - 1] !== \'{\') ||
                (c === \']\' && stack[stack.length - 1] !== \'[\')) {
                return false; // the string is not valid, so return false
            }
            stack.pop(); // otherwise, pop the opening bracket from the stack
        }
    }
    return !stack.length; // if the stack is empty, all opening brackets have been matched with their corresponding closing brackets,
                          // so the string is valid, otherwise, there are unmatched opening brackets, so return false
};

```
# JAVA solution without using stack
```Java []
public class Solution {
    public static boolean isValid(String s) {
        while (true) {
            if (s.contains("()")) {
                s = s.replace("()", "");
            } else if (s.contains("{}")) {
                s = s.replace("{}", "");
            } else if (s.contains("[]")) {
                s = s.replace("[]", "");
            } else {
                // If the string becomes empty, it indicates all brackets are matched.
                return s.isEmpty();
            }
        }
    }
}

```
### Please Comment\uD83D\uDC4D\uD83D\uDC4D
Thanks for visiting my solution. Comment below if you like it.\uD83D\uDE0A  

[![LinkedIn](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/vikas-pathak-8499451b0) **Connect on LinkedIn**  
[![Instagram](https://img.shields.io/badge/Instagram-E4405F?style=for-the-badge&logo=instagram&logoColor=white)](https://www.instagram.com/vikas123.vp79/) **Follow on Instagram**  
[![GitHub](https://img.shields.io/badge/GitHub-181717?style=for-the-badge&logo=github&logoColor=white)](https://github.com/Vikas-Pathak-123) **Check out my GitHub**

```

</details>
