<h2><a href="https://leetcode.com/problems/remove-duplicates-from-sorted-list">Remove Duplicates from Sorted List</a></h2> <img src='https://img.shields.io/badge/Difficulty-Easy-brightgreen' alt='Difficulty: Easy' /><hr><p>Given the <code>head</code> of a sorted linked list, <em>delete all duplicates such that each element appears only once</em>. Return <em>the linked list <strong>sorted</strong> as well</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/01/04/list1.jpg" style="width: 302px; height: 242px;" />
<pre>
<strong>Input:</strong> head = [1,1,2]
<strong>Output:</strong> [1,2]
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/01/04/list2.jpg" style="width: 542px; height: 222px;" />
<pre>
<strong>Input:</strong> head = [1,1,2,3,3]
<strong>Output:</strong> [1,2,3]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of nodes in the list is in the range <code>[0, 300]</code>.</li>
	<li><code>-100 &lt;= Node.val &lt;= 100</code></li>
	<li>The list is guaranteed to be <strong>sorted</strong> in ascending order.</li>
</ul>


<hr>

## Solution Explanation

### Intuition
Since the linked list is already sorted, all duplicate values are guaranteed to be adjacent. This means we only need to compare each node with its immediate next neighbor and bypass any matches to ensure every element appears exactly once.

### Approach
- Handle the edge case of an empty list by returning `null` immediately.
- Initialize a `curr` pointer starting at the `head` of the list.
- Iterate through the list as long as `curr` and its adjacent node `curr.next` are not `null`.
- If `curr.val` equals `curr.next.val`, a duplicate is found; bypass it by pointing `curr.next` to `curr.next.next`.
- If the values are different, no duplicate exists, so safely advance `curr` to the next node.
- Return the original `head` once the traversal is complete.

### Complexity
- **Time:** O(n) — We traverse the linked list exactly once, where n is the number of nodes in the list.
- **Space:** O(1) — We only use a single pointer for traversal, requiring no additional memory.
