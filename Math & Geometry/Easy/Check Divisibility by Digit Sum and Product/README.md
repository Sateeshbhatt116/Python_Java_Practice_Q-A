# Check Divisibility by Digit Sum and Product

| Field | Value |
|-------|-------|
| **Platform** | LeetCode |
| **Difficulty** | Easy |
| **Language** | java |
| **Solved On** | August 23, 2026 |
| **Tags** | Math |
| **Link** | [View Problem](https://leetcode.com/problems/check-divisibility-by-digit-sum-and-product/) |
| **Runtime** | 0 ms |
| **Memory** | 42.6 MB |

## Approach



Extract digits from n one at a time using the standard technique:
n % 10 → gives the last digit
n / 10 → removes the last digit (integer division)
Repeat in a loop until the number becomes 0
Track two running values simultaneously:
sum = 0 (identity for addition)
product = 1 (identity for multiplication — starting at 0 would make the product permanently 0)
For each digit: sum += digit and product *= digit
Handle the zero-digit edge case: if any digit is 0, the product naturally becomes 0 — this is expected and allowed by the problem, not an error to guard against.
Preserve the original value: use a copy of n for digit extraction so the original n is still available for the final divisibility check.
Final check: return true if n % (sum + product) == 0, else false.

## Problem Description

<p>You are given a positive integer <code>n</code>. Determine whether <code>n</code> is divisible by the <strong>sum </strong>of the following two values:</p>

<ul>
	<li>
	<p>The <strong>digit sum</strong> of <code>n</code> (the sum of its digits).</p>
	</li>
	<li>
	<p>The <strong>digit</strong> <strong>product</strong> of <code>n</code> (the product of its digits).</p>
	</li>
</ul>

<p>Return <code>true</code> if <code>n</code> is divisible by this sum; otherwise, return <code>false</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">n = 99</span></p>

<p><strong>Output:</strong> <span class="example-io">true</span></p>

<p><strong>Explanation:</strong></p>

<p>Since 99 is divisible by the sum (9 + 9 = 18) plus product (9 * 9 = 81) of its digits (total 99), the output is true.</p>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">n = 23</span></p>

<p><strong>Output:</strong> <span class="example-io">false</span></p>

<p><strong>Explanation:</strong></p>

<p>Since 23 is not divisible by the sum (2 + 3 = 5) plus product (2 * 3 = 6) of its digits (total 11), the output is false.</p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= n &lt;= 10<sup>6</sup></code></li>
</ul>

