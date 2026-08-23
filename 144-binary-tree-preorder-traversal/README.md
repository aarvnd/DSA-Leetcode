<h2><a href="https://leetcode.com/problems/binary-tree-preorder-traversal">Binary Tree Preorder Traversal</a></h2> <img src='https://img.shields.io/badge/Difficulty-Easy-brightgreen' alt='Difficulty: Easy' /><hr><p>Given the <code>root</code> of a binary tree, return <em>the preorder traversal of its nodes&#39; values</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">root = [1,null,2,3]</span></p>

<p><strong>Output:</strong> <span class="example-io">[1,2,3]</span></p>

<p><strong>Explanation:</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2024/08/29/screenshot-2024-08-29-202743.png" style="width: 200px; height: 264px;" /></p>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">root = [1,2,3,4,5,null,8,null,null,6,7,9]</span></p>

<p><strong>Output:</strong> <span class="example-io">[1,2,4,5,6,7,3,8,9]</span></p>

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
	<li>The number of nodes in the tree is in the range <code>[0, 100]</code>.</li>
	<li><code>-100 &lt;= Node.val &lt;= 100</code></li>
</ul>

<p>&nbsp;</p>
<p><strong>Follow up:</strong> Recursive solution is trivial, could you do it iteratively?</p>


<hr>

## Solution Explanation

### Intuition
Preorder traversal visits nodes in a Root-Left-Right sequence. To achieve this iteratively without relying on the system's call stack, we can use our own stack data structure. The key insight is that because a stack operates on a Last-In-First-Out (LIFO) basis, we must push a node's right child onto the stack *before* its left child, ensuring the left child sits at the top and is processed first.

### Approach
- Initialize a list to store the traversal results and return it immediately if the given root is null.
- Create a stack using a double-ended queue and push the root node onto it to begin the traversal.
- Loop continuously as long as the stack is not empty.
- During each iteration, pop the top node from the stack and append its value to the result list (processing the "Root").
- Push the current node's right child onto the stack if it exists.
- Push the current node's left child onto the stack if it exists, guaranteeing it will be the next node popped.

### Complexity
- **Time:** O(N) — we visit and process every node in the binary tree exactly once.
- **Space:** O(N) — in the worst-case scenario (e.g., a highly unbalanced tree), the stack will store nodes proportional to the tree's height, which can be up to N.
