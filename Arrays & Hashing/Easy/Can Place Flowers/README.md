# Can Place Flowers

| Field | Value |
|-------|-------|
| **Platform** | LeetCode |
| **Difficulty** | Easy |
| **Language** | java |
| **Solved On** | August 25, 2026 |
| **Tags** | Array, Greedy |
| **Link** | [View Problem](https://leetcode.com/problems/can-place-flowers/) |
| **Runtime** | 0 ms |
| **Memory** | 42.2 MB |

## Approach


1. Problem Restated:
   Given a flowerbed array of 0s (empty) and 1s (planted), and a number 
   n, determine if n new flowers can be planted such that no two 
   flowers end up in adjacent plots.

2. Greedy Strategy - Scan Left to Right:
   Walk through the flowerbed one plot at a time, from index 0 to the 
   end. At each plot, decide immediately whether to plant there or not 
   - no backtracking needed.

3. Condition to Plant at Index i:
   A flower can be planted at position i only if ALL three are true:
   a) flowerbed[i] == 0        (this plot itself is empty)
   b) left neighbor is empty   (flowerbed[i-1] == 0, OR i == 0 meaning 
                                 there is no left neighbor at all)
   c) right neighbor is empty  (flowerbed[i+1] == 0, OR i == n-1 
                                 meaning there is no right neighbor)

4. Why Check Boundaries Separately:
   For the first plot (i == 0), there's no plot to its left, so we 
   can't check flowerbed[i-1] (would cause an index-out-of-bounds 
   error) - instead we just treat "no left neighbor" as automatically 
   satisfying the left condition. Same logic applies to the last plot 
   and its right neighbor.

5. Plant Greedily and Update Immediately:
   If all 3 conditions hold at index i:
   - Mark flowerbed[i] = 1 (plant a flower there)
   - Decrease the remaining count of flowers needed (n--)
   
   Marking it immediately (rather than waiting) is essential - it 
   ensures the NEXT iteration's left-neighbor check correctly sees 
   this plot as now occupied, preventing two flowers from ending up 
   adjacent.

6. Why the Greedy Choice Is Always Safe (Correctness Argument):
   Planting a flower as early as possible (at the very first valid 
   position) never hurts future planting opportunities. Since a flower 
   can only be blocked by its immediate left/right neighbors, choosing 
   the leftmost valid spot uses up the "least" surrounding space and 
   never eliminates a valid future position that wouldn't have already 
   been blocked anyway. So greedy is optimal here - no need for 
   dynamic programming or backtracking.

7. Final Check:
   After scanning the entire flowerbed once, compare the remaining 
   count of n:
   - If n <= 0, all required flowers were successfully placed -> true
   - Otherwise -> false

8. Complexity:
   - Time: O(m), where m = length of flowerbed (single pass)
   - Space: O(1), modifies array in-place, no extra data structures

## Problem Description

<p>You have a long flowerbed in which some of the plots are planted, and some are not. However, flowers cannot be planted in <strong>adjacent</strong> plots.</p>

<p>Given an integer array <code>flowerbed</code> containing <code>0</code>'s and <code>1</code>'s, where <code>0</code> means empty and <code>1</code> means not empty, and an integer <code>n</code>, return <code>true</code>&nbsp;<em>if</em> <code>n</code> <em>new flowers can be planted in the</em> <code>flowerbed</code> <em>without violating the no-adjacent-flowers rule and</em> <code>false</code> <em>otherwise</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<pre><strong>Input:</strong> flowerbed = [1,0,0,0,1], n = 1
<strong>Output:</strong> true
</pre><p><strong class="example">Example 2:</strong></p>
<pre><strong>Input:</strong> flowerbed = [1,0,0,0,1], n = 2
<strong>Output:</strong> false
</pre>
<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= flowerbed.length &lt;= 2 * 10<sup>4</sup></code></li>
	<li><code>flowerbed[i]</code> is <code>0</code> or <code>1</code>.</li>
	<li>There are no two adjacent flowers in <code>flowerbed</code>.</li>
	<li><code>0 &lt;= n &lt;= flowerbed.length</code></li>
</ul>


##  Top Community Optimal Approach

<details>
<summary>Click to expand</summary>

**Title**: ✅✅Java | C++ Simple Solution 🔥🔥 Easy to Understand🔥🔥
**Author**: [@cohesk](https://leetcode.com/cohesk/)
**Upvotes**: 420 👍
**Link**: [View Original Post](https://leetcode.com/problems/can-place-flowers/solutions/3317843/)

---

# Please UPVOTE \uD83D\uDC4D

**!! BIG ANNOUNCEMENT !!**
I am Giving away my premium content videos related to computer science and data science and also will be sharing well-structured assignments and study materials to clear interviews at top companies to my first 1000 Subscribers. So, **DON\'T FORGET** to Subscribe

Click Here to Subscribe \uD83D\uDC49 https://www.youtube.com/@techwired8/?sub_confirmation=1

**Solution Video Search \uD83D\uDC49 "Can Place Flowers by Tech Wired leetcode" on YouTube**

![Yellow & Black Earn Money YouTube Thumbnail (54).png](https://assets.leetcode.com/users/images/268d7da5-7ba5-4109-aad6-a2fad83f6475_1679276436.3491614.png)


**Java:**
```
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) {
            return true;
        }
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0 && (i == 0 || flowerbed[i-1] == 0) && (i == flowerbed.length-1 || flowerbed[i+1] == 0)) {
                flowerbed[i] = 1;
                n--;
                if (n == 0) {
                    return true;
                }
            }
        }
        return false;
    }
}

```
**C++:**

```
class Solution {
public:
    bool canPlaceFlowers(vector<int>& flowerbed, int n) {
        if (n == 0) {
            return true;
        }
        for (int i = 0; i < flowerbed.size(); i++) {
            if (flowerbed[i] == 0 && (i == 0 || flowerbed[i-1] == 0) && (i == flowerbed.size()-1 || flowerbed[i+1] == 0)) {
                flowerbed[i] = 1;
                n--;
                if (n == 0) {
                    return true;
                }
            }
        }
        return false;
    }
};

```
![image.png](https://assets.leetcode.com/users/images/e2515d84-99cf-4499-80fb-fe458e1bbae2_1678932606.8004954.png)

# Please UPVOTE \uD83D\uDC4D

</details>
