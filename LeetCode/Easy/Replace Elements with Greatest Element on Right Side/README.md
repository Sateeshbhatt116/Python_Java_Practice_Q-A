# Replace Elements with Greatest Element on Right Side

| Field | Value |
|-------|-------|
| **Platform** | LeetCode |
| **Difficulty** | Easy |
| **Language** | java |
| **Solved On** | August 25, 2026 |
| **Tags** | Array |
| **Link** | [View Problem](https://leetcode.com/problems/replace-elements-with-greatest-element-on-right-side/) |
| **Runtime** | 0 ms |
| **Memory** | 42.7 MB |

## Approach

1. Problem Restated:
   For every index i, arr[i] should become the maximum value found 
   anywhere to the RIGHT of i (not including arr[i] itself). The very 
   last element has nothing to its right, so it becomes -1.

2. Key Insight - Go Right to Left:
   If we scan from the end of the array backward, we can keep a 
   running "maximum seen so far" as we go. This running max always 
   represents "the greatest element to the right" of the current 
   index, since we're building it up from the elements we've already 
   passed (which are all to the right of where we currently are).

3. Step-by-Step:
   a) Start with a variable maxSoFar = -1 (this becomes the value for 
      the last index, since nothing exists to its right).
   b) Iterate i from the last index down to 0.
   c) At each index i, before overwriting arr[i], save its original 
      value in a temp variable (we need it to update maxSoFar AFTER 
      placing the current max into arr[i]).
   d) Set arr[i] = maxSoFar (this is the correct answer for position i, 
      based on everything to its right).
   e) Update maxSoFar = max(maxSoFar, temp) so it now accounts for the 
      original value at position i, ready for the next index to the 
      left.

4. Why Order of Operations Matters:
   We must assign arr[i] = maxSoFar BEFORE updating maxSoFar with 
   arr[i]'s original value - otherwise arr[i] would incorrectly 
   include itself in its own "max to the right" calculation.

5. In-Place Modification:
   Since we're overwriting arr[i] only after saving its original value 
   in a temp variable, we can do this without any extra array - true 
   O(1) space.

6. Complexity:
   - Time: O(m), single backward pass, where m = arr.length
   - Space: O(1), in-place modification, no extra array needed

## Problem Description

<p>Given an array <code>arr</code>,&nbsp;replace every element in that array with the greatest element among the elements to its&nbsp;right, and replace the last element with <code>-1</code>.</p>

<p>After doing so, return the array.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> arr = [17,18,5,4,6,1]
<strong>Output:</strong> [18,6,6,6,1,-1]
<strong>Explanation:</strong> 
- index 0 --&gt; the greatest element to the right of index 0 is index 1 (18).
- index 1 --&gt; the greatest element to the right of index 1 is index 4 (6).
- index 2 --&gt; the greatest element to the right of index 2 is index 4 (6).
- index 3 --&gt; the greatest element to the right of index 3 is index 4 (6).
- index 4 --&gt; the greatest element to the right of index 4 is index 5 (1).
- index 5 --&gt; there are no elements to the right of index 5, so we put -1.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> arr = [400]
<strong>Output:</strong> [-1]
<strong>Explanation:</strong> There are no elements to the right of index 0.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= arr.length &lt;= 10<sup>4</sup></code></li>
	<li><code>1 &lt;= arr[i] &lt;= 10<sup>5</sup></code></li>
</ul>


##  Top Community Optimal Approach

<details>
<summary>Click to expand</summary>

**Title**: ✅ Java | Easy | Similar to Leaders in an Array
**Author**: [@kalinga](https://leetcode.com/kalinga/)
**Upvotes**: 84 👍
**Link**: [View Original Post](https://leetcode.com/problems/replace-elements-with-greatest-element-on-right-side/solutions/3340519/)

---

**T.C.:- O(N)
S.C.:- O(1)**
```
class Solution {
    public int[] replaceElements(int[] arr) {
        int max=-1;
        for(int i=arr.length-1;i>=0;i--){
            if(arr[i]>max){
                int temp=max;
                max=arr[i];
                arr[i]=temp;
            }
            else
                arr[i]=max;
        }
        return arr;
    }
}
```
![image](https://assets.leetcode.com/users/images/1bde3f1a-2bb3-45d1-92c0-4d579992e1c6_1679762566.7449884.jpeg)


</details>
