# Reorder List

| Field | Value |
|-------|-------|
| **Platform** | LeetCode |
| **Difficulty** | Medium |
| **Language** | java |
| **Solved On** | November 26, 2026 |
| **Tags** | Linked List, Two Pointers, Stack, Recursion |
| **Link** | [View Problem](https://leetcode.com/problems/reorder-list/) |
| **Runtime** | 2 ms |
| **Memory** | 48.6 MB |

## Problem Description

<p>You are given the head of a singly linked-list. The list can be represented as:</p>

<pre>L<sub>0</sub> → L<sub>1</sub> → … → L<sub>n - 1</sub> → L<sub>n</sub>
</pre>

<p><em>Reorder the list to be on the following form:</em></p>

<pre>L<sub>0</sub> → L<sub>n</sub> → L<sub>1</sub> → L<sub>n - 1</sub> → L<sub>2</sub> → L<sub>n - 2</sub> → …
</pre>

<p>You may not modify the values in the list's nodes. Only nodes themselves may be changed.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/03/04/reorder1linked-list.jpg" style="width: 422px; height: 222px;">
<pre><strong>Input:</strong> head = [1,2,3,4]
<strong>Output:</strong> [1,4,2,3]
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/03/09/reorder2-linked-list.jpg" style="width: 542px; height: 222px;">
<pre><strong>Input:</strong> head = [1,2,3,4,5]
<strong>Output:</strong> [1,5,2,4,3]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of nodes in the list is in the range <code>[1, 5 * 10<sup>4</sup>]</code>.</li>
	<li><code>1 &lt;= Node.val &lt;= 1000</code></li>
</ul>


##  Top Community Optimal Approach

<details>
<summary>Click to expand</summary>

**Title**: Java solution with 3 steps
**Author**: [@wanqing](https://leetcode.com/wanqing/)
**Upvotes**: 622 👍
**Link**: [View Original Post](https://leetcode.com/problems/reorder-list/solutions/44992/)

---

This question is a combination of **Reverse a linked list I & II**. It should be pretty straight forward to do it in 3 steps :)

    public void reorderList(ListNode head) {
                if(head==null||head.next==null) return;
                
                //Find the middle of the list
                ListNode p1=head;
                ListNode p2=head;
                while(p2.next!=null&&p2.next.next!=null){ 
                    p1=p1.next;
                    p2=p2.next.next;
                }
                
                //Reverse the half after middle  1->2->3->4->5->6 to 1->2->3->6->5->4
                ListNode preMiddle=p1;
                ListNode preCurrent=p1.next;
                while(preCurrent.next!=null){
                    ListNode current=preCurrent.next;
                    preCurrent.next=current.next;
                    current.next=preMiddle.next;
                    preMiddle.next=current;
                }
                
                //Start reorder one by one  1->2->3->6->5->4 to 1->6->2->5->3->4
                p1=head;
                p2=preMiddle.next;
                while(p1!=preMiddle){
                    preMiddle.next=p2.next;
                    p2.next=p1.next;
                    p1.next=p2;
                    p1=p2.next;
                    p2=preMiddle.next;
                }
            }

</details>
