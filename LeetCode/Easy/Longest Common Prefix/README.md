# Longest Common Prefix

| Field | Value |
|-------|-------|
| **Platform** | LeetCode |
| **Difficulty** | Easy |
| **Language** | java |
| **Solved On** | September 9, 2026 |
| **Tags** | Array, String, Trie |
| **Link** | [View Problem](https://leetcode.com/problems/longest-common-prefix/) |
| **Runtime** | 0 ms |
| **Memory** | 43.3 MB |

## Problem Description

<p>Write a function to find the longest common prefix string amongst an array of strings.</p>

<p>If there is no common prefix, return an empty string <code>""</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> strs = ["flower","flow","flight"]
<strong>Output:</strong> "fl"
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> strs = ["dog","racecar","car"]
<strong>Output:</strong> ""
<strong>Explanation:</strong> There is no common prefix among the input strings.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= strs.length &lt;= 200</code></li>
	<li><code>0 &lt;= strs[i].length &lt;= 200</code></li>
	<li><code>strs[i]</code> consists of only lowercase English letters if it is non-empty.</li>
</ul>


##  Top Community Optimal Approach

<details>
<summary>Click to expand</summary>

**Title**: ✅Python3 || C++|| Java✅ 19 ms || Beats 99.91%
**Author**: [@abdullayev_akbar](https://leetcode.com/abdullayev_akbar/)
**Upvotes**: 3261 👍
**Link**: [View Original Post](https://leetcode.com/problems/longest-common-prefix/solutions/3273176/)

---

# Please UPVOTE\uD83D\uDE0A
![image.png](https://assets.leetcode.com/users/images/f54185ef-bb76-4c6e-807b-66e506e7fab0_1678294130.6935549.png)

This code implements the longestCommonPrefix function that takes a list of strings v as input and returns the longest common prefix of all the strings. Here is an explanation of how the code works:

1. Initialize an empty string ans to store the common prefix.
2. Sort the input list v lexicographically. This step is necessary because the common prefix should be common to all the strings, so we need to find the common prefix of the first and last string in the sorted list.
3. Iterate through the characters of the first and last string in the sorted list, stopping at the length of the shorter string.
4. If the current character of the first string is not equal to the current character of the last string, return the common prefix found so far.
5. Otherwise, append the current character to the ans string.
6. Return the ans string containing the longest common prefix.

Note that the code assumes that the input list v is non-empty, and that all the strings in v have at least one character. If either of these assumptions is not true, the code may fail.
# Python3
```
class Solution:
    def longestCommonPrefix(self, v: List[str]) -> str:
        ans=""
        v=sorted(v)
        first=v[0]
        last=v[-1]
        for i in range(min(len(first),len(last))):
            if(first[i]!=last[i]):
                return ans
            ans+=first[i]
        return ans 

```
# C++
```
class Solution {
public:
    string longestCommonPrefix(vector<string>& v) {
        string ans="";
        sort(v.begin(),v.end());
        int n=v.size();
        string first=v[0],last=v[n-1];
        for(int i=0;i<min(first.size(),last.size());i++){
            if(first[i]!=last[i]){
                return ans;
            }
            ans+=first[i];
        }
        return ans;
    }
};
```
# Java 
```
class Solution {
    public String longestCommonPrefix(String[] v) {
        StringBuilder ans = new StringBuilder();
        Arrays.sort(v);
        String first = v[0];
        String last = v[v.length-1];
        for (int i=0; i<Math.min(first.length(), last.length()); i++) {
            if (first.charAt(i) != last.charAt(i)) {
                return ans.toString();
            }
            ans.append(first.charAt(i));
        }
        return ans.toString();
    }
}
```
![image.png](https://assets.leetcode.com/users/images/a6c83c54-1d1a-4f26-8273-b687d119dd5b_1679889261.1494205.png)

</details>
