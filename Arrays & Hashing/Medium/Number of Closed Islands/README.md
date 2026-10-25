# Number of Closed Islands

| Field | Value |
|-------|-------|
| **Platform** | LeetCode |
| **Difficulty** | Medium |
| **Language** | java |
| **Solved On** | October 26, 2026 |
| **Tags** | Array, Depth-First Search, Breadth-First Search, Union-Find, Matrix |
| **Link** | [View Problem](https://leetcode.com/problems/number-of-closed-islands/) |
| **Runtime** | 3 ms |
| **Memory** | 46.1 MB |

## Problem Description

<p>Given a 2D&nbsp;<code>grid</code> consists of <code>0s</code> (land)&nbsp;and <code>1s</code> (water).&nbsp; An <em>island</em> is a maximal 4-directionally connected group of <code><font face="monospace">0</font>s</code> and a <em>closed island</em>&nbsp;is an island <strong>totally</strong>&nbsp;(all left, top, right, bottom) surrounded by <code>1s.</code></p>

<p>Return the number of <em>closed islands</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2019/10/31/sample_3_1610.png" style="width: 240px; height: 120px;"></p>

<pre><strong>Input:</strong> grid = [[1,1,1,1,1,1,1,0],[1,0,0,0,0,1,1,0],[1,0,1,0,1,1,1,0],[1,0,0,0,0,1,0,1],[1,1,1,1,1,1,1,0]]
<strong>Output:</strong> 2
<strong>Explanation:</strong> 
Islands in gray are closed because they are completely surrounded by water (group of 1s).</pre>

<p><strong class="example">Example 2:</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2019/10/31/sample_4_1610.png" style="width: 160px; height: 80px;"></p>

<pre><strong>Input:</strong> grid = [[0,0,1,0,0],[0,1,0,1,0],[0,1,1,1,0]]
<strong>Output:</strong> 1
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> grid = [[1,1,1,1,1,1,1],
&nbsp;              [1,0,0,0,0,0,1],
&nbsp;              [1,0,1,1,1,0,1],
&nbsp;              [1,0,1,0,1,0,1],
&nbsp;              [1,0,1,1,1,0,1],
&nbsp;              [1,0,0,0,0,0,1],
               [1,1,1,1,1,1,1]]
<strong>Output:</strong> 2
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= grid.length, grid[0].length &lt;= 100</code></li>
	<li><code>0 &lt;= grid[i][j] &lt;=1</code></li>
</ul>


##  Top Community Optimal Approach

<details>
<summary>Click to expand</summary>

**Title**: ✅[Python3//C++//Java]✅ Easy and understand DFS solution(Beats 100%)
**Author**: [@abdullayev_akbar](https://leetcode.com/abdullayev_akbar/)
**Upvotes**: 149 👍
**Link**: [View Original Post](https://leetcode.com/problems/number-of-closed-islands/solutions/3384821/)

---

![image.png](https://assets.leetcode.com/users/images/93228c54-c5cd-44bd-8330-bc5a11446c0c_1680747123.9804895.png)

The DFS function takes a position (i, j) and recursively checks its neighboring cells. If the cell is out of bounds or has a value of 1, it returns True. Otherwise, it marks the cell as visited and continues to recursively check its neighbors. If any of the neighboring cells are not closed islands (i.e., not completely surrounded by 1s), it returns False. If all neighbors are closed islands, it returns True.

The main function iterates through each cell in the grid and checks if it is a 0 and a closed island. If it is, it increments the count.
# Please Upvote \uD83D\uDE07
# Python3
<iframe src="https://leetcode.com/playground/LyFhxP5m/shared" frameBorder="0" width="1000" height="600"></iframe>

![image.png](https://assets.leetcode.com/users/images/03354f6c-17b0-4db7-82a2-f82adb22e037_1680666832.3429396.png)

</details>
