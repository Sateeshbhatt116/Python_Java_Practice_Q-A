# Array Nesting

| Field | Value |
|-------|-------|
| **Platform** | LeetCode |
| **Difficulty** | Medium |
| **Language** | java |
| **Solved On** | September 5, 2026 |
| **Tags** | Array, Depth-First Search |
| **Link** | [View Problem](https://leetcode.com/problems/array-nesting/) |
| **Runtime** | 5 ms |
| **Memory** | 69.2 MB |

## Problem Description

<p>You are given an integer array <code>nums</code> of length <code>n</code> where <code>nums</code> is a permutation of the numbers in the range <code>[0, n - 1]</code>.</p>

<p>You should build a set <code>s[k] = {nums[k], nums[nums[k]], nums[nums[nums[k]]], ... }</code> subjected to the following rule:</p>

<ul>
	<li>The first element in <code>s[k]</code> starts with the selection of the element <code>nums[k]</code> of <code>index = k</code>.</li>
	<li>The next element in <code>s[k]</code> should be <code>nums[nums[k]]</code>, and then <code>nums[nums[nums[k]]]</code>, and so on.</li>
	<li>We stop adding right before a duplicate element occurs in <code>s[k]</code>.</li>
</ul>

<p>Return <em>the longest length of a set</em> <code>s[k]</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> nums = [5,4,0,3,1,6,2]
<strong>Output:</strong> 4
<strong>Explanation:</strong> 
nums[0] = 5, nums[1] = 4, nums[2] = 0, nums[3] = 3, nums[4] = 1, nums[5] = 6, nums[6] = 2.
One of the longest sets s[k]:
s[0] = {nums[0], nums[5], nums[6], nums[2]} = {5, 6, 2, 0}
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> nums = [0,1,2]
<strong>Output:</strong> 1
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>0 &lt;= nums[i] &lt; nums.length</code></li>
	<li>All the values of <code>nums</code> are <strong>unique</strong>.</li>
</ul>


##  Top Community Optimal Approach

<details>
<summary>Click to expand</summary>

**Title**: JAVA SOLUTION USING HASHSET
**Author**: [@Subhankar752](https://leetcode.com/Subhankar752/)
**Upvotes**: 5 👍
**Link**: [View Original Post](https://leetcode.com/problems/array-nesting/solutions/1439808/)

---

The main idea is to check for every index and keep count of the distinct elements which is donw by using HashSet.
```
class Solution {
    public int arrayNesting(int[] nums) {
        int n = nums.length;
        int ans = Integer.MIN_VALUE;
        for(int i = 0 ; i < n ; i++){
            HashSet<Integer> hs = new HashSet<>();
            hs.add(nums[i]);
            int x = nums[i];
            while(!hs.contains(nums[x])){
                hs.add(nums[x]);
                x = nums[x];
            }
            ans = Math.max(ans , hs.size());
        }
        return ans;
    }
}
```
Result: TLE in last 3 test cases.

Observation: We can use a single HashSet for the entire operation. Since there are elements from 0 to (n - 1) so overlapping indexes can be avoided by keeping track of the number of times insertion is done. The implementation is given below.

```
class Solution {
    public int arrayNesting(int[] nums) {
        int n = nums.length;
        HashSet<Integer> hs = new HashSet<>();
        int ans = Integer.MIN_VALUE;
        for(int i = 0 ; i < n ; i++){
            int j = i;
            int count = 0;
            while(!hs.contains(nums[j])){
                hs.add(nums[j]);
                j = nums[j];
                count++;
            }
            ans = Math.max(ans , count);
        }
        return ans;
    }
}
```
Result : Accepted. 
Do upvote id it was helpful.

</details>
