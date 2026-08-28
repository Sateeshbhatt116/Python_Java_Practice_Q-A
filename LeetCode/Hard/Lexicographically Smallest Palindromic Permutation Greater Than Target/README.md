# Lexicographically Smallest Palindromic Permutation Greater Than Target

| Field | Value |
|-------|-------|
| **Platform** | LeetCode |
| **Difficulty** | Hard |
| **Language** | java |
| **Solved On** | August 28, 2026 |
| **Tags** | Two Pointers, String, Enumeration |
| **Link** | [View Problem](https://leetcode.com/problems/lexicographically-smallest-palindromic-permutation-greater-than-target/) |
| **Runtime** | 0 ms |
| **Memory** | 42.6 MB |

## Approach

Approach:

1. A palindrome of length n is fully defined by its first half (ceil(n/2) chars); the rest mirrors it. So only need to build the first half, then mirror.

2. Feasibility check: count letter freq of s.
   - n even -> all counts must be even.
   - n odd -> exactly one count must be odd (becomes middle char).
   - If not satisfied -> return "".

3. halfCounts[c] = cnt[c] / 2 for each letter (this is the multiset available to build the first half). middleChar = the odd-count letter (if n is odd).

4. Let T1 = target's first half.

Option B (try first): 
   - Check if halfCounts exactly matches T1's letter counts.
   - If yes, build candidate = T1 + middleChar(if any) + reverse(T1).
   - If candidate > target, return it (this is optimal since equal first half beats any greater first half).

Option A (fallback):
   - Greedily scan T1 left to right, maintaining available letter pool (starts as halfCounts).
   - At each index i, check if any letter > T1[i] exists in pool -> record as a potential pivot (store index, letter, and snapshot of pool at that point).
   - Then consume T1[i] from pool to continue exact match; if T1[i] not available, stop scanning.
   - After scan, use the LAST recorded pivot (latest possible deviation = smallest result).
   - Build first half = T1[0..pivot-1] + pivotChar + (remaining pool letters in ascending order).
   - If no pivot found -> return "".

5. Mirror the first half (+ middle char) to form the final palindrome and return it.

Complexity: O(n + 26), linear.

Why it works: Any palindrome > target has first half either == T1 (Option B, only useful if it makes the string bigger) or first half > T1 (Option A, minimized greedily). Try B first since equal-prefix always beats any larger prefix; otherwise fall back to A.

## Problem Description

<p>You are given two strings <code>s</code> and <code>target</code>, each of length <code>n</code>, consisting of lowercase English letters.</p>

<p>Return the <strong><span data-keyword="lexicographically-smaller-string" class=" cursor-pointer relative text-dark-blue-s text-sm"><button type="button" aria-haspopup="dialog" aria-expanded="false" aria-controls="radix-_r_v_" data-state="closed" class="">lexicographically smallest</button></span> string</strong> that is <strong>both</strong> a <strong><span data-keyword="palindrome-string" class=" cursor-pointer relative text-dark-blue-s text-sm"><button type="button" aria-haspopup="dialog" aria-expanded="false" aria-controls="radix-_r_10_" data-state="closed" class="">palindromic</button></span> <span data-keyword="permutation" class=" cursor-pointer relative text-dark-blue-s text-sm"><button type="button" aria-haspopup="dialog" aria-expanded="false" aria-controls="radix-_r_11_" data-state="closed" class="">permutation</button></span></strong> of <code>s</code> and <strong>strictly</strong> greater than <code>target</code>. If no such permutation exists, return an empty string.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = "baba", target = "abba"</span></p>

<p><strong>Output:</strong> <span class="example-io">"baab"</span></p>

<p><strong>Explanation:</strong></p>

<ul>
	<li>The palindromic permutations of <code>s</code> (in lexicographical order) are <code>"abba"</code> and <code>"baab"</code>.</li>
	<li>The lexicographically smallest permutation that is strictly greater than <code>target</code> is <code>"baab"</code>.</li>
</ul>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = "baba", target = "bbaa"</span></p>

<p><strong>Output:</strong> <span class="example-io">""</span></p>

<p><strong>Explanation:</strong></p>

<ul>
	<li>The palindromic permutations of <code>s</code> (in lexicographical order) are <code>"abba"</code> and <code>"baab"</code>.</li>
	<li>None of them is lexicographically strictly greater than <code>target</code>. Therefore, the answer is <code>""</code>.</li>
</ul>
</div>

<p><strong class="example">Example 3:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = "abc", target = "abb"</span></p>

<p><strong>Output:</strong> <span class="example-io">""</span></p>

<p><strong>Explanation:</strong></p>

<p><code>s</code> has no palindromic permutations. Therefore, the answer is <code>""</code>.</p>
</div>

<p><strong class="example">Example 4:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = "aac", target = "abb"</span></p>

<p><strong>Output:</strong> <span class="example-io">"aca"</span></p>

<p><strong>Explanation:</strong></p>

<ul>
	<li>The only palindromic permutation of <code>s</code> is <code>"aca"</code>.</li>
	<li><code>"aca"</code> is strictly greater than <code>target</code>. Therefore, the answer is <code>"aca"</code>.</li>
</ul>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= n == s.length == target.length &lt;= 300</code></li>
	<li><code>s</code> and <code>target</code> consist of only lowercase English letters.</li>
</ul>

