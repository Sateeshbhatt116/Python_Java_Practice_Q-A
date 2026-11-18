# Palindrome Linked List

| Field | Value |
|-------|-------|
| **Platform** | LeetCode |
| **Difficulty** | Easy |
| **Language** | java |
| **Solved On** | November 18, 2026 |
| **Tags** | Linked List, Two Pointers, Stack, Recursion |
| **Link** | [View Problem](https://leetcode.com/problems/palindrome-linked-list/) |
| **Runtime** | 7 ms |
| **Memory** | 99.3 MB |

## Problem Description

<p>Given the <code>head</code> of a singly linked list, return <code>true</code><em> if it is a </em><span data-keyword="palindrome-sequence" class=" cursor-pointer relative text-dark-blue-s text-sm"><button type="button" aria-haspopup="dialog" aria-expanded="false" aria-controls="radix-_r_f6_" data-state="closed" class=""><em>palindrome</em></button></span><em> or </em><code>false</code><em> otherwise</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/03/03/pal1linked-list.jpg" style="width: 422px; height: 62px;">
<pre><strong>Input:</strong> head = [1,2,2,1]
<strong>Output:</strong> true
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/03/03/pal2linked-list.jpg" style="width: 182px; height: 62px;">
<pre><strong>Input:</strong> head = [1,2]
<strong>Output:</strong> false
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of nodes in the list is in the range <code>[1, 10<sup>5</sup>]</code>.</li>
	<li><code>0 &lt;= Node.val &lt;= 9</code></li>
</ul>

<p>&nbsp;</p>
<strong>Follow up:</strong> Could you do it in <code>O(n)</code> time and <code>O(1)</code> space?

##  Top Community Optimal Approach

<details>
<summary>Click to expand</summary>

**Title**: JS, Python, Java, C++ | Easy Floyd's + Reversal Solution w/ Explanation
**Author**: [@sgallivan](https://leetcode.com/sgallivan/)
**Upvotes**: 1822 👍
**Link**: [View Original Post](https://leetcode.com/problems/palindrome-linked-list/solutions/1137027/)

---

*(Note: This is part of a series of Leetcode solution explanations. If you like this solution or find it useful,* ***please upvote*** *this post.)*

---

#### ***Idea:***

The naive approach here would be to run through the linked list and create an array of its values, then compare the array to its reverse to find out if it\'s a palindrome. Though this is easy enough to accomplish, we\'re challenged to find an approach with a **space complexity** of only **O(1)** while maintaining a **time complexity** of **O(N)**.

The only way to check for a palindrome in **O(1) space** would require us to be able to access both nodes for comparison at the same time, rather than storing values for later comparison. This would seem to be a challenge, as the linked list only promotes travel in one direction.

But what if it didn\'t?

The answer is to reverse the back half of the linked list to have the **next** attribute point to the previous node instead of the next node. (*Note: we could instead add a **prev** attribute as we iterate through the linked list, rather than overwriting **next** on the back half, but that would technically use **O(N) extra space**, just as if we\'d created an external array of node values.*)

The first challenge then becomes finding the middle of the linked list in order to start our reversing process there. For that, we can look to [**Floyd\'s Cycle Detection Algorithm**](https://en.wikipedia.org/wiki/Cycle_detection#Floyd\'s_tortoise_and_hare).

With Floyd\'s, we\'ll travel through the linked list with **two pointers**, one of which is moving twice as fast as the other. When the **fast** pointer reaches the end of the list, the **slow** pointer must then be in the middle.
![Diagram 1](https://i.imgur.com/RERjbdB.png)
With **slow** now at the middle, we can reverse the back half of the list with the help of another variable to contain a reference to the previous node (**prev**) and a three-way swap. Before we do this, however, we\'ll want to set **prev.next = null**, so that we break the reverse cycle and avoid an endless loop.
![Diagram 2](https://i.imgur.com/mjbMYP4.png)
Once the back half is properly reversed and **slow** is once again at the end of the list, we can now start **fast** back over again at the **head** and compare the two halves simultaneously, with no extra space required.
![Diagram 3](https://i.imgur.com/EL3Fwze.png)
If the two pointers ever disagree in value, we can **return false**, otherwise we can **return true** if both pointers reach the middle successfully.

(*Note: This process works regardless of whether the length of the linked list is odd or even, as the comparison will stop when **slow** reaches the "dead-end" node.*)

![Diagram 4](https://i.imgur.com/Q4skHkb.png)

---

#### ***Implementation:***

The code for all four languages is almost identical.

---

#### ***Javascript Code:***
```javascript
var isPalindrome = function(head) {
    let slow = head, fast = head, prev, temp
    while (fast && fast.next)
        slow = slow.next, fast = fast.next.next
    prev = slow, slow = slow.next, prev.next = null
    while (slow)
        temp = slow.next, slow.next = prev, prev = slow, slow = temp
    fast = head, slow = prev
    while (slow)
        if (fast.val !== slow.val) return false
        else fast = fast.next, slow = slow.next
    return true
};
```

---

#### ***Python Code:***
```python
class Solution:
    def isPalindrome(self, head: ListNode) -> bool:
        slow, fast, prev = head, head, None
        while fast and fast.next:
            slow, fast = slow.next, fast.next.next
        prev, slow, prev.next = slow, slow.next, None
        while slow:
            slow.next, prev, slow = prev, slow, slow.next
        fast, slow = head, prev
        while slow:
            if fast.val != slow.val: return False
            fast, slow = fast.next, slow.next
        return True
```

---

#### ***Java Code:***
```java
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head, prev, temp;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        prev = slow;
        slow = slow.next;
        prev.next = null;
        while (slow != null) {
            temp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = temp;
        }
        fast = head;
        slow = prev;
        while (slow != null) {
            if (fast.val != slow.val) return false;
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }
}
```

---

#### ***C++ Code:***
```c++
class Solution {
public:
    bool isPalindrome(ListNode* head) {
        ListNode *slow = head, *fast = head, *prev, *temp;
        while (fast && fast->next)
            slow = slow->next, fast = fast->next->next;
        prev = slow, slow = slow->next, prev->next = NULL;
        while (slow)
            temp = slow->next, slow->next = prev, prev = slow, slow = temp;
        fast = head, slow = prev;
        while (slow)
            if (fast->val != slow->val) return false;
            else fast = fast->next, slow = slow->next;
        return true;
    }
};
```

</details>
