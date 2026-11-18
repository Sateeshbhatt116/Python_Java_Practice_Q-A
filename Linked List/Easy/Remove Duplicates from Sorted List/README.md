# Remove Duplicates from Sorted List

| Field | Value |
|-------|-------|
| **Platform** | LeetCode |
| **Difficulty** | Easy |
| **Language** | java |
| **Solved On** | November 18, 2026 |
| **Tags** | Linked List |
| **Link** | [View Problem](https://leetcode.com/problems/remove-duplicates-from-sorted-list/) |
| **Runtime** | 2 ms |
| **Memory** | 46.1 MB |

## Problem Description

<p>Given the <code>head</code> of a sorted linked list, <em>delete all duplicates such that each element appears only once</em>. Return <em>the linked list <strong>sorted</strong> as well</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/01/04/list1.jpg" style="width: 302px; height: 242px;">
<pre><strong>Input:</strong> head = [1,1,2]
<strong>Output:</strong> [1,2]
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/01/04/list2.jpg" style="width: 542px; height: 222px;">
<pre><strong>Input:</strong> head = [1,1,2,3,3]
<strong>Output:</strong> [1,2,3]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of nodes in the list is in the range <code>[0, 300]</code>.</li>
	<li><code>-100 &lt;= Node.val &lt;= 100</code></li>
	<li>The list is guaranteed to be <strong>sorted</strong> in ascending order.</li>
</ul>


##  Top Community Optimal Approach

<details>
<summary>Click to expand</summary>

**Title**: 3 Line JAVA recursive solution
**Author**: [@wen587sort](https://leetcode.com/wen587sort/)
**Upvotes**: 386 👍
**Link**: [View Original Post](https://leetcode.com/problems/remove-duplicates-from-sorted-list/solutions/28625/)

---

This solution is inspired by renzid https://leetcode.com/discuss/33043/3-line-recursive-solution

    public ListNode deleteDuplicates(ListNode head) {
            if(head == null || head.next == null)return head;
            head.next = deleteDuplicates(head.next);
            return head.val == head.next.val ? head.next : head;
    }

Enjoy!

</details>
