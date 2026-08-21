# Shift 2D Grid

| Field | Value |
|-------|-------|
| **Platform** | LeetCode |
| **Difficulty** | Easy |
| **Language** | java |
| **Solved On** | August 21, 2026 |
| **Tags** | Array, Matrix, Simulation |
| **Link** | [View Problem](https://leetcode.com/problems/shift-2d-grid/) |
| **Runtime** | 0 ms |
| **Memory** | 42.6 MB |

## Approach

1. Find the number of rows and columns in the grid.

2. Perform the shifting operation k times.

3. For each shift:
   - Store the last element of the grid because it will move to the first position.
   - Traverse the grid from bottom-right to top-left.
   - If the current element is in the first column, take the last element
     from the previous row.
   - Otherwise, take the element from the left.
   - Finally, place the stored last element at grid[0][0].

4. After completing all k shifts, convert the 2D array into
   List<List<Integer>>.

5. Return the resulting list.

Time Complexity: O(k × rows × cols)
Space Complexity: O(rows × cols)

## Problem Description

<p>Given a 2D <code>grid</code> of size <code>m x n</code>&nbsp;and an integer <code>k</code>. You need to shift the <code>grid</code>&nbsp;<code>k</code> times.</p>

<p>In one shift operation:</p>

<ul>
	<li>Element at <code>grid[i][j]</code> moves to <code>grid[i][j + 1]</code>.</li>
	<li>Element at <code>grid[i][n - 1]</code> moves to <code>grid[i + 1][0]</code>.</li>
	<li>Element at <code>grid[m&nbsp;- 1][n - 1]</code> moves to <code>grid[0][0]</code>.</li>
</ul>

<p>Return the <em>2D grid</em> after applying shift operation <code>k</code> times.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2019/11/05/e1.png" style="width: 400px; height: 178px;">
<pre><strong>Input:</strong> <code>grid</code> = [[1,2,3],[4,5,6],[7,8,9]], k = 1
<strong>Output:</strong> [[9,1,2],[3,4,5],[6,7,8]]
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2019/11/05/e2.png" style="width: 400px; height: 166px;">
<pre><strong>Input:</strong> <code>grid</code> = [[3,8,1,9],[19,7,2,5],[4,6,11,10],[12,0,21,13]], k = 4
<strong>Output:</strong> [[12,0,21,13],[3,8,1,9],[19,7,2,5],[4,6,11,10]]
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> <code>grid</code> = [[1,2,3],[4,5,6],[7,8,9]], k = 9
<strong>Output:</strong> [[1,2,3],[4,5,6],[7,8,9]]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>m ==&nbsp;grid.length</code></li>
	<li><code>n ==&nbsp;grid[i].length</code></li>
	<li><code>1 &lt;= m &lt;= 50</code></li>
	<li><code>1 &lt;= n &lt;= 50</code></li>
	<li><code>-1000 &lt;= grid[i][j] &lt;= 1000</code></li>
	<li><code>0 &lt;= k &lt;= 100</code></li>
</ul>


##  Top Community Optimal Approach

<details>
<summary>Click to expand</summary>

**Title**: Easy Java Code With Explanation(❁´◡`❁)
**Author**: [@hi-ravi](https://leetcode.com/hi-ravi/)
**Upvotes**: 55 👍
**Link**: [View Original Post](https://leetcode.com/problems/shift-2d-grid/solutions/1934848/)

---


```
class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> result = new ArrayList();
        int rows = grid.length, col = grid[0].length;

        for (int r = 0; r < rows; r++)// filling all the rows of result with empty lists
            result.add(new ArrayList());
        k %= (rows * col);// every rows*col shifts grid became the same, skipping the similar shifts
        int dimension = rows * col;
        int begin = dimension - k;// element at (begin) will be at 0,0 in new grid
        int x = 0;// counter variable
        for (int i = begin; i < begin + dimension; i++) {
            int r = (i / col) % rows, c = i % col;// calculating row and cell for new grid
            result.get(x / col).add(grid[r][c]);// adding new element in new row
            x++;
        }
        return result;// returning result list
    }
}
```
<hr>
<hr>

***Time Complexity =O(N+N)=O(2N)=O(N)
Space Complexity=O(N)***

<hr>
<hr>

***UPVOTE if you like the post(^///^)***


</details>
