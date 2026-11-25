# Odd Even Linked List

| Field | Value |
|-------|-------|
| **Platform** | LeetCode |
| **Difficulty** | Medium |
| **Language** | java |
| **Solved On** | November 25, 2026 |
| **Tags** | Linked List |
| **Link** | [View Problem](https://leetcode.com/problems/odd-even-linked-list/) |
| **Runtime** | 0 ms |
| **Memory** | 46 MB |

## Problem Description

<p>Given the <code>head</code> of a singly linked list, group all the nodes with odd indices together followed by the nodes with even indices, and return <em>the reordered list</em>.</p>

<p>The <strong>first</strong> node is considered <strong>odd</strong>, and the <strong>second</strong> node is <strong>even</strong>, and so on.</p>

<p>Note that the relative order inside both the even and odd groups should remain as it was in the input.</p>

<p>You must solve the problem&nbsp;in <code>O(1)</code>&nbsp;extra space complexity and <code>O(n)</code> time complexity.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/03/10/oddeven-linked-list.jpg" style="width: 300px; height: 123px;">
<pre><strong>Input:</strong> head = [1,2,3,4,5]
<strong>Output:</strong> [1,3,5,2,4]
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/03/10/oddeven2-linked-list.jpg" style="width: 500px; height: 142px;">
<pre><strong>Input:</strong> head = [2,1,3,5,6,4,7]
<strong>Output:</strong> [2,3,6,7,1,5,4]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of nodes in the linked list is in the range <code>[0, 10<sup>4</sup>]</code>.</li>
	<li><code>-10<sup>6</sup> &lt;= Node.val &lt;= 10<sup>6</sup></code></li>
</ul>


##  Top Community Optimal Approach

<details>
<summary>Click to expand</summary>

**Title**: JAVA | 2 Solutions | Explanation Using Image | Without Space
**Author**: [@Chaitanya1706](https://leetcode.com/Chaitanya1706/)
**Upvotes**: 135 👍
**Link**: [View Original Post](https://leetcode.com/problems/odd-even-linked-list/solutions/1606975/)

---

**Intution:** Basic idea is just group all the nodes onr for even indices and one for odd indices and then the even indices group will come after odd indices group.

**Approach 1:** Let Split our linked list into odd even index element list then concat even index element list head to odd index element list tail (It is still efficient...beats 100% submission)
Time Complexity : O(n)
Space Complexity : O(1)

```
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head==null || head.next==null) return head;
        
        ListNode oddHead = null, oddTail = null;
        ListNode evenHead = null, evenTail = null;
        ListNode curr = head;
        int i = 1;
        while(curr!=null){
			// generate the odd indices list
            if(i%2==1){
                if(oddHead==null){
                    oddHead = curr;
                    oddTail = curr;
                }
                else{
                    oddTail.next = curr;
                    oddTail = oddTail.next;
                }
            }
			// generate the even indices list
            else{
                if(evenHead==null){
                    evenHead = curr;
                    evenTail = curr;
                }
                else{
                    evenTail.next = curr;
                    evenTail = evenTail.next;
                }
            }
            curr = curr.next;
            i++;
        }
        
        evenTail.next = null;     // there should not be any node after even tail
        oddTail.next  = evenHead;   // join even list after odd
        return oddHead;
    
    }
}
```

**Approach 2:** Two Pointer and Constant space by just updating the pointers
Time Complexity : O(n)
Space Complexity : O(1)

**Explanation:**
![image](https://assets.leetcode.com/users/images/ed7dcc3f-ffcb-4861-b9e7-3f9481c0947a_1638409853.4420247.jpeg)

```
class Solution {
    public ListNode oddEvenList(ListNode head) {
        
		if(head==null) return head;
		
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;
        
        while(even!=null && even.next!=null){
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        
        odd.next = evenHead;
        
        return head;
    }
}
```

** Well If you reached here....thanks for reading!!

</details>
