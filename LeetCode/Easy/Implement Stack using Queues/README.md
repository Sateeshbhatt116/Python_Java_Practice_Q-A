# Implement Stack using Queues

| Field | Value |
|-------|-------|
| **Platform** | LeetCode |
| **Difficulty** | Easy |
| **Language** | java |
| **Solved On** | October 21, 2026 |
| **Tags** | Stack, Design, Queue |
| **Link** | [View Problem](https://leetcode.com/problems/implement-stack-using-queues/) |
| **Runtime** | 2 ms |
| **Memory** | 42.5 MB |

## Problem Description

<p>Implement a last-in-first-out (LIFO) stack using only two queues. The implemented stack should support all the functions of a normal stack (<code>push</code>, <code>top</code>, <code>pop</code>, and <code>empty</code>).</p>

<p>Implement the <code>MyStack</code> class:</p>

<ul>
	<li><code>void push(int x)</code> Pushes element x to the top of the stack.</li>
	<li><code>int pop()</code> Removes the element on the top of the stack and returns it.</li>
	<li><code>int top()</code> Returns the element on the top of the stack.</li>
	<li><code>boolean empty()</code> Returns <code>true</code> if the stack is empty, <code>false</code> otherwise.</li>
</ul>

<p><b>Notes:</b></p>

<ul>
	<li>You must use <strong>only</strong> standard operations of a queue, which means that only <code>push to back</code>, <code>peek/pop from front</code>, <code>size</code> and <code>is empty</code> operations are valid.</li>
	<li>Depending on your language, the queue may not be supported natively. You may simulate a queue using a list or deque (double-ended queue) as long as you use only a queue's standard operations.</li>
</ul>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input</strong>
["MyStack", "push", "push", "top", "pop", "empty"]
[[], [1], [2], [], [], []]
<strong>Output</strong>
[null, null, null, 2, 2, false]

<strong>Explanation</strong>
MyStack myStack = new MyStack();
myStack.push(1);
myStack.push(2);
myStack.top(); // return 2
myStack.pop(); // return 2
myStack.empty(); // return False
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= x &lt;= 9</code></li>
	<li>At most <code>100</code> calls will be made to <code>push</code>, <code>pop</code>, <code>top</code>, and <code>empty</code>.</li>
	<li>All the calls to <code>pop</code> and <code>top</code> are valid.</li>
</ul>

<p>&nbsp;</p>
<p><strong>Follow-up:</strong> Can you implement the stack using only one queue?</p>


##  Top Community Optimal Approach

<details>
<summary>Click to expand</summary>

**Title**: Concise 1 Queue - Java, C++, Python
**Author**: [@StefanPochmann](https://leetcode.com/StefanPochmann/)
**Upvotes**: 316 👍
**Link**: [View Original Post](https://leetcode.com/problems/implement-stack-using-queues/solutions/62516/)

---

**Explanation:**

Just use a queue where you *"push to front"* by pushing to back and then rotating the queue until the new element is at the front (i.e., size-1 times move the front element to the back).

---

**C++:** 0 ms

    class Stack {
        queue<int> q;
    public:
        void push(int x) {
            q.push(x);
            for (int i=1; i<q.size(); i++) {
                q.push(q.front());
                q.pop();
            }
        }
    
        void pop() {
            q.pop();
        }
    
        int top() {
            return q.front();
        }
    
        bool empty() {
            return q.empty();
        }
    };

---

**Java:** 140 ms

    class MyStack {
    
        private Queue<Integer> queue = new LinkedList<>();
    
        public void push(int x) {
            queue.add(x);
            for (int i=1; i<queue.size(); i++)
                queue.add(queue.remove());
        }
    
        public void pop() {
            queue.remove();
        }
    
        public int top() {
            return queue.peek();
        }
    
        public boolean empty() {
            return queue.isEmpty();
        }
    }

---

**Python:** 36 ms

    class Stack:
    
        def __init__(self):
            self._queue = collections.deque()
    
        def push(self, x):
            q = self._queue
            q.append(x)
            for _ in range(len(q) - 1):
                q.append(q.popleft())
            
        def pop(self):
            return self._queue.popleft()
    
        def top(self):
            return self._queue[0]
        
        def empty(self):
            return not len(self._queue)

</details>
