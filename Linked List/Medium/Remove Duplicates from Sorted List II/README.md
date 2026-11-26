# Remove Duplicates from Sorted List II

| Field | Value |
|-------|-------|
| **Platform** | LeetCode |
| **Difficulty** | Medium |
| **Language** | java |
| **Solved On** | November 26, 2026 |
| **Tags** | Linked List, Two Pointers |
| **Link** | [View Problem](https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/) |
| **Runtime** | 1 ms |
| **Memory** | 44.5 MB |

## Problem Description

<p>You are given the <code>head</code> of a <strong>sorted</strong> linked list.</p>

<p>Delete all nodes that have <strong>duplicate</strong> numbers, leaving only <strong>distinct</strong> numbers from the original list.</p>

<p>Return the linked list <strong>sorted</strong> as well.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/01/04/linkedlist1.jpg" style="width: 500px; height: 142px;">
<pre><strong>Input:</strong> head = [1,2,3,3,4,4,5]
<strong>Output:</strong> [1,2,5]
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/01/04/linkedlist2.jpg" style="width: 500px; height: 205px;">
<pre><strong>Input:</strong> head = [1,1,1,2,3]
<strong>Output:</strong> [2,3]
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

**Title**: Java simple and clean code with comment
**Author**: [@jinwu](https://leetcode.com/jinwu/)
**Upvotes**: 202 👍
**Link**: [View Original Post](https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/solutions/28364/)

---

    public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
    	//use two pointers, slow - track the node before the dup nodes, 
    	// fast - to find the last node of dups.
        ListNode dummy = new ListNode(0), fast = head, slow = dummy;
        slow.next = fast;
        while(fast != null) {
        	while (fast.next != null && fast.val == fast.next.val) {
         		fast = fast.next;    //while loop to find the last node of the dups.
        	}
        	if (slow.next != fast) { //duplicates detected.
        		slow.next = fast.next; //remove the dups.
        		fast = slow.next;     //reposition the fast pointer.
        	} else { //no dup, move down both pointer.
        		slow = slow.next;
        		fast = fast.next;
        	}
        	
        }
        return dummy.next;
    } }

</details>
