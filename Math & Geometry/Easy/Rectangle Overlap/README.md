# Rectangle Overlap

| Field | Value |
|-------|-------|
| **Platform** | LeetCode |
| **Difficulty** | Easy |
| **Language** | java |
| **Solved On** | September 14, 2026 |
| **Tags** | Math, Geometry |
| **Link** | [View Problem](https://leetcode.com/problems/rectangle-overlap/) |
| **Runtime** | 0 ms |
| **Memory** | 42.4 MB |

## Problem Description

<p>An axis-aligned rectangle is represented as a list <code>[x1, y1, x2, y2]</code>, where <code>(x1, y1)</code> is the coordinate of its bottom-left corner, and <code>(x2, y2)</code> is the coordinate of its top-right corner. Its top and bottom edges are parallel to the X-axis, and its left and right edges are parallel to the Y-axis.</p>

<p>Two rectangles overlap if the area of their intersection is <strong>positive</strong>. To be clear, two rectangles that only touch at the corner or edges do not overlap.</p>

<p>Given two axis-aligned rectangles <code>rec1</code> and <code>rec2</code>, return <code>true</code><em> if they overlap, otherwise return </em><code>false</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<pre><strong>Input:</strong> rec1 = [0,0,2,2], rec2 = [1,1,3,3]
<strong>Output:</strong> true
</pre><p><strong class="example">Example 2:</strong></p>
<pre><strong>Input:</strong> rec1 = [0,0,1,1], rec2 = [1,0,2,1]
<strong>Output:</strong> false
</pre><p><strong class="example">Example 3:</strong></p>
<pre><strong>Input:</strong> rec1 = [0,0,1,1], rec2 = [2,2,3,3]
<strong>Output:</strong> false
</pre>
<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>rec1.length == 4</code></li>
	<li><code>rec2.length == 4</code></li>
	<li><code>-10<sup>9</sup> &lt;= rec1[i], rec2[i] &lt;= 10<sup>9</sup></code></li>
	<li><code>rec1</code> and <code>rec2</code> represent a valid rectangle with a non-zero area.</li>
</ul>


##  Top Community Optimal Approach

<details>
<summary>Click to expand</summary>

**Title**: (Java) Easy 1 line sol with great explaination || Beats 100%
**Author**: [@am282000](https://leetcode.com/am282000/)
**Upvotes**: 20 👍
**Link**: [View Original Post](https://leetcode.com/problems/rectangle-overlap/solutions/1340498/)

---

# *****************Upvote if you like *************
# Code :
```
public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return (rec1[0] < rec2[2] && rec1[1] < rec2[3] && rec1[2] > rec2[0] &&  rec1[3] > rec2[1]);
    }
```
# Explaination : 
```
                  2,3
rec1            (x2,y2)
         _______
        |       |
        |       |
        |_______|
    (x1,y1)
      0,1
    

rec2            (x2,y2)
                  2,3
         _______
        |       |
        |       |
        |_______|
    (x1,y1)
      0,1


These 0,1,2,3 just for our convienence

Simple idea is that they will overlap only if
 rect1 k x1,y1 < rect2 k x2,y2  
 rect1 k x2,y2 > rect2 k x1,y1  

```


</details>
