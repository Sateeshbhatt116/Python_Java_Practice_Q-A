# Long Pressed Name

| Field | Value |
|-------|-------|
| **Platform** | LeetCode |
| **Difficulty** | Easy |
| **Language** | java |
| **Solved On** | September 2, 2026 |
| **Tags** | Two Pointers, String |
| **Link** | [View Problem](https://leetcode.com/problems/long-pressed-name/) |
| **Runtime** | 0 ms |
| **Memory** | 42.2 MB |

## Problem Description

<p>Your friend is typing his <code>name</code> into a keyboard. Sometimes, when typing a character <code>c</code>, the key might get <em>long pressed</em>, and the character will be typed 1 or more times.</p>

<p>You examine the <code>typed</code> characters of the keyboard. Return <code>True</code> if it is possible that it was your friends name, with some characters (possibly none) being long pressed.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> name = "alex", typed = "aaleex"
<strong>Output:</strong> true
<strong>Explanation: </strong>'a' and 'e' in 'alex' were long pressed.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> name = "saeed", typed = "ssaaedd"
<strong>Output:</strong> false
<strong>Explanation: </strong>'e' must have been pressed twice, but it was not in the typed output.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= name.length, typed.length &lt;= 1000</code></li>
	<li><code>name</code> and <code>typed</code> consist of only lowercase English letters.</li>
</ul>


##  Top Community Optimal Approach

<details>
<summary>Click to expand</summary>

**Title**: Java 2 pointers, natural, general, easiest to understand code
**Author**: [@416486188](https://leetcode.com/416486188/)
**Upvotes**: 59 👍
**Link**: [View Original Post](https://leetcode.com/problems/long-pressed-name/solutions/238723/)

---

Don\'t have much time, but the keys are:
1. 2 pointers `i` and `j` are handling the same characters at the same time(let\'s say `c`)
2. The count of consecutive `c` in `typed` >= the count of  consecutive  `c` in `name`

```
class Solution {
    public boolean isLongPressedName(String name, String typed) {
        int m = name.length(), n = typed.length();
        int i = 0, j = 0;
        
        while(i < m && j < n){
            char c1 = name.charAt(i), c2 = typed.charAt(j);
            if(c1 != c2) return false; // we are handling different chars, no!
            
			// count of consecutive c1/c2
            int count1 = 0; 
            while(i < m && name.charAt(i) == c1){
                count1++;
                i++;
            }
            
			// count of consecutive c1/c2
            int count2 = 0; 
            while(j < n && typed.charAt(j) == c2){
                count2++;
                j++;
            }
            
            if(count2 < count1) return false;
        }
        
		// they both reach the end
        return i == m && j == n;
    }
}
```

time complexity: `O(m + n)`
space complexity: `O(1)`

</details>
