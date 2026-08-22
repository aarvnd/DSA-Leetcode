<h2><a href="https://leetcode.com/problems/check-divisibility-by-digit-sum-and-product">Check Divisibility by Digit Sum and Product</a></h2> <img src='https://img.shields.io/badge/Difficulty-Easy-brightgreen' alt='Difficulty: Easy' /><hr><p>You are given a positive integer <code>n</code>. Determine whether <code>n</code> is divisible by the <strong>sum </strong>of the following two values:</p>

<ul>
	<li>
	<p>The <strong>digit sum</strong> of <code>n</code> (the sum of its digits).</p>
	</li>
	<li>
	<p>The <strong>digit</strong> <strong>product</strong> of <code>n</code> (the product of its digits).</p>
	</li>
</ul>

<p>Return <code>true</code> if <code>n</code> is divisible by this sum; otherwise, return <code>false</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">n = 99</span></p>

<p><strong>Output:</strong> <span class="example-io">true</span></p>

<p><strong>Explanation:</strong></p>

<p>Since 99 is divisible by the sum (9 + 9 = 18) plus product (9 * 9 = 81) of its digits (total 99), the output is true.</p>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">n = 23</span></p>

<p><strong>Output:</strong> <span class="example-io">false</span></p>

<p><strong>Explanation:</strong></p>

<p>Since 23 is not divisible by the sum (2 + 3 = 5) plus product (2 * 3 = 6) of its digits (total 11), the output is false.</p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= n &lt;= 10<sup>6</sup></code></li>
</ul>


<hr>

## Solution Explanation

### Intuition
The problem requires checking divisibility against the combined sum and product of a number's digits. The key insight is that we can compute both metrics simultaneously in a single mathematical pass by repeatedly extracting the rightmost digit using modulo arithmetic, entirely avoiding the overhead of string conversion.

### Approach
- Copy `n` into a temporary variable `temp` so the original value is preserved for the final divisibility check.
- Initialize a `sum` variable to 0 and a `prod` variable to 1 to accumulate the digit sum and product, respectively.
- Iterate while `temp > 0`, extracting the rightmost digit using `temp % 10`.
- Add the extracted digit to `sum` and multiply it into `prod`.
- Truncate the rightmost digit from `temp` using integer division (`temp / 10`).
- Return whether the original `n` modulo `(sum + prod)` is exactly 0.

### Complexity
- **Time:** O(log n) — The number of iterations is equal to the number of digits in `n`, which scales logarithmically (base 10) with the value of `n`.
- **Space:** O(1) — We only use a few primitive integer variables, requiring constant extra memory.
