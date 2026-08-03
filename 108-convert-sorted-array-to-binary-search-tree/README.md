<h2><a href="https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree">Convert Sorted Array to Binary Search Tree</a></h2> <img src='https://img.shields.io/badge/Difficulty-Easy-brightgreen' alt='Difficulty: Easy' /><hr><p>Given an integer array <code>nums</code> where the elements are sorted in <strong>ascending order</strong>, convert <em>it to a </em><span data-keyword="height-balanced"><strong><em>height-balanced</em></strong></span> <em>binary search tree</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/02/18/btree1.jpg" style="width: 302px; height: 222px;" />
<pre>
<strong>Input:</strong> nums = [-10,-3,0,5,9]
<strong>Output:</strong> [0,-3,9,-10,null,5]
<strong>Explanation:</strong> [0,-10,5,null,-3,null,9] is also accepted:
<img alt="" src="https://assets.leetcode.com/uploads/2021/02/18/btree2.jpg" style="width: 302px; height: 222px;" />
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/02/18/btree.jpg" style="width: 342px; height: 142px;" />
<pre>
<strong>Input:</strong> nums = [1,3]
<strong>Output:</strong> [3,1]
<strong>Explanation:</strong> [1,null,3] and [3,1] are both height-balanced BSTs.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>4</sup></code></li>
	<li><code>-10<sup>4</sup> &lt;= nums[i] &lt;= 10<sup>4</sup></code></li>
	<li><code>nums</code> is sorted in a <strong>strictly increasing</strong> order.</li>
</ul>


<hr>

## Solution Explanation

### Intuition
To guarantee a height-balanced Binary Search Tree, the root of any subtree must be the middle element of its corresponding sorted subarray. This ensures that the number of elements in the left and right subtrees are as equal as possible, naturally maintaining the balanced property throughout the tree.

### Approach
- Define a recursive helper function that takes the array alongside the `left` and `right` boundaries of the current subarray.
- Check the base case: if `left > right`, the subarray is empty, meaning there are no nodes to create, so return `null`.
- Calculate the middle index as `left + (right - left) / 2` to find the root of the current subtree while preventing potential integer overflow.
- Instantiate a new tree node using the array value at this middle index.
- Recursively build the left child by calling the helper on the left half of the subarray (`left` to `mid - 1`) and the right child using the right half (`mid + 1` to `right`).
- Return the newly created node so it can be linked to its parent in the recursive call stack.

### Complexity
- **Time:** O(N) — We visit each element in the array exactly once to create its corresponding tree node.
- **Space:** O(log N) — The recursion stack depth is bounded by the height of the balanced tree, which is logarithmically proportional to the number of elements.
