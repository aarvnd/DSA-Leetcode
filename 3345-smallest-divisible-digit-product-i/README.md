<h2><a href="https://leetcode.com/problems/smallest-divisible-digit-product-i">Smallest Divisible Digit Product I</a></h2> <img src='https://img.shields.io/badge/Difficulty-Easy-brightgreen' alt='Difficulty: Easy' /><hr><p>You are given two integers <code>n</code> and <code>t</code>. Return the <strong>smallest</strong> number greater than or equal to <code>n</code> such that the <strong>product of its digits</strong> is divisible by <code>t</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">n = 10, t = 2</span></p>

<p><strong>Output:</strong> <span class="example-io">10</span></p>

<p><strong>Explanation:</strong></p>

<p>The digit product of 10 is 0, which is divisible by 2, making it the smallest number greater than or equal to 10 that satisfies the condition.</p>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">n = 15, t = 3</span></p>

<p><strong>Output:</strong> <span class="example-io">16</span></p>

<p><strong>Explanation:</strong></p>

<p>The digit product of 16 is 6, which is divisible by 3, making it the smallest number greater than or equal to 15 that satisfies the condition.</p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= n &lt;= 100</code></li>
	<li><code>1 &lt;= t &lt;= 10</code></li>
</ul>


<hr>

## Solution Explanation

### Intuition
Because the constraints on the starting number are very small and any number containing a zero has a digit product of zero (which is divisible by any integer), the next valid number is guaranteed to be found within at most 9 increments. This makes a straightforward brute-force simulation highly efficient and perfectly sufficient to solve the problem.

### Approach
*   Initialize a continuous loop starting from the given number `n`.
*   Calculate the product of the current number's digits by repeatedly extracting the last digit (using modulo 10) and multiplying it to a running total.
*   Divide the number by 10 in each step of the calculation to shift to the next digit until all digits are processed.
*   Check if the resulting digit product is evenly divisible by the target `t`.
*   If the condition is met, return the current number; otherwise, increment the number by 1 and repeat the check.

### Complexity
- **Time:** O(1) — The loop runs at most 9 times (until a number ending in 0 is reached), and processing the digits of numbers up to ~110 takes a constant number of operations.
- **Space:** O(1) — Only a few primitive integer variables are used for tracking the number and its digit product.
