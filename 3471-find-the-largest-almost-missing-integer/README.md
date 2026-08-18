<h2><a href="https://leetcode.com/problems/find-the-largest-almost-missing-integer">Find the Largest Almost Missing Integer</a></h2> <img src='https://img.shields.io/badge/Difficulty-Easy-brightgreen' alt='Difficulty: Easy' /><hr><p>You are given an integer array <code>nums</code> and an integer <code>k</code>.</p>

<p>An integer <code>x</code> is <strong>almost missing</strong> from <code>nums</code> if <code>x</code> appears in <em>exactly</em> one subarray of size <code>k</code> within <code>nums</code>.</p>

<p>Return the <b>largest</b> <strong>almost missing</strong> integer from <code>nums</code>. If no such integer exists, return <code>-1</code>.</p>
A <strong>subarray</strong> is a contiguous sequence of elements within an array.
<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [3,9,2,1,7], k = 3</span></p>

<p><strong>Output:</strong> <span class="example-io">7</span></p>

<p><strong>Explanation:</strong></p>

<ul>
	<li>1 appears in 2 subarrays of size 3: <code>[9, 2, 1]</code> and <code>[2, 1, 7]</code>.</li>
	<li>2 appears in 3 subarrays of size 3: <code>[3, 9, 2]</code>, <code>[9, 2, 1]</code>, <code>[2, 1, 7]</code>.</li>
	<li index="2">3 appears in 1 subarray of size 3: <code>[3, 9, 2]</code>.</li>
	<li index="3">7 appears in 1 subarray of size 3: <code>[2, 1, 7]</code>.</li>
	<li index="4">9 appears in 2 subarrays of size 3: <code>[3, 9, 2]</code>, and <code>[9, 2, 1]</code>.</li>
</ul>

<p>We return 7 since it is the largest integer that appears in exactly one subarray of size <code>k</code>.</p>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [3,9,7,2,1,7], k = 4</span></p>

<p><strong>Output:</strong> <span class="example-io">3</span></p>

<p><strong>Explanation:</strong></p>

<ul>
	<li>1 appears in 2 subarrays of size 4: <code>[9, 7, 2, 1]</code>, <code>[7, 2, 1, 7]</code>.</li>
	<li>2 appears in 3 subarrays of size 4: <code>[3, 9, 7, 2]</code>, <code>[9, 7, 2, 1]</code>, <code>[7, 2, 1, 7]</code>.</li>
	<li>3 appears in 1 subarray of size 4: <code>[3, 9, 7, 2]</code>.</li>
	<li>7 appears in 3 subarrays of size 4: <code>[3, 9, 7, 2]</code>, <code>[9, 7, 2, 1]</code>, <code>[7, 2, 1, 7]</code>.</li>
	<li>9 appears in 2 subarrays of size 4: <code>[3, 9, 7, 2]</code>, <code>[9, 7, 2, 1]</code>.</li>
</ul>

<p>We return 3 since it is the largest and only integer that appears in exactly one subarray of size <code>k</code>.</p>
</div>

<p><strong class="example">Example 3:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [0,0], k = 1</span></p>

<p><strong>Output:</strong> <span class="example-io">-1</span></p>

<p><strong>Explanation:</strong></p>

<p>There is no integer that appears in only one subarray of size 1.</p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 50</code></li>
	<li><code>0 &lt;= nums[i] &lt;= 50</code></li>
	<li><code>1 &lt;= k &lt;= nums.length</code></li>
</ul>


<hr>

## Solution Explanation

### Intuition
Because the array size and the maximum possible values are both very small (up to 50), we can solve this problem using direct simulation. By examining every possible subarray of size `k` and tracking which unique numbers appear in each, we can count the total number of subarrays each number belongs to and easily find the largest one that meets the condition.

### Approach
- Initialize a `counts` array of size 51 to track the number of size-`k` subarrays each integer appears in.
- Iterate through every valid starting index to generate all contiguous subarrays of size `k`.
- For each subarray, use a boolean array `present` to mark the integers that exist within that specific window.
- Iterate through the `present` array and increment the global `counts` for any integer found in the current subarray.
- Loop backwards from the maximum possible value (50) down to 0 to guarantee we check the largest integers first.
- Return the first integer that has a count of exactly 1, or return -1 if no such integer exists.

### Complexity
- **Time:** O(n * (k + M)) where n is the length of the array and M is the maximum value (50) — we process n - k + 1 subarrays, and for each, we scan k elements and update M + 1 frequencies.
- **Space:** O(M) where M is the maximum value (50) — we use fixed-size arrays of length 51 for counting and tracking presence.
