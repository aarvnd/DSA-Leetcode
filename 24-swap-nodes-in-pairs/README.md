<h2><a href="https://leetcode.com/problems/swap-nodes-in-pairs">Swap Nodes in Pairs</a></h2> <img src='https://img.shields.io/badge/Difficulty-Medium-orange' alt='Difficulty: Medium' /><hr><p>Given a&nbsp;linked list, swap every two adjacent nodes and return its head. You must solve the problem without&nbsp;modifying the values in the list&#39;s nodes (i.e., only nodes themselves may be changed.)</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">head = [1,2,3,4]</span></p>

<p><strong>Output:</strong> <span class="example-io">[2,1,4,3]</span></p>

<p><strong>Explanation:</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2020/10/03/swap_ex1.jpg" style="width: 422px; height: 222px;" /></p>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">head = []</span></p>

<p><strong>Output:</strong> <span class="example-io">[]</span></p>
</div>

<p><strong class="example">Example 3:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">head = [1]</span></p>

<p><strong>Output:</strong> <span class="example-io">[1]</span></p>
</div>

<p><strong class="example">Example 4:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">head = [1,2,3]</span></p>

<p><strong>Output:</strong> <span class="example-io">[2,1,3]</span></p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of nodes in the&nbsp;list&nbsp;is in the range <code>[0, 100]</code>.</li>
	<li><code>0 &lt;= Node.val &lt;= 100</code></li>
</ul>


<hr>

## Solution Explanation

### Intuition
The key insight is to use a dummy node to simplify the swapping logic at the head of the list, alongside a "previous" pointer that links the already-processed portion of the list to the newly swapped pairs. By carefully manipulating the pointers of three nodes at a time (the previous node and the two adjacent nodes to be swapped), we can reverse the pairs in place without modifying any node values.

### Approach
*   Create a `dummy` node pointing to the `head` of the list to elegantly handle edge cases (like an empty list or a single node) and to keep track of the new start of the list.
*   Initialize a `prev` pointer at the `dummy` node. This pointer acts as a bridge, connecting the sorted part of the list to the next pair being swapped.
*   Traverse the list using a `while` loop that continues as long as there are at least two nodes ahead (`prev.next` and `prev.next.next` are not null).
*   Inside the loop, identify the `first` and `second` nodes of the current pair, then rewire their pointers: link `first` to the rest of the list (`second.next`), link `second` back to `first`, and link `prev` to `second`.
*   Advance the `prev` pointer to the `first` node (which is now at the end of the newly swapped pair) to prepare for the next iteration.

### Complexity
- **Time:** O(n) — We iterate through the linked list exactly once, processing nodes in pairs.
- **Space:** O(1) — We only allocate a few constant extra pointers regardless of the list size.
