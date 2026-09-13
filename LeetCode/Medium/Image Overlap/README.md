# Image Overlap

| Field | Value |
|-------|-------|
| **Platform** | LeetCode |
| **Difficulty** | Medium |
| **Language** | java |
| **Solved On** | September 13, 2026 |
| **Tags** | Array, Matrix |
| **Link** | [View Problem](https://leetcode.com/problems/image-overlap/) |
| **Runtime** | 172 ms |
| **Memory** | 47.6 MB |

## Problem Description

<p>You are given two images, <code>img1</code> and <code>img2</code>, represented as binary, square matrices of size <code>n x n</code>. A binary matrix has only <code>0</code>s and <code>1</code>s as values.</p>

<p>We <strong>translate</strong> one image however we choose by sliding all the <code>1</code> bits left, right, up, and/or down any number of units. We then place it on top of the other image. We can then calculate the <strong>overlap</strong> by counting the number of positions that have a <code>1</code> in <strong>both</strong> images.</p>

<p>Note also that a translation does <strong>not</strong> include any kind of rotation. Any <code>1</code> bits that are translated outside of the matrix borders are erased.</p>

<p>Return <em>the largest possible overlap</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/09/09/overlap1.jpg" style="width: 450px; height: 231px;">
<pre><strong>Input:</strong> img1 = [[1,1,0],[0,1,0],[0,1,0]], img2 = [[0,0,0],[0,1,1],[0,0,1]]
<strong>Output:</strong> 3
<strong>Explanation:</strong> We translate img1 to right by 1 unit and down by 1 unit.
<img alt="" src="https://assets.leetcode.com/uploads/2020/09/09/overlap_step1.jpg" style="width: 450px; height: 105px;">
The number of positions that have a 1 in both images is 3 (shown in red).
<img alt="" src="https://assets.leetcode.com/uploads/2020/09/09/overlap_step2.jpg" style="width: 450px; height: 231px;">
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> img1 = [[1]], img2 = [[1]]
<strong>Output:</strong> 1
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> img1 = [[0]], img2 = [[0]]
<strong>Output:</strong> 0
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>n == img1.length == img1[i].length</code></li>
	<li><code>n == img2.length == img2[i].length</code></li>
	<li><code>1 &lt;= n &lt;= 30</code></li>
	<li><code>img1[i][j]</code> is either <code>0</code> or <code>1</code>.</li>
	<li><code>img2[i][j]</code> is either <code>0</code> or <code>1</code>.</li>
</ul>


##  Top Community Optimal Approach

<details>
<summary>Click to expand</summary>

**Title**: JAVA || Easy Solution With Explanation || 100% Faster Code
**Author**: [@shivrastogi](https://leetcode.com/shivrastogi/)
**Upvotes**: 18 👍
**Link**: [View Original Post](https://leetcode.com/problems/image-overlap/solutions/2747715/)

---

	PLEASE UPVOTE IF YOU LIKE.
```
class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int R1 = img1.length;
        int R2 = img2.length;
        int C1 = img1[0].length;
        int C2 = img2[0].length;
        int max = Integer.MIN_VALUE;
		
		//Slide one image on other image.
        for(int r=0; r<R1+R2-1; r++){
            int i = R1-1 + Math.min(0, R2-1-r);
            int x = r + Math.min(0, R2-1-r);
            for(int c=0; c<C1+C2-1;  c++){
                int j = C1-1 + Math.min( 0 ,  C2-1-c);
                int y = c + Math.min(0 , C2-1-c);
                max = Math.max(max, overlap(img1,img2,i,j,x,y));
            }
        }
        return max;
    }
    
	//Compares two matrices from give coordinates to LEFT-TOP
    int overlap(int[][] img1, int[][] img2, int i1,int j1, int i2, int j2){
        int count = 0;
        for(int i=i1,x=i2; i>=0 && x>=0; i--,x--){
            for(int j=j1, y=j2; j >=0 && y>=0 ; j--,y--){
                if(img1[i][j] == img2[x][y]){
                    if(img1[i][j]==1)
                        count++;
                }
            }
        }
        //System.out.println("[" + i1+" , "+j1+"]    ["+ i2 + " , "+j2+" ]" + "===" + count);
        return count;
    }
}
```

</details>
