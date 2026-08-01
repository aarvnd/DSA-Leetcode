<h2><a href="https://leetcode.com/problems/maximum-depth-of-binary-tree">Maximum Depth of Binary Tree</a></h2> <img src='https://img.shields.io/badge/Difficulty-Easy-brightgreen' alt='Difficulty: Easy' /><hr><p>Given the <code>root</code> of a binary tree, return <em>its maximum depth</em>.</p>

<p>A binary tree&#39;s <strong>maximum depth</strong>&nbsp;is the number of nodes along the longest path from the root node down to the farthest leaf node.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/11/26/tmp-tree.jpg" style="width: 400px; height: 277px;" />
<pre>
<strong>Input:</strong> root = [3,9,20,null,null,15,7]
<strong>Output:</strong> 3
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> root = [1,null,2]
<strong>Output:</strong> 2
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of nodes in the tree is in the range <code>[0, 10<sup>4</sup>]</code>.</li>
	<li><code>-100 &lt;= Node.val &lt;= 100</code></li>
</ul>


<hr>

## Solution Explanation

### Intuition
The maximum depth of a binary tree can be defined recursively as 1 (for the current node) plus the greater of the maximum depths of its left and right subtrees. This self-similar structure makes a recursive depth-first search (DFS) the perfect approach to traverse the tree and calculate the depth from the bottom up.

### Approach
- Check the base case: if the current node is `null`, it represents an empty tree or the end of a path, so return a depth of 0.
- Recursively call the function on the left child to determine the maximum depth of the left subtree.
- Recursively call the function on the right child to determine the maximum depth of the right subtree.
- Compare the two subtree depths, take the maximum of the two, add 1 to account for the current node, and return this total up the call stack.

### Complexity
- **Time:** O(N) — We visit every node in the binary tree exactly once, where N is the total number of nodes.
- **Space:** O(N) — In the worst case (a completely skewed tree), the recursion call stack will grow to N frames; for a perfectly balanced tree, the space complexity would be O(log N).
