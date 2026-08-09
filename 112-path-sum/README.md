<h2><a href="https://leetcode.com/problems/path-sum">Path Sum</a></h2> <img src='https://img.shields.io/badge/Difficulty-Easy-brightgreen' alt='Difficulty: Easy' /><hr><p>Given the <code>root</code> of a binary tree and an integer <code>targetSum</code>, return <code>true</code> if the tree has a <strong>root-to-leaf</strong> path such that adding up all the values along the path equals <code>targetSum</code>.</p>

<p>A <strong>leaf</strong> is a node with no children.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/01/18/pathsum1.jpg" style="width: 500px; height: 356px;" />
<pre>
<strong>Input:</strong> root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
<strong>Output:</strong> true
<strong>Explanation:</strong> The root-to-leaf path with the target sum is shown.
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/01/18/pathsum2.jpg" />
<pre>
<strong>Input:</strong> root = [1,2,3], targetSum = 5
<strong>Output:</strong> false
<strong>Explanation:</strong> There are two root-to-leaf paths in the tree:
(1 --&gt; 2): The sum is 3.
(1 --&gt; 3): The sum is 4.
There is no root-to-leaf path with sum = 5.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> root = [], targetSum = 0
<strong>Output:</strong> false
<strong>Explanation:</strong> Since the tree is empty, there are no root-to-leaf paths.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of nodes in the tree is in the range <code>[0, 5000]</code>.</li>
	<li><code>-1000 &lt;= Node.val &lt;= 1000</code></li>
	<li><code>-1000 &lt;= targetSum &lt;= 1000</code></li>
</ul>


<hr>

## Solution Explanation

### Intuition
The problem can be elegantly solved by breaking it down into smaller subproblems using recursion: as we traverse down the tree, we subtract the current node's value from the target sum. If we reach a leaf node and its value exactly matches the remaining target sum, it means the entire path from the root adds up to the original target.

### Approach
- Check the initial base case: if the current node is `null`, return `false` since an empty tree or an empty branch cannot contain a valid path.
- Identify if the current node is a leaf by checking if both its left and right children are `null`.
- If it is a leaf node, evaluate whether its value is exactly equal to the current `targetSum` and return the boolean result.
- If it is not a leaf, recursively call the function on both the left and right children.
- For these recursive calls, pass the updated target sum as `targetSum - root.val`, and return `true` if either the left or right subtree yields a valid path.

### Complexity
- **Time:** O(N) — We visit each node in the tree exactly once in the worst-case scenario where the path does not exist or is the last one checked.
- **Space:** O(H) — The recursion stack requires space proportional to the height of the tree, which is O(log N) for a balanced tree and O(N) for a completely skewed tree.
