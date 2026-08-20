# Sort Colors

| Field | Value |
|-------|-------|
| **Platform** | LeetCode |
| **Difficulty** | Medium |
| **Language** | java |
| **Solved On** | August 20, 2026 |
| **Tags** | Array, Two Pointers, Sorting, Quicksort, Bubble Sort |
| **Link** | [View Problem](https://leetcode.com/problems/sort-colors/) |
| **Runtime** | 0 ms |
| **Memory** | 43.5 MB |

## Approach

uhebruhaewtrtw awbtabew tuhebruhaewtrtw awbtabew tuhebruhaewtrtw awbtabew tuhebruhaewtrtw awbtabew t

## Problem Description

<p>You are given an array <code>nums</code> with <code>n</code> objects colored red, white, or blue, sort them <strong><a href="https://en.wikipedia.org/wiki/In-place_algorithm" target="_blank">in-place</a> </strong>so that objects of the same color are adjacent, with the colors in the order red, white, and blue.</p>

<p>We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.</p>

<p>You must solve this problem without using the library's sort function.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [2,0,2,1,1,0]</span></p>

<p><strong>Output:</strong> <span class="example-io">[0,0,1,1,2,2]</span></p>

<p><strong>Explanation:</strong></p>

<p>The array has two 0s, two 1s, and two 2s. Sorting them in-place places all 0s first, then all 1s, then all 2s.</p>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [2,0,1]</span></p>

<p><strong>Output:</strong> <span class="example-io">[0,1,2]</span></p>

<p><strong>Explanation:</strong></p>

<p>The array has one each of 0, 1, and 2, arranged in-place in the order 0, 1, 2.</p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>n == nums.length</code></li>
	<li><code>1 &lt;= n &lt;= 300</code></li>
	<li><code>nums[i]</code> is either 0, 1, or 2.</li>
</ul>

<p>&nbsp;</p>
<p><strong>Follow up:</strong>&nbsp;Could you come up with a one-pass algorithm using only&nbsp;constant extra space?</p>


##  Top Community Optimal Approach

<details>
<summary>Click to expand</summary>

**Title**: Solution
**Author**: [@deleted_user](https://leetcode.com/deleted_user/)
**Upvotes**: 485 👍
**Link**: [View Original Post](https://leetcode.com/problems/sort-colors/solutions/3164333/)

---

```C++ []
class Solution {
public:
    void sortColors(vector<int>& nums) {
        int l = 0;
        int m = 0;
        int h = nums.size()-1;

        while(m<=h){
            if(nums[m]==0){
                swap(nums[l], nums[m]);
                l++;
                m++;
            }
            else if(nums[m]==1){
                m++;
            }
            else if(nums[m]==2){
                swap(nums[m], nums[h]);
                h--;
            }
        }
    }
};
```

```Python3 []
class Solution:
    def sortColors(self, nums: List[int]) -> None:

        red, white, blue = 0, 0, len(nums) - 1

        while white <= blue:
            if nums[white] == 0:
                nums[white], nums[red] = nums[red], nums[white]
                red += 1
                white += 1
            elif nums[white] == 1:
                white += 1
            else:
                nums[white], nums[blue] = nums[blue], nums[white]
                blue -= 1
```

```Java []
class Solution {
  public void sortColors(int[] nums) {
    int l = 0;
    int r = nums.length - 1;

    for (int i = 0; i <= r;)
      if (nums[i] == 0)
        swap(nums, i++, l++);
      else if (nums[i] == 1)
        ++i;
      else
        swap(nums, i, r--);
  }

  private void swap(int[] nums, int i, int j) {
    final int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }
}
```


</details>
