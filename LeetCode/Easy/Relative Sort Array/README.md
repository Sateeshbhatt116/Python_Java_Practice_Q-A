# Relative Sort Array

| Field | Value |
|-------|-------|
| **Platform** | LeetCode |
| **Difficulty** | Easy |
| **Language** | java |
| **Solved On** | August 25, 2026 |
| **Tags** | Array, Hash Table, Sorting, Counting Sort, Quicksort, Bubble Sort |
| **Link** | [View Problem](https://leetcode.com/problems/relative-sort-array/) |
| **Runtime** | 0 ms |
| **Memory** | 42.8 MB |

## Approach

Create a frequency array of size 1001 to store the count of each element in arr1.
Traverse arr1 and increase the frequency of every element.
Traverse arr2 and add its elements to arr1 according to their frequency. This maintains the order given by arr2.
Set the frequency of processed elements to 0.
Traverse the frequency array from 0 to 1000 and add the remaining elements in ascending order.
Return the modified arr1.

Time Complexity: O(n + k)
Space Complexity: O(k)
Category: Array + Counting/Frequency + Sorting

## Problem Description

<p>Given two arrays <code>arr1</code> and <code>arr2</code>, the elements of <code>arr2</code> are distinct, and all elements in <code>arr2</code> are also in <code>arr1</code>.</p>

<p>Sort the elements of <code>arr1</code> such that the relative ordering of items in <code>arr1</code> are the same as in <code>arr2</code>. Elements that do not appear in <code>arr2</code> should be placed at the end of <code>arr1</code> in <strong>ascending</strong> order.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
<strong>Output:</strong> [2,2,2,1,4,3,3,9,6,7,19]
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> arr1 = [28,6,22,8,44,17], arr2 = [22,28,8,6]
<strong>Output:</strong> [22,28,8,6,17,44]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= arr1.length, arr2.length &lt;= 1000</code></li>
	<li><code>0 &lt;= arr1[i], arr2[i] &lt;= 1000</code></li>
	<li>All the elements of <code>arr2</code> are <strong>distinct</strong>.</li>
	<li>Each&nbsp;<code>arr2[i]</code> is in <code>arr1</code>.</li>
</ul>


##  Top Community Optimal Approach

<details>
<summary>Click to expand</summary>

**Title**: Java in-place solution using counting sort
**Author**: [@motorix](https://leetcode.com/motorix/)
**Upvotes**: 262 👍
**Link**: [View Original Post](https://leetcode.com/problems/relative-sort-array/solutions/335056/)

---

1. Because ```0 <= arr1[i], arr2[i] <= 1000```, we use an array to count every element.
2. Go through every element in the second array, and update values of the first array based on the order in the second array.
```
class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] cnt = new int[1001];
        for(int n : arr1) cnt[n]++;
        int i = 0;
        for(int n : arr2) {
            while(cnt[n]-- > 0) {
                arr1[i++] = n;
            }
        }
        for(int n = 0; n < cnt.length; n++) {
            while(cnt[n]-- > 0) {
                arr1[i++] = n;
            }
        }
        return arr1;
    }
}
```
Time: O(N)
Space: O(1)

--
**Follow-up: What if this constraint ```0 <= arr1[i], arr2[i] <= 1000``` doesn\'t exist?**
Use TreeMap.
```
class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int n : arr1) map.put(n, map.getOrDefault(n, 0) + 1);
        int i = 0;
        for(int n : arr2) {
            for(int j = 0; j < map.get(n); j++) {
                arr1[i++] = n;
            }
            map.remove(n);
        }
        for(int n : map.keySet()){
            for(int j = 0; j < map.get(n); j++) {
                arr1[i++] = n;
            }
        }
        return arr1;
    }
}
```
Time: O(NlogN)
Space: O(N)

Or use HashMap + PriorityQueue

HashMap is to count those elements in arr2. PriorityQueue is for sorting those elements not in arr2.

```
class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int n : arr1) {
            if (map.containsKey(n)) {
                map.put(n, map.getOrDefault(n, 0) + 1);
            } else {
                pq.add(n);
            }
        }
        int i = 0;
        for (int j = 0; j < arr2.length; j++) {
            if (map.containsKey(arr2[j])) {
                for (int k = map.get(arr2[j]); k > 0; k--) {
                    arr1[i++] = arr2[j];
                }
            }
        }
        while(!pq.isEmpty()) {
            arr1[i++] = pq.poll();
        }
        return arr1;
    }
}
```
Time: O(NlogN)
Space: O(N)

</details>
