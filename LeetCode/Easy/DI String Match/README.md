# DI String Match

| Field | Value |
|-------|-------|
| **Platform** | LeetCode |
| **Difficulty** | Easy |
| **Language** | java |
| **Solved On** | September 11, 2026 |
| **Tags** | Array, Two Pointers, String, Greedy |
| **Link** | [View Problem](https://leetcode.com/problems/di-string-match/) |
| **Runtime** | 2 ms |
| **Memory** | 47.1 MB |

## Problem Description

<p>A permutation <code>perm</code> of <code>n + 1</code> integers of all the integers in the range <code>[0, n]</code> can be represented as a string <code>s</code> of length <code>n</code> where:</p>

<ul>
	<li><code>s[i] == 'I'</code> if <code>perm[i] &lt; perm[i + 1]</code>, and</li>
	<li><code>s[i] == 'D'</code> if <code>perm[i] &gt; perm[i + 1]</code>.</li>
</ul>

<p>Given a string <code>s</code>, reconstruct the permutation <code>perm</code> and return it. If there are multiple valid permutations perm, return <strong>any of them</strong>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<pre><strong>Input:</strong> s = "IDID"
<strong>Output:</strong> [0,4,1,3,2]
</pre><p><strong class="example">Example 2:</strong></p>
<pre><strong>Input:</strong> s = "III"
<strong>Output:</strong> [0,1,2,3]
</pre><p><strong class="example">Example 3:</strong></p>
<pre><strong>Input:</strong> s = "DDI"
<strong>Output:</strong> [3,2,0,1]
</pre>
<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 10<sup>5</sup></code></li>
	<li><code>s[i]</code> is either <code>'I'</code> or <code>'D'</code>.</li>
</ul>


##  Top Community Optimal Approach

<details>
<summary>Click to expand</summary>

**Title**: Easy to Understand Java Code || Beats 100%
**Author**: [@Saurabh_Mishra06](https://leetcode.com/Saurabh_Mishra06/)
**Upvotes**: 5 👍
**Link**: [View Original Post](https://leetcode.com/problems/di-string-match/solutions/4729875/)

---

# Complexity
- Time complexity:
O(n)
- Space complexity:
O(1)
# Code
```
class Solution {
    public int[] diStringMatch(String s) {
        int n = s.length();
        int low = 0;
        int high = n;

        int[] arr = new int[n+1];

        for(int i=0; i<n; i++){
            if(s.charAt(i) == \'I\'){
                arr[i] = low++;
            }else {
                arr[i] = high--;
            }
        }
        arr[n] = high;
        return arr;
    }
}
```

</details>
