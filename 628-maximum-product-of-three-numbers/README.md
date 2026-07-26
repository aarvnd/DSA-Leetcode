<h2><a href="https://leetcode.com/problems/maximum-product-of-three-numbers">Maximum Product of Three Numbers</a></h2> <img src='https://img.shields.io/badge/Difficulty-Easy-brightgreen' alt='Difficulty: Easy' /><hr><p>Given an integer array <code>nums</code>, <em>find three numbers whose product is maximum and return the maximum product</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<pre><strong>Input:</strong> nums = [1,2,3]
<strong>Output:</strong> 6
</pre><p><strong class="example">Example 2:</strong></p>
<pre><strong>Input:</strong> nums = [1,2,3,4]
<strong>Output:</strong> 24
</pre><p><strong class="example">Example 3:</strong></p>
<pre><strong>Input:</strong> nums = [-1,-2,-3]
<strong>Output:</strong> -6
</pre>
<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>3 &lt;= nums.length &lt;=&nbsp;10<sup>4</sup></code></li>
	<li><code>-1000 &lt;= nums[i] &lt;= 1000</code></li>
</ul>


<hr>

## Solution Explanation

### Intuition
The maximum product of three numbers in an array will always be formed by either the three largest numbers or the two smallest (most negative) numbers multiplied by the largest number, because multiplying two large negative numbers yields a large positive result. Therefore, we only need to identify these five specific extreme values to find the answer without needing to sort the entire array.

### Approach
- Initialize five variables to track the three largest values (`max1`, `max2`, `max3`) and the two smallest values (`min1`, `min2`).
- Iterate through each number in the input array exactly once.
- Update the maximums: if the current number is greater than `max1`, shift the previous maximums down and assign the new maximum. Otherwise, cascade the checks to update `max2` or `max3` as appropriate.
- Update the minimums: if the current number is less than `min1`, shift the previous minimum down and assign the new minimum. Otherwise, check and update `min2`.
- Return the maximum of the two possible candidate products: `max1 * max2 * max3` and `min1 * min2 * max1`.

### Complexity
- **Time:** O(N) — we iterate through the array of size N exactly once, performing constant time checks at each step.
- **Space:** O(1) — we only use five variables to track the extreme values, requiring no extra memory that scales with input size.
