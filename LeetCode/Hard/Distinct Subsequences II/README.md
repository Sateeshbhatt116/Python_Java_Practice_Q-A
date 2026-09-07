# Distinct Subsequences II

| Field | Value |
|-------|-------|
| **Platform** | LeetCode |
| **Difficulty** | Hard |
| **Language** | java |
| **Solved On** | September 7, 2026 |
| **Tags** | String, Dynamic Programming |
| **Link** | [View Problem](https://leetcode.com/problems/distinct-subsequences-ii/) |
| **Runtime** | 2 ms |
| **Memory** | 42.9 MB |

## Problem Description

<p>Given a string s, return <em>the number of <strong>distinct non-empty subsequences</strong> of</em> <code>s</code>. Since the answer may be very large, return it <strong>modulo</strong> <code>10<sup>9</sup> + 7</code>.</p>
A <strong>subsequence</strong> of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., <code>"ace"</code> is a subsequence of <code>"<u>a</u>b<u>c</u>d<u>e</u>"</code> while <code>"aec"</code> is not.
<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> s = "abc"
<strong>Output:</strong> 7
<strong>Explanation:</strong> The 7 distinct subsequences are "a", "b", "c", "ab", "ac", "bc", and "abc".
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> s = "aba"
<strong>Output:</strong> 6
<strong>Explanation:</strong> The 6 distinct subsequences are "a", "b", "ab", "aa", "ba", and "aba".
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> s = "aaa"
<strong>Output:</strong> 3
<strong>Explanation:</strong> The 3 distinct subsequences are "a", "aa" and "aaa".
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 2000</code></li>
	<li><code>s</code> consists of lowercase English letters.</li>
</ul>


##  Top Community Optimal Approach

<details>
<summary>Click to expand</summary>

**Title**: Java Clean Solution With Detail Explanation || Interview Question
**Author**: [@Shree_Govind_Jee](https://leetcode.com/Shree_Govind_Jee/)
**Upvotes**: 5 👍
**Link**: [View Original Post](https://leetcode.com/problems/distinct-subsequences-ii/solutions/4899641/)

---

**Intuition I :**

Below is a case where you need to find all distinct subsequences of input string that contains distinct charecters only, and from there we will build a solution which allows non-distinct charecters in the input string as well, taking an example of input **string "abc" :**

![b9cd0743-1e99-4843-82e4-17b190311df2_1633268699.2467167.png](https://assets.leetcode.com/users/images/3ca51bc6-0ea6-4106-ad03-37c3c4c1de63_1710908079.0071301.png)


In the table we see all the possible subsequences forming at `index 0, 1, 2`

As seen at each step ith charecter of the string has 2 choices :

Include itself in the ongoing subsequences.
Skip itself from being part of the ongoing subsequences.
We can see that for an input string of `\'n\'` distinct charecters, we can form 2n distinct subsequences. in `O(1) time.` (including empty subsequence)

If `count[i]` is a data structure which stores the count of all distinct subsequences uptill index i then :
`count[ i ] = count[ i - 1] x 2`


**Intuition II :**
From intuition 1 lets now see what happens when we introduce repeated charecters in the input **string "abcbc" :**

![cf958c14-06e0-49c1-ae52-3ff2eb69a122_1633270769.3795052.png](https://assets.leetcode.com/users/images/1c7189c3-807c-4376-b888-fa415092eedb_1710908111.5838525.png)


Some observations :

Subsequences in green represent repreated subsequences. There are 2 occurances of \'b\', 1st at index 1 and 2nd at index 3.

The latest occurance of \'b\' contains repeated subsequences from the just previous occurance of \'b\'. `Subsequences [\'b\', \'ab\']` first occur at index 1 and then they repeat when \'b\' repeats.

Similarly, `[\'c\', \'ac\', \'bc\', \'abc\']` repeat at the latest occurance of \'c\' at index 4. These strings first occur at index 2 at the previous occurance of \'c\'.

If \'prev\' is the previous occurance of the repreated charecter at index \'i\' then, Repetition **`count = count[ prev - 1]`**


![60b9d2a3-885f-4f27-801c-86459ef8264d_1633271208.272834.png](https://assets.leetcode.com/users/images/3c177181-b345-4d50-bc48-9b5ffb64e9dd_1710908147.4971402.png)


# Code
```
class Solution {
    int MOD = 1_000_000_007;

    // Recusive Solution
    private void solveRec(String s, int idx, StringBuilder sb, List<String> list) {
        // Base Case
        if (idx >= s.length()) {
            if (sb.toString().length() != 0) {
                if (list.contains(sb.toString())) {
                    return;
                }
                list.add(sb.toString());
            }
            return;
        }

        // take it
        sb.append(s.charAt(idx));
        solveRec(s, idx + 1, sb, list);
        sb.deleteCharAt(sb.length() - 1);

        // nontake
        solveRec(s, idx + 1, sb, list);
    }




    // DP + Memoization
    private int solveMemo(String s, int idx, int[] dp) {
        // Base Case
        if (idx >= s.length()) {
            return 0;
        }

        // step-2 => if already calculated just return it
        if (dp[idx] != -1)
            return dp[idx];

        // step-3 => if not calculated just calculate it
        Set<Character> set = new HashSet<>();
        int res = 0;
        for (int j = idx; j < s.length(); j++) {
            if (set.contains(s.charAt(j))) {
                continue;
            }

            set.add(s.charAt(j));
            res = (1 + solveMemo(s, j + 1, dp) % MOD + res % MOD) % MOD;
        }
        return dp[idx] = res;
    }




    // Drive Code
    public int distinctSubseqII(String s) {
        // Recursive
        // List<String> list = new ArrayList<>();
        // solveRec(s, 0, new StringBuilder(), list);
        // return list.size() % MOD;



        // DP + Memoization
        // int[] dp = new int[s.length()];
        // Arrays.fill(dp, -1);
        // return solveMemo(s, 0, dp) % MOD;



        // DP + Tabulation
        int res = 0, added = 0;
        int[] count = new int[26];
        for (char ch : s.toCharArray()) {
            added = (res + 1 - count[ch - \'a\']) % MOD;
            res = (res + added) % MOD;
            count[ch - \'a\'] = (added + count[ch - \'a\']) % MOD;
        }
        return (res + MOD) % MOD;
    }
}





// class Solution {
//     private static final int mod = (int) (1e9 + 7);

//     public int distinctSubseqII(String s) {
//         int[] dp = new int[s.length() + 1];
//         Arrays.fill(dp, -1);

//         int[] last = new int[26];
//         Arrays.fill(last, -1);

//         return (countDistinctSubsequences(s, s.length(), dp, last) - 1 + mod) % mod;
//     }

//     private static int countDistinctSubsequences(String s, int i, int[] dp, int[] last) {
//         if (i == 0) {
//             return 1;
//         }

//         if (dp[i] != -1) {
//             return dp[i];
//         }

//         dp[i] = (int) ((long) 2 * countDistinctSubsequences(s, i - 1, dp, last)) % mod;

//         int charIndex = s.charAt(i - 1) - \'a\';
//         if (last[charIndex] != -1) {
//             dp[i] = (dp[i] - countDistinctSubsequences(s, last[charIndex], dp, last) + mod) % mod;
//         }

//         last[charIndex] = i - 1;

//         return dp[i] % mod;
//     }
// }
```

</details>
