<h2><a href="https://leetcode.com/problems/minimum-depth-of-binary-tree">Minimum Depth of Binary Tree</a></h2> <img src='https://img.shields.io/badge/Difficulty-Easy-brightgreen' alt='Difficulty: Easy' /><hr><p>Given a binary tree, find its minimum depth.</p>

<p>The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.</p>

<p><strong>Note:</strong>&nbsp;A leaf is a node with no children.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/10/12/ex_depth.jpg" style="width: 432px; height: 302px;" />
<pre>
<strong>Input:</strong> root = [3,9,20,null,null,15,7]
<strong>Output:</strong> 2
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> root = [2,null,3,null,4,null,5,null,6]
<strong>Output:</strong> 5
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of nodes in the tree is in the range <code>[0, 10<sup>5</sup>]</code>.</li>
	<li><code>-1000 &lt;= Node.val &lt;= 1000</code></li>
</ul>


<hr>

## Solution Explanation

### Intuition
To find the shortest path to a leaf, Breadth-First Search (BFS) is the ideal approach because it explores the tree level by level. By traversing this way, the very first leaf node we encounter is guaranteed to be at the minimum depth, allowing us to return the answer immediately without unnecessarily exploring the rest of the tree.

### Approach
- Handle the edge case first: if the tree is empty (the root is null), return a depth of 0.
- Initialize a queue to facilitate the BFS, add the root node to it, and set a `depth` counter to 1.
- Traverse the tree level by level using a `while` loop, capturing the current queue size to know exactly how many nodes are on the current level.
- For each node in the current level, dequeue it and check if it is a leaf (both left and right children are null). If it is, immediately return the current `depth`.
- If the node is not a leaf, enqueue its non-null children to be processed in the next level.
- Increment the `depth` counter after fully processing all the nodes at the current level.

### Complexity
- **Time:** O(N) — In the worst case (like a perfectly balanced tree where all leaves are on the same level), we might visit every node in the tree.
- **Space:** O(N) — The queue can hold at most the maximum number of nodes at any single level, which in a balanced binary tree is roughly N/2 nodes, simplifying to O(N).
