# Number of Sets of K Non-Overlapping Line Segments

| Field | Value |
|-------|-------|
| **Platform** | LeetCode |
| **Difficulty** | Medium |
| **Language** | java |
| **Solved On** | September 16, 2026 |
| **Tags** | Math, Dynamic Programming, Combinatorics, Prefix Sum |
| **Link** | [View Problem](https://leetcode.com/problems/number-of-sets-of-k-non-overlapping-line-segments/) |
| **Runtime** | 36 ms |
| **Memory** | 93.4 MB |

## Problem Description

<p>Given <code>n</code> points on a 1-D plane, where the <code>i<sup>th</sup></code> point (from <code>0</code> to <code>n-1</code>) is at <code>x = i</code>, find the number of ways we can draw <strong>exactly</strong> <code>k</code> <strong>non-overlapping</strong> line segments such that each segment covers two or more points. The endpoints of each segment must have <strong>integral coordinates</strong>. The <code>k</code> line segments <strong>do not</strong> have to cover all <code>n</code> points, and they are <strong>allowed</strong> to share endpoints.</p>

<p>Return <em>the number of ways we can draw </em><code>k</code><em> non-overlapping line segments</em><em>.</em> Since this number can be huge, return it <strong>modulo</strong> <code>10<sup>9</sup> + 7</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/09/07/ex1.png" style="width: 179px; height: 222px;">
<pre><strong>Input:</strong> n = 4, k = 2
<strong>Output:</strong> 5
<strong>Explanation:</strong> The two line segments are shown in red and blue.
The image above shows the 5 different ways {(0,2),(2,3)}, {(0,1),(1,3)}, {(0,1),(2,3)}, {(1,2),(2,3)}, {(0,1),(1,2)}.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> n = 3, k = 1
<strong>Output:</strong> 3
<strong>Explanation:</strong> The 3 ways are {(0,1)}, {(0,2)}, {(1,2)}.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> n = 30, k = 7
<strong>Output:</strong> 796297179
<strong>Explanation:</strong> The total number of possible ways to draw 7 line segments is 3796297200. Taking this number modulo 10<sup>9</sup> + 7 gives us 796297179.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>2 &lt;= n &lt;= 1000</code></li>
	<li><code>1 &lt;= k &lt;= n-1</code></li>
</ul>


##  Top Community Optimal Approach

<details>
<summary>Click to expand</summary>

**Title**: [Java/Python] Top Down DP - Clean & Concise - O(4*n*k)
**Author**: [@hiepit](https://leetcode.com/hiepit/)
**Upvotes**: 87 👍
**Link**: [View Original Post](https://leetcode.com/problems/number-of-sets-of-k-non-overlapping-line-segments/solutions/901894/)

---

**Python 3**
```python
class Solution:
    def numberOfSets(self, n: int, k: int) -> int:
        MOD = 10**9 + 7
        @lru_cache(None)
        def dp(i, k, isStart):
            if k == 0: return 1 # Found a way to draw k valid segments
            if i == n: return 0 # Reach end of points
            ans = dp(i+1, k, isStart) # Skip ith point
            if isStart:
                ans += dp(i+1, k, False) # Take ith point as start
            else:
                ans += dp(i, k-1, True) # Take ith point as end
            return ans % MOD
        return dp(0, k, True)
```

**Java**
```java
class Solution {
    Integer[][][] memo;
    int n;
    public int numberOfSets(int n, int k) {
        this.n = n;
        this.memo = new Integer[n+1][k+1][2];
        return dp(0, k, 1);
    }
    int dp(int i, int k, int isStart) {
        if (memo[i][k][isStart] != null) return memo[i][k][isStart];
        if (k == 0) return 1; // Found a way to draw k valid segments
        if (i == n) return 0; // Reach end of points

        int ans = dp(i+1, k, isStart); // Skip ith point
        if (isStart == 1)
            ans += dp(i+1, k, 0); // Take ith point as start
        else
            ans += dp(i, k-1, 1); // Take ith point as end

        return memo[i][k][isStart] = ans % 1_000_000_007;
    }
}
```

**Complexity:**
- Time: `O(4*n*k)`, there are total `2*n*k` state in `dp(i, k, isStart)` functions, inside function there are at most twice call of `dp` function.
- Space: `O(2*n*k)`

Feel free to ask your quetions. If this post is helpful, please help to give it a **vote**!.
Happy coding!

</details>
