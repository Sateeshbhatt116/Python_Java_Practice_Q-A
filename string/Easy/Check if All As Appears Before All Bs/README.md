# Check if All A's Appears Before All B's

| Field | Value |
|-------|-------|
| **Platform** | LeetCode |
| **Difficulty** | Easy |
| **Language** | java |
| **Solved On** | November 25, 2026 |
| **Tags** | String |
| **Link** | [View Problem](https://leetcode.com/problems/check-if-all-as-appears-before-all-bs/) |
| **Runtime** | 1 ms |
| **Memory** | 41.7 MB |

## Problem Description

<p>Given a string <code>s</code> consisting of <strong>only</strong> the characters <code>'a'</code> and <code>'b'</code>, return <code>true</code> <em>if <strong>every</strong> </em><code>'a'</code> <em>appears before <strong>every</strong> </em><code>'b'</code><em> in the string</em>. Otherwise, return <code>false</code>.</p>

<p>&nbsp;</p>
<p><span class="float-right -my-0.5 ml-2 inline-flex select-none items-center" data-example-lang-controls=""><span role="group" class="inline-flex h-6 items-center rounded-sd-md bg-sd-muted p-0.5" data-example-lang-toggle=""><button type="button" aria-pressed="true" class="h-5 max-w-[10rem] truncate whitespace-nowrap rounded-sd-sm border px-2 text-xs font-normal leading-none border-sd-border bg-sd-background text-sd-foreground">Original</button><button type="button" aria-pressed="false" class="h-5 max-w-[10rem] truncate whitespace-nowrap rounded-sd-sm border px-2 text-xs font-normal leading-none border-transparent text-sd-muted-foreground hover:text-sd-foreground">Java</button></span></span><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> s = "aaabbb"
<strong>Output:</strong> true
<strong>Explanation:</strong>
The 'a's are at indices 0, 1, and 2, while the 'b's are at indices 3, 4, and 5.
Hence, every 'a' appears before every 'b' and we return true.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> s = "abab"
<strong>Output:</strong> false
<strong>Explanation:</strong>
There is an 'a' at index 2 and a 'b' at index 1.
Hence, not every 'a' appears before every 'b' and we return false.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> s = "bbb"
<strong>Output:</strong> true
<strong>Explanation:</strong>
There are no 'a's, hence, every 'a' appears before every 'b' and we return true.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 100</code></li>
	<li><code>s[i]</code> is either <code>'a'</code> or <code>'b'</code>.</li>
</ul>


##  Top Community Optimal Approach

<details>
<summary>Click to expand</summary>

**Title**: [Java/Python 3] Check if 'b' followed by 'a'.
**Author**: [@rock](https://leetcode.com/rock/)
**Upvotes**: 44 👍
**Link**: [View Original Post](https://leetcode.com/problems/check-if-all-as-appears-before-all-bs/solutions/1660987/)

---

**Method 1**

```java
    public boolean checkString(String s) {
        for (int i = 1; i < s.length(); ++i) {
            if (s.charAt(i - 1) == \'b\' && s.charAt(i) == \'a\') {
                return false;
            }
        }
        return true;
    }
```
```python
    def checkString(self, s: str) -> bool:
        for i, c in enumerate(s):
            if i > 0 and s[i - 1] == \'b\' and c == \'a\':
                return False
        return True
```

----

**Method 2:**

```java
    public boolean checkString(String s) {
        return !s.contains("ba");
    }
```
```python
    def checkString(self, s: str) -> bool:
        return \'ba\' not in s
```
**Analysis**

Time: `O(n)`, space: `O(1)`, where `n = s.length()`.

</details>
