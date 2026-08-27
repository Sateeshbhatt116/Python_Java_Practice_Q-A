# Lexicographically Smallest Permutation Greater Than Target

| Field | Value |
|-------|-------|
| **Platform** | LeetCode |
| **Difficulty** | Medium |
| **Language** | java |
| **Solved On** | August 27, 2026 |
| **Tags** | Hash Table, String, Greedy, Counting, Enumeration |
| **Link** | [View Problem](https://leetcode.com/problems/lexicographically-smallest-permutation-greater-than-target/) |
| **Runtime** | 0 ms |
| **Memory** | 42.7 MB |

## Approach

To make the result lexicographically smallest while still being strictly greater than target, we want the point where our string first exceeds target to happen as late as possible — matching target's prefix for as long as we can before finally placing a bigger character. Diverging later always beats diverging earlier, since matching equally for longer is smaller than exceeding earlier.

Steps:

Count the frequency of each letter in s.
Scan target left to right, maintaining a running frequency count that represents "characters used so far to match target's prefix."
At each index i, before consuming target[i], check if any character strictly greater than target[i] is still available in the running counts. If yes, record i as a valid divergence point (keep updating so the last valid one is kept).
Try to consume target[i] itself from the running counts to continue matching the prefix. If it's not available, stop scanning — no further divergence point is reachable.
If no divergence point was ever found, return "" (no valid permutation exists).
Otherwise, using the frequency snapshot at the best divergence index: output target[0..bestI-1] as the prefix, then the smallest available character greater than target[bestI], then all remaining characters in ascending order to keep the rest of the string as small as possible.

## Problem Description

<p>You are given two strings <code>s</code> and <code>target</code>, both having length <code>n</code>, consisting of lowercase English letters.</p>

<p>Return the <strong>lexicographically smallest <span data-keyword="permutation-string" class=" cursor-pointer relative text-dark-blue-s text-sm"><button type="button" aria-haspopup="dialog" aria-expanded="false" aria-controls="radix-_r_t_" data-state="closed" class="">permutation</button></span></strong> of <code>s</code> that is <strong>strictly</strong> greater than <code>target</code>. If no permutation of <code>s</code> is lexicographically strictly greater than <code>target</code>, return an empty string.</p>

<p>A string <code>a</code> is <strong>lexicographically strictly greater </strong>than a string <code>b</code> (of the same length) if in the first position where <code>a</code> and <code>b</code> differ, string <code>a</code> has a letter that appears later in the alphabet than the corresponding letter in <code>b</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = "abc", target = "bba"</span></p>

<p><strong>Output:</strong> <span class="example-io">"bca"</span></p>

<p><strong>Explanation:</strong></p>

<ul>
	<li>The permutations of <code>s</code> (in lexicographical order) are <code>"abc"</code>, <code>"acb"</code>, <code>"bac"</code>, <code>"bca"</code>, <code>"cab"</code>, and <code>"cba"</code>.</li>
	<li>The lexicographically smallest permutation that is strictly greater than <code>target</code> is <code>"bca"</code>.</li>
</ul>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = "leet", target = "code"</span></p>

<p><strong>Output:</strong> <span class="example-io">"eelt"</span></p>

<p><strong>Explanation:</strong></p>

<ul>
	<li>The permutations of <code>s</code> (in lexicographical order) are <code>"eelt"</code>, <code>"eetl"</code>, <code>"elet"</code>, <code>"elte"</code>, <code>"etel"</code>, <code>"etle"</code>, <code>"leet"</code>, <code>"lete"</code>, <code>"ltee"</code>, <code>"teel"</code>, <code>"tele"</code>, and <code>"tlee"</code>.</li>
	<li>The lexicographically smallest permutation that is strictly greater than <code>target</code> is <code>"eelt"</code>.</li>
</ul>
</div>

<p><strong class="example">Example 3:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = "baba", target = "bbaa"</span></p>

<p><strong>Output:</strong> <span class="example-io">""</span></p>

<p><strong>Explanation:</strong></p>

<ul>
	<li>The permutations of <code>s</code> (in lexicographical order) are <code>"aabb"</code>, <code>"abab"</code>, <code>"abba"</code>, <code>"baab"</code>, <code>"baba"</code>, and <code>"bbaa"</code>.</li>
	<li>None of them is lexicographically strictly greater than <code>target</code>. Therefore, the answer is <code>""</code>.</li>
</ul>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length == target.length &lt;= 300</code></li>
	<li><code>s</code> and <code>target</code> consist of only lowercase English letters.</li>
</ul>

