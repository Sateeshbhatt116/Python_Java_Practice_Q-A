# Spiral Matrix II

| Field | Value |
|-------|-------|
| **Platform** | LeetCode |
| **Difficulty** | Medium |
| **Language** | java |
| **Solved On** | September 5, 2026 |
| **Tags** | Array, Matrix, Simulation |
| **Link** | [View Problem](https://leetcode.com/problems/spiral-matrix-ii/) |
| **Runtime** | 0 ms |
| **Memory** | 42.7 MB |

## Problem Description

<p>Given a positive integer <code>n</code>, generate an <code>n x n</code> <code>matrix</code> filled with elements from <code>1</code> to <code>n<sup>2</sup></code> in spiral order.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/11/13/spiraln.jpg" style="width: 242px; height: 242px;">
<pre><strong>Input:</strong> n = 3
<strong>Output:</strong> [[1,2,3],[8,9,4],[7,6,5]]
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> n = 1
<strong>Output:</strong> [[1]]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= n &lt;= 20</code></li>
</ul>


##  Top Community Optimal Approach

<details>
<summary>Click to expand</summary>

**Title**: My Super Simple Solution. Can be used for both Spiral Matrix I and II
**Author**: [@qwl5004](https://leetcode.com/qwl5004/)
**Upvotes**: 355 👍
**Link**: [View Original Post](https://leetcode.com/problems/spiral-matrix-ii/solutions/22289/)

---

This is my solution for Spiral Matrix I, [https://oj.leetcode.com/discuss/12228/super-simple-and-easy-to-understand-solution][1]. If you can understand that, this one is a no brainer :)

Guess what? I just made several lines of change (with comment "//change") from that and I have the following AC code:

    public class Solution {
        public int[][] generateMatrix(int n) {
            // Declaration
            int[][] matrix = new int[n][n];
            
            // Edge Case
            if (n == 0) {
                return matrix;
            }
            
            // Normal Case
            int rowStart = 0;
            int rowEnd = n-1;
            int colStart = 0;
            int colEnd = n-1;
            int num = 1; //change
            
            while (rowStart <= rowEnd && colStart <= colEnd) {
                for (int i = colStart; i <= colEnd; i ++) {
                    matrix[rowStart][i] = num ++; //change
                }
                rowStart ++;
                
                for (int i = rowStart; i <= rowEnd; i ++) {
                    matrix[i][colEnd] = num ++; //change
                }
                colEnd --;
                
                for (int i = colEnd; i >= colStart; i --) {
                    if (rowStart <= rowEnd)
                        matrix[rowEnd][i] = num ++; //change
                }
                rowEnd --;
                
                for (int i = rowEnd; i >= rowStart; i --) {
                    if (colStart <= colEnd)
                        matrix[i][colStart] = num ++; //change
                }
                colStart ++;
            }
            
            return matrix;
        }
    }

Obviously, you could merge colStart and colEnd into rowStart and rowEnd because it is a square matrix. But this is easily extensible to matrices that are m*n.

Hope this helps :)


  [1]: https://oj.leetcode.com/discuss/12228/super-simple-and-easy-to-understand-solution

</details>
