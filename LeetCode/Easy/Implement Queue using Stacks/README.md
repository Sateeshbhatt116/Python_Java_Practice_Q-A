# Implement Queue using Stacks

| Field | Value |
|-------|-------|
| **Platform** | LeetCode |
| **Difficulty** | Easy |
| **Language** | java |
| **Solved On** | October 22, 2026 |
| **Tags** | Stack, Design, Queue |
| **Link** | [View Problem](https://leetcode.com/problems/implement-queue-using-stacks/) |
| **Runtime** | 0 ms |
| **Memory** | 42.3 MB |

## Problem Description

<p>Implement a first in first out (FIFO) queue using only two stacks. The implemented queue should support all the functions of a normal queue (<code>push</code>, <code>peek</code>, <code>pop</code>, and <code>empty</code>).</p>

<p>Implement the <code>MyQueue</code> class:</p>

<ul>
	<li><code>void push(int x)</code> Pushes element x to the back of the queue.</li>
	<li><code>int pop()</code> Removes the element from the front of the queue and returns it.</li>
	<li><code>int peek()</code> Returns the element at the front of the queue.</li>
	<li><code>boolean empty()</code> Returns <code>true</code> if the queue is empty, <code>false</code> otherwise.</li>
</ul>

<p><strong>Notes:</strong></p>

<ul>
	<li>You must use <strong>only</strong> standard operations of a stack, which means only <code>push to top</code>, <code>peek/pop from top</code>, <code>size</code>, and <code>is empty</code> operations are valid.</li>
	<li>Depending on your language, the stack may not be supported natively. You may simulate a stack using a list or deque (double-ended queue) as long as you use only a stack's standard operations.</li>
</ul>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input</strong>
["MyQueue", "push", "push", "peek", "pop", "empty"]
[[], [1], [2], [], [], []]
<strong>Output</strong>
[null, null, null, 1, 1, false]

<strong>Explanation</strong>
MyQueue myQueue = new MyQueue();
myQueue.push(1); // queue is: [1]
myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
myQueue.peek(); // return 1
myQueue.pop(); // return 1, queue is [2]
myQueue.empty(); // return false
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= x &lt;= 9</code></li>
	<li>At most <code>100</code>&nbsp;calls will be made to <code>push</code>, <code>pop</code>, <code>peek</code>, and <code>empty</code>.</li>
	<li>All the calls to <code>pop</code> and <code>peek</code> are valid.</li>
</ul>

<p>&nbsp;</p>
<p><strong>Follow-up:</strong> Can you implement the queue such that each operation is <strong><a href="https://en.wikipedia.org/wiki/Amortized_analysis" target="_blank">amortized</a></strong> <code>O(1)</code> time complexity? In other words, performing <code>n</code> operations will take overall <code>O(n)</code> time even if one of those operations may take longer.</p>


##  Top Community Optimal Approach

<details>
<summary>Click to expand</summary>

**Title**: Short O(1) amortized, C++ / Java / Ruby
**Author**: [@StefanPochmann](https://leetcode.com/StefanPochmann/)
**Upvotes**: 902 👍
**Link**: [View Original Post](https://leetcode.com/problems/implement-queue-using-stacks/solutions/64206/)

---

I have one input stack, onto which I push the incoming elements, and one output stack, from which I peek/pop. I move elements from input stack to output stack when needed, i.e., when I need to peek/pop but the output stack is empty. When that happens, I move all elements from input to output stack, thereby reversing the order so it's the correct order for peek/pop.

The loop in `peek` does the moving from input to output stack. Each element only ever gets moved like that once, though, and only after we already spent time pushing it, so the overall amortized cost for each operation is O(1).

**Ruby**

    class Queue
        def initialize
            @in, @out = [], []
        end
    
        def push(x)
            @in << x
        end
    
        def pop
            peek
            @out.pop
        end
    
        def peek
            @out << @in.pop until @in.empty? if @out.empty?
            @out.last
        end
    
        def empty
            @in.empty? && @out.empty?
        end
    end

**Java**

    class MyQueue {
    
        Stack<Integer> input = new Stack();
        Stack<Integer> output = new Stack();
        
        public void push(int x) {
            input.push(x);
        }
    
        public void pop() {
            peek();
            output.pop();
        }
    
        public int peek() {
            if (output.empty())
                while (!input.empty())
                    output.push(input.pop());
            return output.peek();
        }
    
        public boolean empty() {
            return input.empty() && output.empty();
        }
    }

**C++**

    class Queue {
        stack<int> input, output;
    public:
    
        void push(int x) {
            input.push(x);
        }
    
        void pop(void) {
            peek();
            output.pop();
        }
    
        int peek(void) {
            if (output.empty())
                while (input.size())
                    output.push(input.top()), input.pop();
            return output.top();
        }
    
        bool empty(void) {
            return input.empty() && output.empty();
        }
    };

</details>
