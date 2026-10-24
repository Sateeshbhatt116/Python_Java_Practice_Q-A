# Count Days Spent Together

| Field | Value |
|-------|-------|
| **Platform** | LeetCode |
| **Difficulty** | Easy |
| **Language** | java |
| **Solved On** | October 24, 2026 |
| **Tags** | Math, String |
| **Link** | [View Problem](https://leetcode.com/problems/count-days-spent-together/) |
| **Runtime** | 0 ms |
| **Memory** | 42.4 MB |

## Problem Description

<p>Alice and Bob are traveling to Rome for separate business meetings.</p>

<p>You are given 4 strings <code>arriveAlice</code>, <code>leaveAlice</code>, <code>arriveBob</code>, and <code>leaveBob</code>. Alice will be in the city from the dates <code>arriveAlice</code> to <code>leaveAlice</code> (<strong>inclusive</strong>), while Bob will be in the city from the dates <code>arriveBob</code> to <code>leaveBob</code> (<strong>inclusive</strong>). Each will be a 5-character string in the format <code>"MM-DD"</code>, corresponding to the month and day of the date.</p>

<p>Return<em> the total number of days that Alice and Bob are in Rome together.</em></p>

<p>You can assume that all dates occur in the <strong>same</strong> calendar year, which is <strong>not</strong> a leap year. Note that the number of days per month can be represented as: <code>[31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> arriveAlice = "08-15", leaveAlice = "08-18", arriveBob = "08-16", leaveBob = "08-19"
<strong>Output:</strong> 3
<strong>Explanation:</strong> Alice will be in Rome from August 15 to August 18. Bob will be in Rome from August 16 to August 19. They are both in Rome together on August 16th, 17th, and 18th, so the answer is 3.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> arriveAlice = "10-01", leaveAlice = "10-31", arriveBob = "11-01", leaveBob = "12-31"
<strong>Output:</strong> 0
<strong>Explanation:</strong> There is no day when Alice and Bob are in Rome together, so we return 0.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>All dates are provided in the format <code>"MM-DD"</code>.</li>
	<li>Alice and Bob's arrival dates are <strong>earlier than or equal to</strong> their leaving dates.</li>
	<li>The given dates are valid dates of a <strong>non-leap</strong> year.</li>
</ul>


##  Top Community Optimal Approach

<details>
<summary>Click to expand</summary>

**Title**: Simple Solution
**Author**: [@Java_Programmer_Ketan](https://leetcode.com/Java_Programmer_Ketan/)
**Upvotes**: 11 👍
**Link**: [View Original Post](https://leetcode.com/problems/count-days-spent-together/solutions/2587883/)

---

I think this is a tricky implementation question, but if we use library function it becomes very easy.
* Convert the date into number of days from the **Epoch** *1970-01-01* and find the intersection of the days. Check the comments for timeline

```
//toEpochDay counts the number of days from the epoch 1970-01-01
import java.time.LocalDate;
class Solution {

    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob){
        LocalDate d1 = LocalDate.of(2021,Integer.parseInt(arriveAlice.substring(0,2)),Integer.parseInt(arriveAlice.substring(3,5)));
        LocalDate d2 = LocalDate.of(2021,Integer.parseInt(leaveAlice.substring(0,2)),Integer.parseInt(leaveAlice.substring(3,5)));
        LocalDate d3 = LocalDate.of(2021,Integer.parseInt(arriveBob.substring(0,2)),Integer.parseInt(arriveBob.substring(3,5)));
        LocalDate d4 = LocalDate.of(2021,Integer.parseInt(leaveBob.substring(0,2)),Integer.parseInt(leaveBob.substring(3,5)));
        long aa = d1.toEpochDay(); //Alice Arrive
        long al = d2.toEpochDay(); //Alice Left
        long ba = d3.toEpochDay(); //Bob Arrive
        long bl = d4.toEpochDay(); //Bob Left
        if(al<ba || bl<aa) return 0; //No intersection of days
        return (int) ((Math.min(al,bl)-Math.max(aa,ba))+1); //Intersection of days
    }
}
/*
    //Intersection of alice and bob
       aa.....ba.......bl.....al
       aa.....ba.......al......bl
       ba.....aa.......bl......al
       ba.....aa.......al......bl


   //No intersection

           aa......al.....ba......bl
           ba.....bl.....aa......al
 */
```

</details>
