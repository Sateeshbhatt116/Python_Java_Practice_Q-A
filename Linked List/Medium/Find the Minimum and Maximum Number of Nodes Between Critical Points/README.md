# Find the Minimum and Maximum Number of Nodes Between Critical Points

| Field | Value |
|-------|-------|
| **Platform** | LeetCode |
| **Difficulty** | Medium |
| **Language** | java |
| **Solved On** | August 31, 2026 |
| **Tags** | Linked List |
| **Link** | [View Problem](https://leetcode.com/problems/find-the-minimum-and-maximum-number-of-nodes-between-critical-points/) |
| **Runtime** | 0 ms |
| **Memory** | 42.9 MB |

## Problem Description

<p>A <strong>critical point</strong> in a linked list is defined as <strong>either</strong> a <strong>local maxima</strong> or a <strong>local minima</strong>.</p>

<p>A node is a <strong>local maxima</strong> if the current node has a value <strong>strictly greater</strong> than the previous node and the next node.</p>

<p>A node is a <strong>local minima</strong> if the current node has a value <strong>strictly smaller</strong> than the previous node and the next node.</p>

<p>Note that a node can only be a local maxima/minima if there exists <strong>both</strong> a previous node and a next node.</p>

<p>Given a linked list <code>head</code>, return <em>an array of length 2 containing </em><code>[minDistance, maxDistance]</code><em> where </em><code>minDistance</code><em> is the <strong>minimum distance</strong> between <strong>any&nbsp;two distinct</strong> critical points and </em><code>maxDistance</code><em> is the <strong>maximum distance</strong> between <strong>any&nbsp;two distinct</strong> critical points. If there are <strong>fewer</strong> than two critical points, return </em><code>[-1, -1]</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/10/13/a1.png" style="width: 148px; height: 55px;">
<pre><strong>Input:</strong> head = [3,1]
<strong>Output:</strong> [-1,-1]
<strong>Explanation:</strong> There are no critical points in [3,1].
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/10/13/a2.png" style="width: 624px; height: 46px;">
<pre><strong>Input:</strong> head = [5,3,1,2,5,1,2]
<strong>Output:</strong> [1,3]
<strong>Explanation:</strong> There are three critical points:
- [5,3,<strong><u>1</u></strong>,2,5,1,2]: The third node is a local minima because 1 is less than 3 and 2.
- [5,3,1,2,<u><strong>5</strong></u>,1,2]: The fifth node is a local maxima because 5 is greater than 2 and 1.
- [5,3,1,2,5,<u><strong>1</strong></u>,2]: The sixth node is a local minima because 1 is less than 5 and 2.
The minimum distance is between the fifth and the sixth node. minDistance = 6 - 5 = 1.
The maximum distance is between the third and the sixth node. maxDistance = 6 - 3 = 3.
</pre>

<p><strong class="example">Example 3:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/10/14/a5.png" style="width: 624px; height: 39px;">
<pre><strong>Input:</strong> head = [1,3,2,2,3,2,2,2,7]
<strong>Output:</strong> [3,3]
<strong>Explanation:</strong> There are two critical points:
- [1,<u><strong>3</strong></u>,2,2,3,2,2,2,7]: The second node is a local maxima because 3 is greater than 1 and 2.
- [1,3,2,2,<u><strong>3</strong></u>,2,2,2,7]: The fifth node is a local maxima because 3 is greater than 2 and 2.
Both the minimum and maximum distances are between the second and the fifth node.
Thus, minDistance and maxDistance is 5 - 2 = 3.
Note that the last node is not considered a local maxima because it does not have a next node.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of nodes in the list is in the range <code>[2, 10<sup>5</sup>]</code>.</li>
	<li><code>1 &lt;= Node.val &lt;= 10<sup>5</sup></code></li>
</ul>


##  Top Community Optimal Approach

<details>
<summary>Click to expand</summary>

**Title**: ✅Easiest 3 Step Cpp / Java / Py / JS Solution | Normal Approach🏆|  With Explanation
**Author**: [@dev_yash_](https://leetcode.com/dev_yash_/)
**Upvotes**: 86 👍
**Link**: [View Original Post](https://leetcode.com/problems/find-the-minimum-and-maximum-number-of-nodes-between-critical-points/solutions/5418282/)

---

### \uD83C\uDF1F **Step-by-Step Breakdown** \uD83C\uDF1F  

**1. \uD83D\uDEB6 Traverse the Linked List:**  
Identify critical points (either local minima or maxima).  
- Use pointers (`prev`, `curr`, and `next`) to compare the current node\u2019s value with its neighbors.  
- Critical Point:  
  - **Peak:** `curr.val > prev.val && curr.val > next.val`  
  - **Valley:** `curr.val < prev.val && curr.val < next.val`  

---

**2. \uD83D\uDCDD Record Positions of Critical Points:**  
Store the indices of critical points in a list for later calculations.  
- If no critical points or just one, skip the distance calculations.

---

**3. \uD83D\uDCCF Calculate Distances:**  
- **Minimum Distance:** Find the smallest gap between consecutive critical points.  
- **Maximum Distance:** Compute the distance between the first and last critical points.  
- Return `[-1, -1]` if fewer than two critical points are found.

---

**\uD83C\uDFAF Return the Results:**  
- If critical points exist: return `[minDistance, maxDistance]`.  
- Otherwise: return `[-1, -1]`.  

---



### \uD83D\uDCBB C++
```
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */

class Solution {
public:
    vector<int> nodesBetweenCriticalPoints(ListNode* head) {
        vector<int> criticalPts;
        ListNode* prev = nullptr;
        ListNode* curr = head;
        int pos = 0;
        while (curr->next != nullptr) {
            // 1.Traverse and find points
            if (prev != nullptr) {
                // 2.check local min and max and record position
                if ((curr->val > prev->val && curr->val > curr->next->val) ||
                    (curr->val < prev->val && curr->val < curr->next->val)) {
                    criticalPts.push_back(pos);
                }
            }
            prev = curr;
            curr = curr->next;
            pos++;
        }
        if (criticalPts.size() < 2) {
            return {-1, -1};
        }

        // 3. Calculate Distances
        int minDist = INT_MAX;
        int maxDist = criticalPts.back() - criticalPts.front();
        for (int i = 1; i < criticalPts.size(); i++) {
            minDist = min(minDist, criticalPts[i] - criticalPts[i - 1]);
        }

        // return ans
        return {minDist, maxDist};
    }
};

```
### Java
```
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return new int[]{-1, -1};
        }

        List<Integer> criticalPts = new ArrayList<>();
        ListNode prev = null;
        ListNode curr = head;
        int pos = 0;

        while (curr != null && curr.next != null) {
            // 1. Traverse and find points
            if (prev != null) {
                // 2. Check local min and max and record position
                if ((curr.val > prev.val && curr.val > curr.next.val) ||
                    (curr.val < prev.val && curr.val < curr.next.val)) {
                    criticalPts.add(pos);
                }
            }
            prev = curr;
            curr = curr.next;
            pos++;
        }

        if (criticalPts.size() < 2) {
            return new int[]{-1, -1};
        }

        // 3. Calculate Distances
        int minDist = Integer.MAX_VALUE;
        int maxDist = criticalPts.get(criticalPts.size() - 1) - criticalPts.get(0);

        for (int i = 1; i < criticalPts.size(); i++) {
            minDist = Math.min(minDist, criticalPts.get(i) - criticalPts.get(i - 1));
        }

        // return ans
        return new int[]{minDist, maxDist};
    }
}
```

### Python3
```
class Solution:
    def nodesBetweenCriticalPoints(self, head: Optional[ListNode]) -> List[int]:
        if not head or not head.next or not head.next.next:
            return [-1, -1]

        criticalPts = []  
        prev = head
        curr = head.next
        pos = 1  

        while curr.next:
            # 1. Traverse and find points
            if (curr.val > prev.val and curr.val > curr.next.val) or (curr.val < prev.val and curr.val < curr.next.val):
                criticalPts.append(pos)  # Record position of critical points
            prev = curr
            curr = curr.next
            pos += 1  

        if len(criticalPts) < 2:
            return [-1, -1]

        # 2. Calculate Distances
        minDist = float(\'inf\')
        maxDist = criticalPts[-1] - criticalPts[0]

        for i in range(1, len(criticalPts)):
            minDist = min(minDist, criticalPts[i] - criticalPts[i - 1])  # Find the minimum distance

        # Return the result
        return [minDist, maxDist]

```
### JavaScript
```
/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val === undefined ? 0 : val);
 *     this.next = (next === undefined ? null : next);
 * }
 */
/**
 * @param {ListNode} head
 * @return {number[]}
 */
var nodesBetweenCriticalPoints = function(head) {
    if (!head || !head.next || !head.next.next) {
        return [-1, -1];
    }

    const criticalPts = []; 
    let prev = head;
    let curr = head.next;
    let pos = 1;  

    while (curr.next) {
        // 1. Traverse and find points
        if ((curr.val > prev.val && curr.val > curr.next.val) || (curr.val < prev.val && curr.val < curr.next.val)) {
            criticalPts.push(pos);  // Record position of critical points
        }
        prev = curr;
        curr = curr.next;
        pos++; 
    }

    if (criticalPts.length < 2) {
        return [-1, -1];
    }

    // 2. Calculate Distances
    let minDist = Infinity;
    let maxDist = criticalPts[criticalPts.length - 1] - criticalPts[0];

    for (let i = 1; i < criticalPts.length; i++) {
        minDist = Math.min(minDist, criticalPts[i] - criticalPts[i - 1]);  // Find the minimum distance
    }

    // Return the result
    return [minDist, maxDist];
};


```
#### STAY COOL STAY DISCIPLINED..

![image](https://assets.leetcode.com/users/images/ad294515-01e3-4704-a668-9bcc5b0e822c_1717851160.1975598.gif)

</details>
