# Find the Distance Value Between Two Arrays

| Field | Value |
|-------|-------|
| **Platform** | LeetCode |
| **Difficulty** | Easy |
| **Language** | java |
| **Solved On** | November 17, 2026 |
| **Tags** | Array, Two Pointers, Binary Search, Sorting |
| **Link** | [View Problem](https://leetcode.com/problems/find-the-distance-value-between-two-arrays/) |
| **Runtime** | 7 ms |
| **Memory** | 46.1 MB |

## Problem Description

<p dir="ltr">You are given two integer arrays <code dir="ltr">arr1</code> and <code dir="ltr">arr2</code>, and an integer <code dir="ltr">d</code>.</p>

<p dir="ltr">An element <code dir="ltr">arr1[i]</code> is called <strong>far</strong> when every element <code dir="ltr">arr2[j]</code> satisfies <code dir="ltr">|arr1[i] - arr2[j]| &gt; d</code>. In other words, no element of <code dir="ltr">arr2</code> lies within distance <code dir="ltr">d</code> of it.</p>

<p dir="ltr">Return the <strong>distance</strong> value, which is the number of <strong>far</strong> elements in <code dir="ltr">arr1</code>.</p>

<p>&nbsp;</p>
<p><span class="float-right -my-0.5 ml-2 inline-flex select-none items-center" data-example-lang-controls=""><span role="group" class="inline-flex h-6 items-center rounded-sd-md bg-sd-muted p-0.5" data-example-lang-toggle=""><button type="button" aria-pressed="true" class="h-5 max-w-[10rem] truncate whitespace-nowrap rounded-sd-sm border px-2 text-xs font-normal leading-none border-sd-border bg-sd-background text-sd-foreground">Original</button><button type="button" aria-pressed="false" class="h-5 max-w-[10rem] truncate whitespace-nowrap rounded-sd-sm border px-2 text-xs font-normal leading-none border-transparent text-sd-muted-foreground hover:text-sd-foreground">Java</button></span></span><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">arr1 = [4,5,8], arr2 = [10,9,1,8], d = 2</span></p>

<p><strong>Output:</strong> <span class="example-io">2</span></p>

<p><strong>Explanation:</strong></p>

<ul>
	<li>4 is far. Its nearest value in <code>arr2</code> is 1, and <code>|4 - 1| = 3</code>, which is greater than <code>d = 2</code>.</li>
	<li>5 is far. Its nearest value in <code>arr2</code> is 8, and <code>|5 - 8| = 3</code>, which is greater than <code>d = 2</code>.</li>
	<li>8 is not far, because <code>|8 - 8| = 0</code> is at most <code>d = 2</code>.</li>
	<li>Two elements are far, so the distance value is 2.</li>
</ul>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">arr1 = [1,4,2,3], arr2 = [-4,-3,6,10,20,30], d = 3</span></p>

<p><strong>Output:</strong> <span class="example-io">2</span></p>

<p><strong>Explanation:</strong></p>

<ul>
	<li>1 is far. Its nearest value in <code>arr2</code> is -3, and <code>|1 - (-3)| = 4</code>, which is greater than <code>d = 3</code>.</li>
	<li>2 is far. Its nearest value in <code>arr2</code> is 6, and <code>|2 - 6| = 4</code>, which is greater than <code>d = 3</code>.</li>
	<li>4 is not far, because <code>|4 - 6| = 2</code> is at most <code>d = 3</code>.</li>
	<li>3 is not far, because <code>|3 - 6| = 3</code> is at most <code>d = 3</code>.</li>
	<li>Two elements are far, so the distance value is 2.</li>
</ul>
</div>

<p><strong class="example">Example 3:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">arr1 = [2,1,100,3], arr2 = [-5,-2,10,-3,7], d = 6</span></p>

<p><strong>Output:</strong> <span class="example-io">1</span></p>

<p><strong>Explanation:</strong></p>

<ul>
	<li>100 is far. Its nearest value in <code>arr2</code> is 10, and <code>|100 - 10| = 90</code>, which is greater than <code>d = 6</code>.</li>
	<li>2 is not far, because <code>|2 - (-2)| = 4</code> is at most <code>d = 6</code>.</li>
	<li>1 is not far, because <code>|1 - (-2)| = 3</code> is at most <code>d = 6</code>.</li>
	<li>3 is not far, because <code>|3 - 7| = 4</code> is at most <code>d = 6</code>.</li>
	<li>One element is far, so the distance value is 1.</li>
</ul>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= arr1.length, arr2.length &lt;= 500</code></li>
	<li><code>-1000 &lt;= arr1[i], arr2[j] &lt;= 1000</code></li>
	<li><code>0 &lt;= d &lt;= 100</code></li>
</ul>


##  Top Community Optimal Approach

<details>
<summary>Click to expand</summary>

**Title**: [Java] Binary search with explanation
**Author**: [@user8894x](https://leetcode.com/user8894x/)
**Upvotes**: 89 👍
**Link**: [View Original Post](https://leetcode.com/problems/find-the-distance-value-between-two-arrays/solutions/609472/)

---

Expression ```|arr1[i] - arr2[j]| <= d``` equals to ```arr1[i] - d <= arr2[j] <= arr1[i] + d```. So for every value ```val``` in the array ```arr1``` we need to check (using binary search) if the array ```arr2``` contains any value in range from ```val - d``` to ```val + d```. If **not**, increment distance.

```
class Solution {

    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);    
        int distance = 0;
        
        for (int val : arr1) {
            if (notInRange(arr2, val - d, val + d)) {
                distance++;
            }
        }    
        
        return distance;
    }
    
    // Checks if the array doesn\'t contain any value in range (from <= value <= to) using binary search
    private static boolean notInRange(int[] arr, int from, int to) {
        int start = 0;
        int end = arr.length - 1;
        
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] >= from && arr[mid] <= to) {
                return false;
            } else if (arr[mid] < from) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        
        return true;
    }
}
```

</details>
