<h2><a href="https://leetcode.com/problems/remove-nth-node-from-end-of-list">Remove Nth Node From End of List</a></h2> <img src='https://img.shields.io/badge/Difficulty-Medium-orange' alt='Difficulty: Medium' /><hr><p>Given the <code>head</code> of a linked list, remove the <code>n<sup>th</sup></code> node from the end of the list and return its head.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/10/03/remove_ex1.jpg" style="width: 542px; height: 222px;" />
<pre>
<strong>Input:</strong> head = [1,2,3,4,5], n = 2
<strong>Output:</strong> [1,2,3,5]
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> head = [1], n = 1
<strong>Output:</strong> []
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> head = [1,2], n = 1
<strong>Output:</strong> [1]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of nodes in the list is <code>sz</code>.</li>
	<li><code>1 &lt;= sz &lt;= 30</code></li>
	<li><code>0 &lt;= Node.val &lt;= 100</code></li>
	<li><code>1 &lt;= n &lt;= sz</code></li>
</ul>

<p>&nbsp;</p>
<p><strong>Follow up:</strong> Could you do this in one pass?</p>


<hr>

## Solution Explanation

### Intuition
The key insight is using two pointers separated by a fixed gap of `n` nodes. By advancing both pointers at the same speed, when the leading pointer reaches the end of the list, the trailing pointer will naturally be positioned right before the node that needs to be deleted, allowing us to solve the problem in a single pass.

### Approach
- Create a `dummy` node pointing to the `head` to safely handle edge cases, such as removing the first node of the list.
- Initialize two pointers, `fast` and `slow`, both starting at the `dummy` node.
- Advance the `fast` pointer exactly `n + 1` steps forward to establish the required gap between the two pointers.
- Move both `fast` and `slow` pointers forward one node at a time until `fast` goes out of bounds (`null`).
- At this point, `slow` is sitting immediately before the target node; bypass the target node by setting `slow.next = slow.next.next`.
- Return `dummy.next` as the new head of the modified list.

### Complexity
- **Time:** O(sz) — We traverse the linked list of size `sz` exactly once.
- **Space:** O(1) — We only use a constant amount of extra space for the two pointers and the dummy node.
