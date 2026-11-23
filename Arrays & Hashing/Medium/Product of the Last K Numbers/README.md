# Product of the Last K Numbers

| Field | Value |
|-------|-------|
| **Platform** | LeetCode |
| **Difficulty** | Medium |
| **Language** | java |
| **Solved On** | November 23, 2026 |
| **Tags** | Array, Math, Design, Data Stream, Prefix Sum |
| **Link** | [View Problem](https://leetcode.com/problems/product-of-the-last-k-numbers/) |
| **Runtime** | 18 ms |
| **Memory** | 84.5 MB |

## Problem Description

<p>Design an algorithm that accepts a stream of integers and retrieves the product of the last <code>k</code> integers of the stream.</p>

<p>Implement the <code>ProductOfNumbers</code> class:</p>

<ul>
	<li><code>ProductOfNumbers()</code> Initializes the object with an empty stream.</li>
	<li><code>void add(int num)</code> Appends the integer <code>num</code> to the stream.</li>
	<li><code>int getProduct(int k)</code> Returns the product of the last <code>k</code> numbers in the current list. You can assume that always the current list has at least <code>k</code> numbers.</li>
</ul>

<p>The test cases are generated so that, at any time, the product of any contiguous sequence of numbers will fit into a single 32-bit integer without overflowing.</p>

<p>&nbsp;</p>
<p><strong class="example">Example:</strong></p>

<pre><strong>Input</strong>
["ProductOfNumbers","add","add","add","add","add","getProduct","getProduct","getProduct","add","getProduct"]
[[],[3],[0],[2],[5],[4],[2],[3],[4],[8],[2]]

<strong>Output</strong>
[null,null,null,null,null,null,20,40,0,null,32]

<strong>Explanation</strong>
ProductOfNumbers productOfNumbers = new ProductOfNumbers();
productOfNumbers.add(3);        // [3]
productOfNumbers.add(0);        // [3,0]
productOfNumbers.add(2);        // [3,0,2]
productOfNumbers.add(5);        // [3,0,2,5]
productOfNumbers.add(4);        // [3,0,2,5,4]
productOfNumbers.getProduct(2); // return 20. The product of the last 2 numbers is 5 * 4 = 20
productOfNumbers.getProduct(3); // return 40. The product of the last 3 numbers is 2 * 5 * 4 = 40
productOfNumbers.getProduct(4); // return 0. The product of the last 4 numbers is 0 * 2 * 5 * 4 = 0
productOfNumbers.add(8);        // [3,0,2,5,4,8]
productOfNumbers.getProduct(2); // return 32. The product of the last 2 numbers is 4 * 8 = 32 
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>0 &lt;= num &lt;= 100</code></li>
	<li><code>1 &lt;= k &lt;= 4 * 10<sup>4</sup></code></li>
	<li>At most <code>4 * 10<sup>4</sup></code> calls will be made to <code>add</code> and <code>getProduct</code>.</li>
	<li>The product of the stream at any point in time will fit in a <strong>32-bit</strong> integer.</li>
</ul>

<p>&nbsp;</p>
<strong>Follow-up: </strong>Can you implement <strong>both</strong> <code>GetProduct</code> and <code>Add</code> to work in <code>O(1)</code> time complexity instead of <code>O(k)</code> time complexity?

##  Top Community Optimal Approach

<details>
<summary>Click to expand</summary>

**Title**: Java, prefix product, beats 100%, explained
**Author**: [@gthor10](https://leetcode.com/gthor10/)
**Upvotes**: 26 👍
**Link**: [View Original Post](https://leetcode.com/problems/product-of-the-last-k-numbers/solutions/512354/)

---

We can easily count the product in O(1) time if we keep the product prefix array - every next element of such array is the product of the previous product and next element added to the data structure. 

Only problem with this approach is 0 element - it ruins this logic because every next element after it will be 0 if we just keep multiplying naively. 

However if you think about it - we don\'t care about element before 0 because all such queries will return 0. The only sequence that can return some value > 0 will be the after the 0. This means that we essentially reset our structure after 0 element and start over.

For getProduct method we need to check if we have enough elements in our data structure. If not (as per problem statement we should always have enough) it means we have met 0 before and erased the data. In this case we can just return 0. Otherwise return normally as per prefix product logic - arr[N - 1]/arr[N - 1 - k]. 

Catches: it\'s easier if we initialize our list with 1 - in this case calculation became easier for cases when we added exactly k elements, otherwise we would need extra logic to check the size(). 
another cath - we can keep previous element and calculate next element based on it\'s value directly instead of goinmg every time to the list - will save some time

O(1) time for add (on average, if we skip details of dynamic array in java), O(1) getProduct method - few comparisions and one division.
O(n) space - potentially we can have products of all elements in a list

```
public class ProductOfLastKNumbers {
    List<Integer> list;
    int prev;
    public ProductOfLastKNumbers() {
        list = new ArrayList();
        list.add(1);
        prev = 1;
    }

    public void add(int num) {
        //if element is > 0 create next element in a prefix product list. Update prev to be this
        //element
        if (num > 0) {
            prev*=num;
            list.add(prev);
        }
        //if this is 0  we need to reinit the structure
        else {
            list = new ArrayList();
            list.add(1);
            prev = 1;
        }
    }

    public int getProduct(int k) {
        int N = list.size();
        //in case there are not enough elements by the problem definition it can only happen if
        //we have met 0 before. In this case return 0. In all other cases we get the product from
        //division due to prefix product property. Note that list always has n + 1 elements due to 
        //initial 1, we need it to avoid outofbounds checks for edge cases
        return (k < N) ? prev / list.get(N - 1 - k) : 0;
    }
}
```

</details>
