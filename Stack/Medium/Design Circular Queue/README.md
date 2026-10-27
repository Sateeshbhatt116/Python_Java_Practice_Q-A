# Design Circular Queue

| Field | Value |
|-------|-------|
| **Platform** | LeetCode |
| **Difficulty** | Medium |
| **Language** | java |
| **Solved On** | October 27, 2026 |
| **Tags** | Array, Linked List, Design, Queue |
| **Link** | [View Problem](https://leetcode.com/problems/design-circular-queue/) |
| **Runtime** | 5 ms |
| **Memory** | 46.1 MB |

## Problem Description

<p>Design your implementation of the circular queue. The circular queue is a linear data structure in which the operations are performed based on FIFO (First In First Out) principle, and the last position is connected back to the first position to make a circle. It is also called "Ring Buffer".</p>

<p>One of the benefits of the circular queue is that we can make use of the spaces in front of the queue. In a normal queue, once the queue becomes full, we cannot insert the next element even if there is a space in front of the queue. But using the circular queue, we can use the space to store new values.</p>

<p>Implement the <code>MyCircularQueue</code> class:</p>

<ul>
	<li><code>MyCircularQueue(k)</code> Initializes the object with the size of the queue to be <code>k</code>.</li>
	<li><code>int Front()</code> Gets the front item from the queue. If the queue is empty, return <code>-1</code>.</li>
	<li><code>int Rear()</code> Gets the last item from the queue. If the queue is empty, return <code>-1</code>.</li>
	<li><code>boolean enQueue(int value)</code> Inserts an element into the circular queue. Return <code>true</code> if the operation is successful.</li>
	<li><code>boolean deQueue()</code> Deletes an element from the circular queue. Return <code>true</code> if the operation is successful.</li>
	<li><code>boolean isEmpty()</code> Checks whether the circular queue is empty or not.</li>
	<li><code>boolean isFull()</code> Checks whether the circular queue is full or not.</li>
</ul>

<p>You must solve the problem without using the built-in queue data structure in your programming language.&nbsp;</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input</strong>
["MyCircularQueue", "enQueue", "enQueue", "enQueue", "enQueue", "Rear", "isFull", "deQueue", "enQueue", "Rear"]
[[3], [1], [2], [3], [4], [], [], [], [4], []]
<strong>Output</strong>
[null, true, true, true, false, 3, true, true, true, 4]

<strong>Explanation</strong>
MyCircularQueue myCircularQueue = new MyCircularQueue(3);
myCircularQueue.enQueue(1); // return True
myCircularQueue.enQueue(2); // return True
myCircularQueue.enQueue(3); // return True
myCircularQueue.enQueue(4); // return False
myCircularQueue.Rear();     // return 3
myCircularQueue.isFull();   // return True
myCircularQueue.deQueue();  // return True
myCircularQueue.enQueue(4); // return True
myCircularQueue.Rear();     // return 4
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= k &lt;= 1000</code></li>
	<li><code>0 &lt;= value &lt;= 1000</code></li>
	<li>At most <code>3000</code> calls will be made to&nbsp;<code>enQueue</code>, <code>deQueue</code>,&nbsp;<code>Front</code>,&nbsp;<code>Rear</code>,&nbsp;<code>isEmpty</code>, and&nbsp;<code>isFull</code>.</li>
</ul>


##  Top Community Optimal Approach

<details>
<summary>Click to expand</summary>

**Title**: JS, Python, Java, C++ | Simple Array Solution w/ Explanation
**Author**: [@sgallivan](https://leetcode.com/sgallivan/)
**Upvotes**: 123 👍
**Link**: [View Original Post](https://leetcode.com/problems/design-circular-queue/solutions/1141876/)

---

*(Note: This is part of a series of Leetcode solution explanations. If you like this solution or find it useful,* ***please upvote*** *this post.)*

---

#### ***Idea:***

(*Update: On my initial read of the problem, I skipped the second half of the first paragraph which talks about connecting the end of the data structure to its beginning, so I chose a **linked list** approach with the idea of saving on unused data structure memory allocation. But with the full description in mind, the more correct interpretation would be an **array**-based approach with rolling indexes for the head and the tail of the queue. I\'ve left the code for the linked list approach below, but I\'ve updated this solution to effect the change in approach.*)

Since this problem tasks us with creating a queue data structure that is connected front-to-back, but with a set size, we should be thinking of the standard **array**-based queue structure, but modified with a **modulo index system** in order to reuse the cleared space at the beginning of the queue without the need to constantly reallocate with push and shift operations.

Otherwise, the code here is fairly straightforward. We\'ll use a modulo index system to seamlessly connect the back to the front of the queue and separate pointers for the **head** and **tail**.

One challenge will be defining our **isEmpty** state. There are several options, but rather than using any other variables, and since the **enQueue** method will naturally increment **tail**, we can use **tail = -1** to represent an empty queue, which will conveniently lead into **tail = 0** once we add our first entry.

That means that our **deQueue** method will need to reset back to this initial condition if there\'s only one element left (**head = tail**) prior to its removal.

Finally, the queue **isFull** when the **tail** is just behind the **head**, except for the case of an empty queue.

---

#### ***Javascript Code w/ Array Modulo:***
```javascript
class MyCircularQueue {
    constructor(k) {
        this.data = new Uint16Array(k)
        this.maxSize = k
        this.head = 0
        this.tail = -1
    }
    enQueue(val) {
        if (this.isFull()) return false
        this.tail = (this.tail + 1) % this.maxSize
        this.data[this.tail] = val
        return true
    }
    deQueue() {
        if (this.isEmpty()) return false
        if (this.head === this.tail) this.head = 0, this.tail = -1
        else this.head = (this.head + 1) % this.maxSize
        return true
    }
    Front() {
        return this.isEmpty() ? -1 : this.data[this.head]
    }
    Rear() {
        return this.isEmpty() ? -1 : this.data[this.tail]
    }
    isEmpty() {
        return this.tail === -1
    }
    isFull() {
        return !this.isEmpty() && (this.tail + 1) % this.maxSize === this.head
    };
};
```


#### ***Javascript Code w/ Linked List:***
```javascript
class ListNode {
    constructor(val, next=null) {
        this.val = val
        this.next = next
    }
}
class MyCircularQueue {
    constructor(k) {
        this.maxSize = k
        this.size = 0
        this.head = null
        this.tail = null
    }
    enQueue(val) {
        if (this.isFull()) return false
        let newNode = new ListNode(val)
        if (this.isEmpty()) this.head = this.tail = newNode
        else this.tail.next = newNode, this.tail = this.tail.next
        this.size++
        return true
    }
    deQueue() {
        if (this.isEmpty()) return false
        this.head = this.head.next
        this.size--
        return true
    }
    Front() {
        return this.isEmpty() ? -1 : this.head.val
    }
    Rear() {
        return this.isEmpty() ? -1 : this.tail.val
    }
    isEmpty() {
        return (this.size === 0)
    }
    isFull() {
        return (this.size === this.maxSize)
    };
};
```

---

#### ***Python Code w/ Array Modulo:***
```python
class MyCircularQueue:
    def __init__(self, k: int):
        self.data = [0] * k
        self.maxSize = k
        self.head = 0
        self.tail = -1
    def enQueue(self, val: int) -> bool:
        if self.isFull(): return False
        self.tail = (self.tail + 1) % self.maxSize
        self.data[self.tail] = val
        return True
    def deQueue(self) -> bool:
        if self.isEmpty(): return False
        if self.head == self.tail: self.head, self.tail = 0, -1
        else: self.head = (self.head + 1) % self.maxSize
        return True
    def Front(self) -> int:
        return -1 if self.isEmpty() else self.data[self.head]
    def Rear(self) -> int:
        return -1 if self.isEmpty() else self.data[self.tail]
    def isEmpty(self) -> bool:
        return self.tail == -1
    def isFull(self) -> bool:
        return not self.isEmpty() and (self.tail + 1) % self.maxSize == self.head
```

---

#### ***Python Code w/ Linked List:***
```python
class ListNode:
    def __init__(self, val: int, nxt: ListNode = None):
        self.val = val
        self.next = nxt
class MyCircularQueue:
    def __init__(self, k: int):
        self.maxSize = k
        self.size = 0
        self.head = None
        self.tail = None
    def enQueue(self, val: int) -> bool:
        if self.isFull(): return False
        newNode = ListNode(val)
        if self.isEmpty(): self.head = self.tail = newNode
        else: 
            self.tail.next = newNode
            self.tail = self.tail.next
        self.size += 1
        return True
    def deQueue(self) -> bool:
        if self.isEmpty(): return False
        self.head = self.head.next
        self.size -= 1
        return True
    def Front(self) -> int:
        return -1 if self.isEmpty() else self.head.val
    def Rear(self) -> int:
        return -1 if self.isEmpty() else self.tail.val
    def isEmpty(self) -> bool:
        return self.size == 0
    def isFull(self) -> bool:
        return self.size == self.maxSize
```

---

#### ***Java Code w/ Array Modulo:***
```java
class MyCircularQueue {
    int maxSize, head = 0, tail = -1;
    int[] data;
    public MyCircularQueue(int k) {
        data = new int[k];
        maxSize = k;
    }
    public boolean enQueue(int val) {
        if (isFull()) return false;
        tail = (tail + 1) % maxSize;
        data[tail] = val;
        return true;
    }
    public boolean deQueue() {
        if (isEmpty()) return false;
        if (head == tail) {
            head = 0;
            tail = -1;
        } else head = (head + 1) % maxSize;
        return true;
    }
    public int Front() {
        return isEmpty() ? -1 : data[head];
    }
    public int Rear() {
        return isEmpty() ? -1 : data[tail];
    }
    public boolean isEmpty() {
        return tail == -1;
    }
    public boolean isFull() {
        return !isEmpty() && (tail + 1) % maxSize == head;
    }
```

---

#### ***Java Code w/ Linked List:***
```java
class ListNode {
    int val;
    ListNode next;
    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
class MyCircularQueue {
    int maxSize, size = 0;
    ListNode head = null, tail = null;
    public MyCircularQueue(int k) {
        maxSize = k;
    }
    public boolean enQueue(int val) {
        if (isFull()) return false;
        ListNode newNode = new ListNode(val, null);
        if (isEmpty()) head = tail = newNode;
        else {
            tail.next = newNode;
            tail = tail.next;
        }
        size++;
        return true;
    }
    public boolean deQueue() {
        if (isEmpty()) return false;
        head = head.next;
        size--;
        return true;
    }
    public int Front() {
        return isEmpty() ? -1 : head.val;
    }
    public int Rear() {
        return isEmpty() ? -1 : tail.val;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public boolean isFull() {
        return size == maxSize;
    }
}
```

---

#### ***C++ Code w/ Array Modulo:***
```c++
class MyCircularQueue {
public:
    MyCircularQueue(int k) {
        data.resize(k);
        maxSize = k;
    }
    bool enQueue(int val) {
        if (isFull()) return false;
        tail = (tail + 1) % maxSize;
        data[tail] = val;
        return true;
    }
    bool deQueue() {
        if (isEmpty()) return false;
        if (head == tail) head = 0, tail = -1;
        else head = (head + 1) % maxSize;
        return true;
    }
    int Front() {
        return isEmpty() ? -1 : data[head];
    }
    int Rear() {
        return isEmpty() ? -1 : data[tail];
    }
    bool isEmpty() {
        return tail == -1;
    }
    bool isFull() {
        return !isEmpty() && (tail + 1) % maxSize == head;
    }
private:
    int maxSize, head = 0, tail = -1;
    vector<int> data;
};
```

---

#### ***C++ Code w/ Linked List:***
```c++
struct Node {
public:
    int val;
    Node* next;
    Node(int v, Node* n=nullptr) {
        val = v;
        next = n;
    }
};
class MyCircularQueue {
public:
    MyCircularQueue(int k) {
        maxSize = k;
    }
    bool enQueue(int val) {
        if (isFull()) return false;
        Node* newNode = new Node(val);
        if (isEmpty()) head = newNode, tail = newNode;
        else tail->next = newNode, tail = tail->next;
        size++;
        return true;
    }
    bool deQueue() {
        if (isEmpty()) return false;
        Node* rem = head;
        head = head->next;
        delete rem;
        size--;
        return true;
    }
    int Front() {
        return isEmpty() ? -1 : head->val;
    }
    int Rear() {
        return isEmpty() ? -1 : tail->val;
    }
    bool isEmpty() {
        return size == 0;
    }
    bool isFull() {
        return size == maxSize;
    }
private:
    int maxSize, size = 0;
    Node *head = new Node(0), *tail = new Node(0);
};
```

</details>
