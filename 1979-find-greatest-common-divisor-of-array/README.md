<h2><a href="https://leetcode.com/problems/find-greatest-common-divisor-of-array">Find Greatest Common Divisor of Array</a></h2> <img src='https://img.shields.io/badge/Difficulty-Easy-brightgreen' alt='Difficulty: Easy' /><hr><p>Given an integer array <code>nums</code>, return<strong> </strong><em>the <strong>greatest common divisor</strong> of the smallest number and largest number in </em><code>nums</code>.</p>

<p>The <strong>greatest common divisor</strong> of two numbers is the largest positive integer that evenly divides both numbers.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [2,5,6,9,10]
<strong>Output:</strong> 2
<strong>Explanation:</strong>
The smallest number in nums is 2.
The largest number in nums is 10.
The greatest common divisor of 2 and 10 is 2.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [7,5,6,8,3]
<strong>Output:</strong> 1
<strong>Explanation:</strong>
The smallest number in nums is 3.
The largest number in nums is 8.
The greatest common divisor of 3 and 8 is 1.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> nums = [3,3]
<strong>Output:</strong> 3
<strong>Explanation:</strong>
The smallest number in nums is 3.
The largest number in nums is 3.
The greatest common divisor of 3 and 3 is 3.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>2 &lt;= nums.length &lt;= 1000</code></li>
	<li><code>1 &lt;= nums[i] &lt;= 1000</code></li>
</ul>


<hr>

## Solution Explanation

### Intuition
The key insight is that we only need the absolute minimum and maximum values from the array, which can be found simultaneously in a single linear scan without the overhead of sorting. Once these two extremes are identified, the standard Euclidean algorithm can efficiently compute their greatest common divisor.

### Approach
- Initialize `min` and `max` variables using the first element of the array.
- Iterate through the array from the second element onwards, updating `min` if the current element is smaller, and `max` if it is larger.
- Pass the identified `min` and `max` values to a helper function to calculate their Greatest Common Divisor (GCD).
- Apply the Euclidean algorithm in a `while` loop by repeatedly replacing `a` with `b` and `b` with the remainder of `a % b` until `b` becomes 0.
- Return `a`, which holds the final GCD of the two numbers.

### Complexity
- **Time:** O(N) — finding the min and max takes O(N) time, and the Euclidean algorithm takes O(log(min(a, b))) time, making the linear scan the dominant factor.
- **Space:** O(1) — only a few integer variables are used for tracking values and computing the GCD, requiring constant extra space.
