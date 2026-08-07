<h2><a href="https://leetcode.com/problems/smallest-divisible-digit-product-ii">Smallest Divisible Digit Product II</a></h2> <img src='https://img.shields.io/badge/Difficulty-Hard-red' alt='Difficulty: Hard' /><hr><p>You are given a string <code>num</code> which represents a <strong>positive</strong> integer, and an integer <code>t</code>.</p>

<p>A number is called <strong>zero-free</strong> if <em>none</em> of its digits are 0.</p>

<p>Return a string representing the <strong>smallest</strong> <strong>zero-free</strong> number greater than or equal to <code>num</code> such that the <strong>product of its digits</strong> is divisible by <code>t</code>. If no such number exists, return <code>&quot;-1&quot;</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">num = &quot;1234&quot;, t = 256</span></p>

<p><strong>Output:</strong> <span class="example-io">&quot;1488&quot;</span></p>

<p><strong>Explanation:</strong></p>

<p>The smallest zero-free number that is greater than 1234 and has the product of its digits divisible by 256 is 1488, with the product of its digits equal to 256.</p>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">num = &quot;12355&quot;, t = 50</span></p>

<p><strong>Output:</strong> <span class="example-io">&quot;12355&quot;</span></p>

<p><strong>Explanation:</strong></p>

<p>12355 is already zero-free and has the product of its digits divisible by 50, with the product of its digits equal to 150.</p>
</div>

<p><strong class="example">Example 3:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">num = &quot;11111&quot;, t = 26</span></p>

<p><strong>Output:</strong> <span class="example-io">&quot;-1&quot;</span></p>

<p><strong>Explanation:</strong></p>

<p>No number greater than 11111 has the product of its digits divisible by 26.</p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>2 &lt;= num.length &lt;= 2 * 10<sup>5</sup></code></li>
	<li><code>num</code> consists only of digits in the range <code>[&#39;0&#39;, &#39;9&#39;]</code>.</li>
	<li><code>num</code> does not contain leading zeros.</li>
	<li><code>1 &lt;= t &lt;= 10<sup>14</sup></code></li>
</ul>


<hr>

## Solution Explanation

### Intuition
Since a number's digits can only be from 1 to 9, their product can only contain the prime factors 2, 3, 5, and 7. If `t` has any other prime factors, no such number exists. The problem then reduces to finding the smallest lexicographical sequence of digits that provides the required prime factors. By precomputing the minimum number of digits needed to satisfy any combination of factors of 2 and 3, we can efficiently check if a valid suffix can be formed within a given length, allowing us to greedily find the optimal divergence point from the original string.

### Approach
- **Prime Factorization:** Extract the counts of prime factors 2, 3, 5, and 7 from `t`. If `t` reduces to anything greater than 1 after this, return `"-1"`.
- **Precompute Minimum Digits (DP):** Use dynamic programming to build a table `dp[i][j]` representing the minimum number of digits (using 2, 3, 4, 6, 8, 9) required to get at least `i` factors of 2 and `j` factors of 3. Factors of 5 and 7 are independent and always require exactly one digit (5 and 7 respectively) per factor.
- **Prefix Processing:** Compute the prefix counts of prime factors provided by the digits of `num`. Stop if a `'0'` is encountered, as the divergence point must occur at or before the first zero.
- **Find Divergence Point:** Iterate backwards from the end of `num` (or the first `'0'`). Try to increment the current digit (up to 9). Check if the remaining suffix length is enough to hold the remaining required factors using the condition: `req_5 + req_7 + dp[req_2][req_3] <= remaining_length`.
- **Greedy Construction:** 
  - If a valid divergence point is found, keep the prefix, append the incremented digit, and fill the rest of the string greedily from left to right with the smallest possible valid digits (1-9).
  - If no divergence point works, the answer must be longer than `num`. Calculate the new required length (at least `num.length() + 1`) and greedily build the entire string from scratch using the smallest valid digits.

### Complexity
- **Time:** O(N) — The DP table takes O(1) time (fixed 65x45 size), and both the backward search and greedy string construction take O(N) time where N is the length of `num`.
- **Space:** O(N) — We use O(N) space for the prefix arrays and the `StringBuilder` to construct the result.
