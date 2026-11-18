# Minimum Number of Changes to Make Binary String Beautiful

| Field | Value |
|-------|-------|
| **Platform** | LeetCode |
| **Difficulty** | Medium |
| **Language** | java |
| **Solved On** | November 18, 2026 |
| **Tags** | String |
| **Link** | [View Problem](https://leetcode.com/problems/minimum-number-of-changes-to-make-binary-string-beautiful/) |
| **Runtime** | 3 ms |
| **Memory** | 45.8 MB |

## Problem Description

<p>You are given a <strong>0-indexed</strong> binary string <code>s</code> having an even length.</p>

<p>A string is <strong>beautiful</strong> if it's possible to partition it into one or more substrings such that:</p>

<ul>
	<li>Each substring has an <strong>even length</strong>.</li>
	<li>Each substring contains <strong>only</strong> <code>1</code>'s or <strong>only</strong> <code>0</code>'s.</li>
</ul>

<p>You can change any character in <code>s</code> to <code>0</code> or <code>1</code>.</p>

<p>Return <em>the <strong>minimum</strong> number of changes required to make the string </em><code>s</code> <em>beautiful</em>.</p>

<p>&nbsp;</p>
<p><span class="float-right -my-0.5 ml-2 inline-flex select-none items-center" data-example-lang-controls=""><span role="group" class="inline-flex h-6 items-center rounded-sd-md bg-sd-muted p-0.5" data-example-lang-toggle=""><button type="button" aria-pressed="true" class="h-5 max-w-[10rem] truncate whitespace-nowrap rounded-sd-sm border px-2 text-xs font-normal leading-none border-sd-border bg-sd-background text-sd-foreground">Original</button><button type="button" aria-pressed="false" class="h-5 max-w-[10rem] truncate whitespace-nowrap rounded-sd-sm border px-2 text-xs font-normal leading-none border-transparent text-sd-muted-foreground hover:text-sd-foreground">Java</button></span></span><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> s = "1001"
<strong>Output:</strong> 2
<strong>Explanation:</strong> We change s[1] to 1 and s[3] to 0 to get string "1100".
It can be seen that the string "1100" is beautiful because we can partition it into "11|00".
It can be proven that 2 is the minimum number of changes needed to make the string beautiful.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> s = "10"
<strong>Output:</strong> 1
<strong>Explanation:</strong> We change s[1] to 1 to get string "11".
It can be seen that the string "11" is beautiful because we can partition it into "11".
It can be proven that 1 is the minimum number of changes needed to make the string beautiful.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> s = "0000"
<strong>Output:</strong> 0
<strong>Explanation:</strong> We don't need to make any changes as the string "0000" is beautiful already.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>2 &lt;= s.length &lt;= 10<sup>5</sup></code></li>
	<li><code>s</code> has an even length.</li>
	<li><code>s[i]</code> is either <code>'0'</code> or <code>'1'</code>.</li>
</ul>


##  Top Community Optimal Approach

<details>
<summary>Click to expand</summary>

**Title**: 🌟 Beats 100.00% 👏 || For loop || Explained with example
**Author**: [@Srinivas_Bodduru](https://leetcode.com/Srinivas_Bodduru/)
**Upvotes**: 86 👍
**Link**: [View Original Post](https://leetcode.com/problems/minimum-number-of-changes-to-make-binary-string-beautiful/solutions/6008345/)

---

![image.png](https://assets.leetcode.com/users/images/f35249c0-b082-4f1e-b08c-1bb6c16d4644_1730765254.7264168.png)

# Intuition
<!-- Describe your first thoughts on how to solve this problem. -->
The problem requires us to count the number of changes needed to make adjacent pairs in the string identical. This means for each pair (s[i], s[i + 1]), we check if they are the same. If they are not, it counts as one required change to make them identical.

The goal is to minimize the number of changes needed to make all these pairs identical, so we simply count how many pairs have different characters and return this count.
# Approach
<!-- Describe your approach to solving the problem. -->
Initialize a counter: Set up a variable count to track the number of pairs that need changes.
Iterate through the string in steps of 2: Start a loop at index 0 and increment by 2 each time, so we examine pairs (s[i], s[i+1]).
Note: We stop at len(s) - 1 because s[i + 1] needs to exist as the second character in the pair.
Check if characters in the pair are different:
If s[i] != s[i + 1], increase count by 1 because it represents a change needed.
Return the result: After finishing the loop, return count, which gives the minimum number of changes required to make all pairs identical.

# Complexity
- Time complexity:O(N)
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity:O(1)
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

# Code
```javascript []

var minChanges = function (s) {
    let count = 0
    for (let i = 0; i < s.length; i = i + 2) {
        if (s[i] != s[i + 1]) count++
    }
    return count
};
```
```python []
def min_changes(s):
    count = 0
    i = 0
    while i < len(s) - 1:
        if s[i] != s[i + 1]:
            count += 1
        i += 2
    return count

```
```java []
public class Solution {
    public int minChanges(String s) {
        int count = 0;
        for (int i = 0; i < s.length() - 1; i += 2) {
            if (s.charAt(i) != s.charAt(i + 1)) {
                count++;
            }
        }
        return count;
    }
}

```
```c []
#include <string.h>

int minChanges(char* s) {
    int count = 0;
    for (int i = 0; i < strlen(s) - 1; i += 2) {
        if (s[i] != s[i + 1]) {
            count++;
        }
    }
    return count;
}

```
```c++ []
class Solution {
public:
    int minChanges(const std::string& s) {
    int count = 0;
    for (int i = 0; i < s.size() - 1; i += 2) {
        if (s[i] != s[i + 1]) {
            count++;
        }
    }
    return count;
}
};
#include <string>



```

</details>
