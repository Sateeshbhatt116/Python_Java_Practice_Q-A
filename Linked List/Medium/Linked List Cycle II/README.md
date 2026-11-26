# Linked List Cycle II

| Field | Value |
|-------|-------|
| **Platform** | LeetCode |
| **Difficulty** | Medium |
| **Language** | java |
| **Solved On** | November 26, 2026 |
| **Tags** | Hash Table, Linked List, Two Pointers, Floyd's Cycle Finding Algorithm |
| **Link** | [View Problem](https://leetcode.com/problems/linked-list-cycle-ii/) |
| **Runtime** | 0 ms |
| **Memory** | 46 MB |

## Problem Description

<p>Given the <code>head</code> of a linked list, return <em>the node where the cycle begins. If there is no cycle, return </em><code>null</code>.</p>

<p>There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the <code>next</code> pointer. Internally, <code>pos</code> is used to denote the index of the node that tail's <code>next</code> pointer is connected to (<strong>0-indexed</strong>). It is <code>-1</code> if there is no cycle. <strong>Note that</strong> <code>pos</code> <strong>is not passed as a parameter</strong>.</p>

<p><strong>Do not modify</strong> the linked list.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2018/12/07/circularlinkedlist.png" style="height: 145px; width: 450px;">
<pre><strong>Input:</strong> head = [3,2,0,-4], pos = 1
<strong>Output:</strong> tail connects to node index 1
<strong>Explanation:</strong> There is a cycle in the linked list, where tail connects to the second node.
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2018/12/07/circularlinkedlist_test2.png" style="height: 105px; width: 201px;">
<pre><strong>Input:</strong> head = [1,2], pos = 0
<strong>Output:</strong> tail connects to node index 0
<strong>Explanation:</strong> There is a cycle in the linked list, where tail connects to the first node.
</pre>

<p><strong class="example">Example 3:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2018/12/07/circularlinkedlist_test3.png" style="height: 65px; width: 65px;">
<pre><strong>Input:</strong> head = [1], pos = -1
<strong>Output:</strong> no cycle
<strong>Explanation:</strong> There is no cycle in the linked list.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of the nodes in the list is in the range <code>[0, 10<sup>4</sup>]</code>.</li>
	<li><code>-10<sup>5</sup> &lt;= Node.val &lt;= 10<sup>5</sup></code></li>
	<li><code>pos</code> is <code>-1</code> or a <strong>valid index</strong> in the linked-list.</li>
</ul>

<p>&nbsp;</p>
<p><strong>Follow up:</strong> Can you solve it using <code>O(1)</code> (i.e. constant) memory?</p>


##  Top Community Optimal Approach

<details>
<summary>Click to expand</summary>

**Title**: ✅ [C++/Java/Python] Slow and Fast || Image Explanation || Beginner Friendly
**Author**: [@linfq](https://leetcode.com/linfq/)
**Upvotes**: 1128 👍
**Link**: [View Original Post](https://leetcode.com/problems/linked-list-cycle-ii/solutions/1701128/)

---

**PLEASE UPVOTE if you like** \uD83D\uDE01 **If you have any question, feel free to ask.** 
![image](https://assets.leetcode.com/users/images/eb4e7e41-f0a8-4648-b145-23a9764fcd57_1642561451.2184958.png)

* `slow` moves 1 step at a time, `fast` moves 2 steps at a time.
* when `slow` and `fast` meet each other, they must be on the cycle
	* `x` denotes the length of the linked list before starting the circle
	* `y` denotes the distance from the start of the cycle to where `slow` and `fast` met 
	* `C` denotes the length of the cycle
	* when they meet, slow traveled `(x + y)` steps while `fast` traveled `2 * (x + y)` steps, and the extra distance `(x + y)` must be a multiple of the circle length `C`
		* note that `x`, `y`, `C` are all lengths or the number of steps need to move. 
		* `head`, `slow`, `fast` are pointers. 
		* `head` moves `x` steps and arrives at the start of the cycle.
* so we have `x + y = N * C`, let `slow` continue to travel from `y` and after `x` more steps, `slow` will return to the start of the cycle.
* At the same time, according to the definition of x, `head` will also reach the start of the cycle after moving `x` steps.
* so if `head` and `slow` start to move at the same time, they will meet at the start of the cycle, that is the answer.

```
Time  Complexity: O(N)
Space Complexity: O(1)
```

**Python**
```
class Solution(object):
    def detectCycle(self, head):
        slow = fast = head
        while fast and fast.next:
            slow, fast = slow.next, fast.next.next
            if slow == fast: break
        else: return None  # if not (fast and fast.next): return None
        while head != slow:
            head, slow = head.next, slow.next
        return head
```

**C++**
```
class Solution {
public:
    ListNode *detectCycle(ListNode *head) {
        ListNode *slow = head, *fast = head;
        while (fast && fast->next) {
            slow = slow->next;
            fast = fast->next->next;
            if (slow == fast) break;
        }
        if (!(fast && fast->next)) return NULL;
        while (head != slow) {
            head = head->next;
            slow = slow->next;
        }
        return head;
    }
};
```

**Java**
```
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) break;
        }
        if (fast == null || fast.next == null) return null;
        while (head != slow) {
            head = head.next;
            slow = slow.next;
        }
        return head;
    }
}
```

**PLEASE UPVOTE if you like** \uD83D\uDE01 **If you have any question, feel free to ask.**

</details>
