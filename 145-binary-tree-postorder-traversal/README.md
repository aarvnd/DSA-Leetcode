<h2><a href="https://leetcode.com/problems/binary-tree-postorder-traversal">Binary Tree Postorder Traversal</a></h2> <img src='https://img.shields.io/badge/Difficulty-Easy-brightgreen' alt='Difficulty: Easy' /><hr><p>Given the <code>root</code> of a&nbsp;binary tree, return <em>the postorder traversal of its nodes&#39; values</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">root = [1,null,2,3]</span></p>

<p><strong>Output:</strong> <span class="example-io">[3,2,1]</span></p>

<p><strong>Explanation:</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2024/08/29/screenshot-2024-08-29-202743.png" style="width: 200px; height: 264px;" /></p>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">root = [1,2,3,4,5,null,8,null,null,6,7,9]</span></p>

<p><strong>Output:</strong> <span class="example-io">[4,6,7,5,2,9,8,3,1]</span></p>

<p><strong>Explanation:</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2024/08/29/tree_2.png" style="width: 350px; height: 286px;" /></p>
</div>

<p><strong class="example">Example 3:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">root = []</span></p>

<p><strong>Output:</strong> <span class="example-io">[]</span></p>
</div>

<p><strong class="example">Example 4:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">root = [1]</span></p>

<p><strong>Output:</strong> <span class="example-io">[1]</span></p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of the nodes in the tree is in the range <code>[0, 100]</code>.</li>
	<li><code>-100 &lt;= Node.val &lt;= 100</code></li>
</ul>

<p>&nbsp;</p>
<strong>Follow up:</strong> Recursive solution is trivial, could you do it iteratively?

<hr>

## Solution Explanation

### Intuition
Postorder traversal requires visiting nodes in Left -> Right -> Root order, which can be tricky to implement iteratively with a standard stack. However, we can cleverly reverse the process: if we traverse the tree in a modified preorder sequence (Root -> Right -> Left) and continuously prepend the visited nodes to our result list, the final list will perfectly reflect the desired postorder sequence.

### Approach
- Initialize a `LinkedList` to store the result (which allows O(1) prepends) and a stack to manage the nodes during traversal.
- Handle the edge case of an empty tree by returning the empty list immediately.
- Push the root node onto the stack to begin the traversal.
- While the stack is not empty, pop the top node and prepend its value to the front of the result list using `addFirst()`.
- Push the popped node's left child, followed by its right child, onto the stack. Pushing the left child first ensures the right child sits at the top of the stack and is processed next.

### Complexity
- **Time:** O(N) — We visit each of the N nodes exactly once, and prepending to a `LinkedList` is an O(1) operation.
- **Space:** O(N) — The stack can hold up to O(N) nodes in the worst-case scenario (e.g., a completely unbalanced tree).
