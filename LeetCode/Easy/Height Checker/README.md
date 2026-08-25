# Height Checker

| Field | Value |
|-------|-------|
| **Platform** | LeetCode |
| **Difficulty** | Easy |
| **Language** | java |
| **Solved On** | August 25, 2026 |
| **Tags** | Array, Sorting, Counting Sort, Bubble Sort |
| **Link** | [View Problem](https://leetcode.com/problems/height-checker/) |
| **Runtime** | 4 ms |
| **Memory** | 43.5 MB |

## Approach

1. Problem Restated:
   Students are currently standing in some order (given by "heights"). 
   We want to know how many students are NOT standing in the correct 
   position, where "correct" means sorted in non-decreasing (ascending) 
   order of height.

2. Create the "Expected" Arrangement:
   Make a copy of the heights array, and sort that copy. This sorted 
   copy represents the ideal, expected order.

3. Compare Actual vs Expected, Index by Index:
   Loop through both arrays (original "heights" and the sorted copy) 
   at the same time, comparing heights[i] with sorted[i] for every 
   index i.

4. Count Mismatches:
   Every time heights[i] != sorted[i], that student is out of place - 
   increment a counter.

5. Why This Works:
   The "expected" order is uniquely determined by sorting - there's 
   only one non-decreasing arrangement of a given multiset of heights 
   (ignoring which specific student holds a duplicate value, since 
   values are just numbers here). So directly comparing position-by-
   position against the sorted version correctly identifies every 
   index that doesn't match the ideal order.

6. Final Answer:
   Return the total count of mismatched indices.

7. Complexity:
   - Sorting: O(m log m), where m = heights.length
   - Comparison pass: O(m)
   - Overall Time: O(m log m)
   - Space: O(m) for the sorted copy

## Problem Description

<p>A school is trying to take an annual photo of all the students. The students are asked to stand in a single file line in <strong>non-decreasing order</strong> by height. Let this ordering be represented by the integer array <code>expected</code> where <code>expected[i]</code> is the expected height of the <code>i<sup>th</sup></code> student in line.</p>

<p>You are given an integer array <code>heights</code> representing the <strong>current order</strong> that the students are standing in. Each <code>heights[i]</code> is the height of the <code>i<sup>th</sup></code> student in line (<strong>0-indexed</strong>).</p>

<p>Return <em>the <strong>number of indices</strong> where </em><code>heights[i] != expected[i]</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> heights = [1,1,4,2,1,3]
<strong>Output:</strong> 3
<strong>Explanation:</strong> 
heights:  [1,1,<u>4</u>,2,<u>1</u>,<u>3</u>]
expected: [1,1,<u>1</u>,2,<u>3</u>,<u>4</u>]
Indices 2, 4, and 5 do not match.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> heights = [5,1,2,3,4]
<strong>Output:</strong> 5
<strong>Explanation:</strong>
heights:  [<u>5</u>,<u>1</u>,<u>2</u>,<u>3</u>,<u>4</u>]
expected: [<u>1</u>,<u>2</u>,<u>3</u>,<u>4</u>,<u>5</u>]
All indices do not match.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> heights = [1,2,3,4,5]
<strong>Output:</strong> 0
<strong>Explanation:</strong>
heights:  [1,2,3,4,5]
expected: [1,2,3,4,5]
All indices match.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= heights.length &lt;= 100</code></li>
	<li><code>1 &lt;= heights[i] &lt;= 100</code></li>
</ul>


##  Top Community Optimal Approach

<details>
<summary>Click to expand</summary>

**Title**: 💯✅🔥Easy Java ,Python3 ,C++ Solution|| 2 ms ||≧◠‿◠≦✌
**Author**: [@suyalneeraj09](https://leetcode.com/suyalneeraj09/)
**Upvotes**: 41 👍
**Link**: [View Original Post](https://leetcode.com/problems/height-checker/solutions/5286562/)

---

# Intuition
<!-- Describe your first thoughts on how to solve this problem. -->
The problem is to find the number of students who are not in their correct positions in a line based on their heights. This is achieved by comparing the actual order of students with the order they would be in if they were sorted by height.
# Approach
<!-- Describe your approach to solving the problem. -->
- **Create a Copy of the Original Array**: Create a copy of the original array to maintain the original order of students.
- **Sort the Copy**: Sort the copy of the array in ascending order based on the heights.
- **Compare the Original and Sorted Arrays**: Iterate through both arrays and count the number of students who are not in their correct positions.
# Complexity
- Time complexity:O(n log n)
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity:O(n)
<!-- Add your space complexity here, e.g. $$O(n)$$ -->


# Code
```Java []
class Solution {
    public int heightChecker(int[] heights) {
        int[] expected = heights.clone();
        Arrays.sort(expected);
        int count = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != expected[i])
                count++;
        }
        return count;
    }
}
```
```python3 []
class Solution:
    def heightChecker(self, heights: List[int]) -> int:
        return sum(h1 != h2 for h1, h2 in zip(heights, sorted(heights)))
```
```C++ []
class Solution {
public:
    int heightChecker(vector<int>& heights) {
        vector<int> v(heights);
        sort(v.begin(),v.end());
        int count = 0;
        for(int i=0;i<heights.size();i++){
            if(heights[i] != v[i])
             count++;
        }
        return count;
    }
};
```

![upvote.png](https://assets.leetcode.com/users/images/ef3746b7-74e8-46ac-b638-a232588b33cb_1717979537.4347806.png)




</details>
