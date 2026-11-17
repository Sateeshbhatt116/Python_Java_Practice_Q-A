# Minimum Positive Sum Subarray

| Field | Value |
|-------|-------|
| **Platform** | LeetCode |
| **Difficulty** | Easy |
| **Language** | java |
| **Solved On** | November 17, 2026 |
| **Tags** | Array, Sliding Window, Prefix Sum |
| **Link** | [View Problem](https://leetcode.com/problems/minimum-positive-sum-subarray/) |
| **Runtime** | 2 ms |
| **Memory** | 45.9 MB |

## Problem Description

<p>You are given an integer array <code>nums</code> and <strong>two</strong> integers <code>l</code> and <code>r</code>. Your task is to find the <strong>minimum</strong> sum of a <strong>subarray</strong> whose size is between <code>l</code> and <code>r</code> (inclusive) and whose sum is greater than 0.</p>

<p>Return the <strong>minimum</strong> sum of such a subarray. If no such subarray exists, return -1.</p>

<p>A <strong>subarray</strong> is a contiguous <b>non-empty</b> sequence of elements within an array.</p>

<p>&nbsp;</p>
<p><span class="float-right -my-0.5 ml-2 inline-flex select-none items-center" data-example-lang-controls=""><span role="group" class="inline-flex h-6 items-center rounded-sd-md bg-sd-muted p-0.5" data-example-lang-toggle=""><button type="button" aria-pressed="true" class="h-5 max-w-[10rem] truncate whitespace-nowrap rounded-sd-sm border px-2 text-xs font-normal leading-none border-sd-border bg-sd-background text-sd-foreground">Original</button><button type="button" aria-pressed="false" class="h-5 max-w-[10rem] truncate whitespace-nowrap rounded-sd-sm border px-2 text-xs font-normal leading-none border-transparent text-sd-muted-foreground hover:text-sd-foreground">Java</button></span></span><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [3, -2, 1, 4], l = 2, r = 3</span></p>

<p><strong>Output:</strong> <span class="example-io">1</span></p>

<p><strong>Explanation:</strong></p>

<p>The subarrays of length between <code>l = 2</code> and <code>r = 3</code> where the sum is greater than 0 are:</p>

<ul>
	<li><code>[3, -2]</code> with a sum of 1</li>
	<li><code>[1, 4]</code> with a sum of 5</li>
	<li><code>[3, -2, 1]</code> with a sum of 2</li>
	<li><code>[-2, 1, 4]</code> with a sum of 3</li>
</ul>

<p>Out of these, the subarray <code>[3, -2]</code> has a sum of 1, which is the smallest positive sum. Hence, the answer is 1.</p>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [-2, 2, -3, 1], l = 2, r = 3</span></p>

<p><strong>Output:</strong> <span class="example-io">-1</span></p>

<p><strong>Explanation:</strong></p>

<p>There is no subarray of length between <code>l</code> and <code>r</code> that has a sum greater than 0. So, the answer is -1.</p>
</div>

<p><strong class="example">Example 3:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [1, 2, 3, 4], l = 2, r = 4</span></p>

<p><strong>Output:</strong> <span class="example-io">3</span></p>

<p><strong>Explanation:</strong></p>

<p>The subarray <code>[1, 2]</code> has a length of 2 and the minimum sum greater than 0. So, the answer is 3.</p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 100</code></li>
	<li><code>1 &lt;= l &lt;= r &lt;= nums.length</code></li>
	<li><code>-1000 &lt;= nums[i] &lt;= 1000</code></li>
</ul>


##  Top Community Optimal Approach

<details>
<summary>Click to expand</summary>

**Title**: Java treemap+ prefix sum || Nlogn Time complexity||
**Author**: [@new_born2023](https://leetcode.com/new_born2023/)
**Upvotes**: 4 👍
**Link**: [View Original Post](https://leetcode.com/problems/minimum-positive-sum-subarray/solutions/6077663/)

---

```
class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n = nums.size();
        int[] pre = new int[n];
        for (int i = 0; i < n; i++) {
            int res = (i == 0 ? 0 : pre[i - 1]) + nums.get(i);
            pre[i] = res;
        }
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int best = Integer.MAX_VALUE;
        int count = 0;
        for (int i = l - 1; i < n; i++) {
            int toAdd = i >= l ? pre[i - l] : 0;
            map.put(toAdd, map.getOrDefault(toAdd, 0) + 1);
            count++;
            if (count > r - l + 1) {
                int toRemove = i > r ? pre[i - r - 1] : 0;
                map.put(toRemove, map.get(toRemove) - 1);
                if (map.get(toRemove) == 0) map.remove(toRemove);
                count--;
            }
            Integer closest = map.lowerKey(pre[i]);
            if (closest != null) {
                best = Math.min(best, pre[i] - closest);
            }
        }
        return best == Integer.MAX_VALUE ? -1 : best;
    }
}
```

</details>
