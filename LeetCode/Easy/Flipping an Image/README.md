# Flipping an Image

| Field | Value |
|-------|-------|
| **Platform** | LeetCode |
| **Difficulty** | Easy |
| **Language** | java |
| **Solved On** | August 20, 2026 |
| **Tags** | Array, Two Pointers, Bit Manipulation, Matrix, Simulation |
| **Link** | [View Problem](https://leetcode.com/problems/flipping-an-image/) |
| **Runtime** | 0 ms |
| **Memory** | 42.7 MB |

## Problem Description

<p>Given an <code>n x n</code> binary matrix <code>image</code>, flip the image <strong>horizontally</strong>, then invert it, and return <em>the resulting image</em>.</p>

<p>To flip an image horizontally means that each row of the image is reversed.</p>

<ul>
	<li>For example, flipping <code>[1,1,0]</code> horizontally results in <code>[0,1,1]</code>.</li>
</ul>

<p>To invert an image means that each <code>0</code> is replaced by <code>1</code>, and each <code>1</code> is replaced by <code>0</code>.</p>

<ul>
	<li>For example, inverting <code>[0,1,1]</code> results in <code>[1,0,0]</code>.</li>
</ul>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> image = [[1,1,0],[1,0,1],[0,0,0]]
<strong>Output:</strong> [[1,0,0],[0,1,0],[1,1,1]]
<strong>Explanation:</strong> First reverse each row: [[0,1,1],[1,0,1],[0,0,0]].
Then, invert the image: [[1,0,0],[0,1,0],[1,1,1]]
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> image = [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
<strong>Output:</strong> [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
<strong>Explanation:</strong> First reverse each row: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]].
Then invert the image: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>n == image.length</code></li>
	<li><code>n == image[i].length</code></li>
	<li><code>1 &lt;= n &lt;= 20</code></li>
	<li><code>images[i][j]</code> is either <code>0</code> or <code>1</code>.</li>
</ul>


##  Top Community Optimal Approach

<details>
<summary>Click to expand</summary>

**Title**: 🔥🚀Beginner 🧠friendly🥰   | |    ✅Green Beats🙌🧠  | |  JAVA
**Author**: [@Pintu008](https://leetcode.com/Pintu008/)
**Upvotes**: 26 👍
**Link**: [View Original Post](https://leetcode.com/problems/flipping-an-image/solutions/4364415/)

---

# Intuition
- The horizontal flip is performed by reversing the order of elements in each row.
- Inversion is achieved by changing 0s to 1s and 1s to 0s.
- The combination of these two operations creates the desired result.
<!-- Describe your first thoughts on how to solve this problem. -->

# Approach
### 1. Horizontal Flip:

For each row in the image, reverse the order of its elements. This effectively flips the image horizontally.
### 2. Invert:

Iterate through the flipped image and replace each 0 with 1 and each 1 with 0. This step achieves the inversion.
### 3. Return Result:

Return the resulting image after both horizontal flipping and inversion.
<!-- Describe your approach to solving the problem. -->

# Complexity
- Time complexity: **O(N*M)**
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity: **ON*M)**
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

# Code
```
class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        int [][] rev = new int[image[0].length][image.length];
        for(int i=0; i<image.length; i++){
            int k=0;
            for(int j=image[i].length-1; j>=0; j--){
                rev[i][k++] = image[i][j];
            }
        }
        for(int i=0; i<rev.length; i++){
            for(int j=0; j<rev[i].length; j++){
                if(rev[i][j]==1) rev[i][j]=0;
                else if(rev[i][j]==0) rev[i][j]=1;
            }
        }
        return rev;
    }
}
```
![WhatsApp Image 2023-12-03 at 12.33.52.jpeg](https://assets.leetcode.com/users/images/6ff7963e-c65c-4056-aee9-ace044237626_1701756136.3264186.jpeg)


</details>
