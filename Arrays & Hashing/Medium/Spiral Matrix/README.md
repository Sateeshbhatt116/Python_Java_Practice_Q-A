# Spiral Matrix

| Field | Value |
|-------|-------|
| **Platform** | LeetCode |
| **Difficulty** | Medium |
| **Language** | java |
| **Solved On** | August 21, 2026 |
| **Tags** | Array, Matrix, Simulation |
| **Link** | [View Problem](https://leetcode.com/problems/spiral-matrix/) |
| **Runtime** | 0 ms |
| **Memory** | 42.8 MB |

## Approach

Approach:

Traverse the matrix layer by layer in spiral order.

1. Use four boundaries:
   - top → first row
   - bottom → last row
   - left → first column
   - right → last column

2. Traverse from left to right along the top row, then increase top.

3. Traverse from top to bottom along the right column, then decrease right.

4. Traverse from right to left along the bottom row, then decrease bottom.

5. Traverse from bottom to top along the left column, then increase left.

6. Repeat until all elements are visited.

Time Complexity: O(m × n)
Space Complexity: O(1) excluding the output list.

## Problem Description

<p>Given an <code>m x n</code> <code>matrix</code>, return <em>all elements of the</em> <code>matrix</code> <em>in spiral order</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/11/13/spiral1.jpg" style="width: 242px; height: 242px;">
<pre><strong>Input:</strong> matrix = [[1,2,3],[4,5,6],[7,8,9]]
<strong>Output:</strong> [1,2,3,6,9,8,7,4,5]
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/11/13/spiral.jpg" style="width: 322px; height: 242px;">
<pre><strong>Input:</strong> matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
<strong>Output:</strong> [1,2,3,4,8,12,11,10,9,5,6,7]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>m == matrix.length</code></li>
	<li><code>n == matrix[i].length</code></li>
	<li><code>1 &lt;= m, n &lt;= 10</code></li>
	<li><code>-100 &lt;= matrix[i][j] &lt;= 100</code></li>
</ul>


##  Top Community Optimal Approach

<details>
<summary>Click to expand</summary>

**Title**: Super Simple and Easy to Understand Solution
**Author**: [@qwl5004](https://leetcode.com/qwl5004/)
**Upvotes**: 1542 👍
**Link**: [View Original Post](https://leetcode.com/problems/spiral-matrix/solutions/20599/)

---

This is a very simple and easy to understand solution. I traverse right and increment rowBegin, then traverse down and decrement colEnd, then I traverse left and decrement rowEnd, and finally I traverse up and increment colBegin.

The only tricky part is that when I traverse left or up I have to check whether the row or col still exists to prevent duplicates. If anyone can do the same thing without that check, please let me know!

Any comments greatly appreciated.

    public class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            
            List<Integer> res = new ArrayList<Integer>();
            
            if (matrix.length == 0) {
                return res;
            }
            
            int rowBegin = 0;
            int rowEnd = matrix.length-1;
            int colBegin = 0;
            int colEnd = matrix[0].length - 1;
            
            while (rowBegin <= rowEnd && colBegin <= colEnd) {
                // Traverse Right
                for (int j = colBegin; j <= colEnd; j ++) {
                    res.add(matrix[rowBegin][j]);
                }
                rowBegin++;
                
                // Traverse Down
                for (int j = rowBegin; j <= rowEnd; j ++) {
                    res.add(matrix[j][colEnd]);
                }
                colEnd--;
                
                if (rowBegin <= rowEnd) {
                    // Traverse Left
                    for (int j = colEnd; j >= colBegin; j --) {
                        res.add(matrix[rowEnd][j]);
                    }
                }
                rowEnd--;
                
                if (colBegin <= colEnd) {
                    // Traver Up
                    for (int j = rowEnd; j >= rowBegin; j --) {
                        res.add(matrix[j][colBegin]);
                    }
                }
                colBegin ++;
            }
            
            return res;
        }
    }

</details>
