<h2><a href="https://leetcode.com/problems/divide-two-integers">Divide Two Integers</a></h2> <img src='https://img.shields.io/badge/Difficulty-Medium-orange' alt='Difficulty: Medium' /><hr><p>Given two integers <code>dividend</code> and <code>divisor</code>, divide two integers <strong>without</strong> using multiplication, division, and mod operator.</p>

<p>The integer division should truncate toward zero, which means losing its fractional part. For example, <code>8.345</code> would be truncated to <code>8</code>, and <code>-2.7335</code> would be truncated to <code>-2</code>.</p>

<p>Return <em>the <strong>quotient</strong> after dividing </em><code>dividend</code><em> by </em><code>divisor</code>.</p>

<p><strong>Note: </strong>Assume we are dealing with an environment that could only store integers within the <strong>32-bit</strong> signed integer range: <code>[&minus;2<sup>31</sup>, 2<sup>31</sup> &minus; 1]</code>. For this problem, if the quotient is <strong>strictly greater than</strong> <code>2<sup>31</sup> - 1</code>, then return <code>2<sup>31</sup> - 1</code>, and if the quotient is <strong>strictly less than</strong> <code>-2<sup>31</sup></code>, then return <code>-2<sup>31</sup></code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> dividend = 10, divisor = 3
<strong>Output:</strong> 3
<strong>Explanation:</strong> 10/3 = 3.33333.. which is truncated to 3.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> dividend = 7, divisor = -3
<strong>Output:</strong> -2
<strong>Explanation:</strong> 7/-3 = -2.33333.. which is truncated to -2.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>-2<sup>31</sup> &lt;= dividend, divisor &lt;= 2<sup>31</sup> - 1</code></li>
	<li><code>divisor != 0</code></li>
</ul>


<hr>

## Solution Explanation

### Intuition
To divide efficiently without multiplication or division, we can repeatedly subtract the divisor from the dividend by exponentially doubling it (using addition) to subtract the largest possible chunks. By converting both numbers to negative values, we safely avoid 32-bit integer overflow, since the negative boundary of a 32-bit signed integer can hold a larger absolute value than its positive boundary.

### Approach
- Handle the overflow edge case (`Integer.MIN_VALUE` divided by `-1`) and determine the final sign of the quotient using the XOR operator on the inputs.
- Convert both the dividend and divisor to negative numbers to safely accommodate `Integer.MIN_VALUE` without causing an overflow during absolute value conversion.
- Iterate as long as the remaining dividend is less than or equal to the divisor (keeping in mind both are negative, so this means the dividend's absolute value is larger).
- Inside the loop, repeatedly double the divisor and the quotient multiplier using addition until the next doubling would exceed the remaining dividend or overflow the 32-bit limit.
- Subtract this maximized chunk from the dividend, add the multiplier to the accumulated negative quotient, and repeat the process before finally returning the result with the correct sign.

### Complexity
- **Time:** O(log N) — where N is the absolute value of the dividend, because we exponentially double the divisor, requiring at most 32 iterations.
- **Space:** O(1) — only a constant number of primitive integer variables are used for tracking state.
