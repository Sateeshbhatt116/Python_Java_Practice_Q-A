# Number of Ways to Reorder Array to Get Same BST

| Field | Value |
|-------|-------|
| **Platform** | LeetCode |
| **Difficulty** | Hard |
| **Language** | java |
| **Solved On** | November 3, 2026 |
| **Tags** | Array, Math, Divide and Conquer, Dynamic Programming, Tree, Union-Find, Binary Search Tree, Memoization, Combinatorics, Binary Tree, Fermat's Little Theorem |
| **Link** | [View Problem](https://leetcode.com/problems/number-of-ways-to-reorder-array-to-get-same-bst/) |
| **Runtime** | 64 ms |
| **Memory** | 169.6 MB |

## Problem Description

<p>Given an array <code>nums</code> that represents a permutation of integers from <code>1</code> to <code>n</code>. We are going to construct a binary search tree (BST) by inserting the elements of <code>nums</code> in order into an initially empty BST. Find the number of different ways to reorder <code>nums</code> so that the constructed BST is identical to that formed from the original array <code>nums</code>.</p>

<ul>
	<li>For example, given <code>nums = [2,1,3]</code>, we will have 2 as the root, 1 as a left child, and 3 as a right child. The array <code>[2,3,1]</code> also yields the same BST but <code>[3,2,1]</code> yields a different BST.</li>
</ul>

<p>Return <em>the number of ways to reorder</em> <code>nums</code> <em>such that the BST formed is identical to the original BST formed from</em> <code>nums</code>.</p>

<p>Since the answer may be very large, <strong>return it modulo </strong><code>10<sup>9</sup> + 7</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2026/02/23/1569_ex0.png" style="width: 160px; height: 160px;">
<pre><strong>Input:</strong> nums = [2,1,3]
<strong>Output:</strong> 1
<strong>Explanation:</strong> We can reorder nums to be [2,3,1] which will yield the same BST. There are no other ways to reorder nums which will yield the same BST.
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2026/02/23/1569_ex.png" style="width: 270px; height: 270px;">
<pre><strong>Input:</strong> nums = [3,4,5,1,2]
<strong>Output:</strong> 5
<strong>Explanation:</strong> The following 5 arrays will yield the same BST: 
[3,1,2,4,5]
[3,1,4,2,5]
[3,1,4,5,2]
[3,4,1,2,5]
[3,4,1,5,2]
</pre>

<p><strong class="example">Example 3:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2026/02/23/1569_ex2.png" style="width: 205px; height: 205px;">
<pre><strong>Input:</strong> nums = [1,2,3]
<strong>Output:</strong> 0
<strong>Explanation:</strong> There are no other orderings of nums that will yield the same BST.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 1000</code></li>
	<li><code>1 &lt;= nums[i] &lt;= nums.length</code></li>
	<li>All integers in <code>nums</code> are <strong>distinct</strong>.</li>
</ul>


##  Top Community Optimal Approach

<details>
<summary>Click to expand</summary>

**Title**: Java Solution for Number of Ways to Reorder Array to Get Same BST Problem
**Author**: [@Aman_Raj_Sinha](https://leetcode.com/Aman_Raj_Sinha/)
**Upvotes**: 20 👍
**Link**: [View Original Post](https://leetcode.com/problems/number-of-ways-to-reorder-array-to-get-same-bst/solutions/3643613/)

---

# Intuition
<!-- Describe your first thoughts on how to solve this problem. -->
The problem asks for the number of different ways to reorder the given array nums such that the constructed Binary Search Tree (BST) is identical to the original BST formed from nums. We can solve this problem recursively by considering the root element of the BST and splitting the remaining elements into two groups: the left subtree elements (less than the root) and the right subtree elements (greater than the root). The total number of ways to reorder nums can be calculated by multiplying the number of ways to reorder the left subtree, the number of ways to reorder the right subtree, and the number of possible combinations of left and right subtrees.

# Approach
<!-- Describe your approach to solving the problem. -->
1. Create a helper function countWays that takes a list of integers (nums) as input and returns the number of ways to reorder nums to form the same BST.
1. In the countWays function:
- If the size of nums is less than or equal to 2, return 1 since there is only one way to reorder 0 or 1 element.
- Create two empty lists: left and right.
- Set the first element of nums as the root value.
- Iterate through the remaining elements of nums (starting from the second element):
- If the current element is less than the root value, add it to the left list.
- Otherwise, add it to the right list.
- Calculate the number of ways to reorder the left list (recursively) and store it in leftCount.
- Calculate the number of ways to reorder the right list (recursively) and store it in rightCount.
- Calculate the number of possible combinations of left and right subtrees using the comb function.
- Return the product of comb, leftCount, and rightCount.
3. Create a numOfWays function that converts the input array into a list and calls the countWays function. Subtract 1 from the result and return it as the final output.
1. Test the program with provided test cases or additional test cases.

# Complexity
- Time complexity:
<!-- Add your time complexity here, e.g. $$O(n)$$ -->
The time complexity of the solution is O(n^2), where n is the size of the nums array. This is because for each recursive call, we split the list into left and right subtrees, and in the worst case, the number of elements in the subtrees can be O(n). The comb function also has a time complexity of O(n^2) because it calculates combinations using dynamic programming.

- Space complexity:
<!-- Add your space complexity here, e.g. $$O(n)$$ -->
The space complexity is O(n) because we use additional space to store the left and right subtrees. The depth of the recursion can be at most n, so the space required for recursion is also O(n).

# Code
```
class Solution {
    private static final int MOD = 1000000007;
    public int numOfWays(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        return countWays(list) - 1;
    }
    private int countWays(List<Integer> nums) {
        if (nums.size() <= 2) {
            return 1;
        }
        
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        int root = nums.get(0);
        
        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i) < root) {
                left.add(nums.get(i));
            } else {
                right.add(nums.get(i));
            }
        }
        
        long leftCount = countWays(left);
        long rightCount = countWays(right);
        
        return (int) ((comb(nums.size() - 1, left.size()) % MOD) * (leftCount % MOD) % MOD * (rightCount % MOD) % MOD);
    }
    
    private long comb(int n, int k) {
        long[][] dp = new long[n + 1][k + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= Math.min(i, k); j++) {
                dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]) % MOD;
            }
        }
        return dp[n][k];
    }
}
```

</details>
