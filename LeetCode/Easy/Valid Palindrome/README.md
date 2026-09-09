# Valid Palindrome

| Field | Value |
|-------|-------|
| **Platform** | LeetCode |
| **Difficulty** | Easy |
| **Language** | java |
| **Solved On** | September 9, 2026 |
| **Tags** | Two Pointers, String |
| **Link** | [View Problem](https://leetcode.com/problems/valid-palindrome/) |
| **Runtime** | 248 ms |
| **Memory** | 53.6 MB |

## Problem Description

<p>A phrase is a <strong>palindrome</strong> if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.</p>

<p>Given a string <code>s</code>, return <code>true</code><em> if it is a <strong>palindrome</strong>, or </em><code>false</code><em> otherwise</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> s = "A man, a plan, a canal: Panama"
<strong>Output:</strong> true
<strong>Explanation:</strong> "amanaplanacanalpanama" is a palindrome.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> s = "race a car"
<strong>Output:</strong> false
<strong>Explanation:</strong> "raceacar" is not a palindrome.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> s = " "
<strong>Output:</strong> true
<strong>Explanation:</strong> s is an empty string "" after removing non-alphanumeric characters.
Since an empty string reads the same forward and backward, it is a palindrome.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 2 * 10<sup>5</sup></code></li>
	<li><code>s</code> consists only of printable ASCII characters.</li>
</ul>


##  Top Community Optimal Approach

<details>
<summary>Click to expand</summary>

**Title**: Beats 96.9% || Well Explained Code in JAVA✅
**Author**: [@sakshamkaushiik](https://leetcode.com/sakshamkaushiik/)
**Upvotes**: 1018 👍
**Link**: [View Original Post](https://leetcode.com/problems/valid-palindrome/solutions/3165353/)

---



# Approach
This code is an implementation of a solution to determine if a given string is a palindrome. A string is considered a palindrome if it reads the same forwards and backwards, ignoring spaces, punctuation, and letter casing.

The approach used in this solution is a two-pointer technique, where two pointers are maintained, one at the start of the string and the other at the end of the string. The two pointers move towards each other until they meet in the middle of the string.

At each iteration of the while loop, the characters pointed to by the start and last pointers are checked. If either of the characters is not a letter or digit (e.g., a space or punctuation), the pointer is moved one step to the right (for start) or one step to the left (for last) until a letter or digit is found.

If both characters are letters or digits, they are converted to lowercase and compared. If they are not equal, the function returns false, as the string is not a palindrome. If they are equal, both pointers are moved one step to the right and left, respectively.

The while loop continues until the start pointer is greater than the last pointer, indicating that all the characters have been checked and that the string is a palindrome. The function then returns true.

# Complexity
- Time complexity:
The time complexity of this solution is O(n), where n is the length of the string. This is because, in the worst case, all characters in the string need to be checked once, so the number of operations is proportional to the length of the string.



- Space complexity:
The space complexity of this solution is O(1), as no additional data structures are used, and only a constant amount of memory is required for the start and last pointers and a few variables.

# Code
```
class Solution {
    public boolean isPalindrome(String s) {
        if (s.isEmpty()) {
        	return true;
        }
        int start = 0;
        int last = s.length() - 1;
        while(start <= last) {
        	char currFirst = s.charAt(start);
        	char currLast = s.charAt(last);
        	if (!Character.isLetterOrDigit(currFirst )) {
        		start++;
        	} else if(!Character.isLetterOrDigit(currLast)) {
        		last--;
        	} else {
        		if (Character.toLowerCase(currFirst) != Character.toLowerCase(currLast)) {
        			return false;
        		}
        		start++;
        		last--;
        	}
        }
        return true;
    }
}

```
![upvote.jpeg](https://assets.leetcode.com/users/images/b12cb9bd-d3f5-43f8-aa22-9ddd4e30f15a_1675966495.975759.jpeg)


</details>
