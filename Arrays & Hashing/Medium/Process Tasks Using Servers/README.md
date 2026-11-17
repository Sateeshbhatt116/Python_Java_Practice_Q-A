# Process Tasks Using Servers

| Field | Value |
|-------|-------|
| **Platform** | LeetCode |
| **Difficulty** | Medium |
| **Language** | java |
| **Solved On** | November 17, 2026 |
| **Tags** | Array, Heap (Priority Queue) |
| **Link** | [View Problem](https://leetcode.com/problems/process-tasks-using-servers/) |
| **Runtime** | 255 ms |
| **Memory** | 171.7 MB |

## Problem Description

<p>You are given two <strong>0-indexed</strong> integer arrays <code>servers</code> and <code>tasks</code> of lengths <code>n</code>​​​​​​ and <code>m</code>​​​​​​ respectively. <code>servers[i]</code> is the <strong>weight</strong> of the <code>i<sup>​​​​​​th</sup></code>​​​​ server, and <code>tasks[j]</code> is the <strong>time needed</strong> to process the <code>j<sup>​​​​​​th</sup></code>​​​​ task <strong>in seconds</strong>.</p>

<p>Tasks are assigned to the servers using a <strong>task queue</strong>. Initially, all servers are free, and the queue is <strong>empty</strong>.</p>

<p>At second <code>j</code>, the <code>j<sup>th</sup></code> task is <strong>inserted</strong> into the queue (starting with the <code>0<sup>th</sup></code> task being inserted at second <code>0</code>). As long as there are free servers and the queue is not empty, the task in the front of the queue will be assigned to a free server with the <strong>smallest weight</strong>, and in case of a tie, it is assigned to a free server with the <strong>smallest index</strong>.</p>

<p>If there are no free servers and the queue is not empty, we wait until a server becomes free and immediately assign the next task. If multiple servers become free at the same time, then multiple tasks from the queue will be assigned <strong>in order of insertion</strong> following the weight and index priorities above.</p>

<p>A server that is assigned task <code>j</code> at second <code>t</code> will be free again at second <code>t + tasks[j]</code>.</p>

<p>Build an array <code>ans</code>​​​​ of length <code>m</code>, where <code>ans[j]</code> is the <strong>index</strong> of the server the <code>j<sup>​​​​​​th</sup></code> task will be assigned to.</p>

<p>Return <em>the array </em><code>ans</code>​​​​.</p>

<p>&nbsp;</p>
<p><span class="float-right -my-0.5 ml-2 inline-flex select-none items-center" data-example-lang-controls=""><span role="group" class="inline-flex h-6 items-center rounded-sd-md bg-sd-muted p-0.5" data-example-lang-toggle=""><button type="button" aria-pressed="true" class="h-5 max-w-[10rem] truncate whitespace-nowrap rounded-sd-sm border px-2 text-xs font-normal leading-none border-sd-border bg-sd-background text-sd-foreground">Original</button><button type="button" aria-pressed="false" class="h-5 max-w-[10rem] truncate whitespace-nowrap rounded-sd-sm border px-2 text-xs font-normal leading-none border-transparent text-sd-muted-foreground hover:text-sd-foreground">Java</button></span></span><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> servers = [3,3,2], tasks = [1,2,3,2,1,2]
<strong>Output:</strong> [2,2,0,2,1,2]
<strong>Explanation: </strong>Events in chronological order go as follows:
- At second 0, task 0 is added and processed using server 2 until second 1.
- At second 1, server 2 becomes free. Task 1 is added and processed using server 2 until second 3.
- At second 2, task 2 is added and processed using server 0 until second 5.
- At second 3, server 2 becomes free. Task 3 is added and processed using server 2 until second 5.
- At second 4, task 4 is added and processed using server 1 until second 5.
- At second 5, all servers become free. Task 5 is added and processed using server 2 until second 7.</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> servers = [5,1,4,3,2], tasks = [2,1,2,4,5,2,1]
<strong>Output:</strong> [1,4,1,4,1,3,2]
<strong>Explanation: </strong>Events in chronological order go as follows: 
- At second 0, task 0 is added and processed using server 1 until second 2.
- At second 1, task 1 is added and processed using server 4 until second 2.
- At second 2, servers 1 and 4 become free. Task 2 is added and processed using server 1 until second 4. 
- At second 3, task 3 is added and processed using server 4 until second 7.
- At second 4, server 1 becomes free. Task 4 is added and processed using server 1 until second 9. 
- At second 5, task 5 is added and processed using server 3 until second 7.
- At second 6, task 6 is added and processed using server 2 until second 7.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>servers.length == n</code></li>
	<li><code>tasks.length == m</code></li>
	<li><code>1 &lt;= n, m &lt;= 2 * 10<sup>5</sup></code></li>
	<li><code>1 &lt;= servers[i], tasks[j] &lt;= 2 * 10<sup>5</sup></code></li>
</ul>


##  Top Community Optimal Approach

<details>
<summary>Click to expand</summary>

**Title**: Java | Heap Solution | Interview Code with Classes
**Author**: [@polyvoid](https://leetcode.com/polyvoid/)
**Upvotes**: 11 👍
**Link**: [View Original Post](https://leetcode.com/problems/process-tasks-using-servers/solutions/1635716/)

---

The question itself mentions that you need to choose minimum weight server with least index in order to schedule a given job.
This alone tells us that "Greedy" choice at each step should work.

So, everytime we need to schedule a task, we need to find a candidate server that satisfies "Greedy" requirement above. So, at current timestamp
1. Check all servers that are free at this point and add them to a PQ
2. Poll the PQ and assign tasks to the free servers

```
    private class Server {
        int weight;
        int index;

        public Server(int weight, int index) {
            this.weight = weight;
            this.index = index;
        }
    }
	
	// Represents task-server assignment
    private class Assign {
		// time at which this server will become free again
        int freeTime;
        Server server;

        public Assign(int freeTime, Server server) {
            this.freeTime = freeTime;
            this.server = server;
        }
    }

    public int[] assignTasks(int[] servers, int[] tasks) {
		// PQ to store servers (server with least weight or least index is polled first)
        Queue<Server> serverQueue = new PriorityQueue<>((s1, s2) -> {
            if (s1.weight - s2.weight != 0)
                return s1.weight - s2.weight;
            return s1.index - s2.index;
        });
		
		// PQ to store assigned servers (server with least freeTime is polled first)
        Queue<Assign> assignQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a.freeTime));

        for (int i = 0; i < servers.length; ++i)
            serverQueue.add(new Server(servers[i], i));

        int j = 0;
        int time = 0;
        int[] ans = new int[tasks.length];

        while (j < tasks.length) {
			// check what all servers have become free
            while (!assignQueue.isEmpty() && assignQueue.peek().freeTime <= time) {
                serverQueue.add(assignQueue.poll().server);
            }
			// assign tasks to available servers
            // using condition "j <= time" because accd. to question "At second j, the jth task is inserted into the queue"
            while (!serverQueue.isEmpty() && j <= time && j < tasks.length) {
                int task = tasks[j];
                Server server = serverQueue.poll();
                ans[j] = server.index;
                assignQueue.add(new Assign(time + task, server));
                ++j;
            }
            // increase time, so that we can process next task
            if (!serverQueue.isEmpty())
                time++;
            else
                // when no servers are available, move to next available server\'s freeTime
				// this decreases loop iterations, since there can be a situation where time <<< next freeTime
                time = assignQueue.peek().freeTime;
        }

        return ans;
    }
```

</details>
