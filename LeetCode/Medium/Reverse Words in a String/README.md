# Reverse Words in a String

| Field | Value |
|-------|-------|
| **Platform** | LeetCode |
| **Difficulty** | Medium |
| **Language** | java |
| **Solved On** | September 5, 2026 |
| **Tags** | Two Pointers, String |
| **Link** | [View Problem](https://leetcode.com/problems/reverse-words-in-a-string/) |
| **Runtime** | 8 ms |
| **Memory** | 44.3 MB |

## Problem Description

<p>Given an input string <code>s</code>, reverse the order of the <strong>words</strong>.</p>

<p>A <strong>word</strong> is defined as a sequence of non-space characters. The <strong>words</strong> in <code>s</code> will be separated by at least one space.</p>

<p>Return <em>a string of the words in reverse order concatenated by a single space.</em></p>

<p><b>Note</b> that <code>s</code> may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> s = "the sky is blue"
<strong>Output:</strong> "blue is sky the"
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> s = "  hello world  "
<strong>Output:</strong> "world hello"
<strong>Explanation:</strong> Your reversed string should not contain leading or trailing spaces.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> s = "a good   example"
<strong>Output:</strong> "example good a"
<strong>Explanation:</strong> You need to reduce multiple spaces between two words to a single space in the reversed string.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 10<sup>4</sup></code></li>
	<li><code>s</code> contains English letters (upper-case and lower-case), digits, and spaces <code>' '</code>.</li>
	<li>There is <strong>at least one</strong> word in <code>s</code>.</li>
</ul>

<p>&nbsp;</p>
<p><b data-stringify-type="bold">Follow-up:&nbsp;</b>If the string data type is mutable in your language, can&nbsp;you solve it&nbsp;<b data-stringify-type="bold">in-place</b>&nbsp;with&nbsp;<code data-stringify-type="code">O(1)</code>&nbsp;extra space?</p>


##  Top Community Optimal Approach

<details>
<summary>Click to expand</summary>

**Title**: Clean Java two-pointers solution (no trim( ), no split( ), no StringBuilder)
**Author**: [@jeantimex](https://leetcode.com/jeantimex/)
**Upvotes**: 836 👍
**Link**: [View Original Post](https://leetcode.com/problems/reverse-words-in-a-string/solutions/47720/)

---

    public class Solution {
      
      public String reverseWords(String s) {
        if (s == null) return null;
        
        char[] a = s.toCharArray();
        int n = a.length;
        
        // step 1. reverse the whole string
        reverse(a, 0, n - 1);
        // step 2. reverse each word
        reverseWords(a, n);
        // step 3. clean up spaces
        return cleanSpaces(a, n);
      }
      
      void reverseWords(char[] a, int n) {
        int i = 0, j = 0;
          
        while (i < n) {
          while (i < j || i < n && a[i] == ' ') i++; // skip spaces
          while (j < i || j < n && a[j] != ' ') j++; // skip non spaces
          reverse(a, i, j - 1);                      // reverse the word
        }
      }
      
      // trim leading, trailing and multiple spaces
      String cleanSpaces(char[] a, int n) {
        int i = 0, j = 0;
          
        while (j < n) {
          while (j < n && a[j] == ' ') j++;             // skip spaces
          while (j < n && a[j] != ' ') a[i++] = a[j++]; // keep non spaces
          while (j < n && a[j] == ' ') j++;             // skip spaces
          if (j < n) a[i++] = ' ';                      // keep only one space
        }
      
        return new String(a).substring(0, i);
      }
      
      // reverse a[] from a[i] to a[j]
      private void reverse(char[] a, int i, int j) {
        while (i < j) {
          char t = a[i];
          a[i++] = a[j];
          a[j--] = t;
        }
      }
      
    }

</details>
