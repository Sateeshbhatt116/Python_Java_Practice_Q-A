# First Missing Positive

| Field | Value |
|-------|-------|
| **Platform** | LeetCode |
| **Difficulty** | Hard |
| **Language** | java |
| **Solved On** | August 23, 2026 |
| **Tags** | Array, Hash Table |
| **Link** | [View Problem](https://leetcode.com/problems/first-missing-positive/) |
| **Runtime** | 0 ms |
| **Memory** | 42.6 MB |

## Approach


Use index mapping to place each positive number at its correct position.

For a number x, its correct index is x - 1.
Ignore numbers that are <= 0 or greater than n.

Traverse the array and swap each valid number to its correct index.
After rearranging, traverse the array again.
If nums[i] != i + 1, then i + 1 is the smallest missing positive number.

If all positions are correct, return n + 1.

Time Complexity: O(n)
Space Complexity: O(1)

## Problem Description

<p>Given an unsorted integer array <code>nums</code>. Return the <em>smallest positive integer</em> that is <em>not present</em> in <code>nums</code>.</p>

<p>You must implement an algorithm that runs in <code>O(n)</code> time and uses <code>O(1)</code> auxiliary space.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> nums = [1,2,0]
<strong>Output:</strong> 3
<strong>Explanation:</strong> The numbers in the range [1,2] are all in the array.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> nums = [3,4,-1,1]
<strong>Output:</strong> 2
<strong>Explanation:</strong> 1 is in the array but 2 is missing.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> nums = [7,8,9,11,12]
<strong>Output:</strong> 1
<strong>Explanation:</strong> The smallest positive integer 1 is missing.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>-2<sup>31</sup> &lt;= nums[i] &lt;= 2<sup>31</sup> - 1</code></li>
</ul>


##  Top Community Optimal Approach

<details>
<summary>Click to expand</summary>

**Title**: O(1) space Java Solution
**Author**: [@siyang3](https://leetcode.com/siyang3/)
**Upvotes**: 299 👍
**Link**: [View Original Post](https://leetcode.com/problems/first-missing-positive/solutions/17083/)

---

The key here is to use swapping to keep constant space and also make use of the length of the array, which means there can be at most n positive integers. So each time we encounter an valid integer, find its correct position and swap. Otherwise we continue.

    public class Solution {
        public int firstMissingPositive(int[] A) {
            int i = 0;
            while(i < A.length){
                if(A[i] == i+1 || A[i] <= 0 || A[i] > A.length) i++;
                else if(A[A[i]-1] != A[i]) swap(A, i, A[i]-1);
                else i++;
            }
            i = 0;
            while(i < A.length && A[i] == i+1) i++;
            return i+1;
        }
        
        private void swap(int[] A, int i, int j){
            int temp = A[i];
            A[i] = A[j];
            A[j] = temp;
        }
    }

</details>
