# Count Servers that Communicate

| Field | Value |
|-------|-------|
| **Platform** | LeetCode |
| **Difficulty** | Medium |
| **Language** | java |
| **Solved On** | November 17, 2026 |
| **Tags** | Array, Depth-First Search, Breadth-First Search, Union-Find, Matrix, Counting |
| **Link** | [View Problem](https://leetcode.com/problems/count-servers-that-communicate/) |
| **Runtime** | 3 ms |
| **Memory** | 54.9 MB |

## Problem Description

<p>You are given a map of a server center, represented as a <code>m * n</code> integer matrix&nbsp;<code>grid</code>, where 1 means that on that cell there is a server and 0 means that it is no server. Two servers are said to communicate if they are on the same row or on the same column.<br>
<br>
Return the number of servers&nbsp;that communicate with any other server.</p>

<p>&nbsp;</p>
<p><span class="float-right -my-0.5 ml-2 inline-flex select-none items-center" data-example-lang-controls=""><span role="group" class="inline-flex h-6 items-center rounded-sd-md bg-sd-muted p-0.5" data-example-lang-toggle=""><button type="button" aria-pressed="true" class="h-5 max-w-[10rem] truncate whitespace-nowrap rounded-sd-sm border px-2 text-xs font-normal leading-none border-sd-border bg-sd-background text-sd-foreground">Original</button><button type="button" aria-pressed="false" class="h-5 max-w-[10rem] truncate whitespace-nowrap rounded-sd-sm border px-2 text-xs font-normal leading-none border-transparent text-sd-muted-foreground hover:text-sd-foreground">Java</button></span></span><strong class="example">Example 1:</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2019/11/14/untitled-diagram-6.jpg" style="width: 202px; height: 203px;"></p>

<pre><strong>Input:</strong> grid = [[1,0],[0,1]]
<strong>Output:</strong> 0
<b>Explanation:</b>&nbsp;No servers can communicate with others.</pre>

<p><strong class="example">Example 2:</strong></p>

<p><strong><img alt="" src="https://assets.leetcode.com/uploads/2019/11/13/untitled-diagram-4.jpg" style="width: 203px; height: 203px;"></strong></p>

<pre><strong>Input:</strong> grid = [[1,0],[1,1]]
<strong>Output:</strong> 3
<b>Explanation:</b>&nbsp;All three servers can communicate with at least one other server.
</pre>

<p><strong class="example">Example 3:</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2019/11/14/untitled-diagram-1-3.jpg" style="width: 443px; height: 443px;"></p>

<pre><strong>Input:</strong> grid = [[1,1,0,0],[0,0,1,0],[0,0,1,0],[0,0,0,1]]
<strong>Output:</strong> 4
<b>Explanation:</b>&nbsp;The two servers in the first row can communicate with each other. The two servers in the third column can communicate with each other. The server at right bottom corner can't communicate with any other server.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>m == grid.length</code></li>
	<li><code>n == grid[i].length</code></li>
	<li><code>1 &lt;= m &lt;= 250</code></li>
	<li><code>1 &lt;= n &lt;= 250</code></li>
	<li><code>grid[i][j] == 0 or 1</code></li>
</ul>


##  Top Community Optimal Approach

<details>
<summary>Click to expand</summary>

**Title**: JAVA || Clean & Concise & Optimal code || 2ms Time || 100% Faster Solution
**Author**: [@anii_agrawal](https://leetcode.com/anii_agrawal/)
**Upvotes**: 16 👍
**Link**: [View Original Post](https://leetcode.com/problems/count-servers-that-communicate/solutions/1245787/)

---

```
class Solution {
    public int countServers(int[][] grid) {
        
        int rows = grid.length;
        int cols = rows == 0 ? 0 : grid[0].length;
        int servers = 0;
        int[] countServersInRow = new int[rows];
        int[] countServersInCol = new int[cols];
        
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == 1) {
                    ++countServersInRow[row];
                    ++countServersInCol[col];
                }
            }
        }
        
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == 1 && (countServersInRow[row] > 1 || countServersInCol[col] > 1)) {
                    ++servers;
                }
            }
        }
        
        return servers;
    }
}
```

Please help to **UPVOTE** if this post is useful for you.
If you have any questions, feel free to comment below.

**LOVE CODING :)
HAPPY CODING :)
HAPPY LEARNING :)**

</details>
