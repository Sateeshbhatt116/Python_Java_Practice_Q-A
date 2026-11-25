# Minimum Score by Changing Two Elements

| Field | Value |
|-------|-------|
| **Platform** | LeetCode |
| **Difficulty** | Medium |
| **Language** | java |
| **Solved On** | November 25, 2026 |
| **Tags** | Array, Greedy, Sorting |
| **Link** | [View Problem](https://leetcode.com/problems/minimum-score-by-changing-two-elements/) |
| **Runtime** | 18 ms |
| **Memory** | 59.2 MB |

## Problem Description

<p>You are given an integer array <code>nums</code>.</p>

<ul>
	<li>The <strong>low</strong> score of <code>nums</code> is the <strong>minimum</strong> absolute difference between any two integers.</li>
	<li>The <strong>high</strong> score of <code>nums</code> is the <strong>maximum</strong> absolute difference between any two integers.</li>
	<li>The <strong>score</strong> of <code>nums</code> is the sum of the <strong>high</strong> and <strong>low</strong> scores.</li>
</ul>

<p>Return the <strong>minimum score</strong> after <strong>changing two elements</strong> of <code>nums</code>.</p>

<p>&nbsp;</p>
<p><span class="float-right -my-0.5 ml-2 inline-flex select-none items-center" data-example-lang-controls=""><span role="group" class="inline-flex h-6 items-center rounded-sd-md bg-sd-muted p-0.5" data-example-lang-toggle=""><button type="button" aria-pressed="true" class="h-5 max-w-[10rem] truncate whitespace-nowrap rounded-sd-sm border px-2 text-xs font-normal leading-none border-sd-border bg-sd-background text-sd-foreground">Original</button><button type="button" aria-pressed="false" class="h-5 max-w-[10rem] truncate whitespace-nowrap rounded-sd-sm border px-2 text-xs font-normal leading-none border-transparent text-sd-muted-foreground hover:text-sd-foreground">Java</button></span></span><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [1,4,7,8,5]</span></p>

<p><strong>Output:</strong> <span class="example-io">3</span></p>

<p><strong>Explanation:</strong></p>

<ul>
	<li>Change <code>nums[0]</code> and <code>nums[1]</code> to be 6 so that <code>nums</code> becomes [6,6,7,8,5].</li>
	<li>The low score is the minimum absolute difference: |6 - 6| = 0.</li>
	<li>The high score is the maximum absolute difference: |8 - 5| = 3.</li>
	<li>The sum of high and low score is 3.</li>
</ul>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [1,4,3]</span></p>

<p><strong>Output:</strong> <span class="example-io">0</span></p>

<p><strong>Explanation:</strong></p>

<ul>
	<li>Change <code>nums[1]</code> and <code>nums[2]</code> to 1 so that <code>nums</code> becomes [1,1,1].</li>
	<li>The sum of maximum absolute difference and minimum absolute difference is 0.</li>
</ul>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>3 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= nums[i] &lt;= 10<sup>9</sup></code></li>
</ul>


##  Top Community Optimal Approach

<details>
<summary>Click to expand</summary>

**Title**: Simple Diagram Explanation
**Author**: [@L30XL1U](https://leetcode.com/L30XL1U/)
**Upvotes**: 53 👍
**Link**: [View Original Post](https://leetcode.com/problems/minimum-score-by-changing-two-elements/solutions/3202969/)

---

# Idea
- Sort `nums` so that we can easily access maximum and minimum values
- We will always make the low score $$0$$ by creating duplicate values
- Now we have changed the question to finding the minimum maximum value difference by changing two values
- We have three options:
    - Change the two largest values to the third largest value. Third largest value now becomes the max value.
    - Change the two smallest values to the third smallest value. Third smallest value now becomes the min value.
    - Change largest value to second largest value and smallest value to second smallest value. Second largest becomes max value and second smallest becomes min value.
- It must be one of these three options because we have to create duplicates to satisfy the low score constraint and the high score always deals with difference between maximum and minimum.


# Example

- Let us use `nums = [1,4,7,8,5]`

![1.jfif](https://assets.leetcode.com/users/images/cd239624-970e-4050-b0d4-d691e9a1fdc8_1676750417.0719316.jpeg)



# Code
```
class Solution {
public:
    int minimizeSum(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        int n = nums.size();
        return min(nums[n-1]-nums[2], min(nums[n-2]-nums[1], nums[n-3]-nums[0]));
    }
};
```
- Notice from the code that we do not actually need to change the values, we just need to compare the elements of interest by the three options.
#### If this helped please leave an upvote. Thanks!

</details>
