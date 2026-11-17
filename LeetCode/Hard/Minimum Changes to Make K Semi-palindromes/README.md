# Minimum Changes to Make K Semi-palindromes

| Field | Value |
|-------|-------|
| **Platform** | LeetCode |
| **Difficulty** | Hard |
| **Language** | java |
| **Solved On** | November 17, 2026 |
| **Tags** | Two Pointers, String, Dynamic Programming |
| **Link** | [View Problem](https://leetcode.com/problems/minimum-changes-to-make-k-semi-palindromes/) |
| **Runtime** | 114 ms |
| **Memory** | 46.8 MB |

## Problem Description

<p>Given a string <code>s</code> and an integer <code>k</code>, partition <code>s</code> into <code>k</code> <strong><span data-keyword="substring-nonempty" class=" cursor-pointer relative text-dark-blue-s text-sm"><button type="button" aria-haspopup="dialog" aria-expanded="false" aria-controls="radix-_r_v_" data-state="closed" class="">substrings</button></span></strong> such that the letter changes needed to make each substring a <strong>semi-palindrome</strong>&nbsp;are minimized.</p>

<p>Return the <em><strong>minimum</strong> number of letter changes</em> required<em>.</em></p>

<p>A <strong>semi-palindrome</strong> is a special type of string that can be divided into <strong><span data-keyword="palindrome" class=" cursor-pointer relative text-dark-blue-s text-sm"><button type="button" aria-haspopup="dialog" aria-expanded="false" aria-controls="radix-_r_10_" data-state="closed" class="">palindromes</button></span></strong> based on a repeating pattern. To check if a string is a semi-palindrome:​</p>

<ol>
	<li>Choose a positive divisor <code>d</code> of the string's length. <code>d</code> can range from <code>1</code> up to, but not including, the string's length. For a string of length <code>1</code>, it does not have a valid divisor as per this definition, since the only divisor is its length, which is not allowed.</li>
	<li>For a given divisor <code>d</code>, divide the string into groups where each group contains characters from the string that follow a repeating pattern of length <code>d</code>. Specifically, the first group consists of characters at positions <code>1</code>, <code>1 + d</code>, <code>1 + 2d</code>, and so on; the second group includes characters at positions <code>2</code>, <code>2 + d</code>, <code>2 + 2d</code>, etc.</li>
	<li>The string is considered a semi-palindrome if each of these groups forms a palindrome.</li>
</ol>

<p>Consider the string <code>"abcabc"</code>:</p>

<ul>
	<li>The length of <code>"abcabc"</code> is <code>6</code>. Valid divisors are <code>1</code>, <code>2</code>, and <code>3</code>.</li>
	<li>For <code>d = 1</code>: The entire string <code>"abcabc"</code> forms one group. Not a palindrome.</li>
	<li>For <code>d = 2</code>:
	<ul>
		<li>Group 1 (positions <code>1, 3, 5</code>): <code>"acb"</code></li>
		<li>Group 2 (positions <code>2, 4, 6</code>): <code>"bac"</code></li>
		<li>Neither group forms a palindrome.</li>
	</ul>
	</li>
	<li>For <code>d = 3</code>:
	<ul>
		<li>Group 1 (positions <code>1, 4</code>): <code>"aa"</code></li>
		<li>Group 2 (positions <code>2, 5</code>): <code>"bb"</code></li>
		<li>Group 3 (positions <code>3, 6</code>): <code>"cc"</code></li>
		<li>All groups form palindromes. Therefore, <code>"abcabc"</code> is a semi-palindrome.</li>
	</ul>
	</li>
</ul>

<p>&nbsp;</p>
<p><span class="float-right -my-0.5 ml-2 inline-flex select-none items-center" data-example-lang-controls=""><span role="group" class="inline-flex h-6 items-center rounded-sd-md bg-sd-muted p-0.5" data-example-lang-toggle=""><button type="button" aria-pressed="true" class="h-5 max-w-[10rem] truncate whitespace-nowrap rounded-sd-sm border px-2 text-xs font-normal leading-none border-sd-border bg-sd-background text-sd-foreground">Original</button><button type="button" aria-pressed="false" class="h-5 max-w-[10rem] truncate whitespace-nowrap rounded-sd-sm border px-2 text-xs font-normal leading-none border-transparent text-sd-muted-foreground hover:text-sd-foreground">Java</button></span></span><strong class="example">Example 1: </strong></p>

<div class="example-block" style="border-color: var(--border-tertiary); border-left-width: 2px; color: var(--text-secondary); font-size: 0.875rem; margin-bottom: 1rem; margin-top: 1rem; overflow: visible; padding-left: 1rem;">
<p><strong>Input: </strong> <span class="example-io" style="font-family: Menlo, sans-serif; font-size: 0.85rem;"> s = "abcac", k = 2 </span></p>

<p><strong>Output: </strong> <span class="example-io" style="font-family: Menlo, sans-serif; font-size: 0.85rem;"> 1 </span></p>

<p><strong>Explanation: </strong> Divide <code>s</code> into <code>"ab"</code> and <code>"cac"</code>. <code>"cac"</code> is already semi-palindrome. Change <code>"ab"</code> to <code>"aa"</code>, it becomes semi-palindrome with <code>d = 1</code>.</p>
</div>

<p><strong class="example">Example 2: </strong></p>

<div class="example-block" style="border-color: var(--border-tertiary); border-left-width: 2px; color: var(--text-secondary); font-size: 0.875rem; margin-bottom: 1rem; margin-top: 1rem; overflow: visible; padding-left: 1rem;">
<p><strong>Input: </strong> <span class="example-io" style="font-family: Menlo, sans-serif; font-size: 0.85rem;"> s = "abcdef", k = 2 </span></p>

<p><strong>Output: </strong> <span class="example-io" style="font-family: Menlo, sans-serif; font-size: 0.85rem;"> 2 </span></p>

<p><strong>Explanation: </strong> Divide <code>s</code> into substrings <code>"abc"</code> and <code>"def"</code>. Each&nbsp;needs one change to become semi-palindrome.</p>
</div>

<p><strong class="example">Example 3: </strong></p>

<div class="example-block" style="border-color: var(--border-tertiary); border-left-width: 2px; color: var(--text-secondary); font-size: 0.875rem; margin-bottom: 1rem; margin-top: 1rem; overflow: visible; padding-left: 1rem;">
<p><strong>Input: </strong> <span class="example-io" style="font-family: Menlo, sans-serif; font-size: 0.85rem;"> s = "aabbaa", k = 3 </span></p>

<p><strong>Output: </strong> <span class="example-io" style="font-family: Menlo, sans-serif; font-size: 0.85rem;"> 0 </span></p>

<p><strong>Explanation: </strong> Divide <code>s</code> into substrings <code>"aa"</code>, <code>"bb"</code> and <code>"aa"</code>.&nbsp;All are already semi-palindromes.</p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>2 &lt;= s.length &lt;= 200</code></li>
	<li><code>1 &lt;= k &lt;= s.length / 2</code></li>
	<li><code>s</code> contains only lowercase English letters.</li>
</ul>


##  Top Community Optimal Approach

<details>
<summary>Click to expand</summary>

**Title**: ✅☑[C++/Java/Python/JavaScript] || EXPLAINED🔥
**Author**: [@MarkSPhilip31](https://leetcode.com/MarkSPhilip31/)
**Upvotes**: 9 👍
**Link**: [View Original Post](https://leetcode.com/problems/minimum-changes-to-make-k-semi-palindromes/solutions/4195236/)

---

# PLEASE UPVOTE IF IT HELPED

---


# Approaches
**(Also explained in the code)**

1. The code defines a class `Solution` with a function `minimumChanges` to find the minimum changes needed to make a given string palindrome by considering substrings of length k.

1. It uses a dynamic programming approach to compute the minimum changes needed for different substrings.

1. The `dp` array is used to store dynamic programming values where `dp[i][j]` represents the minimum changes needed for a substring of length `i` with `j` changes.

1. The `fac` vector is used to store factors of string lengths to optimize the calculation of changes needed for substrings.

1. The `num` function calculates the number of changes needed to make a substring a palindrome.

1. The code initializes the `dp` array and calculates the number of changes needed for substrings of various lengths.

1. It iteratively updates the `dp` values for different values of `k`.

1. Finally, the code returns the minimum changes needed for the entire string.


# Complexity
- *Time complexity:*
   $$O(n^3 * k)$$
    

- *Space complexity:*
   $$O(nk)$$
    


# Code
```C++ []
class Solution {
public:
    int dp[210][110];  // A 2D array to store dynamic programming values.
    vector<int> fac[210];  // A vector of vectors to store factors of string lengths.

    // Function to calculate the number of changes needed to make a string palindrome.
    int num(string st) {
        int n = st.length();
        int ans = 1e9;  // Initialize ans with a large value.

        // Iterate through all factors of the string length.
        for (auto it : fac[st.length()]) {
            int nu = n / it;
            int cur = 0;

            // Compare characters in the string to make it a palindrome.
            for (int i = 0; i < nu / 2; i++) {
                int i2 = nu - i - 1;
                for (int j = 0; j < it; j++)
                    if (st[i * it + j] != st[i2 * it + j])
                        cur++;
            }

            ans = min(ans, cur);  // Update ans with the minimum changes needed.
        }
        return ans;
    }

    // Main function to calculate the minimum changes needed.
    int minimumChanges(string st, int k) {
        int n = st.length();

        // Precompute factors for string lengths.
        for (int i = 2; i <= n; i++)
            for (int j = 1; j < i; j++)
                if (i % j == 0)
                    fac[i].push_back(j);

        // Initialize the dp array with a large value.
        for (int i = 0; i <= n; i++)
            for (int j = 0; j <= k; j++)
                dp[i][j] = 1e9;

        dp[0][0] = 0;  // Base case: no changes needed for an empty string.

        // Dynamic programming to find the minimum changes needed.
        for (int i = 0; i < n; i++)
            for (int j = 0; j <= i; j++) {
                string cur = st.substr(j, i - j + 1);
                int add = num(cur);  // Calculate changes needed for the current substring.

                // Update dp values for different values of k.
                for (int l = 0; l < k; l++)
                    dp[i + 1][l + 1] = min(dp[i + 1][l + 1], dp[j][l] + add);
            }

        return dp[n][k];  // Return the minimum changes needed for the entire string.
    }
};


```

```C []
#include <stdio.h>
#include <string.h>

int dp[210][110];
int fac[210][210];

int num(char *st, int n) {
    int ans = 1000000000;
    for (int i = 0; i < 210; i++) {
        int it = fac[n][i];
        if (it == 0) break;
        int nu = n / it;
        int cur = 0;

        for (int i = 0; i < nu / 2; i++) {
            int i2 = nu - i - 1;
            for (int j = 0; j < it; j++) {
                if (st[i * it + j] != st[i2 * it + j]) {
                    cur++;
                }
            }
        }

        if (cur < ans) {
            ans = cur;
        }
    }
    return ans;
}

int minimumChanges(char *st, int n, int k) {
    for (int i = 2; i <= n; i++) {
        int count = 0;
        for (int j = 1; j < i; j++) {
            if (i % j == 0) {
                fac[i][count] = j;
                count++;
            }
        }
    }

    for (int i = 0; i <= n; i++) {
        for (int j = 0; j <= k; j++) {
            dp[i][j] = 1000000000;
        }
    }

    dp[0][0] = 0;

    for (int i = 0; i < n; i++) {
        for (int j = 0; j <= i; j++) {
            int len = i - j + 1;
            char cur[210];
            strncpy(cur, st + j, len);
            cur[len] = \'\\0\';
            int add = num(cur, len);

            for (int l = 0; l < k; l++) {
                if (dp[j][l] + add < dp[i + 1][l + 1]) {
                    dp[i + 1][l + 1] = dp[j][l] + add;
                }
            }
        }
    }

    return dp[n][k];
}

int main() {
    char st[] = "ab";
    int n = 2;
    int k = 1;
    int result = minimumChanges(st, n, k);
    printf("Minimum changes: %d\
", result);
    return 0;
}

```



```Java []
import java.util.ArrayList;
import java.util.List;

public class Solution {
    int[][] dp = new int[210][110];
    List<Integer>[] fac = new List[210];

    public int num(String st) {
        int n = st.length();
        int ans = 1e9;

        for (int it : fac[st.length()]) {
            int nu = n / it;
            int cur = 0;

            for (int i = 0; i < nu / 2; i++) {
                int i2 = nu - i - 1;
                for (int j = 0; j < it; j++) {
                    if (st.charAt(i * it + j) != st.charAt(i2 * it + j)) {
                        cur++;
                    }
                }
            }

            ans = Math.min(ans, cur);
        }
        return ans;
    }

    public int minimumChanges(String st, int k) {
        int n = st.length();

        for (int i = 2; i <= n; i++) {
            fac[i] = new ArrayList<>();
            for (int j = 1; j < i; j++) {
                if (i % j == 0) {
                    fac[i].add(j);
                }
            }
        }

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                dp[i][j] = 1e9;
            }
        }

        dp[0][0] = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                String cur = st.substring(j, i - j + 1);
                int add = num(cur);

                for (int l = 0; l < k; l++) {
                    dp[i + 1][l + 1] = Math.min(dp[i + 1][l + 1], dp[j][l] + add);
                }
            }
        }

        return dp[n][k];
    }
}


```

```python3 []
class Solution:
    def minimumChanges(self, st: str, k: int) -> int:
        def num(st):
            n = len(st)
            ans = float(\'inf\')
            for it in fac[len(st)]:
                nu = n // it
                cur = 0
                for i in range(nu // 2):
                    i2 = nu - i - 1
                    for j in range(it):
                        if st[i * it + j] != st[i2 * it + j]:
                            cur += 1
                ans = min(ans, cur)
            return ans

        n = len(st)
        for i in range(2, n + 1):
            fac[i] = []
            for j in range(1, i):
                if i % j == 0:
                    fac[i].append(j)

        dp = [[float(\'inf\')] * (k + 1) for _ in range(n + 1)]
        dp[0][0] = 0

        for i in range(n):
            for j in range(i + 1):
                cur = st[j:i + 1]
                add = num(cur)
                for l in range(k):
                    dp[i + 1][l + 1] = min(dp[i + 1][l + 1], dp[j][l] + add)

        return dp[n][k]

# Initialize the fac array.
fac = [[] for _ in range(210)]



```
```javascript []
class Solution {
    num(st) {
        const n = st.length;
        let ans = 1e9;
        for (const it of this.fac[st.length]) {
            const nu = Math.floor(n / it);
            let cur = 0;
            for (let i = 0; i < Math.floor(nu / 2); i++) {
                const i2 = nu - i - 1;
                for (let j = 0; j < it; j++) {
                    if (st[i * it + j] !== st[i2 * it + j]) {
                        cur++;
                    }
                }
            }
            ans = Math.min(ans, cur);
        }
        return ans;
    }

    minimumChanges(st, k) {
        const n = st.length;

        for (let i = 2; i <= n; i++) {
            this.fac[i] = [];
            for (let j = 1; j < i; j++) {
                if (i % j === 0) {
                    this.fac[i].push(j);
                }
            }
        }

        const dp = new Array(n + 1).fill(0).map(() => new Array(k + 1).fill(1e9));
        dp[0][0] = 0;

        for (let i = 0; i < n; i++) {
            for (let j = 0; j <= i; j++) {
                const cur = st.slice(j, i + 1);
                const add = this.num(cur);
                for (let l = 0; l < k; l++) {
                    dp[i + 1][l + 1] = Math.min(dp[i + 1][l + 1], dp[j][l] + add);
                }
            }
        }

        return dp[n][k];
    }
}

// Initialize the fac array.
Solution.prototype.fac = new Array(210).fill().map(() => []);


```

---



# PLEASE UPVOTE IF IT HELPED

---
---


---

</details>
