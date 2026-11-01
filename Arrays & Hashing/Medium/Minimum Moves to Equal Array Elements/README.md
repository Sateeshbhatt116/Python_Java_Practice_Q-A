# Minimum Moves to Equal Array Elements

| Field | Value |
|-------|-------|
| **Platform** | LeetCode |
| **Difficulty** | Medium |
| **Language** | java |
| **Solved On** | November 1, 2026 |
| **Tags** | Array, Math |
| **Link** | [View Problem](https://leetcode.com/problems/minimum-moves-to-equal-array-elements/) |
| **Runtime** | 2 ms |
| **Memory** | 46.4 MB |

## Problem Description

<p>Given an integer array <code>nums</code> of size <code>n</code>, return <em>the minimum number of moves required to make all array elements equal</em>.</p>

<p>In one move, you can increment <code>n - 1</code> elements of the array by <code>1</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> nums = [1,2,3]
<strong>Output:</strong> 3
<strong>Explanation:</strong> Only three moves are needed (remember each move increments two elements):
[1,2,3]  =&gt;  [2,3,3]  =&gt;  [3,4,3]  =&gt;  [4,4,4]
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> nums = [1,1,1]
<strong>Output:</strong> 0
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>n == nums.length</code></li>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>-10<sup>9</sup> &lt;= nums[i] &lt;= 10<sup>9</sup></code></li>
	<li>The answer is guaranteed to fit in a <strong>32-bit</strong> integer.</li>
</ul>


##  Top Community Optimal Approach

<details>
<summary>Click to expand</summary>

**Title**: What if we are not smart enough to come up with decrease 1. Here is how we do it.
**Author**: [@KnightY](https://leetcode.com/KnightY/)
**Upvotes**: 99 👍
**Link**: [View Original Post](https://leetcode.com/problems/minimum-moves-to-equal-array-elements/solutions/93828/)

---

First, the method of decreasing 1 instead of adding 1 for n-1 elements is brilliant. But, when I was doing the contest, I was dumb, so dumb to think outside the box. And this is how I tackled it using just math logic.

First, traverse the array, get the sum and the minimum value. If every element is equal, then min*(len) should equal to sum. This part is easy to understand. So, if they are not equal, what should we do? we should keep adding 1 to the array for k times until min*(len)==sum. Then we have:

len*(min+k)=sum+k*(len-1). 
==> k=sum-min*len;

Looks familiar? If you do it by decreasing 1 each time, this equation should be easy to understand!
Some of you may have this question: how can I be sure that after adding 1 to (n-1) elements in the array, the minimum value is the previous min plus one. Is it possible that the minimum value stays the same after this? The answer is no, it's not possible. As long as all elements are not same, adding 1 to (n-1) elements meaning only one element in the array is not getting a candy. And I'm sure you will choose not to give the candy to the oldest one. So, yes, every time you do that add operation, the min value adds 1. 
```
public int minMoves(int[] nums) {
        if(nums==null||nums.length<=1) return 0;
        long min=(long)nums[0];
        long sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=(long)nums[i];
            min=Math.min(min,nums[i]);
        }
        return (int)(sum-min*nums.length);
    }
```

</details>
