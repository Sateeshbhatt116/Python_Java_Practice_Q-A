# Longest Valid Parentheses

| Field | Value |
|-------|-------|
| **Platform** | LeetCode |
| **Difficulty** | Hard |
| **Language** | java |
| **Solved On** | October 4, 2026 |
| **Tags** | String, Dynamic Programming, Stack, Bracket Sequences |
| **Link** | [View Problem](https://leetcode.com/problems/longest-valid-parentheses/) |
| **Runtime** | 5 ms |
| **Memory** | 46.4 MB |

## Problem Description

<p>Given a string containing just the characters <code>'('</code> and <code>')'</code>, return <em>the length of the longest valid (well-formed) parentheses </em><span data-keyword="substring-nonempty" class=" cursor-pointer relative text-dark-blue-s text-sm"><button type="button" aria-haspopup="dialog" aria-expanded="false" aria-controls="radix-_r_t_" data-state="closed" class=""><em>substring</em></button></span>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> s = "(()"
<strong>Output:</strong> 2
<strong>Explanation:</strong> The longest valid parentheses substring is "()".
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> s = ")()())"
<strong>Output:</strong> 4
<strong>Explanation:</strong> The longest valid parentheses substring is "()()".
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> s = ""
<strong>Output:</strong> 0
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>0 &lt;= s.length &lt;= 3 * 10<sup>4</sup></code></li>
	<li><code>s[i]</code> is <code>'('</code>, or <code>')'</code>.</li>
</ul>


##  Top Community Optimal Approach

<details>
<summary>Click to expand</summary>

**Title**: Simple JAVA solution, O(n) time, one stack
**Author**: [@nmjnmjnmj](https://leetcode.com/nmjnmjnmj/)
**Upvotes**: 234 👍
**Link**: [View Original Post](https://leetcode.com/problems/longest-valid-parentheses/solutions/14167/)

---

```
public class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int max=0;
        int left = -1;
        for(int j=0;j<s.length();j++){
            if(s.charAt(j)=='(') stack.push(j);            
            else {
                if (stack.isEmpty()) left=j;
                else{
                    stack.pop();
                    if(stack.isEmpty()) max=Math.max(max,j-left);
                    else max=Math.max(max,j-stack.peek());
                }
            }
        }
        return max;
    }
}
```

</details>
