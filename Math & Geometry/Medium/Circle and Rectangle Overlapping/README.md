# Circle and Rectangle Overlapping

| Field | Value |
|-------|-------|
| **Platform** | LeetCode |
| **Difficulty** | Medium |
| **Language** | java |
| **Solved On** | September 20, 2026 |
| **Tags** | Math, Geometry |
| **Link** | [View Problem](https://leetcode.com/problems/circle-and-rectangle-overlapping/) |
| **Runtime** | 0 ms |
| **Memory** | 42.5 MB |

## Problem Description

<p>You are given a circle represented as <code>(radius, xCenter, yCenter)</code> and an axis-aligned rectangle represented as <code>(x1, y1, x2, y2)</code>, where <code>(x1, y1)</code> are the coordinates of the bottom-left corner, and <code>(x2, y2)</code> are the coordinates of the top-right corner of the rectangle.</p>

<p>Return <code>true</code><em> if the circle and rectangle are overlapped otherwise return </em><code>false</code>. In other words, check if there is <strong>any</strong> point <code>(x<sub>i</sub>, y<sub>i</sub>)</code> that belongs to the circle and the rectangle at the same time.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/02/20/sample_4_1728.png" style="width: 258px; height: 167px;">
<pre><strong>Input:</strong> radius = 1, xCenter = 0, yCenter = 0, x1 = 1, y1 = -1, x2 = 3, y2 = 1
<strong>Output:</strong> true
<strong>Explanation:</strong> Circle and rectangle share the point (1,0).
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> radius = 1, xCenter = 1, yCenter = 1, x1 = 1, y1 = -3, x2 = 2, y2 = -1
<strong>Output:</strong> false
</pre>

<p><strong class="example">Example 3:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/02/20/sample_2_1728.png" style="width: 150px; height: 135px;">
<pre><strong>Input:</strong> radius = 1, xCenter = 0, yCenter = 0, x1 = -1, y1 = 0, x2 = 0, y2 = 1
<strong>Output:</strong> true
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= radius &lt;= 2000</code></li>
	<li><code>-10<sup>4</sup> &lt;= xCenter, yCenter &lt;= 10<sup>4</sup></code></li>
	<li><code>-10<sup>4</sup> &lt;= x1 &lt; x2 &lt;= 10<sup>4</sup></code></li>
	<li><code>-10<sup>4</sup> &lt;= y1 &lt; y2 &lt;= 10<sup>4</sup></code></li>
</ul>


##  Top Community Optimal Approach

<details>
<summary>Click to expand</summary>

**Title**: Trying to Explain with Diagram..
**Author**: [@ankit1478](https://leetcode.com/ankit1478/)
**Upvotes**: 27 👍
**Link**: [View Original Post](https://leetcode.com/problems/circle-and-rectangle-overlapping/solutions/4523344/)

---

![1.jpg](https://assets.leetcode.com/users/images/60578153-ee64-4a8f-9f5d-c49695e598cc_1704634395.3776312.jpeg)
![2.jpg](https://assets.leetcode.com/users/images/4808e26d-8b96-4b8a-8b3d-565a01c21170_1704634413.0493991.jpeg)
![3.jpg](https://assets.leetcode.com/users/images/c926545b-f999-4976-be0d-94ad015d17e6_1704634427.6670887.jpeg)
![4.jpg](https://assets.leetcode.com/users/images/1aa9096d-0495-4d63-ae75-dc5922506207_1704634442.672843.jpeg)


# Code
```
class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        int nearestX = Math.max(x1, Math.min(x2, xCenter));
        int nearestY = Math.max(y1, Math.min(y2, yCenter));

        int distX = xCenter - nearestX;
        int distY = yCenter - nearestY;
        return distX * distX + distY * distY <= radius*radius;
    }
} 
```

</details>
