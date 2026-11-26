# Stone Removal Game

| Field | Value |
|-------|-------|
| **Platform** | LeetCode |
| **Difficulty** | Easy |
| **Language** | java |
| **Solved On** | November 26, 2026 |
| **Tags** | Math, Simulation |
| **Link** | [View Problem](https://leetcode.com/problems/stone-removal-game/) |
| **Runtime** | 0 ms |
| **Memory** | 41.5 MB |

## Problem Description

<p>Alice and Bob are playing a game where they take turns removing stones from a pile, with <em>Alice going first</em>.</p>

<ul>
	<li>Alice starts by removing <strong>exactly</strong> 10 stones on her first turn.</li>
	<li>For each subsequent turn, each player removes <strong>exactly</strong> 1 fewer<strong> </strong>stone<strong> </strong>than the previous opponent.</li>
</ul>

<p>The player who cannot make a move loses the game.</p>

<p>Given a positive integer <code>n</code>, return <code>true</code> if Alice wins the game and <code>false</code> otherwise.</p>

<p>&nbsp;</p>
<p><span class="float-right -my-0.5 ml-2 inline-flex select-none items-center" data-example-lang-controls=""><span role="group" class="inline-flex h-6 items-center rounded-sd-md bg-sd-muted p-0.5" data-example-lang-toggle=""><button type="button" aria-pressed="true" class="h-5 max-w-[10rem] truncate whitespace-nowrap rounded-sd-sm border px-2 text-xs font-normal leading-none border-sd-border bg-sd-background text-sd-foreground">Original</button><button type="button" aria-pressed="false" class="h-5 max-w-[10rem] truncate whitespace-nowrap rounded-sd-sm border px-2 text-xs font-normal leading-none border-transparent text-sd-muted-foreground hover:text-sd-foreground">Java</button></span></span><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">n = 12</span></p>

<p><strong>Output:</strong> <span class="example-io">true</span></p>

<p><strong>Explanation:</strong></p>

<ul>
	<li>Alice removes 10 stones on her first turn, leaving 2 stones for Bob.</li>
	<li>Bob cannot remove 9 stones, so Alice wins.</li>
</ul>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">n = 1</span></p>

<p><strong>Output:</strong> <span class="example-io">false</span></p>

<p><strong>Explanation:</strong></p>

<ul>
	<li>Alice cannot remove 10 stones, so Alice loses.</li>
</ul>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= n &lt;= 50</code></li>
</ul>


##  Top Community Optimal Approach

<details>
<summary>Click to expand</summary>

**Title**: Python3 || 4 lines, with explanation  || T/S: 99% / 99%
**Author**: [@Spaulding_](https://leetcode.com/Spaulding_/)
**Upvotes**: 13 👍
**Link**: [View Original Post](https://leetcode.com/problems/stone-removal-game/solutions/6076267/)

---

Here\'s the intuition:
- Let\'s ignore the arbitrary constraint  *n* <= 50 and solve this problem for any positive number of stones.

- Consider the game in terms of *rounds*, in which we define a *round* as both Alice and Bob are able to complete a turn. To complete the first round *n* must be greater than 10 + 9 = 19. If so, we move on to the second round with *n* - 19 stones on the table. 
- We can complete a second round if an only if there are 8 + 7 = 15 stones on the table, and if so, there are *n* - 34 stones left for the next round. And so on.
- If we reach a round which cannot be completed, we test whether at least Alice can complete her turn.
- If we complete 5 rounds (which is 10 turns, or 55 stones taken), then Alice wins because Bob cannot take -1 stones. (This scenaro is not in the test cases because of the arbitrary constraint *n* <= 50.)
 ___

```python3 []
class Solution:
    def canAliceWin(self, n: int) -> bool:
        
        for stones in (19, 15, 11, 7, 3):

            if n >= stones: n-= stones
               
            else: return n >= stones//2 +1

        return True
```
```cpp []
class Solution {
public:
    bool canAliceWin(int n) {
        int stones[] = {19, 15, 11, 7, 3};
        for (int stone : stones) {
            if (n >= stone) {
                n -= stone;} 
            else {
                return n >= (stone / 2) + 1;}
        }
        return true;}
}
```
```java []
class Solution {
    public boolean canAliceWin(int n) {

        int[] stones = {19, 15, 11, 7, 3};
        for (int stone : stones) {
            if (n >= stone) {
                n -= stone;
            } else {
                return n >= (stone / 2) + 1;}
        }
        return true; }
}

```
[https://leetcode.com/problems/stone-removal-game/submissions/1462779974/?submissionId=1461027364](https://leetcode.com/problems/stone-removal-game/submissions/1462779974/?submissionId=1461027364)

I could be wrong, but I think that time complexity is *O*(1) and space complexity is *O*(1).

</details>
