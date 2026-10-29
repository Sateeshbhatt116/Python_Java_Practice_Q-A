# Online Stock Span

| Field | Value |
|-------|-------|
| **Platform** | LeetCode |
| **Difficulty** | Medium |
| **Language** | java |
| **Solved On** | October 29, 2026 |
| **Tags** | Stack, Design, Monotonic Stack, Data Stream |
| **Link** | [View Problem](https://leetcode.com/problems/online-stock-span/) |
| **Runtime** | 38 ms |
| **Memory** | 56 MB |

## Problem Description

<p>Design an algorithm that collects daily price quotes for some stock and returns <strong>the span</strong> of that stock's price for the current day.</p>

<p>The <strong>span</strong> of the stock's price in one day is the maximum number of consecutive days (starting from that day and going backward) for which the stock price was less than or equal to the price of that day.</p>

<ul>
	<li>For example, if the prices of the stock in the last four days are <code>[7,2,1,2]</code> and the price of the stock today is 2, then the span of today is 4 because starting from today, the price of the stock was less than or equal to 2 for 4 consecutive days.</li>
	<li>Also, if the prices of the stock in the last four days is <code>[7,34,1,2]</code> and the price of the stock today is <code>8</code>, then the span of today is <code>3</code> because starting from today, the price of the stock was less than or equal <code>8</code> for <code>3</code> consecutive days.</li>
</ul>

<p>Implement the <code>StockSpanner</code> class:</p>

<ul>
	<li><code>StockSpanner()</code> Initializes the object of the class.</li>
	<li><code>int next(int price)</code> Returns the <strong>span</strong> of the stock's price given that today's price is <code>price</code>.</li>
</ul>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input</strong>
["StockSpanner", "next", "next", "next", "next", "next", "next", "next"]
[[], [100], [80], [60], [70], [60], [75], [85]]
<strong>Output</strong>
[null, 1, 1, 1, 2, 1, 4, 6]

<strong>Explanation</strong>
StockSpanner stockSpanner = new StockSpanner();
stockSpanner.next(100); // return 1
stockSpanner.next(80);  // return 1
stockSpanner.next(60);  // return 1
stockSpanner.next(70);  // return 2
stockSpanner.next(60);  // return 1
stockSpanner.next(75);  // return 4, because the last 4 prices (including today's price of 75) were less than or equal to today's price.
stockSpanner.next(85);  // return 6
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= price &lt;= 10<sup>5</sup></code></li>
	<li>At most <code>10<sup>4</sup></code> calls will be made to <code>next</code>.</li>
</ul>


##  Top Community Optimal Approach

<details>
<summary>Click to expand</summary>

**Title**: Clean Java Stack solution with explanation. 90% better run time
**Author**: [@neerazz90](https://leetcode.com/neerazz90/)
**Upvotes**: 58 👍
**Link**: [View Original Post](https://leetcode.com/problems/online-stock-span/solutions/640648/)

---

```
class StockSpanner {
//    Initialize a stack with int array.
//      First Index would be price, and
//      Second Index Will be span at that price.
    Stack<int[]> stack;
    public StockSpanner() {
        stack = new Stack<>();
    }

    public int next(int price) {
//        At each level initialize the span to 1.
        int span = 1;
//        If The top element of stack price is below or equal to the current price:
//          Then, the previous element will be span of current.
        while(!stack.isEmpty() && stack.peek()[0] <= price){
            span += stack.pop()[1];
        }
//        At each level add the price and the span. 
//        So that Next time when visited for consecutive days, you have the value of current that will avoid traversal till the current days span. 
        stack.add(new int[]{price, span});
        return span;
    }
}
```

![image](https://assets.leetcode.com/users/neerazz90/image_1589898370.png)

</details>
