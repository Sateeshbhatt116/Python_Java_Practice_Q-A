# Number of Recent Calls

| Field | Value |
|-------|-------|
| **Platform** | LeetCode |
| **Difficulty** | Easy |
| **Language** | java |
| **Solved On** | October 27, 2026 |
| **Tags** | Design, Queue, Data Stream |
| **Link** | [View Problem](https://leetcode.com/problems/number-of-recent-calls/) |
| **Runtime** | 22 ms |
| **Memory** | 58.9 MB |

## Problem Description

<p>You have a <code>RecentCounter</code> class which counts the number of recent requests within a certain time frame.</p>

<p>Implement the <code>RecentCounter</code> class:</p>

<ul>
	<li><code>RecentCounter()</code> Initializes the counter with zero recent requests.</li>
	<li><code>int ping(int t)</code> Adds a new request at time <code>t</code>, where <code>t</code> represents some time in milliseconds, and returns the number of requests that have happened in the inclusive range <code>[t - 3000, t]</code>, that is, the new request plus every earlier request that is no more than <code>3000</code> milliseconds older.</li>
</ul>

<p>It is <strong>guaranteed</strong> that every call to <code>ping</code> uses a strictly larger value of <code>t</code> than the previous call.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input</strong>
["RecentCounter", "ping", "ping", "ping", "ping"]
[[], [1], [100], [3001], [3002]]
<strong>Output</strong>
[null, 1, 2, 3, 3]

<strong>Explanation</strong>
RecentCounter recentCounter = new RecentCounter();
recentCounter.ping(1);     // requests = [<u>1</u>], range is [-2999,1], return 1
recentCounter.ping(100);   // requests = [<u>1</u>, <u>100</u>], range is [-2900,100], return 2
recentCounter.ping(3001);  // requests = [<u>1</u>, <u>100</u>, <u>3001</u>], range is [1,3001], return 3
recentCounter.ping(3002);  // requests = [1, <u>100</u>, <u>3001</u>, <u>3002</u>], range is [2,3002], return 3
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= t &lt;= 10<sup>9</sup></code></li>
	<li>Each test case will call <code>ping</code> with <strong>strictly increasing</strong> values of <code>t</code>.</li>
	<li>At most <code>10<sup>4</sup></code> calls will be made to <code>ping</code>.</li>
</ul>


##  Top Community Optimal Approach

<details>
<summary>Click to expand</summary>

**Title**: Beats 100% ✅🔥(Both time and space) | Java, Python, C++ | Detailed Explanation
**Author**: [@Vedant_Tiwari](https://leetcode.com/Vedant_Tiwari/)
**Upvotes**: 104 👍
**Link**: [View Original Post](https://leetcode.com/problems/number-of-recent-calls/solutions/5390658/)

---

![image.png](https://assets.leetcode.com/users/images/ae9f5dc0-1634-47f9-8c1d-d9e196321220_1719738823.6726809.png)

# Intuition
The goal of the RecentCounter class is to count the number of requests that occurred in the last `3000` milliseconds (ms). Each time a request is made (using the ping method), we record the time and maintain a count of all requests within the last `3000` ms. By efficiently tracking only the relevant requests, we can quickly compute the `result`.

# Approach
1. `Data Structure`: Use an array `records` to store timestamps of requests. The start and end indices mark the window of valid requests within the last `3000` ms.
2. `ping(int t)` Method:
    - **Add Timestamp**: Insert the current timestamp t at the position indicated by `end`.
    - **Remove Outdated Requests**: Increment the `start` index until the requests are within the `3000` ms window (`t - records[start] <= 3000`).
    - **Count Valid Requests**: Return the count of requests within the window (`end - start`), which represents the number of valid requests in the last 3000 ms.

# Complexity
- Time complexity: $$O(n)$$

- Space complexity: $$O(1)$$

# Code
```java []
class RecentCounter {
    private static final int[] records = new int[10000]; //
    private int start;
    private int end;

    public RecentCounter() {        
        start = 0;
        end = 0;
    }
    
    public int ping(int t) {
        while (start < end && (t - records[start] > 3000)) { 
            start++; // if the difference in time is greater than 3000ms, 
            // than increase the value of start unitl it\'s equal or less than 3000ms.
        }
        records[end++] = t; // Inserting the current time at the end
        return end - start; // Returning the answer including the element added just now.
    }
}

```
```python []
class RecentCounter:
    def __init__(self):
        self.records = []
        self.start = 0

    def ping(self, t: int) -> int:
        self.records.append(t)
        while self.records[self.start] < t - 3000:
            self.start += 1
        return len(self.records) - self.start

```
```cpp []
#include <vector>

class RecentCounter {
private:
    std::vector<int> records;
    int start;

public:
    RecentCounter() : start(0) {}

    int ping(int t) {
        records.push_back(t);
        while (records[start] < t - 3000) {
            start++;
        }
        return records.size() - start;
    }
};

```
![Upvote.jpg](https://assets.leetcode.com/users/images/6247f4cf-99e3-4232-a975-f25b40770bb4_1719738837.3176522.jpeg)


</details>
