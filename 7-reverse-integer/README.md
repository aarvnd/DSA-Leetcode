<h2><a href="https://leetcode.com/problems/reverse-integer">Reverse Integer</a></h2> <img src='https://img.shields.io/badge/Difficulty-Medium-orange' alt='Difficulty: Medium' /><hr><p>Given a signed 32-bit integer <code>x</code>, return <code>x</code><em> with its digits reversed</em>. If reversing <code>x</code> causes the value to go outside the signed 32-bit integer range <code>[-2<sup>31</sup>, 2<sup>31</sup> - 1]</code>, then return <code>0</code>.</p>

<p><strong>Assume the environment does not allow you to store 64-bit integers (signed or unsigned).</strong></p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> x = 123
<strong>Output:</strong> 321
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> x = -123
<strong>Output:</strong> -321
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> x = 120
<strong>Output:</strong> 21
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>-2<sup>31</sup> &lt;= x &lt;= 2<sup>31</sup> - 1</code></li>
</ul>


<hr>

## Solution Explanation

### Intuition
The key insight is to build the reversed number digit by digit from the back of the original number using modulo arithmetic, while strictly checking for 32-bit integer overflow *before* appending the next digit to ensure we never exceed the environment's limits.

### Approach
- Initialize a variable `rev` to 0 to store the reversed integer.
- Loop while `x` is not 0, extracting the last digit (`pop`) using `x % 10` and truncating `x` using `x / 10`.
- Before appending `pop` to `rev`, check for positive overflow: if `rev` is strictly greater than `MAX_VALUE / 10`, or if it equals `MAX_VALUE / 10` and `pop` is greater than 7 (the last digit of $2^{31}-1$), return 0.
- Check for negative overflow in the same way: if `rev` is strictly less than `MIN_VALUE / 10`, or if it equals `MIN_VALUE / 10` and `pop` is less than -8 (the last digit of $-2^{31}$), return 0.
- If no overflow is imminent, safely update `rev` by multiplying it by 10 and adding `pop`.
- Return `rev` once all digits have been processed.

### Complexity
- **Time:** O(log(x)) — The number of digits in `x` is proportional to log10(x), meaning the loop runs at most 10 times.
- **Space:** O(1) — Only a few primitive integer variables are used, requiring constant extra space.
