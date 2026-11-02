# Rank Transform of an Array

| Field | Value |
|-------|-------|
| **Platform** | LeetCode |
| **Difficulty** | Easy |
| **Language** | java |
| **Solved On** | November 2, 2026 |
| **Tags** | Array, Hash Table, Sorting |
| **Link** | [View Problem](https://leetcode.com/problems/rank-transform-of-an-array/) |
| **Runtime** | 33 ms |
| **Memory** | 75 MB |

## Problem Description

<p>Given an array of integers&nbsp;<code>arr</code>, replace each element with its rank.</p>

<p>The rank represents how large the element is. The rank has the following rules:</p>

<ul>
	<li>Rank is an integer starting from 1.</li>
	<li>The larger the element, the larger the rank. If two elements are equal, their rank must be the same.</li>
	<li>Rank should be as small as possible.</li>
</ul>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> arr = [40,10,20,30]
<strong>Output:</strong> [4,1,2,3]
<strong>Explanation</strong>: 40 is the largest element. 10 is the smallest. 20 is the second smallest. 30 is the third smallest.</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> arr = [100,100,100]
<strong>Output:</strong> [1,1,1]
<strong>Explanation</strong>: Same elements share the same rank.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> arr = [37,12,28,9,100,56,80,5,12]
<strong>Output:</strong> [5,3,4,2,8,6,7,1,3]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>0 &lt;= arr.length &lt;= 10<sup>5</sup></code></li>
	<li><code>-10<sup>9</sup>&nbsp;&lt;= arr[i] &lt;= 10<sup>9</sup></code></li>
</ul>


##  Top Community Optimal Approach

<details>
<summary>Click to expand</summary>

**Title**: Simple and Easy to understand | Beats 95% | Python | CPP | Java
**Author**: [@4ty7](https://leetcode.com/4ty7/)
**Upvotes**: 42 👍
**Link**: [View Original Post](https://leetcode.com/problems/rank-transform-of-an-array/solutions/5858069/)

---

# Approach
The approach first eliminates duplicates from the array by converting it to a set and sorts the unique elements. Sorting helps to assign ranks starting from 1 for the smallest element. A dictionary is used to map each unique element to its rank. Then, the original array is updated by replacing each element with its corresponding rank from the dictionary. This ensures that the original order is preserved, and the ranks are assigned correctly. The intuition is that sorting the array allows us to assign ranks in increasing order, while the dictionary enables quick lookups to replace elements efficiently.

# Complexity
- Time complexity:
$$O(NLogN)$$

- Space complexity:
$$O(N)$$

# Code
```python3 []
class Solution:
    def arrayRankTransform(self, arr: List[int]) -> List[int]:
        value_to_rank = {}  # Dictionary to store value-to-rank mapping
        sorted_unique_numbers = sorted(list(set(arr)))  # Remove duplicates and sort unique elements
        
        # Assign ranks to sorted unique elements
        for index in range(len(sorted_unique_numbers)): 
            value_to_rank[sorted_unique_numbers[index]] = index + 1
          
        # Replace each element in the original array with its rank
        for index in range(len(arr)): 
            arr[index] = value_to_rank[arr[index]]
        
        return arr  # Return the updated array
```
```cpp []
class Solution {
public:
    std::vector<int> arrayRankTransform(std::vector<int>& arr) {
        std::unordered_map<int, int> valueToRank;  // Map to store value-to-rank mapping
        std::vector<int> sortedUniqueNumbers = arr; 
        
        // Remove duplicates and sort
        std::sort(sortedUniqueNumbers.begin(), sortedUniqueNumbers.end());
        sortedUniqueNumbers.erase(std::unique(sortedUniqueNumbers.begin(), sortedUniqueNumbers.end()), sortedUniqueNumbers.end());
        
        // Assign ranks to sorted unique elements
        for (int i = 0; i < sortedUniqueNumbers.size(); i++) {
            valueToRank[sortedUniqueNumbers[i]] = i + 1;
        }

        // Replace each element in the original array with its rank
        for (int i = 0; i < arr.size(); i++) {
            arr[i] = valueToRank[arr[i]];
        }

        return arr;  // Return the updated array
    }
};

```
```java []
import java.util.*;

class Solution {
    public int[] arrayRankTransform(int[] arr) {
        Map<Integer, Integer> valueToRank = new HashMap<>();  // Map to store value-to-rank mapping
        int[] sortedUniqueNumbers = Arrays.stream(arr).distinct().sorted().toArray();  // Remove duplicates and sort
        
        // Assign ranks to sorted unique elements
        for (int i = 0; i < sortedUniqueNumbers.length; i++) {
            valueToRank.put(sortedUniqueNumbers[i], i + 1);
        }

        // Replace each element in the original array with its rank
        for (int i = 0; i < arr.length; i++) {
            arr[i] = valueToRank.get(arr[i]);
        }

        return arr;  // Return the updated array
    }
}


```

</details>
