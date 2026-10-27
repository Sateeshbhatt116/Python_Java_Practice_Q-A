# Next Greater Element I

| Field | Value |
|-------|-------|
| **Platform** | LeetCode |
| **Difficulty** | Easy |
| **Language** | java |
| **Solved On** | October 27, 2026 |
| **Tags** | Array, Hash Table, Stack, Monotonic Stack |
| **Link** | [View Problem](https://leetcode.com/problems/next-greater-element-i/) |
| **Runtime** | 3 ms |
| **Memory** | 44.4 MB |

## Problem Description

<p>The <strong>next greater element</strong> of some element <code>x</code> in an array is the <strong>first greater</strong> element that is <strong>to the right</strong> of <code>x</code> in the same array.</p>

<p>You are given two <strong>distinct 0-indexed</strong> integer arrays <code>nums1</code> and <code>nums2</code>, where <code>nums1</code> is a subset of <code>nums2</code>.</p>

<p>For each <code>0 &lt;= i &lt; nums1.length</code>, find the index <code>j</code> such that <code>nums1[i] == nums2[j]</code> and determine the <strong>next greater element</strong> of <code>nums2[j]</code> in <code>nums2</code>. If there is no next greater element, then the answer for this query is <code>-1</code>.</p>

<p>Return <em>an array </em><code>ans</code><em> of length </em><code>nums1.length</code><em> such that </em><code>ans[i]</code><em> is the <strong>next greater element</strong> as described above.</em></p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> nums1 = [4,1,2], nums2 = [1,3,4,2]
<strong>Output:</strong> [-1,3,-1]
<strong>Explanation:</strong> The next greater element for each value of nums1 is as follows:
- 4 is underlined in nums2 = [1,3,<u>4</u>,2]. There is no next greater element, so the answer is -1.
- 1 is underlined in nums2 = [<u>1</u>,3,4,2]. The next greater element is 3.
- 2 is underlined in nums2 = [1,3,4,<u>2</u>]. There is no next greater element, so the answer is -1.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> nums1 = [2,4], nums2 = [1,2,3,4]
<strong>Output:</strong> [3,-1]
<strong>Explanation:</strong> The next greater element for each value of nums1 is as follows:
- 2 is underlined in nums2 = [1,<u>2</u>,3,4]. The next greater element is 3.
- 4 is underlined in nums2 = [1,2,3,<u>4</u>]. There is no next greater element, so the answer is -1.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums1.length &lt;= nums2.length &lt;= 1000</code></li>
	<li><code>0 &lt;= nums1[i], nums2[i] &lt;= 10<sup>4</sup></code></li>
	<li>All integers in <code>nums1</code> and <code>nums2</code> are <strong>unique</strong>.</li>
	<li>All the integers of <code>nums1</code> also appear in <code>nums2</code>.</li>
</ul>

<p>&nbsp;</p>
<strong>Follow up:</strong> Could you find an <code>O(nums1.length + nums2.length)</code> solution?

##  Top Community Optimal Approach

<details>
<summary>Click to expand</summary>

**Title**: Java easy solution || Brute and optimal || Stack || Diagrammatic explanation
**Author**: [@Chaitanya31612](https://leetcode.com/Chaitanya31612/)
**Upvotes**: 134 👍
**Link**: [View Original Post](https://leetcode.com/problems/next-greater-element-i/solutions/1579935/)

---

# Brute
Time - **O(n^2)**

**Code**

```java
public int[] nextGreaterElementBrute(int[] nums1, int[] nums2) {
	int[] ans = new int[nums1.length];

	for(int i = 0; i < nums1.length; i++) {
		int greaterIdx = -1, j = nums2.length - 1;
		while(j >= 0 && nums2[j] != nums1[i]) {
			if(nums2[j] > nums1[i]){
				greaterIdx = nums2[j];
			}
			j--;
		}
		ans[i] = greaterIdx;
	}

	return ans;
}
```

**Explanation**
This is actually a bit modified brute force, in this the logic is to start searching backwards until `nums2[j] != nums1[i]` check fails, and update `greaterIdx` to `nums2[j]` if `nums2[j] > nums1[i]`. 
Then update ans[i] to greaterIdx, it will be -1 in case no greater element and value if exists.
Then return ans


# Optimal
Time - **O(n)** where n is length of nums2 as it is equal to or greater than nums1, 

**Code**
```java
public int[] nextGreaterElement(int[] nums1, int[] nums2) {
	int[] ans = new int[nums1.length];

	Stack<Integer> stack = new Stack<>();
	HashMap<Integer, Integer> map = new HashMap<>();

	// find out all the next greater elements in nums2 array
	for(int num: nums2) {
		// if num is greater than top elements in stack then it is the next greater element in nums2
		while(!stack.isEmpty() && num > stack.peek()) {
			map.put(stack.pop(), num);
		}
		// then add num to stack
		stack.add(num);
	}

	int i = 0;
	for(int num : nums1) {
		ans[i++] = map.getOrDefault(num, -1);
	}

	return ans;
}
```

**Explanation**
This approach uses stack, the main point is to store next greater element for all the elements in `nums2` array. It does that by following steps:-
- In this we traverse `nums2` array and add the element to stack if either stack is empty or the element is smaller than the top element.
- If case occurs when the element is greater then top in the stack then that means current element is the next greater element for that top element in stack, remove that and add it\'s entry in map.
- Repeat this until either stack becomes empty or that element is no longer larger than top in stack.
- Now iterate through nums1 and put entries in ans array by fetching it from map.
- return ans

Here are some examples for better understanding

![image](https://assets.leetcode.com/users/images/e4fd7005-519b-40bc-9b07-ef10fc5e9921_1636997239.2652416.png)

![image](https://assets.leetcode.com/users/images/ab02713e-5a91-40c0-a004-d48fcdbc97d2_1636997254.9248097.png)


Hope it helps
Do upvote
Thanks

</details>
