# Find Subtree Sizes After Changes

| Field | Value |
|-------|-------|
| **Platform** | LeetCode |
| **Difficulty** | Medium |
| **Language** | java |
| **Solved On** | November 21, 2026 |
| **Tags** | Array, Hash Table, String, Tree, Depth-First Search |
| **Link** | [View Problem](https://leetcode.com/problems/find-subtree-sizes-after-changes/) |
| **Runtime** | 30 ms |
| **Memory** | 152.7 MB |

## Problem Description

<p>You are given a tree rooted at node 0 that consists of <code>n</code> nodes numbered from <code>0</code> to <code>n - 1</code>. The tree is represented by an array <code>parent</code> of size <code>n</code>, where <code>parent[i]</code> is the parent of node <code>i</code>. Since node 0 is the root, <code>parent[0] == -1</code>.</p>

<p>You are also given a string <code>s</code> of length <code>n</code>, where <code>s[i]</code> is the character assigned to node <code>i</code>.</p>

<p>We make the following changes on the tree <strong>one</strong> time <strong>simultaneously</strong> for all nodes <code>x</code> from <code>1</code> to <code>n - 1</code>:</p>

<ul>
	<li>Find the <strong>closest</strong> node <code>y</code> to node <code>x</code> such that <code>y</code> is an ancestor of <code>x</code>, and <code>s[x] == s[y]</code>.</li>
	<li>If node <code>y</code> does not exist, do nothing.</li>
	<li>Otherwise, <strong>remove</strong> the edge between <code>x</code> and its current parent and make node <code>y</code> the new parent of <code>x</code> by adding an edge between them.</li>
</ul>

<p>Return an array <code>answer</code> of size <code>n</code> where <code>answer[i]</code> is the <strong>size</strong> of the <span data-keyword="subtree" class=" cursor-pointer relative text-dark-blue-s text-sm"><button type="button" aria-haspopup="dialog" aria-expanded="false" aria-controls="radix-_r_u_" data-state="closed" class="">subtree</button></span> rooted at node <code>i</code> in the <strong>final</strong> tree.</p>

<p>&nbsp;</p>
<p><span class="float-right -my-0.5 ml-2 inline-flex select-none items-center" data-example-lang-controls=""><span role="group" class="inline-flex h-6 items-center rounded-sd-md bg-sd-muted p-0.5" data-example-lang-toggle=""><button type="button" aria-pressed="true" class="h-5 max-w-[10rem] truncate whitespace-nowrap rounded-sd-sm border px-2 text-xs font-normal leading-none border-sd-border bg-sd-background text-sd-foreground">Original</button><button type="button" aria-pressed="false" class="h-5 max-w-[10rem] truncate whitespace-nowrap rounded-sd-sm border px-2 text-xs font-normal leading-none border-transparent text-sd-muted-foreground hover:text-sd-foreground">Java</button></span></span><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">parent = [-1,0,0,1,1,1], s = "abaabc"</span></p>

<p><strong>Output:</strong> <span class="example-io">[6,3,1,1,1,1]</span></p>

<p><strong>Explanation:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2024/08/15/graphex1drawio.png" style="width: 230px; height: 277px;">
<p>The parent of node 3 will change from node 1 to node 0.</p>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">parent = [-1,0,4,0,1], s = "abbba"</span></p>

<p><strong>Output:</strong> <span class="example-io">[5,2,1,1,1]</span></p>

<p><strong>Explanation:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2024/08/20/exgraph2drawio.png" style="width: 160px; height: 308px;">
<p>The following changes will happen at the same time:</p>

<ul>
	<li>The parent of node 4 will change from node 1 to node 0.</li>
	<li>The parent of node 2 will change from node 4 to node 1.</li>
</ul>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>n == parent.length == s.length</code></li>
	<li><code>1 &lt;= n &lt;= 10<sup>5</sup></code></li>
	<li><code>0 &lt;= parent[i] &lt;= n - 1</code> for all <code>i &gt;= 1</code>.</li>
	<li><code>parent[0] == -1</code></li>
	<li><code>parent</code> represents a valid tree.</li>
	<li><code>s</code> consists only of lowercase English letters.</li>
</ul>


##  Top Community Optimal Approach

<details>
<summary>Click to expand</summary>

**Title**: Java code ✅
**Author**: [@deleted_user](https://leetcode.com/deleted_user/)
**Upvotes**: 11 👍
**Link**: [View Original Post](https://leetcode.com/problems/find-subtree-sizes-after-changes/solutions/5971320/)

---

### Approach
1. **Tree Representation**: Construct an adjacency list to represent the tree based on the `parent` array.
2. **Adjust Parents**: Use a DFS traversal to adjust the parents based on the last seen characters in the string `s`.
3. **Count Subtree Sizes**: Perform another DFS traversal to calculate the sizes of the subtrees and store them in the `answer` array.

### Complexity
- **Time**: \\( O(n) \\), where \\( n \\) is the number of nodes (length of `parent`).
- **Space**: \\( O(n) \\) for the adjacency list and the `answer` array.

### Code
```java
class Solution {
    public int[] findSubtreeSizes(int[] parent, String s) {
        int n = parent.length;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 1; i < n; i++) {
            adj.get(parent[i]).add(i);
        }

        int[] newParent = Arrays.copyOf(parent, n);
        Map<Character, Integer> lastSeen = new HashMap<>();
        dfsAdjustParent(0, s, adj, lastSeen, newParent);

        List<List<Integer>> finalAdj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            finalAdj.add(new ArrayList<>());
        }
        for (int i = 1; i < n; i++) {
            finalAdj.get(newParent[i]).add(i);
        }

        int[] answer = new int[n];
        dfsCountSubtreeSizes(0, finalAdj, answer);
        
        return answer;
    }

    public void dfsAdjustParent(int node, String s, List<List<Integer>> adj, Map<Character, Integer> lastSeen, int[] newParent) {
        char c = s.charAt(node);
        Integer prev = lastSeen.get(c);
        if (prev != null && prev != newParent[node]) {
            newParent[node] = prev;
        }

        Integer originalParent = lastSeen.put(c, node);
        for (int child : adj.get(node)) {
            dfsAdjustParent(child, s, adj, lastSeen, newParent);
        }
        if (originalParent == null) {
            lastSeen.remove(c);
        } else {
            lastSeen.put(c, originalParent);
        }
    }

    public int dfsCountSubtreeSizes(int node, List<List<Integer>> adj, int[] answer) {
        int size = 1;
        for (int child : adj.get(node)) {
            size += dfsCountSubtreeSizes(child, adj, answer);
        }
        answer[node] = size;
        return size;
    }
}
```

### Upvote if you found this helpful! \uD83D\uDE0A

</details>
