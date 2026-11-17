# Count Zero Request Servers

| Field | Value |
|-------|-------|
| **Platform** | LeetCode |
| **Difficulty** | Medium |
| **Language** | java |
| **Solved On** | November 17, 2026 |
| **Tags** | Array, Hash Table, Sliding Window, Sorting |
| **Link** | [View Problem](https://leetcode.com/problems/count-zero-request-servers/) |
| **Runtime** | 29 ms |
| **Memory** | 135.7 MB |

## Problem Description

<p>You are given an integer <code>n</code> denoting the total number of servers and a <strong>2D</strong> <strong>0-indexed </strong>integer array <code>logs</code>, where <code>logs[i] = [server_id, time]</code> denotes that the server with id <code>server_id</code> received a request at time <code>time</code>.</p>

<p>You are also given an integer <code>x</code> and a <strong>0-indexed</strong> integer array <code>queries</code>.</p>

<p>Return <em>a <strong>0-indexed</strong> integer array</em> <code>arr</code> <em>of length</em> <code>queries.length</code> <em>where</em> <code>arr[i]</code> <em>represents the number of servers that <strong>did not receive</strong> any requests during the time interval</em> <code>[queries[i] - x, queries[i]]</code>.</p>

<p>Note that the time intervals are inclusive.</p>

<p>&nbsp;</p>
<p><span class="float-right -my-0.5 ml-2 inline-flex select-none items-center" data-example-lang-controls=""><span role="group" class="inline-flex h-6 items-center rounded-sd-md bg-sd-muted p-0.5" data-example-lang-toggle=""><button type="button" aria-pressed="true" class="h-5 max-w-[10rem] truncate whitespace-nowrap rounded-sd-sm border px-2 text-xs font-normal leading-none border-sd-border bg-sd-background text-sd-foreground">Original</button><button type="button" aria-pressed="false" class="h-5 max-w-[10rem] truncate whitespace-nowrap rounded-sd-sm border px-2 text-xs font-normal leading-none border-transparent text-sd-muted-foreground hover:text-sd-foreground">Java</button></span></span><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> n = 3, logs = [[1,3],[2,6],[1,5]], x = 5, queries = [10,11]
<strong>Output:</strong> [1,2]
<strong>Explanation:</strong> 
For queries[0]: The servers with ids 1 and 2 get requests in the duration of [5, 10]. Hence, only server 3 gets zero requests.
For queries[1]: Only the server with id 2 gets a request in duration of [6,11]. Hence, the servers with ids 1 and 3 are the only servers that do not receive any requests during that time period.

</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> n = 3, logs = [[2,4],[2,1],[1,2],[3,1]], x = 2, queries = [3,4]
<strong>Output:</strong> [0,1]
<strong>Explanation:</strong> 
For queries[0]: All servers get at least one request in the duration of [1, 3].
For queries[1]: Only server with id 3 gets no request in the duration [2,4].

</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= n &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= logs.length &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= queries.length &lt;= 10<sup>5</sup></code></li>
	<li><code><font face="monospace">logs[i].length == 2</font></code></li>
	<li><code>1 &lt;= logs[i][0] &lt;= n</code></li>
	<li><code>1 &lt;= logs[i][1] &lt;= 10<sup>6</sup></code></li>
	<li><code>1 &lt;= x &lt;= 10<sup>5</sup></code></li>
	<li><code>x &lt;&nbsp;queries[i]&nbsp;&lt;= 10<sup>6</sup></code></li>
</ul>


##  Top Community Optimal Approach

<details>
<summary>Click to expand</summary>

**Title**: Java Sliding Window with comments
**Author**: [@basic-abc](https://leetcode.com/basic-abc/)
**Upvotes**: 3 👍
**Link**: [View Original Post](https://leetcode.com/problems/count-zero-request-servers/solutions/3680688/)

---

# Approach
Sort logs and queries. Iterate over queries and maintain a window of logs that are "active" with two pointers to include/exclude logs. Time complexity should be `O(nlog(n) + mlog(m))`, depending on which set is larger, the number of logs or the number of queries.
<!-- Describe your approach to solving the problem. -->

# Code
```
class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        // Sort logs according to time of log
        Arrays.sort(logs, (a, b) -> a[1] - b[1]);

        // Append query id to queries, and sort to time of query
        List<int[]> queriesWithId = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            queriesWithId.add(new int[] {i, queries[i]});
        }
        Collections.sort(queriesWithId, (a, b) -> a[1] - b[1]);

        int[] res = new int[queries.length];

        // Map to keep track of active servers, key - server id, value - number of logs within query window
        Map<Integer, Integer> activeServers = new HashMap<>();
        int loggerStart = 0; // left pointer to exclude logs
        int loggerEnd = 0; // right pointer to include logs
        for (int[] query : queriesWithId) {
            int queryId = query[0];
            int queryStart = query[1] - x;
            int queryEnd = query[1];
            // System.out.println("query: " + queryId + " -> [" + queryStart + ", " + queryEnd + "]");

            // capture all logs that are within time period - expand window
            while (loggerEnd < logs.length && logs[loggerEnd][1] <= queryEnd) {
                int server = logs[loggerEnd][0];
                // System.out.println("Add log (server, time): " + server + ", time: " + logs[loggerEnd][1]);
                activeServers.put(server, activeServers.getOrDefault(server, 0) + 1);
                loggerEnd++;
            }
            
            // exclude all logs no longer within time period - narrow window
            while (loggerStart < logs.length && logs[loggerStart][1] < queryStart) {
                int server = logs[loggerStart][0];
                // System.out.println("Remove log (server, time): " + server + ", time: " + logs[loggerStart][1]);
                activeServers.put(server, activeServers.get(server) - 1);
                if (activeServers.get(server) == 0) activeServers.remove(server);
                loggerStart++;
            }

            res[queryId] = n - activeServers.size();
            // System.out.println("res[queryId]: " + res[queryId]);
        }
        return res;
    }
}
```

</details>
