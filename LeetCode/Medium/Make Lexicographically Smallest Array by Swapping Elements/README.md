# Make Lexicographically Smallest Array by Swapping Elements

| Field | Value |
|-------|-------|
| **Platform** | LeetCode |
| **Difficulty** | Medium |
| **Language** | java |
| **Solved On** | August 29, 2026 |
| **Tags** | Array, Union-Find, Sorting |
| **Link** | [View Problem](https://leetcode.com/problems/make-lexicographically-smallest-array-by-swapping-elements/) |
| **Runtime** | 1 ms |
| **Memory** | 42.8 MB |

## Approach

Pair each value with its original index, sort by value.
Scan the sorted array, splitting into groups whenever the gap between consecutive sorted values exceeds limit.
Within each group, collect the original indices and assign the sorted values back to those indices in ascending order (smallest value → smallest original index) — this gives the lexicographically smallest arrangement for that group.
Combine all groups into the result array.

## Problem Description

<p>You are given a <strong>0-indexed</strong> array of <strong>positive</strong> integers <code>nums</code> and a <strong>positive</strong> integer <code>limit</code>.</p>

<p>In one operation, you can choose any two indices <code>i</code> and <code>j</code> and swap <code>nums[i]</code> and <code>nums[j]</code> <strong>if</strong> <code>|nums[i] - nums[j]| &lt;= limit</code>.</p>

<p>Return <em>the <strong>lexicographically smallest array</strong> that can be obtained by performing the operation any number of times</em>.</p>

<p>An array <code>a</code> is lexicographically smaller than an array <code>b</code> if in the first position where <code>a</code> and <code>b</code> differ, array <code>a</code> has an element that is less than the corresponding element in <code>b</code>. For example, the array <code>[2,10,3]</code> is lexicographically smaller than the array <code>[10,2,3]</code> because they differ at index <code>0</code> and <code>2 &lt; 10</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> nums = [1,5,3,9,8], limit = 2
<strong>Output:</strong> [1,3,5,8,9]
<strong>Explanation:</strong> Apply the operation 2 times:
- Swap nums[1] with nums[2]. The array becomes [1,3,5,9,8]
- Swap nums[3] with nums[4]. The array becomes [1,3,5,8,9]
We cannot obtain a lexicographically smaller array by applying any more operations.
Note that it may be possible to get the same result by doing different operations.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> nums = [1,7,6,18,2,1], limit = 3
<strong>Output:</strong> [1,6,7,18,1,2]
<strong>Explanation:</strong> Apply the operation 3 times:
- Swap nums[1] with nums[2]. The array becomes [1,6,7,18,2,1]
- Swap nums[0] with nums[4]. The array becomes [2,6,7,18,1,1]
- Swap nums[0] with nums[5]. The array becomes [1,6,7,18,1,2]
We cannot obtain a lexicographically smaller array by applying any more operations.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> nums = [1,7,28,19,10], limit = 3
<strong>Output:</strong> [1,7,28,19,10]
<strong>Explanation:</strong> [1,7,28,19,10] is the lexicographically smallest array we can obtain because we cannot apply the operation on any two indices.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= nums[i] &lt;= 10<sup>9</sup></code></li>
	<li><code>1 &lt;= limit &lt;= 10<sup>9</sup></code></li>
</ul>


##  Top Community Optimal Approach

<details>
<summary>Click to expand</summary>

**Title**: 🥇 C++ | PYTHON | JAVA || EXPLAINED || ; ] ✅
**Author**: [@karan_8082](https://leetcode.com/karan_8082/)
**Upvotes**: 62 👍
**Link**: [View Original Post](https://leetcode.com/problems/make-lexicographically-smallest-array-by-swapping-elements/solutions/4330616/)

---

**UPVOTE IF HELPFuuL**

# Intuition
- We have to make the array lexicographically smallest by swapping elements.
- Only Those elements can be swapped whose difference is ```<= limit```
- We can form subarrays [By removing elements from orginal array] such that 
- - Difference between successive elements is ```<=k```
- - Array is sorted in ```non-dreasing``` order
- - No ```2 subarray``` should have a common element.

- Then we can combine all subarrays keeping their relative position to original array same.

# Approach
We create Tuples ```[array[i], index_of(array[i]) -> i]``` -> ```[a[i], i]```
* We sort array in ```non-decreasing``` manner.
* Then group the elements such that difference to its neighbor is ```<=k```

We get certain ``sorted`` groups.
For result to be in ``lexicographically`` smallest condition, elements in result should occur in same manner as they occur in groups.
With the help of ``index`` stored in tuples, we re-arrange elements in original array.

Example 
``Division into groups is done on basis of differnce <= limit``
``We kept the indexes stored to make replacements in final array``
![Screenshot 2023-11-26 at 10.59.45 AM.png](https://assets.leetcode.com/users/images/f61ef525-c2e7-419c-bbe2-92c74646c98b_1700976600.3129516.png)



# Complexity
- Time complexity:
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity:
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

```Python []
class Solution:
    def lexicographicallySmallestArray(self, a: List[int], k: int) -> List[int]:
        b = []
        n = len(a)
        for i in range(n):
            b.append((a[i],i))
        b = sorted(b,key=lambda x: x[0])
        
        c = [[b[0]]]
        for i in range(1,n):
            if b[i][0]-b[i-1][0] <= k:
                c[-1].append(b[i])
            else:
                c.append([b[i]])
        for t in c:
            ind = []
            for x,y in t:
                ind.append(y)
            ind.sort()
            for i in range(len(ind)):
                a[ind[i]] = t[i][0]
        return a
```
```C++ []
class Solution {
public:
    vector<int> lexicographicallySmallestArray(vector<int>& nums, int limit) {
        vector<pair<int, int>> b;
        int n = nums.size();

        for (int i = 0; i < n; ++i)
            b.push_back(make_pair(nums[i], i));

        sort(b.begin(), b.end(), [](const auto& x, const auto& y) {
            return x.first < y.first;
        });
        vector<vector<pair<int, int>>> c = {{b[0]}};

        for (int i = 1; i < n; ++i) {
            if (b[i].first - b[i - 1].first <= limit)
                c.back().push_back(b[i]);
            else
                c.push_back({b[i]});
        }

        for (const auto& t : c) {
            vector<int> ind;
            for (const auto& p : t)
                ind.push_back(p.second);
            sort(ind.begin(), ind.end());

            for (int i = 0; i < ind.size(); ++i)
                nums[ind[i]] = t[i].first;
        }
        return nums;
    }
};
```
```JAVA []
public class Solution {
    public static class Pair {
        int element;
        int index;

        Pair(int element, int index) {
            this.element = element;
            this.index = index;
        }
    }
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        List<Pair> pairs = new ArrayList<>();
        for (int i = 0; i < n; ++i) 
            pairs.add(new Pair(nums[i], i));
        pairs.sort(Comparator.comparingInt(p -> p.element));

        List<List<Pair>> result = new ArrayList<>();
        result.add(new ArrayList<>(Arrays.asList(pairs.get(0))));

        for (int i = 1; i < n; ++i) {
            if (pairs.get(i).element - pairs.get(i - 1).element <= limit)
                result.get(result.size() - 1).add(pairs.get(i));
            else
                result.add(new ArrayList<>(Arrays.asList(pairs.get(i))));
        }

        for (List<Pair> group : result) {
            List<Pair> sortedGroup = new ArrayList<>(group);
            sortedGroup.sort(Comparator.comparingInt(p -> p.index));

            for (int i = 0; i < group.size(); ++i)
                nums[sortedGroup.get(i).index] = group.get(i).element;
        }
        return nums;
    }
}

```
![IMG_3740.JPG](https://assets.leetcode.com/users/images/b212cd1e-76ef-4472-838c-579028771fa7_1700974270.8774912.jpeg)


</details>
