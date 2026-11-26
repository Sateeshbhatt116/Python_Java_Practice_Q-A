# Merge k Sorted Lists

| Field | Value |
|-------|-------|
| **Platform** | LeetCode |
| **Difficulty** | Hard |
| **Language** | java |
| **Solved On** | November 26, 2026 |
| **Tags** | Linked List, Divide and Conquer, Heap (Priority Queue), Merge Sort, Tournament Sort |
| **Link** | [View Problem](https://leetcode.com/problems/merge-k-sorted-lists/) |
| **Runtime** | 6 ms |
| **Memory** | 46.4 MB |

## Problem Description

<p>You are given an array of <code>k</code> linked-lists <code>lists</code>, each linked-list is sorted in ascending order.</p>

<p><em>Merge all the linked-lists into one sorted linked-list and return it.</em></p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> lists = [[1,4,5],[1,3,4],[2,6]]
<strong>Output:</strong> [1,1,2,3,4,4,5,6]
<strong>Explanation:</strong> The linked-lists are:
[
  1-&gt;4-&gt;5,
  1-&gt;3-&gt;4,
  2-&gt;6
]
merging them into one sorted linked list:
1-&gt;1-&gt;2-&gt;3-&gt;4-&gt;4-&gt;5-&gt;6
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> lists = []
<strong>Output:</strong> []
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> lists = [[]]
<strong>Output:</strong> []
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>k == lists.length</code></li>
	<li><code>0 &lt;= k &lt;= 10<sup>4</sup></code></li>
	<li><code>0 &lt;= lists[i].length &lt;= 500</code></li>
	<li><code>-10<sup>4</sup> &lt;= lists[i][j] &lt;= 10<sup>4</sup></code></li>
	<li><code>lists[i]</code> is sorted in <strong>ascending order</strong>.</li>
	<li>The sum of <code>lists[i].length</code> will not exceed <code>10<sup>4</sup></code>.</li>
</ul>


##  Top Community Optimal Approach

<details>
<summary>Click to expand</summary>

**Title**: A java solution based on Priority Queue
**Author**: [@reeclapple](https://leetcode.com/reeclapple/)
**Upvotes**: 758 👍
**Link**: [View Original Post](https://leetcode.com/problems/merge-k-sorted-lists/solutions/10528/)

---

If someone understand how priority queue works, then it would be trivial to walk through the codes. 

My question: is that possible to solve this question under the same time complexity without implementing the priority queue?


    public class Solution {
        public ListNode mergeKLists(List<ListNode> lists) {
            if (lists==null||lists.size()==0) return null;
            
            PriorityQueue<ListNode> queue= new PriorityQueue<ListNode>(lists.size(),new Comparator<ListNode>(){
                @Override
                public int compare(ListNode o1,ListNode o2){
                    if (o1.val<o2.val)
                        return -1;
                    else if (o1.val==o2.val)
                        return 0;
                    else 
                        return 1;
                }
            });
            
            ListNode dummy = new ListNode(0);
            ListNode tail=dummy;
            
            for (ListNode node:lists)
                if (node!=null)
                    queue.add(node);
                
            while (!queue.isEmpty()){
                tail.next=queue.poll();
                tail=tail.next;
                
                if (tail.next!=null)
                    queue.add(tail.next);
            }
            return dummy.next;
        }
    }

</details>
