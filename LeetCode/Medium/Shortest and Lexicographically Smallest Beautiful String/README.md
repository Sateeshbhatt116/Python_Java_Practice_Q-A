# Shortest and Lexicographically Smallest Beautiful String

| Field | Value |
|-------|-------|
| **Platform** | LeetCode |
| **Difficulty** | Medium |
| **Language** | java |
| **Solved On** | August 26, 2026 |
| **Tags** | String, Sliding Window |
| **Link** | [View Problem](https://leetcode.com/problems/shortest-and-lexicographically-smallest-beautiful-string/) |
| **Runtime** | 0 ms |
| **Memory** | 42.6 MB |

## Problem Description

<p>You are given a binary string <code>s</code> and a positive integer <code>k</code>.</p>

<p>A substring of <code>s</code> is <strong>beautiful</strong> if the number of <code>1</code>'s in it is exactly <code>k</code>.</p>

<p>Let <code>len</code> be the length of the <strong>shortest</strong> beautiful substring.</p>

<p>Return <em>the lexicographically <strong>smallest</strong> beautiful substring of string </em><code>s</code><em> with length equal to </em><code>len</code>. If <code>s</code> doesn't contain a beautiful substring, return <em>an <strong>empty</strong> string</em>.</p>

<p>A string <code>a</code> is lexicographically <strong>larger</strong> than a string <code>b</code> (of the same length) if in the first position where <code>a</code> and <code>b</code> differ, <code>a</code> has a character strictly larger than the corresponding character in <code>b</code>.</p>

<ul>
	<li>For example, <code>"abcd"</code> is lexicographically larger than <code>"abcc"</code> because the first position they differ is at the fourth character, and <code>d</code> is greater than <code>c</code>.</li>
</ul>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> s = "100011001", k = 3
<strong>Output:</strong> "11001"
<strong>Explanation:</strong> There are 7 beautiful substrings in this example:
1. The substring "<u>100011</u>001".
2. The substring "<u>1000110</u>01".
3. The substring "<u>10001100</u>1".
4. The substring "1<u>00011001</u>".
5. The substring "10<u>0011001</u>".
6. The substring "100<u>011001</u>".
7. The substring "1000<u>11001</u>".
The length of the shortest beautiful substring is 5.
The lexicographically smallest beautiful substring with length 5 is the substring "11001".
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> s = "1011", k = 2
<strong>Output:</strong> "11"
<strong>Explanation:</strong> There are 3 beautiful substrings in this example:
1. The substring "<u>101</u>1".
2. The substring "1<u>011</u>".
3. The substring "10<u>11</u>".
The length of the shortest beautiful substring is 2.
The lexicographically smallest beautiful substring with length 2 is the substring "11".
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> s = "000", k = 1
<strong>Output:</strong> ""
<strong>Explanation:</strong> There are no beautiful substrings in this example.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 100</code></li>
	<li><code>1 &lt;= k &lt;= s.length</code></li>
</ul>


##  Top Community Optimal Approach

<details>
<summary>Click to expand</summary>

**Title**: Video Solution(Brute->Optimal) 🔥 || Sliding Window 🔥 || C++,JAVA,PYTHON 🔥
**Author**: [@ayushnemmaniwar12](https://leetcode.com/ayushnemmaniwar12/)
**Upvotes**: 21 👍
**Link**: [View Original Post](https://leetcode.com/problems/shortest-and-lexicographically-smallest-beautiful-string/solutions/4170162/)

---

# Intuition
<!-- Describe your first thoughts on how to solve this problem. -->
Try to code brute force and observe whether we can optimize it or not.
Whenever we find \'k\' or some condition to satify \'k\'. Try to think about sliding window or priority_queue. You will get some leads

# ***Detailed and easy Video Solution***

https://youtu.be/q7bEQMv9TFQ

# Approach
<!-- Describe your approach to solving the problem. -->
The code iterates through a string, counting \'1\'s until reaching the desired count, \'k\'. It then slides a window to find the shortest substring with \'k\' \'1\'s, updating the result string accordingly. It compares substrings by length and lexicographic order in the process.
# Complexity
- Time complexity:
<!-- Add your time complexity here, e.g. $$O(n)$$ -->
    O(N+N)->O(N)

- Space complexity:
<!-- Add your space complexity here, e.g. $$O(n)$$ -->
    O(N)

# Brute Force
```C++ []
class Solution {
public:
    string shortestBeautifulSubstring(string s, int k) {
        int n=s.size();
        string ans;
        int i=0,j=0;
        int c=0;
        while(j<n)
        {
            if(s[j]==\'1\')
                c++;
            if(c==k)
            {   
                while(i<n && c==k)
                {
                    string s1=s.substr(i,j-i+1);
                    if(ans.size()==0 || s1.size()<ans.size())
                        ans=s1;
                    else if(s1.size()==ans.size())
                        ans=min(ans,s1);
                    if(s[i]==\'1\')
                        c--;
                    i++;
                }
            }
            j++;
        }
        return ans;
    }
};
```
```python []
class Solution:
    def shortestBeautifulSubstring(self, s, k):
        n = len(s)
        ans = ""
        i = 0
        j = 0
        c = 0

        while j < n:
            if s[j] == \'1\':
                c += 1
            if c == k:
                while i < n and c == k:
                    s1 = s[i:j + 1]
                    if not ans or len(s1) < len(ans):
                        ans = s1
                    elif len(s1) == len(ans):
                        ans = min(ans, s1)
                    if s[i] == \'1\':
                        c -= 1
                    i += 1
            j += 1
        return ans

```
```Java []
public class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();
        String ans = "";
        int i = 0, j = 0;
        int c = 0;
        
        while (j < n) {
            if (s.charAt(j) == \'1\') {
                c++;
            }
            if (c == k) {
                while (i < n && c == k) {
                    String s1 = s.substring(i, j + 1);
                    if (ans.isEmpty() || s1.length() < ans.length()) {
                        ans = s1;
                    } else if (s1.length() == ans.length()) {
                        ans = (ans.compareTo(s1) < 0) ? ans : s1;
                    }
                    if (s.charAt(i) == \'1\') {
                        c--;
                    }
                    i++;
                }
            }
            j++;
        }
        return ans;
    }
}

```

# Optimal Code
```C++ []
class Solution {
public:
    string shortestBeautifulSubstring(string s, int k) {
        int n=s.size();
        string ans;
        int i=0,j=0;
        int c=0;
        while(j<n)
        {
            if(s[j]==\'1\')
                c++;
            if(c==k)
            {   
                while(i<n && c==k)
                {
                    string s1=s.substr(i,j-i+1);
                    if(ans.size()==0 || s1.size()<ans.size())
                        ans=s1;
                    else if(s1.size()==ans.size())
                        ans=min(ans,s1);
                    if(s[i]==\'1\')
                        c--;
                    i++;
                }
            }
            j++;
        }
        return ans;
    }
};
```
```python []
class Solution:
    def shortestBeautifulSubstring(self, s, k):
        n = len(s)
        ans = ""
        i = 0
        j = 0
        c = 0

        while j < n:
            if s[j] == \'1\':
                c += 1
            if c == k:
                while i < n and c == k:
                    s1 = s[i:j + 1]
                    if not ans or len(s1) < len(ans):
                        ans = s1
                    elif len(s1) == len(ans):
                        ans = min(ans, s1)
                    if s[i] == \'1\':
                        c -= 1
                    i += 1
                j += 1
        return ans
```
```Java []
public class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();
        String ans = "";
        int i = 0, j = 0;
        int c = 0;
        
        while (j < n) {
            if (s.charAt(j) == \'1\') {
                c++;
            }
            if (c == k) {
                while (i < n && c == k) {
                    String s1 = s.substring(i, j + 1);
                    if (ans.isEmpty() || s1.length() < ans.length()) {
                        ans = s1;
                    } else if (s1.length() == ans.length()) {
                        ans = (ans.compareTo(s1) < 0) ? ans : s1;
                    }
                    if (s.charAt(i) == \'1\') {
                        c--;
                    }
                    i++;
                }
            }
            j++;
        }
        return ans;
    }
}
```

# ***If you like the solution Please Upvote and subscribe to my youtube channel***
***It Motivates me to record more videos***

*Thank you* \uD83D\uDE00

</details>
