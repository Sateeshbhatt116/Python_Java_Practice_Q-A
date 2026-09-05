# Length of Last Word

| Field | Value |
|-------|-------|
| **Platform** | LeetCode |
| **Difficulty** | Easy |
| **Language** | java |
| **Solved On** | September 5, 2026 |
| **Tags** | String |
| **Link** | [View Problem](https://leetcode.com/problems/length-of-last-word/) |
| **Runtime** | 0 ms |
| **Memory** | 43.1 MB |

## Problem Description

<p>Given a string <code>s</code> consisting of words and spaces, return <em>the length of the <strong>last</strong> word in the string.</em></p>

<p>A <strong>word</strong> is a maximal <span data-keyword="substring-nonempty" class=" cursor-pointer relative text-dark-blue-s text-sm"><button type="button" aria-haspopup="dialog" aria-expanded="false" aria-controls="radix-_r_t_" data-state="closed" class="">substring</button></span> consisting of non-space characters only.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> s = "Hello World"
<strong>Output:</strong> 5
<strong>Explanation:</strong> The last word is "World" with length 5.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> s = "   fly me   to   the moon  "
<strong>Output:</strong> 4
<strong>Explanation:</strong> The last word is "moon" with length 4.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> s = "luffy is still joyboy"
<strong>Output:</strong> 6
<strong>Explanation:</strong> The last word is "joyboy" with length 6.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 10<sup>4</sup></code></li>
	<li><code>s</code> consists of only English letters and spaces <code>' '</code>.</li>
	<li>There will be at least one word in <code>s</code>.</li>
</ul>


##  Top Community Optimal Approach

<details>
<summary>Click to expand</summary>

**Title**: Java 0ms | 100% | 100% Single Reverse loop with explanation
**Author**: [@Tochyao](https://leetcode.com/Tochyao/)
**Upvotes**: 342 👍
**Link**: [View Original Post](https://leetcode.com/problems/length-of-last-word/solutions/370636/)

---

``` Java
class Solution {
    public int lengthOfLastWord(String s) {
        int length = 0;
		
		// We are looking for the last word so let\'s go backward
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != \' \') { // a letter is found so count
                length++;
            } else {  // it\'s a white space instead
				//  Did we already started to count a word ? Yes so we found the last word
                if (length > 0) return length;
            }
        }
        return length;
    }
}
```

</details>
