<h2><a href="https://leetcode.com/problems/linked-list-cycle">Linked List Cycle</a></h2> <img src='https://img.shields.io/badge/Difficulty-Easy-brightgreen' alt='Difficulty: Easy' /><hr><p>Given <code>head</code>, the head of a linked list, determine if the linked list has a cycle in it.</p>

<p>There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the&nbsp;<code>next</code>&nbsp;pointer. Internally, <code>pos</code>&nbsp;is used to denote the index of the node that&nbsp;tail&#39;s&nbsp;<code>next</code>&nbsp;pointer is connected to.&nbsp;<strong>Note that&nbsp;<code>pos</code>&nbsp;is not passed as a parameter</strong>.</p>

<p>Return&nbsp;<code>true</code><em> if there is a cycle in the linked list</em>. Otherwise, return <code>false</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2018/12/07/circularlinkedlist.png" style="width: 300px; height: 97px; margin-top: 8px; margin-bottom: 8px;" />
<pre>
<strong>Input:</strong> head = [3,2,0,-4], pos = 1
<strong>Output:</strong> true
<strong>Explanation:</strong> There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2018/12/07/circularlinkedlist_test2.png" style="width: 141px; height: 74px;" />
<pre>
<strong>Input:</strong> head = [1,2], pos = 0
<strong>Output:</strong> true
<strong>Explanation:</strong> There is a cycle in the linked list, where the tail connects to the 0th node.
</pre>

<p><strong class="example">Example 3:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2018/12/07/circularlinkedlist_test3.png" style="width: 45px; height: 45px;" />
<pre>
<strong>Input:</strong> head = [1], pos = -1
<strong>Output:</strong> false
<strong>Explanation:</strong> There is no cycle in the linked list.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of the nodes in the list is in the range <code>[0, 10<sup>4</sup>]</code>.</li>
	<li><code>-10<sup>5</sup> &lt;= Node.val &lt;= 10<sup>5</sup></code></li>
	<li><code>pos</code> is <code>-1</code> or a <strong>valid index</strong> in the linked-list.</li>
</ul>

<p>&nbsp;</p>
<p><strong>Follow up:</strong> Can you solve it using <code>O(1)</code> (i.e. constant) memory?</p>


<hr>

## Solution Explanation

### Intuition
The problem can be solved by thinking of two runners on a track moving at different speeds. By using a "slow" pointer that moves one step at a time and a "fast" pointer that moves two steps at a time, the fast pointer will eventually lap and collide with the slow pointer if a cycle exists. If there is no cycle, the fast pointer will simply reach the end of the list.

### Approach
* Handle the edge case where the list is empty by returning `false`.
* Initialize two pointers, `slow` and `fast`, both starting at the `head` of the list.
* Iterate through the list as long as `fast` and `fast.next` are not null to ensure we can safely move the fast pointer two steps.
* During each iteration, advance the `slow` pointer by one step and the `fast` pointer by two steps.
* If `slow` and `fast` ever point to the exact same node, a cycle exists, so return `true`.
* If the loop terminates, the `fast` pointer has reached the end of the list, meaning there is no cycle, so return `false`.

### Complexity
- **Time:** O(n) — The fast pointer will either reach the end of the list or lap the slow pointer in at most n iterations, where n is the number of nodes.
- **Space:** O(1) — Only two pointers are used, requiring constant extra memory regardless of the list size.
