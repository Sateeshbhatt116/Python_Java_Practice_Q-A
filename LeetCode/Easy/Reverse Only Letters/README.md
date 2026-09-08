# Reverse Only Letters

| Field | Value |
|-------|-------|
| **Platform** | LeetCode |
| **Difficulty** | Easy |
| **Language** | java |
| **Solved On** | September 8, 2026 |
| **Tags** | Two Pointers, String |
| **Link** | [View Problem](https://leetcode.com/problems/reverse-only-letters/) |
| **Runtime** | 0 ms |
| **Memory** | 43.2 MB |

## Problem Description

<p>Given a string <code>s</code>, reverse the string according to the following rules:</p>

<ul>
	<li>All the characters that are not English letters remain in the same position.</li>
	<li>All the English letters (lowercase or uppercase) should be reversed.</li>
</ul>

<p>Return <code>s</code><em> after reversing it</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<pre><strong>Input:</strong> s = "ab-cd"
<strong>Output:</strong> "dc-ba"
</pre><p><strong class="example">Example 2:</strong></p>
<pre><strong>Input:</strong> s = "a-bC-dEf-ghIj"
<strong>Output:</strong> "j-Ih-gfE-dCba"
</pre><p><strong class="example">Example 3:</strong></p>
<pre><strong>Input:</strong> s = "Test1ng-Leet=code-Q!"
<strong>Output:</strong> "Qedo1ct-eeLg=ntse-T!"
</pre>
<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 100</code></li>
	<li><code>s</code> consists of characters with ASCII values in the range <code>[33, 122]</code>.</li>
	<li><code>s</code> does not contain <code>'\"'</code> or <code>'\\'</code>.</li>
</ul>


##  Top Community Optimal Approach

<details>
<summary>Click to expand</summary>

**Title**: ✅Java Simple Solution || ✅Runtime 0ms || ✅ Beats100%
**Author**: [@ahmedna126](https://leetcode.com/ahmedna126/)
**Upvotes**: 10 👍
**Link**: [View Original Post](https://leetcode.com/problems/reverse-only-letters/solutions/4219822/)

---

# Intuition
<!-- Describe your first thoughts on how to solve this problem. -->

# Approach
<!-- Describe your approach to solving the problem. -->

# Complexity
- Time complexity:
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity:
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

# Code1
```
class Solution {
    public String reverseOnlyLetters(String s) {
        char[] arr = s.toCharArray();
        int i = 0 , j = s.length()-1;

        while (i < j)
        {
            char c1 = arr[i];
            char c2 = arr[j];
            if (Character.isLetter(c1) && Character.isLetter(c2)) {
                arr[i++] = c2;
                arr[j--] = c1;
            }
            if(!Character.isLetter(c2)){
                j--;
            }
            if (!Character.isLetter(c1)){
                i++;
            }
        }

        return new String(arr);

    }
}
```

# Code2
```
class Solution {
    public String reverseOnlyLetters(String s) {
        StringBuilder str = new StringBuilder();
        for (int i = s.length()-1 ; i >= 0 ; i--) {
            char c1 = s.charAt(i);
            if (Character.isLetter(c1)) str.append(c1);
        }

        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            if (!Character.isLetter(c1)) str.insert( i , c1);
        }
        return str.toString();
    }
}
```
## For additional problem-solving solutions, you can explore my repository on GitHub: [GitHub Repository](https://github.com/ahmedna126/java_leetcode_challenges)


![abcd1.jpeg](https://assets.leetcode.com/users/images/105b13b3-c4b7-40f7-8543-e7683afd0c28_1698522897.1162162.jpeg)


</details>
