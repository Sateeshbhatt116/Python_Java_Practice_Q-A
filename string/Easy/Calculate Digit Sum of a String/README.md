# Calculate Digit Sum of a String

| Field | Value |
|-------|-------|
| **Platform** | LeetCode |
| **Difficulty** | Easy |
| **Language** | java |
| **Solved On** | November 17, 2026 |
| **Tags** | String, Simulation |
| **Link** | [View Problem](https://leetcode.com/problems/calculate-digit-sum-of-a-string/) |
| **Runtime** | 1 ms |
| **Memory** | 42.6 MB |

## Problem Description

<p>You are given a string <code>s</code> consisting of digits and an integer <code>k</code>.</p>

<p>A <strong>round</strong> can be completed if the length of <code>s</code> is greater than <code>k</code>. In one round, do the following:</p>

<ol>
	<li><strong>Divide</strong> <code>s</code> into <strong>consecutive groups</strong> of size <code>k</code> such that the first <code>k</code> characters are in the first group, the next <code>k</code> characters are in the second group, and so on. <strong>Note</strong> that the size of the last group can be smaller than <code>k</code>.</li>
	<li><strong>Replace</strong> each group of <code>s</code> with a string representing the sum of all its digits. For example, <code>"346"</code> is replaced with <code>"13"</code> because <code>3 + 4 + 6 = 13</code>.</li>
	<li><strong>Merge</strong> consecutive groups together to form a new string. If the length of the string is greater than <code>k</code>, repeat from step <code>1</code>.</li>
</ol>

<p>Return <code>s</code> <em>after all rounds have been completed</em>.</p>

<p>&nbsp;</p>
<p><span class="float-right -my-0.5 ml-2 inline-flex select-none items-center" data-example-lang-controls=""><span role="group" class="inline-flex h-6 items-center rounded-sd-md bg-sd-muted p-0.5" data-example-lang-toggle=""><button type="button" aria-pressed="true" class="h-5 max-w-[10rem] truncate whitespace-nowrap rounded-sd-sm border px-2 text-xs font-normal leading-none border-sd-border bg-sd-background text-sd-foreground">Original</button><button type="button" aria-pressed="false" class="h-5 max-w-[10rem] truncate whitespace-nowrap rounded-sd-sm border px-2 text-xs font-normal leading-none border-transparent text-sd-muted-foreground hover:text-sd-foreground">Java</button></span></span><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> s = "11111222223", k = 3
<strong>Output:</strong> "135"
<strong>Explanation:</strong> 
- For the first round, we divide s into groups of size 3: "111", "112", "222", and "23".
  ​​​​​Then we calculate the digit sum of each group: 1 + 1 + 1 = 3, 1 + 1 + 2 = 4, 2 + 2 + 2 = 6, and 2 + 3 = 5. 
&nbsp; So, s becomes "3" + "4" + "6" + "5" = "3465" after the first round.
- For the second round, we divide s into "346" and "5".
&nbsp; Then we calculate the digit sum of each group: 3 + 4 + 6 = 13, 5 = 5. 
&nbsp; So, s becomes "13" + "5" = "135" after second round. 
Now, s.length &lt;= k, so we return "135" as the answer.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> s = "00000000", k = 3
<strong>Output:</strong> "000"
<strong>Explanation:</strong> 
We divide s into "000", "000", and "00".
Then we calculate the digit sum of each group: 0 + 0 + 0 = 0, 0 + 0 + 0 = 0, and 0 + 0 = 0. 
s becomes "0" + "0" + "0" = "000", whose length is equal to k, so we return "000".
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 100</code></li>
	<li><code>2 &lt;= k &lt;= 100</code></li>
	<li><code>s</code> consists of digits only.</li>
</ul>


##  Top Community Optimal Approach

<details>
<summary>Click to expand</summary>

**Title**: Simple Java Solution with comments for understanding
**Author**: [@m0rnings8ar](https://leetcode.com/m0rnings8ar/)
**Upvotes**: 28 👍
**Link**: [View Original Post](https://leetcode.com/problems/calculate-digit-sum-of-a-string/solutions/1955290/)

---

```
class Solution {
    public String digitSum(String s, int k) {
        while(s.length()>k){
            String ns=""; // replace the old string with updated one
            for(int i=0;i<s.length();i+=k){
                String t=s.substring(i,Math.min(i+k,s.length())); // form the string of k size
                int sum=0;
                for(int l=0;l<t.length();l++){ // to find the character sum of string t
                    sum+=t.charAt(l)-\'0\';
                }
                ns+="" + sum;    //update the string with sum of k size string character                 
            }
            s=ns; //update the old string with updated one
        }
        return s;
    }
}
```
Upvote if it\'s helpful

</details>
