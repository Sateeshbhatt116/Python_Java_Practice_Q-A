# Merge Two Sorted Lists

| Field | Value |
|-------|-------|
| **Platform** | LeetCode |
| **Difficulty** | Easy |
| **Language** | java |
| **Solved On** | November 18, 2026 |
| **Tags** | Linked List, Recursion |
| **Link** | [View Problem](https://leetcode.com/problems/merge-two-sorted-lists/) |
| **Runtime** | 3 ms |
| **Memory** | 44.2 MB |

## Problem Description

<p>You are given the heads of two sorted linked lists <code>list1</code> and <code>list2</code>.</p>

<p>Merge the two lists into one <strong>sorted</strong> list. The list should be made by splicing together the nodes of the first two lists.</p>

<p>Return <em>the head of the merged linked list</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/10/03/merge_ex1.jpg" style="width: 662px; height: 302px;">
<pre><strong>Input:</strong> list1 = [1,2,4], list2 = [1,3,4]
<strong>Output:</strong> [1,1,2,3,4,4]
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> list1 = [], list2 = []
<strong>Output:</strong> []
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> list1 = [], list2 = [0]
<strong>Output:</strong> [0]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of nodes in both lists is in the range <code>[0, 50]</code>.</li>
	<li><code>-100 &lt;= Node.val &lt;= 100</code></li>
	<li>Both <code>list1</code> and <code>list2</code> are sorted in <strong>non-decreasing</strong> order.</li>
</ul>


##  Top Community Optimal Approach

<details>
<summary>Click to expand</summary>

**Title**: Java, 1 ms, 4 lines codes, using recursion
**Author**: [@yangliguang](https://leetcode.com/yangliguang/)
**Upvotes**: 1469 👍
**Link**: [View Original Post](https://leetcode.com/problems/merge-two-sorted-lists/solutions/9715/)

---

    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
    		if(l1 == null) return l2;
    		if(l2 == null) return l1;
    		if(l1.val < l2.val){
    			l1.next = mergeTwoLists(l1.next, l2);
    			return l1;
    		} else{
    			l2.next = mergeTwoLists(l1, l2.next);
    			return l2;
    		}
    }

</details>
