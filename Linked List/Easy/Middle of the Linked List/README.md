# Middle of the Linked List

| Field | Value |
|-------|-------|
| **Platform** | LeetCode |
| **Difficulty** | Easy |
| **Language** | java |
| **Solved On** | November 18, 2026 |
| **Tags** | Linked List, Two Pointers |
| **Link** | [View Problem](https://leetcode.com/problems/middle-of-the-linked-list/) |
| **Runtime** | 0 ms |
| **Memory** | 42.3 MB |

## Problem Description

<p>Given the <code>head</code> of a singly linked list, return <em>the middle node of the linked list</em>.</p>

<p>If there are two middle nodes, return <strong>the second middle</strong> node.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/07/23/lc-midlist1.jpg" style="width: 544px; height: 65px;">
<pre><strong>Input:</strong> head = [1,2,3,4,5]
<strong>Output:</strong> [3,4,5]
<strong>Explanation:</strong> The middle node of the list is node 3.
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/07/23/lc-midlist2.jpg" style="width: 664px; height: 65px;">
<pre><strong>Input:</strong> head = [1,2,3,4,5,6]
<strong>Output:</strong> [4,5,6]
<strong>Explanation:</strong> Since the list has two middle nodes with values 3 and 4, we return the second one.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of nodes in the list is in the range <code>[1, 100]</code>.</li>
	<li><code>1 &lt;= Node.val &lt;= 100</code></li>
</ul>


##  Top Community Optimal Approach

<details>
<summary>Click to expand</summary>

**Title**: ✅ [Python/Java/C++] Simple Solution || One-Pass || Beginner Friendly || Detailed Explanation
**Author**: [@linfq](https://leetcode.com/linfq/)
**Upvotes**: 639 👍
**Link**: [View Original Post](https://leetcode.com/problems/middle-of-the-linked-list/solutions/1651600/)

---

**PLEASE UPVOTE if you like** \uD83D\uDE01 **If you have any question, feel free to ask.** 

* While `slow` moves one step forward, `fast` moves two steps forward.
* Finally, when `fast` reaches the end, `slow` happens to be in the middle of the linked list.
* For example, head = [1, 2, 3, 4, 5], I **bolded** the `slow` and `fast` in the list.
	* step 0: `slow`: [**1**, 2, 3, 4, 5], `fast`: [**1**, 2, 3, 4, 5]
	* step 1: `slow`: [1, **2**, 3, 4, 5], `fast`: [1, 2, **3**, 4, 5]
	* step 2: `slow`: [1, 2, **3**, 4, 5], `fast`: [1, 2, 3, 4, **5**]
	* end because `fast` cannot move forward anymore and `return [3, 4, 5]`


**Python**
```
class Solution(object):
    def middleNode(self, head):
        # While slow moves one step forward, fast moves two steps forward.
        # Finally, when fast reaches the end, slow happens to be in the middle of the linked list.
        slow = fast = head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
        return slow
```
**C++**
```
class Solution {
public:
    ListNode* middleNode(ListNode* head) {
        ListNode *slow = head, *fast = head;
        while (fast && fast->next) {
            slow = slow->next;
            fast = fast->next->next;
        }
        return slow;
    }
};
```
**Java**
```
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
```

**PLEASE UPVOTE if you like \uD83D\uDE01 If you have any question, feel free to ask.**




</details>
