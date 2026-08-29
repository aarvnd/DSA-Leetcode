<h2><a href="https://leetcode.com/problems/jump-game-ii">Jump Game II</a></h2> <img src='https://img.shields.io/badge/Difficulty-Medium-orange' alt='Difficulty: Medium' /><hr><p>You are given a <strong>0-indexed</strong> array of integers <code>nums</code> of length <code>n</code>. You are initially positioned at&nbsp;index 0.</p>

<p>Each element <code>nums[i]</code> represents the maximum length of a forward jump from index <code>i</code>. In other words, if you are at index <code>i</code>, you can jump to any index <code>(i + j)</code>&nbsp;where:</p>

<ul>
	<li><code>0 &lt;= j &lt;= nums[i]</code> and</li>
	<li><code>i + j &lt; n</code></li>
</ul>

<p>Return <em>the minimum number of jumps to reach index </em><code>n - 1</code>. The test cases are generated such that you can reach index&nbsp;<code>n - 1</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [2,3,1,1,4]
<strong>Output:</strong> 2
<strong>Explanation:</strong> The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [2,3,0,1,4]
<strong>Output:</strong> 2
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>4</sup></code></li>
	<li><code>0 &lt;= nums[i] &lt;= 1000</code></li>
	<li>It&#39;s guaranteed that you can reach <code>nums[n - 1]</code>.</li>
</ul>


<hr>

## Solution Explanation

### Intuition
The problem can be solved using a greedy approach by thinking of the jumps in terms of reachable "windows", similar to a Breadth-First Search. Instead of calculating the exact path, we track the furthest index we can reach. Whenever we hit the boundary of our current jump's maximum reach, we are forced to make another jump, extending our boundary to the furthest point discovered within the current window.

### Approach
- Initialize `jumps` to count the minimum jumps, `currentEnd` to mark the boundary of the current jump, and `furthest` to track the maximum reachable index.
- Iterate through the array up to the second-to-last element. We stop before the last index because arriving at the last index does not require initiating another jump.
- At each step, update `furthest` to the maximum of its current value and the reach from the current index (`i + nums[i]`).
- Check if the current index `i` has reached `currentEnd`. If it has, it means we have exhausted all starting positions for the current jump.
- When this boundary is reached, increment the `jumps` counter and update `currentEnd` to the `furthest` index found, effectively moving to the next jump window.

### Complexity
- **Time:** O(n) — We iterate through the array exactly once.
- **Space:** O(1) — We only use three integer variables to keep track of the jumps and ranges, requiring constant extra space.
