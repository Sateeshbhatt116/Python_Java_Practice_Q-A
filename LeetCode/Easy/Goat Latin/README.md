# Goat Latin

| Field | Value |
|-------|-------|
| **Platform** | LeetCode |
| **Difficulty** | Easy |
| **Language** | java |
| **Solved On** | September 8, 2026 |
| **Tags** | String |
| **Link** | [View Problem](https://leetcode.com/problems/goat-latin/) |
| **Runtime** | 6 ms |
| **Memory** | 44.2 MB |

## Problem Description

<p>You are given a string <code>sentence</code> that consist of words separated by spaces. Each word consists of lowercase and uppercase letters only.</p>

<p>We would like to convert the sentence to "Goat Latin" (a made-up language similar to Pig Latin.) The rules of Goat Latin are as follows:</p>

<ul>
	<li>If a word begins with a vowel (<code>'a'</code>, <code>'e'</code>, <code>'i'</code>, <code>'o'</code>, or <code>'u'</code>), append <code>"ma"</code> to the end of the word.

	<ul>
		<li>For example, the word <code>"apple"</code> becomes <code>"applema"</code>.</li>
	</ul>
	</li>
	<li>If a word begins with a consonant (i.e., not a vowel), remove the first letter and append it to the end, then add <code>"ma"</code>.
	<ul>
		<li>For example, the word <code>"goat"</code> becomes <code>"oatgma"</code>.</li>
	</ul>
	</li>
	<li>Add one letter <code>'a'</code> to the end of each word per its word index in the sentence, starting with <code>1</code>.
	<ul>
		<li>For example, the first word gets <code>"a"</code> added to the end, the second word gets <code>"aa"</code> added to the end, and so on.</li>
	</ul>
	</li>
</ul>

<p>Return<em> the final sentence representing the conversion from sentence to Goat Latin</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<pre><strong>Input:</strong> sentence = "I speak Goat Latin"
<strong>Output:</strong> "Imaa peaksmaaa oatGmaaaa atinLmaaaaa"
</pre><p><strong class="example">Example 2:</strong></p>
<pre><strong>Input:</strong> sentence = "The quick brown fox jumped over the lazy dog"
<strong>Output:</strong> "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"
</pre>
<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= sentence.length &lt;= 150</code></li>
	<li><code>sentence</code> consists of English letters and spaces.</li>
	<li><code>sentence</code> has no leading or trailing spaces.</li>
	<li>All the words in <code>sentence</code> are separated by a single space.</li>
</ul>


##  Top Community Optimal Approach

<details>
<summary>Click to expand</summary>

**Title**: Java 1ms 100% - Clean & Efficient O(n) Solution (Faster Solution)
**Author**: [@talhashaikh1998](https://leetcode.com/talhashaikh1998/)
**Upvotes**: 9 👍
**Link**: [View Original Post](https://leetcode.com/problems/goat-latin/solutions/1469434/)

---

**Hit the UPVOTE! Thankyou <3**
```
class Solution {
    public String toGoatLatin(String sentence) {
        StringBuilder sb = new StringBuilder();
        String[] words = sentence.split(" ");
        int r = 1;
        for(String word : words){
            char ch = word.charAt(0);
            if(ch == \'a\' || ch == \'e\' || ch == \'i\' || ch == \'o\' || ch == \'u\' ||ch == \'A\' || ch == \'E\' || ch == \'I\' || ch == \'O\' || ch == \'U\')
                sb.append(word).append("ma").append("a".repeat(r++)).append(" ");
            else
                sb.append(word.substring(1,word.length())).append(word.charAt(0)).append("ma").append("a".repeat(r++)).append(" ");            
        }        
        return sb.toString().trim();
    }
}
```

</details>
