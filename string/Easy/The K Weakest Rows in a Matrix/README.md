# The K Weakest Rows in a Matrix

| Field | Value |
|-------|-------|
| **Platform** | LeetCode |
| **Difficulty** | Easy |
| **Language** | java |
| **Solved On** | September 16, 2026 |
| **Tags** | Array, Binary Search, Sorting, Heap (Priority Queue), Matrix |
| **Link** | [View Problem](https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/) |
| **Runtime** | 4 ms |
| **Memory** | 46 MB |

## Problem Description

<p>You are given an <code>m x n</code> binary matrix <code>mat</code> of <code>1</code>'s (representing soldiers) and <code>0</code>'s (representing civilians). The soldiers are positioned <strong>in front</strong> of the civilians. That is, all the <code>1</code>'s will appear to the <strong>left</strong> of all the <code>0</code>'s in each row.</p>

<p>A row <code>i</code> is <strong>weaker</strong> than a row <code>j</code> if one of the following is true:</p>

<ul>
	<li>The number of soldiers in row <code>i</code> is less than the number of soldiers in row <code>j</code>.</li>
	<li>Both rows have the same number of soldiers and <code>i &lt; j</code>.</li>
</ul>

<p>Return <em>the indices of the </em><code>k</code><em> <strong>weakest</strong> rows in the matrix ordered from weakest to strongest</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> mat = 
[[1,1,0,0,0],
 [1,1,1,1,0],
 [1,0,0,0,0],
 [1,1,0,0,0],
 [1,1,1,1,1]], 
k = 3
<strong>Output:</strong> [2,0,3]
<strong>Explanation:</strong> 
The number of soldiers in each row is: 
- Row 0: 2 
- Row 1: 4 
- Row 2: 1 
- Row 3: 2 
- Row 4: 5 
The rows ordered from weakest to strongest are [2,0,3,1,4].
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> mat = 
[[1,0,0,0],
 [1,1,1,1],
 [1,0,0,0],
 [1,0,0,0]], 
k = 2
<strong>Output:</strong> [0,2]
<strong>Explanation:</strong> 
The number of soldiers in each row is: 
- Row 0: 1 
- Row 1: 4 
- Row 2: 1 
- Row 3: 1 
The rows ordered from weakest to strongest are [0,2,3,1].
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>m == mat.length</code></li>
	<li><code>n == mat[i].length</code></li>
	<li><code>2 &lt;= n, m &lt;= 100</code></li>
	<li><code>1 &lt;= k &lt;= m</code></li>
	<li><code>matrix[i][j]</code> is either 0 or 1.</li>
</ul>


##  Top Community Optimal Approach

<details>
<summary>Click to expand</summary>

**Title**: Simple Solution In Java
**Author**: [@xiaoqiaomei](https://leetcode.com/xiaoqiaomei/)
**Upvotes**: 111 👍
**Link**: [View Original Post](https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/solutions/560163/)

---

```
public int[] kWeakestRows(int[][] mat, int k) {
    int rows = mat.length;
    int cols = mat[0].length;

    int[] score = new int[rows];
    int j;
    for (int i = 0; i < rows; i++) {
        j = 0;
        for (; j < cols; j++) {
            if (mat[i][j] == 0) {
                break;
            }
        }
		/*
		 * we can create a score to match the sort condition from description
		 * score = soldiersCount * rows + currentRowIndex
		 * so we can get soldiersCount by score / rows, and get rowIndex by score % rows
		 */
        score[i] = j * rows + i;
    }

    Arrays.sort(score);
    for (int i = 0; i < score.length; i++) {
		// get rowIndex
        score[i] = score[i] % rows;
    }

    return Arrays.copyOfRange(score, 0, k);
}
```

</details>
