# Count Negative Numbers in a Sorted Matrix

| Field | Value |
|-------|-------|
| **Platform** | LeetCode |
| **Difficulty** | Easy |
| **Language** | java |
| **Solved On** | August 21, 2026 |
| **Tags** | Array, Binary Search, Matrix |
| **Link** | [View Problem](https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/) |
| **Runtime** | 0 ms |
| **Memory** | 42.3 MB |

## Approach

Traverse the matrix using two nested loops.
For every element, check if it is less than 0.
If it is negative, increment count.
Return the final count.

Complexity:

Time: O(m × n)
Space: O(1)

## Problem Description

<p>Given a <code>m x n</code> matrix <code>grid</code> which is sorted in non-increasing order both row-wise and column-wise, return <em>the number of <strong>negative</strong> numbers in</em> <code>grid</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
<strong>Output:</strong> 8
<strong>Explanation:</strong> There are 8 negatives number in the matrix.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> grid = [[3,2],[1,0]]
<strong>Output:</strong> 0
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>m == grid.length</code></li>
	<li><code>n == grid[i].length</code></li>
	<li><code>1 &lt;= m, n &lt;= 100</code></li>
	<li><code>-100 &lt;= grid[i][j] &lt;= 100</code></li>
</ul>

<p>&nbsp;</p>
<strong>Follow up:</strong> Could you find an <code>O(n + m)</code> solution?

##  Top Community Optimal Approach

<details>
<summary>Click to expand</summary>

**Title**: Java, binary search, beats 100%, explained
**Author**: [@gthor10](https://leetcode.com/gthor10/)
**Upvotes**: 185 👍
**Link**: [View Original Post](https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/solutions/512165/)

---

This problem can be solved with a binary search. 

For every row do the binary search to find exact position of the fist negative element, after that all elements are negative.  Optimization here - for every next row the right limit for the binary search can be the index of the first negative from the previous row. This is due to fact that cols are also sorted so for the same column for every negative element the element below can be only negative. Thus we can explude it from the binary search on the next step.

Also taking care of the edge cases helps - if first element is < 0 then all elements in a row are negative, if last one is non-negative then all elements are non-negative.

O(rows x lg(cols)) time - need to do lg(cols) binary search for each of rows row, O(1) space - no extrace space other than few variables.

```
    public int countNegatives(int[][] grid) {
        int rows = grid.length, cols = grid[0].length; 
        int res = 0, lastNeg = cols - 1;
        for (int row = 0; row < rows; row++) {
            //check edge cases - if first element is < 0 - all elements in row are negative
            if (grid[row][0] < 0) {
                res+=cols;
                continue;
            }
            //if last element is positive - it means there are no negative numbers in a row
            if (grid[row][cols - 1] > 0)
                continue;
            //there is a mix of negative and positive ones, need to find the border. starting
            //binary search
            int l = 0, r = lastNeg;
            while (l <= r) {
                int m = l + (r - l)/2;
                if (grid[row][m] < 0) {
                    r = m - 1;
                } else
                    l = m + 1;
            }
            //l points to the first negative element, which means cols - l is a number of
            //such elements
            res += (cols - l); lastNeg = l;
        }
        return res;
    }
```

</details>
