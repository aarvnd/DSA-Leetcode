<h2><a href="https://leetcode.com/problems/maximum-product-of-two-digits">Maximum Product of Two Digits</a></h2> <img src='https://img.shields.io/badge/Difficulty-Easy-brightgreen' alt='Difficulty: Easy' /><hr><p>You are given a positive integer <code>n</code>.</p>

<p>Return the <strong>maximum</strong> product of any two digits in <code>n</code>.</p>

<p><strong>Note:</strong> You may use the <strong>same</strong> digit twice if it appears more than once in <code>n</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">n = 31</span></p>

<p><strong>Output:</strong> <span class="example-io">3</span></p>

<p><strong>Explanation:</strong></p>

<ul>
	<li>The digits of <code>n</code> are <code>[3, 1]</code>.</li>
	<li>The possible products of any two digits are: <code>3 * 1 = 3</code>.</li>
	<li>The maximum product is 3.</li>
</ul>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">n = 22</span></p>

<p><strong>Output:</strong> <span class="example-io">4</span></p>

<p><strong>Explanation:</strong></p>

<ul>
	<li>The digits of <code>n</code> are <code>[2, 2]</code>.</li>
	<li>The possible products of any two digits are: <code>2 * 2 = 4</code>.</li>
	<li>The maximum product is 4.</li>
</ul>
</div>

<p><strong class="example">Example 3:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">n = 124</span></p>

<p><strong>Output:</strong> <span class="example-io">8</span></p>

<p><strong>Explanation:</strong></p>

<ul>
	<li>The digits of <code>n</code> are <code>[1, 2, 4]</code>.</li>
	<li>The possible products of any two digits are: <code>1 * 2 = 2</code>, <code>1 * 4 = 4</code>, <code>2 * 4 = 8</code>.</li>
	<li>The maximum product is 8.</li>
</ul>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>10 &lt;= n &lt;= 10<sup>9</sup></code></li>
</ul>


<hr>

## Solution Explanation

### Intuition
To maximize the product of two positive single-digit numbers, we simply need to multiply the two largest digits present in the integer. Instead of converting the number to a string or sorting its digits, we can find these two maximum values in a single mathematical pass by peeling off digits one by one from right to left.

### Approach
- Initialize two variables, `max1` and `max2`, to -1 to keep track of the largest and second-largest digits seen so far.
- Iterate through the integer using a loop, extracting the rightmost digit during each step using the modulo operator (`n % 10`).
- Check if the extracted digit is greater than or equal to `max1`. If it is, shift the old `max1` value into `max2`, and update `max1` to the current digit.
- If the digit is not larger than `max1` but is larger than `max2`, update `max2` to the current digit.
- Divide the integer by 10 (`n /= 10`) to remove the processed digit, repeating until the number becomes 0.
- Return the product of the two largest digits, `max1 * max2`.

### Complexity
- **Time:** O(log n) — we process each digit of the base-10 number exactly once, which takes logarithmic time relative to the value of n.
- **Space:** O(1) — we only use a few integer variables to track the maximums, requiring constant extra space regardless of the input size.
