# Reverse Words in a String III

| Field | Value |
|-------|-------|
| **Platform** | LeetCode |
| **Difficulty** | Easy |
| **Language** | java |
| **Solved On** | September 1, 2026 |
| **Tags** | Two Pointers, String |
| **Link** | [View Problem](https://leetcode.com/problems/reverse-words-in-a-string-iii/) |
| **Runtime** | 0 ms |
| **Memory** | 42.3 MB |

## Approach

1. Convert the string into a character array.
2. Use two pointers to find each word.
3. When a word is found, reverse the characters of that word.
4. Continue until the complete string is processed.
5. Return the modified string.


## Problem Description

<p>Given a string <code>s</code>, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> s = "Let's take LeetCode contest"
<strong>Output:</strong> "s'teL ekat edoCteeL tsetnoc"
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> s = "Mr Ding"
<strong>Output:</strong> "rM gniD"
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 5 * 10<sup>4</sup></code></li>
	<li><code>s</code> contains printable <strong>ASCII</strong> characters.</li>
	<li><code>s</code> does not contain any leading or trailing spaces.</li>
	<li>There is <strong>at least one</strong> word in <code>s</code>.</li>
	<li>All the words in <code>s</code> are separated by a single space.</li>
</ul>


##  Top Community Optimal Approach

<details>
<summary>Click to expand</summary>

**Title**: ✅91.55%🔥Easy Solution🔥Reverse & Join
**Author**: [@MrAke](https://leetcode.com/MrAke/)
**Upvotes**: 138 👍
**Link**: [View Original Post](https://leetcode.com/problems/reverse-words-in-a-string-iii/solutions/4111458/)

---

# Problem
##### The problem you\'re trying to solve is to reverse the order of characters in each word within a sentence while still preserving the original whitespace and the initial order of words.
##### Here\'s an example to illustrate the problem:
###### Input: "Let\'s take LeetCode contest"
###### Output: "s\'teL ekat edoCteeL tsetnoc"

##### In this example, you need to reverse the characters within each word, but the words themselves should remain in the same order, and the spaces should stay where they are.
---
# python Solution
#### 1. s.split(): The input string s is first split into words using the default whitespace delimiter. This creates a list of words from the input string.

#### 2. lambda word: word[::-1]: For each word in the list, a lambda function is applied to reverse the order of characters within the word. This is done using slicing with [::-1].

#### 3. map(...): The map function applies the lambda function to each word in the list, effectively reversing the characters in each word.

#### 4. \' \'.join(...): Finally, the reversed words are joined back together into a single string, with spaces between them, using the \' \'.join(...) method. This preserves the original whitespace and word order.

#### So, when you call reverseWords with your input string, it returns the desired output with the words reversed while maintaining the original sentence structure.
---
# Code
```python []
class Solution:
    def reverseWords(self, s: str) -> str:
        return \' \'.join(map(lambda word: word[::-1], s.split()))

```
```C# []
public class Solution
{
    public string ReverseWords(string s)
    {
        string[] words = s.Split();
        string[] reversedWords = new string[words.Length];

        for (int i = 0; i < words.Length; i++)
        {
            char[] wordChars = words[i].ToCharArray();
            Array.Reverse(wordChars);
            reversedWords[i] = new string(wordChars);
        }

        return string.Join(" ", reversedWords);
    }
}

```
```C++ []
class Solution {
public:
    string reverseWords(string s) {
        stringstream ss(s);
        string temp,ans;
        while(ss>>temp){
            reverse(temp.begin(),temp.end());
            ans+= (temp+" ");
        }
        
        return ans.substr(0,ans.size()-1);
    }
};
```
```C []
void reverseWord(char *start, char *end) {
    char temp;
    while (start < end) {
        temp = *start;
        *start = *end;
        *end = temp;
        start++;
        end--;
    }
}

char *reverseWords(char *s) {
    int length = strlen(s);
    char *start = s;
    
    for (int i = 0; i <= length; i++) {
        if (s[i] == \' \' || s[i] == \'\\0\') {
            reverseWord(start, &s[i - 1]);
            start = &s[i + 1];
        }
    }
    
    return s;
}
```
```Java []
public class Solution {
    public String reverseWords(String s) {
        String[] words = s.split("\\\\s+"); 
        StringBuilder reversed = new StringBuilder();
        for (String word : words) {
            StringBuilder reversedWord = new StringBuilder(word);
            reversedWord.reverse(); 
            reversed.append(reversedWord).append(" "); 
        }
        return reversed.toString().trim();
    }
}
```
```javascript []
var reverseWords = function(s) {
    const words = s.split(\' \'); 
    for (let i = 0; i < words.length; i++) {
        words[i] = words[i].split(\'\').reverse().join(\'\');
    }
    return words.join(\' \');
};
```
```PHP []
class Solution {
    function reverseWords($s) {
        $words = explode(\' \', $s); 
        foreach ($words as &$word) {
            $word = strrev($word);
        }
        return implode(\' \', $words);
    }
}

```
```Go []
func reverseWords(s string) string {
    words := strings.Fields(s) 
    for i, word := range words {
        reversedWord := reverseString(word)
        words[i] = reversedWord
    }
    return strings.Join(words, " ")
}

func reverseString(s string) string {
    runes := []rune(s)
    left, right := 0, len(runes)-1
    for left < right {
        runes[left], runes[right] = runes[right], runes[left]
        left++
        right--
    }

    return string(runes)
}
```

</details>
