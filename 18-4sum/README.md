<h2><a href="https://leetcode.com/problems/4sum">4Sum</a></h2> <img src='https://img.shields.io/badge/Difficulty-Medium-orange' alt='Difficulty: Medium' /><hr><p>Given an array <code>nums</code> of <code>n</code> integers, return <em>an array of all the <strong>unique</strong> quadruplets</em> <code>[nums[a], nums[b], nums[c], nums[d]]</code> such that:</p>

<ul>
	<li><code>0 &lt;= a, b, c, d&nbsp;&lt; n</code></li>
	<li><code>a</code>, <code>b</code>, <code>c</code>, and <code>d</code> are <strong>distinct</strong>.</li>
	<li><code>nums[a] + nums[b] + nums[c] + nums[d] == target</code></li>
</ul>

<p>You may return the answer in <strong>any order</strong>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [1,0,-1,0,-2,2], target = 0
<strong>Output:</strong> [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [2,2,2,2,2], target = 8
<strong>Output:</strong> [[2,2,2,2]]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 200</code></li>
	<li><code>-10<sup>9</sup> &lt;= nums[i] &lt;= 10<sup>9</sup></code></li>
	<li><code>-10<sup>9</sup> &lt;= target &lt;= 10<sup>9</sup></code></li>
</ul>


<hr>

## Solution Explanation

### Intuition
By sorting the array, we can reduce the 4Sum problem to a series of 2Sum problems. We fix the first two elements using nested loops and use a two-pointer approach to find the remaining two, which allows us to easily skip duplicates and implement early pruning to drastically reduce the search space.

### Approach
- Sort the input array to enable the two-pointer technique and simplify the identification of duplicate values.
- Use two nested loops to fix the first two numbers of the quadruplet, skipping identical adjacent elements to prevent duplicate results.
- Implement early pruning in both loops: break early if the smallest possible sum exceeds the target, and continue to the next iteration if the largest possible sum is less than the target.
- Use two pointers (`left` and `right`) to find the remaining two numbers, calculating the four-number sum using 64-bit integers (`long`) to prevent integer overflow.
- If the sum matches the target, add the quadruplet to the result and move both pointers inward while skipping any adjacent duplicates.
- If the sum is too small, increment the `left` pointer; if it is too large, decrement the `right` pointer.

### Complexity
- **Time:** O(n^3) — Sorting takes O(n log n) time, and the two nested loops combined with the two-pointer traversal take O(n^3) time in the worst case.
- **Space:** O(1) — Auxiliary space is constant, excluding the space required to store the output list and the implicit memory used by the sorting algorithm.
