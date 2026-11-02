# 4Sum

| Field | Value |
|-------|-------|
| **Platform** | LeetCode |
| **Difficulty** | Medium |
| **Language** | java |
| **Solved On** | November 2, 2026 |
| **Tags** | Array, Two Pointers, Sorting |
| **Link** | [View Problem](https://leetcode.com/problems/4sum/) |
| **Runtime** | 24 ms |
| **Memory** | 45.4 MB |

## Problem Description

<p>Given an array <code>nums</code> of <code>n</code> integers, return <em>an array of all the <strong>unique</strong> quadruplets</em> <code>[nums[a], nums[b], nums[c], nums[d]]</code> such that:</p>

<ul>
	<li><code>0 &lt;= a, b, c, d&nbsp;&lt; n</code></li>
	<li><code>a</code>, <code>b</code>, <code>c</code>, and <code>d</code> are <strong>distinct</strong>.</li>
	<li><code>nums[a] + nums[b] + nums[c] + nums[d] == target</code></li>
</ul>

<p>You may return the answer in <strong>any order</strong>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> nums = [1,0,-1,0,-2,2], target = 0
<strong>Output:</strong> [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> nums = [2,2,2,2,2], target = 8
<strong>Output:</strong> [[2,2,2,2]]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 200</code></li>
	<li><code>-10<sup>9</sup> &lt;= nums[i] &lt;= 10<sup>9</sup></code></li>
	<li><code>-10<sup>9</sup> &lt;= target &lt;= 10<sup>9</sup></code></li>
</ul>


##  Top Community Optimal Approach

<details>
<summary>Click to expand</summary>

**Title**: My solution generalized for kSums in JAVA
**Author**: [@henryhoo](https://leetcode.com/henryhoo/)
**Upvotes**: 502 👍
**Link**: [View Original Post](https://leetcode.com/problems/4sum/solutions/8609/)

---

#### General Idea
If you have already read and implement the 3sum and 4sum by using the sorting approach: reduce them into 2sum at the end, you might already got the feeling that, all ksum problem can be divided into two problems: 
1. 2sum Problem
2. Reduce K sum problem to K \u2013 1 sum Problem

Therefore, the ideas is simple and straightforward. We could use recursive to solve this problem. Time complexity is O(N^(K-1)).

```JAVA
    public class Solution {
        int len = 0;
        public List<List<Integer>> fourSum(int[] nums, int target) {
            len = nums.length;
            Arrays.sort(nums);
            return kSum(nums, target, 4, 0);
        }
       private ArrayList<List<Integer>> kSum(int[] nums, int target, int k, int index) {
            ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
            if(index >= len) {
                return res;
            }
            if(k == 2) {
            	int i = index, j = len - 1;
            	while(i < j) {
                    //find a pair
            	    if(target - nums[i] == nums[j]) {
            	    	List<Integer> temp = new ArrayList<>();
                    	temp.add(nums[i]);
                    	temp.add(target-nums[i]);
                        res.add(temp);
                        //skip duplication
                        while(i<j && nums[i]==nums[i+1]) i++;
                        while(i<j && nums[j-1]==nums[j]) j--;
                        i++;
                        j--;
                    //move left bound
            	    } else if (target - nums[i] > nums[j]) {
            	        i++;
                    //move right bound
            	    } else {
            	        j--;
            	    }
            	}
            } else{
                for (int i = index; i < len - k + 1; i++) {
                    //use current number to reduce ksum into k-1sum
                    ArrayList<List<Integer>> temp = kSum(nums, target - nums[i], k-1, i+1);
                    if(temp != null){
                        //add previous results
                        for (List<Integer> t : temp) {
                            t.add(0, nums[i]);
                        }
                        res.addAll(temp);
                    }
                    while (i < len-1 && nums[i] == nums[i+1]) {
                        //skip duplicated numbers
                        i++;
                    }
                }
            }
            return res;
        }
    }
```

</details>
