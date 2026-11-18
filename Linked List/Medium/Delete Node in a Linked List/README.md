# Delete Node in a Linked List

| Field | Value |
|-------|-------|
| **Platform** | LeetCode |
| **Difficulty** | Medium |
| **Language** | java |
| **Solved On** | November 18, 2026 |
| **Tags** | Linked List |
| **Link** | [View Problem](https://leetcode.com/problems/delete-node-in-a-linked-list/) |
| **Runtime** | 0 ms |
| **Memory** | 44.6 MB |

## Problem Description

<p>There is a singly-linked list <code>head</code> and we want to delete a node <code>node</code> in it.</p>

<p>You are given the node to be deleted <code>node</code>. You will <strong>not be given access</strong> to the first node of <code>head</code>.</p>

<p>All the values of the linked list are <strong>unique</strong>, and it is guaranteed that the given node <code>node</code> is not the last node in the linked list.</p>

<p>Delete the given node. Note that by deleting the node, we do not mean removing it from memory. We mean:</p>

<ul>
	<li>The value of the given node should not exist in the linked list.</li>
	<li>The number of nodes in the linked list should decrease by one.</li>
	<li>All the values before <code>node</code> should be in the same order.</li>
	<li>All the values after <code>node</code> should be in the same order.</li>
</ul>

<p><strong>Custom testing:</strong></p>

<ul>
	<li>For the input, you should provide the entire linked list <code>head</code> and the node to be given <code>node</code>. <code>node</code> should not be the last node of the list and should be an actual node in the list.</li>
	<li>We will build the linked list and pass the node to your function.</li>
	<li>The output will be the entire list after calling your function.</li>
</ul>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/09/01/node1.jpg" style="width: 400px; height: 286px;">
<pre><strong>Input:</strong> head = [4,5,1,9], node = 5
<strong>Output:</strong> [4,1,9]
<strong>Explanation: </strong>You are given the second node with value 5, the linked list should become 4 -&gt; 1 -&gt; 9 after calling your function.
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/09/01/node2.jpg" style="width: 400px; height: 315px;">
<pre><strong>Input:</strong> head = [4,5,1,9], node = 1
<strong>Output:</strong> [4,5,9]
<strong>Explanation: </strong>You are given the third node with value 1, the linked list should become 4 -&gt; 5 -&gt; 9 after calling your function.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of the nodes in the given list is in the range <code>[2, 1000]</code>.</li>
	<li><code>-1000 &lt;= Node.val &lt;= 1000</code></li>
	<li>The value of each node in the list is <strong>unique</strong>.</li>
	<li>The <code>node</code> to be deleted is <strong>in the list</strong> and is <strong>not a tail</strong> node.</li>
</ul>


##  Top Community Optimal Approach

<details>
<summary>Click to expand</summary>

**Title**: ✅ Detailed Explanation🔥🔥Extremely Simple🔥1&2-liner🔥O(1) Time and Space Complexity🔥🔥🔥
**Author**: [@Saketh3011](https://leetcode.com/Saketh3011/)
**Upvotes**: 578 👍
**Link**: [View Original Post](https://leetcode.com/problems/delete-node-in-a-linked-list/solutions/5113147/)

---

# \uD83C\uDFAFProblem Explaination:
We have to delete the given node\'s val and delete a node from a singly-linked list without knowing its head or previous node. Not actual given node.
Given node is not tail node, so it will always have next node.
> Only question is hard to understand.
This is the easiest "Leetcode-Medium" I have seen so far.
Why is this Medium, not Easy?

# \uD83E\uDD14 Intuition
We know that previous node pointer to given node. What if we change given node value to next nodes and point `next` to `next.next`. It\'s essentially changing current node to next and deleting next. 

# \uD83E\uDDE0 Approach
To delete the given `node`, we copy the value of the next node to the current node and adjust the next pointer to skip the next node.
- Copy the value of the next node to the current node.
- Adjust the next pointer to skip the next node.

![image.png](https://assets.leetcode.com/users/images/1d9363ee-924a-48c9-a894-cbf5bec1e985_1714872196.8337712.png)

**Note:** We are not actually removing/deleting given node, as question might imply. To actually delete the `node`, we need to change the reference of the previous node\'s next pointer to skip over the given node. However, we do not have access to the previous node. 

# \uD83D\uDCD2 Complexity
- \u23F0 Time complexity: $$O(1)$$, as we\'re only modifying the current node
- \uD83E\uDDFASpace complexity: $$O(1)$$, no extra space is used.

# \uD83E\uDDD1\u200D\uD83D\uDCBB Code
``` python []
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def deleteNode(self, node: ListNode) -> None:
        node.val = node.next.val
        node.next = node.next.next

        ## alternative, one liner
        # node.val, node.next = node.next.val, node.next.next
```
``` java []
class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
```
``` cpp []
class Solution {
public:
    void deleteNode(ListNode* node) {
        node->val = node->next->val;
        node->next = node->next->next;

    // Alternative, we can copy next node\'s properties directly with
        // *node = *node->next;
    }
};
```
```javascript []
var deleteNode = function(node) {
    node.val = node.next.val;
    node.next = node.next.next;

// alternative 
    // Object.assign(node, node.next);
};
```
``` kotlin []
class Solution {
    fun deleteNode(node: ListNode?){
         if (node != null) {
            node.`val` = node.next.`val`
            node.next = node.next.next
        }
    }
}
```

---
## Unused Memory Deletion
In Python, Java, JavaScript and Kotlin garbage collector will then handle the deallocation of memory / deleting next node. 
But in _C++_ we have to manually delete next node from memory.

``` cpp []
class Solution {
public:
    void deleteNode(ListNode* node) {
        ListNode* nextNode = node -> next;
        node->val = node->next->val;
        node->next = node->next->next;
        delete nextNode;
    }
};
```
``` cpp []
class Solution {
public:
    void deleteNode(ListNode* node) {
        ListNode* temp = node->next;
        *node = *node->next;
        delete temp;
    }
};
```

---
# Please consider giving an Upvote!
![upvote.png](https://assets.leetcode.com/users/images/5fbeecf2-18f6-4dce-a4a0-f11c859e46ad_1714711173.2665718.png)

</details>
