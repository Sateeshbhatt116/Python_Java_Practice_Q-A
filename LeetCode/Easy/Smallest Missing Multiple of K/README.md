# Smallest Missing Multiple of K

| Field | Value |
|-------|-------|
| **Platform** | LeetCode |
| **Difficulty** | Easy |
| **Language** | java |
| **Solved On** | August 25, 2026 |
| **Tags** | Array, Hash Table |
| **Link** | [View Problem](https://leetcode.com/problems/smallest-missing-multiple-of-k/) |
| **Runtime** | 0 ms |
| **Memory** | 42.5 MB |

## Approach



1. Problem Restated:
   Given an array nums and integer k, find the smallest positive number 
   of the form (k * i) for i = 1, 2, 3, ... that does NOT appear in nums.

2. Use a Set for Fast Lookup:
   Put all elements of nums into a HashSet. This lets us check "does 
   this value exist in nums?" in O(1) time instead of scanning the 
   array repeatedly (which would be O(n) per check).

3. Enumerate Multiples of k in Increasing Order:
   Start with multiple = k, then k*2, k*3, k*4, and so on 
   (equivalently: multiple += k each step).
   
   We check them in increasing order because we specifically need the 
   SMALLEST missing multiple — checking in order guarantees the first 
   one we find missing is the answer, no need to check further or sort.

4. Stop at First Miss:
   For each multiple, check if it exists in the set.
   - If it exists, move to the next multiple (multiple += k).
   - If it does NOT exist, that's our answer — return it immediately.

5. Why the Loop Always Terminates Quickly:
   Given constraints (nums.length <= 100, nums[i] <= 100, k <= 100), 
   there are at most 100 values in nums that could possibly block a 
   multiple. By pigeonhole principle, within about the first 101 
   multiples of k, at least one must be missing from nums (since nums 
   has at most 100 elements total). So the loop runs a small, bounded 
   number of times.

6. Complexity:
   - Building the set: O(n) time, O(n) space
   - Enumerating multiples: O(n) time in the worst case
   - Overall: O(n) time, O(n) space

## Problem Description

<p>Given an integer array <code>nums</code> and an integer <code>k</code>, return the <strong>smallest positive multiple</strong> of <code>k</code> that is <strong>missing</strong> from <code>nums</code>.</p>

<p>A <strong>multiple</strong> of <code>k</code> is any positive integer divisible by <code>k</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [8,2,3,4,6], k = 2</span></p>

<p><strong>Output:</strong> <span class="example-io">10</span></p>

<p><strong>Explanation:</strong></p>

<p>The multiples of <code>k = 2</code> are 2, 4, 6, 8, 10, 12... and the smallest multiple missing from <code>nums</code> is 10.</p>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [1,4,7,10,15], k = 5</span></p>

<p><strong>Output:</strong> <span class="example-io">5</span></p>

<p><strong>Explanation:</strong></p>

<p>The multiples of <code>k = 5</code> are 5, 10, 15, 20... and the smallest multiple missing from <code>nums</code> is 5.</p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 100</code></li>
	<li><code>1 &lt;= nums[i] &lt;= 100</code></li>
	<li><code>1 &lt;= k &lt;= 100</code></li>
</ul>

