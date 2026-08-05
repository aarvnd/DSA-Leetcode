<h2><a href="https://leetcode.com/problems/balanced-binary-tree">Balanced Binary Tree</a></h2> <img src='https://img.shields.io/badge/Difficulty-Easy-brightgreen' alt='Difficulty: Easy' /><hr><p>Given a binary tree, determine if it is <span data-keyword="height-balanced"><strong>height-balanced</strong></span>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/10/06/balance_1.jpg" style="width: 342px; height: 221px;" />
<pre>
<strong>Input:</strong> root = [3,9,20,null,null,15,7]
<strong>Output:</strong> true
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/10/06/balance_2.jpg" style="width: 452px; height: 301px;" />
<pre>
<strong>Input:</strong> root = [1,2,2,3,3,null,null,4,4]
<strong>Output:</strong> false
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> root = []
<strong>Output:</strong> true
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of nodes in the tree is in the range <code>[0, 5000]</code>.</li>
	<li><code>-10<sup>4</sup> &lt;= Node.val &lt;= 10<sup>4</sup></code></li>
</ul>


<hr>

## Solution Explanation

### Intuition
To determine if a binary tree is balanced efficiently, we can check the heights of the subtrees from the bottom up. By returning a sentinel value (`-1`) the moment we detect a height difference greater than 1 between any node's left and right subtrees, we avoid redundant height calculations and immediately short-circuit the recursion.

### Approach
- Define a recursive helper function that returns the height of a tree, or `-1` if it is unbalanced.
- For the base case, if the current node is null, return a height of 0.
- Recursively calculate the height of the left subtree; if it returns `-1`, immediately return `-1` to propagate the failure upwards.
- Recursively calculate the height of the right subtree, again returning `-1` immediately if an imbalance was found deeper in the tree.
- Check the absolute difference between the left and right subtree heights; if it exceeds 1, return `-1` to flag the current subtree as unbalanced.
- If the subtrees are balanced, return the current node's actual height by taking the maximum of the left and right heights and adding 1.

### Complexity
- **Time:** O(N) — Each node in the tree is visited exactly once during the bottom-up traversal.
- **Space:** O(N) — The recursion stack can go as deep as the number of nodes in the worst case of a completely skewed tree.
