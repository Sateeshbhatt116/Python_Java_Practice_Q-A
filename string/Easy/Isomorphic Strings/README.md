# Isomorphic Strings

| Field | Value |
|-------|-------|
| **Platform** | LeetCode |
| **Difficulty** | Easy |
| **Language** | java |
| **Solved On** | September 2, 2026 |
| **Tags** | Hash Table, String |
| **Link** | [View Problem](https://leetcode.com/problems/isomorphic-strings/) |
| **Runtime** | 0 ms |
| **Memory** | 42.6 MB |

## Approach

1. Check whether both strings have the same length.
2. Create two `HashMap` objects.
3. Traverse both strings character by character.
4. Check whether the character from `s` already has a different mapping.
5. Check whether the character from `t` is already mapped to a different character.
6. If either condition is violated, return `false`.
7. Otherwise, store both mappings.
8. If all characters are processed successfully, return `true`.


## Problem Description

<p>Given two strings <code>s</code> and <code>t</code>, <em>determine if they are isomorphic</em>.</p>

<p>Two strings <code>s</code> and <code>t</code> are isomorphic if the characters in <code>s</code> can be replaced to get <code>t</code>.</p>

<p>All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = "egg", t = "add"</span></p>

<p><strong>Output:</strong> <span class="example-io">true</span></p>

<p><strong>Explanation:</strong></p>

<p>The strings <code>s</code> and <code>t</code> can be made identical by:</p>

<ul>
	<li>Mapping <code>'e'</code> to <code>'a'</code>.</li>
	<li>Mapping <code>'g'</code> to <code>'d'</code>.</li>
</ul>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = "f11", t = "b23"</span></p>

<p><strong>Output:</strong> <span class="example-io">false</span></p>

<p><strong>Explanation:</strong></p>

<p>The strings <code>s</code> and <code>t</code> can not be made identical as <code>'1'</code> needs to be mapped to both <code>'2'</code> and <code>'3'</code>.</p>
</div>

<p><strong class="example">Example 3:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = "paper", t = "title"</span></p>

<p><strong>Output:</strong> <span class="example-io">true</span></p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 5 * 10<sup>4</sup></code></li>
	<li><code>t.length == s.length</code></li>
	<li><code>s</code> and <code>t</code> consist of any valid ascii character.</li>
</ul>


##  Top Community Optimal Approach

<details>
<summary>Click to expand</summary>

**Title**: Well Explained Simple Java ✅ || Runtime 1 ms✅ || Beats 94.7% ✅
**Author**: [@sourabh-jadhav](https://leetcode.com/sourabh-jadhav/)
**Upvotes**: 581 👍
**Link**: [View Original Post](https://leetcode.com/problems/isomorphic-strings/solutions/3171737/)

---

# Intuition
<!-- Describe your first thoughts on how to solve this problem. -->

# Approach
![unnamed.jpg](https://assets.leetcode.com/users/images/131e5eec-0cd2-44cf-8ef4-9839f0897128_1676116616.0294912.jpeg)

![unnasadgmed.jpg](https://assets.leetcode.com/users/images/db4aad46-382e-40d1-8140-e6e2d40a6f0a_1676116628.9868093.jpeg)

![unnamesdagd.jpg](https://assets.leetcode.com/users/images/ad165947-b6fc-4fe5-94cd-2e2a19cca57f_1676116640.4013977.jpeg)




# Complexity
- Time complexity:
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity:
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

# Code
```
class Solution {
    public boolean isIsomorphic(String s, String t) {

        int map1[]=new int[200];
        int map2[]=new int[200];

        if(s.length()!=t.length())
            return false;


        for(int i=0;i<s.length();i++)
        {
            if(map1[s.charAt(i)]!=map2[t.charAt(i)])
                return false;

            map1[s.charAt(i)]=i+1;
            map2[t.charAt(i)]=i+1;
        }
        return true;
    }
}
```
![image.png](https://assets.leetcode.com/users/images/e587fee2-1549-4296-8f91-57972114355a_1676116720.9865656.png)


</details>
