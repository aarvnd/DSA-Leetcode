<h2><a href="https://leetcode.com/problems/3sum-closest">3Sum Closest</a></h2> <img src='https://img.shields.io/badge/Difficulty-Medium-orange' alt='Difficulty: Medium' /><hr><p>Given an integer array <code>nums</code> of length <code>n</code> and an integer <code>target</code>, find three integers at <strong>distinct indices</strong> in <code>nums</code> such that the sum is closest to <code>target</code>.</p>

<p>Return <em>the sum of the three integers</em>.</p>

<p>You may assume that each input would have exactly one solution.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [-1,2,1,-4], target = 1
<strong>Output:</strong> 2
<strong>Explanation:</strong> The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [0,0,0], target = 1
<strong>Output:</strong> 0
<strong>Explanation:</strong> The sum that is closest to the target is 0. (0 + 0 + 0 = 0).
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>3 &lt;= nums.length &lt;= 500</code></li>
	<li><code>-1000 &lt;= nums[i] &lt;= 1000</code></li>
	<li><code>-10<sup>4</sup> &lt;= target &lt;= 10<sup>4</sup></code></li>
</ul>


<hr>

## Solution Explanation

### Intuition
By sorting the array first, we can reduce the problem to a series of two-pointer searches. Fixing one element allows us to dynamically adjust the other two elements from the edges inward, intelligently narrowing down the closest sum to the target without having to brute-force every possible triplet combination.

### Approach
- Sort the input array in ascending order to enable the directional two-pointer technique.
- Initialize `closestSum` with the sum of the first three elements to serve as a valid baseline.
- Iterate through the array with an index `i`, treating `nums[i]` as the first fixed element of our potential triplet.
- For each fixed element, initialize a `left` pointer at `i + 1` and a `right` pointer at the end of the array.
- Calculate the `currentSum` of the three elements. If it exactly equals the `target`, return it immediately. If its absolute difference from the `target` is smaller than the difference between `closestSum` and `target`, update `closestSum`.
- Adjust the pointers based on the sum: if `currentSum` is less than `target`, increment `left` to increase the sum; if it is greater, decrement `right` to decrease the sum.

### Complexity
- **Time:** O(n^2) — Sorting the array takes O(n log n) time, and the outer loop combined with the inner two-pointer traversal takes O(n^2) time, dominating the overall complexity.
- **Space:** O(1) — The algorithm uses a constant amount of extra space for pointers and variables, excluding the O(log n) stack space typically required by the sorting algorithm.
