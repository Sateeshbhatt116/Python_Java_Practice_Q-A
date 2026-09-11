# Intersection of Two Arrays

| Field | Value |
|-------|-------|
| **Platform** | LeetCode |
| **Difficulty** | Easy |
| **Language** | java |
| **Solved On** | September 11, 2026 |
| **Tags** | Array, Hash Table, Two Pointers, Binary Search, Sorting |
| **Link** | [View Problem](https://leetcode.com/problems/intersection-of-two-arrays/) |
| **Runtime** | 2 ms |
| **Memory** | 45 MB |

## Problem Description

<p>Given two integer arrays <code>nums1</code> and <code>nums2</code>, return <em>an array of their <span data-keyword="array-intersection" class=" cursor-pointer relative text-dark-blue-s text-sm"><button type="button" aria-haspopup="dialog" aria-expanded="false" aria-controls="radix-_r_nu_" data-state="closed" class="">intersection</button></span></em>. Each element in the result must be <strong>unique</strong> and you may return the result in <strong>any order</strong>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> nums1 = [1,2,2,1], nums2 = [2,2]
<strong>Output:</strong> [2]
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> nums1 = [4,9,5], nums2 = [9,4,9,8,4]
<strong>Output:</strong> [9,4]
<strong>Explanation:</strong> [4,9] is also accepted.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums1.length, nums2.length &lt;= 1000</code></li>
	<li><code>0 &lt;= nums1[i], nums2[i] &lt;= 1000</code></li>
</ul>


##  Top Community Optimal Approach

<details>
<summary>Click to expand</summary>

**Title**: 5ms Java Using 1 hashset and time complexity of O(m+n)
**Author**: [@mitulshr](https://leetcode.com/mitulshr/)
**Upvotes**: 73 👍
**Link**: [View Original Post](https://leetcode.com/problems/intersection-of-two-arrays/solutions/81974/)

---

    HashSet<Integer> set = new HashSet<Integer>();
            ArrayList<Integer> res = new ArrayList<Integer>();
            //Add all elements to set from array 1
            for(int i =0; i< nums1.length; i++) set.add(nums1[i]);
            for(int j = 0; j < nums2.length; j++) {
               // If present in array 2 then add to res and remove from set 
               if(set.contains(nums2[j])) {
                    res.add(nums2[j]);
                    set.remove(nums2[j]);
                }
            }
            // Convert ArrayList to array
            int[] arr = new int[res.size()];
            for (int i= 0; i < res.size(); i++) arr[i] = res.get(i);
            return arr;

</details>
