<h2><a href="https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array">Find First and Last Position of Element in Sorted Array</a></h2> <img src='https://img.shields.io/badge/Difficulty-Medium-orange' alt='Difficulty: Medium' /><hr><p>Given an array of integers <code>nums</code> sorted in non-decreasing order, find the starting and ending position of a given <code>target</code> value.</p>

<p>If <code>target</code> is not found in the array, return <code>[-1, -1]</code>.</p>

<p>You must&nbsp;write an algorithm with&nbsp;<code>O(log n)</code> runtime complexity.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<pre><strong>Input:</strong> nums = [5,7,7,8,8,10], target = 8
<strong>Output:</strong> [3,4]
</pre><p><strong class="example">Example 2:</strong></p>
<pre><strong>Input:</strong> nums = [5,7,7,8,8,10], target = 6
<strong>Output:</strong> [-1,-1]
</pre><p><strong class="example">Example 3:</strong></p>
<pre><strong>Input:</strong> nums = [], target = 0
<strong>Output:</strong> [-1,-1]
</pre>
<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>0 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>-10<sup>9</sup>&nbsp;&lt;= nums[i]&nbsp;&lt;= 10<sup>9</sup></code></li>
	<li><code>nums</code> is a non-decreasing array.</li>
	<li><code>-10<sup>9</sup>&nbsp;&lt;= target&nbsp;&lt;= 10<sup>9</sup></code></li>
</ul>


<hr>

## Solution Explanation

### Intuition
Since the array is sorted and an O(log n) runtime is required, binary search is the ideal approach. The key insight is to modify the standard binary search so that instead of stopping when the target is found, it records the position and continues searching in the left or right half to pinpoint the absolute first or last occurrence among duplicates.

### Approach
- Create a helper binary search function that accepts a boolean flag to determine if it should search for the first or last boundary.
- Initialize standard `left` and `right` pointers, along with a variable to store the potential boundary index.
- When the target is found at the `mid` index, record `mid` as the current boundary.
- If looking for the first occurrence, narrow the search space to the left (`right = mid - 1`) to see if earlier targets exist. If looking for the last occurrence, narrow the search space to the right (`left = mid + 1`).
- If the target is not found at `mid`, adjust the pointers normally based on whether the target is greater or smaller than the value at `mid`.
- Call this helper function to find the first index; if it returns -1, immediately return `[-1, -1]`. Otherwise, call it again to find the last index and return the pair.

### Complexity
- **Time:** O(log n) — We perform at most two independent binary searches, each halving the search space in logarithmic time.
- **Space:** O(1) — The algorithm only uses a few integer variables for pointers, requiring no additional scaling memory.
