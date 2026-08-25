# Find All Numbers Disappeared in an Array

| Field | Value |
|-------|-------|
| **Platform** | LeetCode |
| **Difficulty** | Easy |
| **Language** | java |
| **Solved On** | August 25, 2026 |
| **Tags** | Array, Hash Table |
| **Link** | [View Problem](https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/) |
| **Runtime** | 0 ms |
| **Memory** | 42.8 MB |

## Approach

1. Problem Restated:
   nums has n elements, and every value is supposed to be somewhere in 
   the range [1, n], but some numbers may be missing (not present at 
   all) while others may appear more than once (taking the missing 
   ones' "place"). Find all numbers in [1, n] that never appear.

2. Key Insight - Use the Array Itself as a Hash Map:
   Since values are guaranteed to be in range [1, n], each value v can 
   be mapped to a valid index (v - 1) in the same array. We can use 
   the SIGN of the number at that index to mark "this value has been 
   seen" - without needing a separate boolean/visited array.

3. Step 1 - Mark Seen Values by Negating:
   For each element in nums, take its absolute value (since it might 
   already have been negated by a previous step) to get val. Then go 
   to index (val - 1) and make the number there NEGATIVE, if it isn't 
   already negative. This marks "value val has been seen at least 
   once" by flipping the sign of whatever sits at its "home index."

4. Why Use Absolute Value:
   Because we might negate a slot more than once (if a value appears 
   multiple times in nums), later reads of nums[i] could already be 
   negative from an earlier marking. We must read Math.abs(nums[i]) to 
   get the true original value before using it as an index reference.

5. Step 2 - Scan for Unmarked (Still Positive) Slots:
   After marking, go through the array again. Any index i where 
   nums[i] is still POSITIVE means the value (i + 1) was NEVER seen in 
   the original array - because if it had been seen, that slot would 
   have been flipped negative in step 1.
   
   Add (i + 1) to the result list for every such positive slot found.

6. Why This Works:
   Every value in nums points to exactly one "home" index (value - 1). 
   If a value from 1 to n is present anywhere in nums, its home index 
   gets marked negative - regardless of duplicates. So after marking, 
   positive slots correspond precisely to values that never appeared.

7. Optional - Restore the Array:
   If the input array must remain unmodified after the function 
   returns, take absolute values again in a final pass. (Not required 
   by the problem, but good practice if the array is reused elsewhere.)

8. Complexity:
   - Time: O(n) - two linear passes over the array
   - Space: O(1) extra, not counting the output list (in-place sign 
     marking on the input array itself)

## Problem Description

<p>Given an array <code>nums</code> of <code>n</code> integers where <code>nums[i]</code> is in the range <code>[1, n]</code>, return <em>an array of all the integers in the range</em> <code>[1, n]</code> <em>that do not appear in</em> <code>nums</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<pre><strong>Input:</strong> nums = [4,3,2,7,8,2,3,1]
<strong>Output:</strong> [5,6]
</pre><p><strong class="example">Example 2:</strong></p>
<pre><strong>Input:</strong> nums = [1,1]
<strong>Output:</strong> [2]
</pre>
<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>n == nums.length</code></li>
	<li><code>1 &lt;= n &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= nums[i] &lt;= n</code></li>
</ul>

<p>&nbsp;</p>
<p><strong>Follow up:</strong> Could you do it without extra space and in <code>O(n)</code> runtime? You may assume the returned list does not count as extra space.</p>


##  Top Community Optimal Approach

<details>
<summary>Click to expand</summary>

**Title**: TIme: O(n), Space: O(1)
**Author**: [@riyakushwaha](https://leetcode.com/riyakushwaha/)
**Upvotes**: 352 👍
**Link**: [View Original Post](https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/solutions/1583741/)

---

For each value in the array mark its presence by making the number negative at that place in array 
eg. if you hae array [3,1,4,1] for 3, i will go to index 2 and make its value negative ie. now nums[2] becomes -4. present array: [3,1,-4,1]
for 1, i will go to index 0 and make its value negative ie. now nums[0] becomes -3. present array: [-3,1,-4,1]
for 4, (take abs value), i will go to index 3 and make its value negative ie. now nums[3] becomes -1. present array: [-3,1,-4,-1]
for 1 take abs value), i will go to index 0 as it is already -ve do nothing. present array: [-3,1,-4,-1]
At last I will have [-3,1,-4,-1]. now i will iterate over the array, whichever idx has positive value that number will not be in the array so as we have nums[1]>0 so 2 is not in the list.

**PLEASE UPVOTE** if you liked the solution, comment for any queries

```
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int idx = -1;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] < 0){
                idx = nums[i]*-1-1;
            }else{
                idx = nums[i]-1;
            }
            
            if(nums[idx]>0){
                nums[idx] = -nums[idx];
            }
            
        }
        
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0){
                list.add(i+1);
            };
            
        }
        
        return list;
    }
	```

</details>
