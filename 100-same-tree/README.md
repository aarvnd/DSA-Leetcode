<h2><a href="https://leetcode.com/problems/same-tree">Same Tree</a></h2> <img src='https://img.shields.io/badge/Difficulty-Easy-brightgreen' alt='Difficulty: Easy' /><hr><p>Given the roots of two binary trees <code>p</code> and <code>q</code>, write a function to check if they are the same or not.</p>

<p>Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/12/20/ex1.jpg" style="width: 622px; height: 182px;" />
<pre>
<strong>Input:</strong> p = [1,2,3], q = [1,2,3]
<strong>Output:</strong> true
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/12/20/ex2.jpg" style="width: 382px; height: 182px;" />
<pre>
<strong>Input:</strong> p = [1,2], q = [1,null,2]
<strong>Output:</strong> false
</pre>

<p><strong class="example">Example 3:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/12/20/ex3.jpg" style="width: 622px; height: 182px;" />
<pre>
<strong>Input:</strong> p = [1,2,1], q = [1,1,2]
<strong>Output:</strong> false
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of nodes in both trees is in the range <code>[0, 100]</code>.</li>
	<li><code>-10<sup>4</sup> &lt;= Node.val &lt;= 10<sup>4</sup></code></li>
</ul>


<hr>

## Solution Explanation

### Intuition
Two binary trees are identical if and only if their root nodes have the same value and their corresponding left and right subtrees are also identical. This naturally lends itself to a recursive, divide-and-conquer approach where we traverse both trees simultaneously and compare them node by node.

### Approach
- Check the first base case: if both current nodes (`p` and `q`) are `null`, we have reached the end of a branch without any mismatches, so we return `true`.
- Check for a structural mismatch: if exactly one of the nodes is `null` while the other is not, the trees have different shapes, so we return `false`.
- Check for a value mismatch: if both nodes exist but their values (`p.val` and `q.val`) differ, return `false`.
- If the current nodes match in both structure and value, recursively call the function to compare their left subtrees and their right subtrees.
- Return `true` only if both the left and right recursive comparisons return `true`.

### Complexity
- **Time:** O(min(N, M)) — we visit each corresponding node at most once and stop immediately upon finding a mismatch, where N and M are the number of nodes in the two trees.
- **Space:** O(min(H1, H2)) — the memory used by the call stack is determined by the height of the trees, which in the worst case (a completely skewed tree) equals the number of nodes O(min(N, M)).
