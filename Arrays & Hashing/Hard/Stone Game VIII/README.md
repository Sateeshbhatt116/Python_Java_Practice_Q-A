# Stone Game VIII

| Field | Value |
|-------|-------|
| **Platform** | LeetCode |
| **Difficulty** | Hard |
| **Language** | java |
| **Solved On** | August 24, 2026 |
| **Tags** | Array, Math, Dynamic Programming, Minimax, Prefix Sum, Game Theory, Zero-Sum Game |
| **Link** | [View Problem](https://leetcode.com/problems/stone-game-viii/) |
| **Runtime** | 0 ms |
| **Memory** | 42.3 MB |

## Approach



1. Key Insight - Prefix Sum Invariant:
   Removing the leftmost x stones and replacing them with their sum is 
   equivalent to merging those stones. This means the prefix sum of the 
   array NEVER changes throughout the game, no matter how moves are made.
   
   So first, build a prefix sum array s[], where:
   s[i] = stones[0] + stones[1] + ... + stones[i]

2. Key Insight - Reframe Moves as Index Selection:
   Because of the merging property, every move is really just "picking 
   an index i in the prefix sum array to stop at." Since x must be > 1, 
   the smallest valid move takes at least the first two stones — so the 
   first move must pick some index i >= 1 (not 0).
   
   When a player picks index i:
   - They score s[i] (the prefix sum up to i)
   - The opponent then plays optimally on the remaining suffix starting 
     from index i+1

3. Define the DP:
   Let dp[i] = the best score DIFFERENCE the current player can achieve, 
   assuming the game effectively starts at prefix-sum index i.
   
   At index i, the current player has 2 choices:
   a) Stop here, take s[i], and pass the turn onward:
      difference = s[i] - dp[i+1]
      (subtract because whatever the opponent scores next counts against you)
   b) Skip this index (don't stop here), just carry forward:
      difference = dp[i+1]
   
   Take the max of these two options:
   dp[i] = max(dp[i+1], s[i] - dp[i+1])

4. Base Case:
   dp[n-1] = s[n-1]  (at the last index, taking everything is the only option)

5. Iterate:
   Process i from n-2 down to 1 (inclusive). 
   i stops at 1, not 0, because the first move needs at least 2 stones, 
   so the first player can never "stop" exactly at index 0 alone.

6. Final Answer:
   dp[1] — since the very first move must start by choosing some index >= 1.

7. Why this is efficient:
   A naive interval DP (trying every possible split into two halves) is 
   O(n^2) and times out for large inputs. Because merges only ever affect 
   a prefix, and prefix sums stay fixed regardless of move order, the 
   entire game reduces to a single linear backward pass over the prefix 
   sum array.
   
   Time Complexity: O(n)
   Space Complexity: O(1) extra (dp value can be tracked with a single 
   variable instead of a full array)

## Problem Description

<p>Alice and Bob take turns playing a game, with <strong>Alice starting first</strong>.</p>

<p>There are <code>n</code> stones arranged in a row. On each player's turn, while the number of stones is <strong>more than one</strong>, they will do the following:</p>

<ol>
	<li>Choose an integer <code>x &gt; 1</code>, and <strong>remove</strong> the leftmost <code>x</code> stones from the row.</li>
	<li>Add the <strong>sum</strong> of the <strong>removed</strong> stones' values to the player's score.</li>
	<li>Place a <strong>new stone</strong>, whose value is equal to that sum, on the left side of the row.</li>
</ol>

<p>The game stops when <strong>only</strong> <strong>one</strong> stone is left in the row.</p>

<p>The <strong>score difference</strong> between Alice and Bob is <code>(Alice's score - Bob's score)</code>. Alice's goal is to <strong>maximize</strong> the score difference, and Bob's goal is the <strong>minimize</strong> the score difference.</p>

<p>Given an integer array <code>stones</code> of length <code>n</code> where <code>stones[i]</code> represents the value of the <code>i<sup>th</sup></code> stone <strong>from the left</strong>, return <em>the <strong>score difference</strong> between Alice and Bob if they both play <strong>optimally</strong>.</em></p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> stones = [-1,2,-3,4,-5]
<strong>Output:</strong> 5
<strong>Explanation:</strong>
- Alice removes the first 4 stones, adds (-1) + 2 + (-3) + 4 = 2 to her score, and places a stone of
  value 2 on the left. stones = [2,-5].
- Bob removes the first 2 stones, adds 2 + (-5) = -3 to his score, and places a stone of value -3 on
  the left. stones = [-3].
The difference between their scores is 2 - (-3) = 5.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> stones = [7,-6,5,10,5,-2,-6]
<strong>Output:</strong> 13
<strong>Explanation:</strong>
- Alice removes all stones, adds 7 + (-6) + 5 + 10 + 5 + (-2) + (-6) = 13 to her score, and places a
  stone of value 13 on the left. stones = [13].
The difference between their scores is 13 - 0 = 13.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> stones = [-10,-12]
<strong>Output:</strong> -22
<strong>Explanation:</strong>
- Alice can only make one move, which is to remove both stones. She adds (-10) + (-12) = -22 to her
  score and places a stone of value -22 on the left. stones = [-22].
The difference between their scores is (-22) - 0 = -22.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>n == stones.length</code></li>
	<li><code>2 &lt;= n &lt;= 10<sup>5</sup></code></li>
	<li><code>-10<sup>4</sup> &lt;= stones[i] &lt;= 10<sup>4</sup></code></li>
</ul>


##  Top Community Optimal Approach

<details>
<summary>Click to expand</summary>

**Title**: O(n) time + O(1) space detailed solution, no modification to original array
**Author**: [@Maristie](https://leetcode.com/Maristie/)
**Upvotes**: 7 👍
**Link**: [View Original Post](https://leetcode.com/problems/stone-game-viii/solutions/1224903/)

---

## Intuition
Observe that each player gets a score of prefix subarray sum from the original array, and the length of prefix subarray is strictly increasing.

Assume the current player chooses the subarray `[0..k]` (`k` exclusive), then the next player would be faced with a choice set of `[0..k+1], [0..k+2], ..., [0..n]` as the prefix subarray, in which the next player would try to select one with maximized possible final score difference.

If we denote the current player by `A`, next player by `B`, and the maximum possible score difference `score(A) - score(B)` with a choice set of `[0..k], [0..k+1], ..., [0..n]` by `maxDiff(k)`, then
```
maxDiff(k) = max { sum(0..i) - maxDiff(i + 1) for all k <= i <= n }
```

From the above definition, note further that
```
maxDiff(k) = max(maxDiff(k + 1), sum(0..k) - maxDiff(k + 1))
```

And for our purpose, we want to compute `maxDiff(2)`. As a base case, `maxDiff(n) = sum(0..n)`.
Hence the code below follows.

## Implementation

```java
    public int stoneGameVIII(int[] stones) {
        int n = stones.length;
        int sum = 0;
        for (int i = 0; i < n; ++i) {
            sum += stones[i];
        }
        
        int max = sum;
        for (int i = n - 1; i >= 2; --i) {
            sum -= stones[i];
            max = Math.max(max, sum - max);
        }
        return max;
    }
```

</details>
