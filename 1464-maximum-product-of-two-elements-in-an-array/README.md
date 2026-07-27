<h2><a href="https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array">Maximum Product of Two Elements in an Array</a></h2> <img src='https://img.shields.io/badge/Difficulty-Easy-brightgreen' alt='Difficulty: Easy' /><hr>Given the array of integers <code>nums</code>, you will choose two different indices <code>i</code> and <code>j</code> of that array. <em>Return the maximum value of</em> <code>(nums[i]-1)*(nums[j]-1)</code>.
<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [3,4,5,2]
<strong>Output:</strong> 12 
<strong>Explanation:</strong> If you choose the indices i=1 and j=2 (indexed from 0), you will get the maximum value, that is, (nums[1]-1)*(nums[2]-1) = (4-1)*(5-1) = 3*4 = 12. 
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [1,5,4,5]
<strong>Output:</strong> 16
<strong>Explanation:</strong> Choosing the indices i=1 and j=3 (indexed from 0), you will get the maximum value of (5-1)*(5-1) = 16.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> nums = [3,7]
<strong>Output:</strong> 12
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>2 &lt;= nums.length &lt;= 500</code></li>
	<li><code>1 &lt;= nums[i] &lt;= 10^3</code></li>
</ul>


<hr>

## Solution Explanation

### Intuition
Since all numbers in the array are positive integers, the maximum possible product of any two elements minus one will always be achieved by multiplying the two largest elements in the array. Therefore, the problem simplifies to finding the maximum and second-maximum values in a single pass.

### Approach
- Initialize two variables, `max1` and `max2`, to 0 to track the largest and second-largest elements seen so far.
- Iterate through each number `n` in the input array.
- If `n` is greater than `max1`, it means we found a new largest number. The old largest number (`max1`) becomes the new second-largest (`max2`), and `max1` is updated to `n`.
- Otherwise, if `n` is not greater than `max1` but is greater than `max2`, simply update `max2` to `n`.
- After checking all numbers, compute and return the final result using the formula `(max1 - 1) * (max2 - 1)`.

### Complexity
- **Time:** O(N) — We iterate through the array of size N exactly once.
- **Space:** O(1) — We only use two integer variables to store the maximums, requiring constant extra space.
