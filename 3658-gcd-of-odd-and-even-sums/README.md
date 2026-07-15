<h2><a href="https://leetcode.com/problems/gcd-of-odd-and-even-sums">GCD of Odd and Even Sums</a></h2> <img src='https://img.shields.io/badge/Difficulty-Easy-brightgreen' alt='Difficulty: Easy' /><hr><p>You are given an integer <code>n</code>. Your task is to compute the <strong>GCD</strong> (greatest common divisor) of two values:</p>

<ul>
	<li>
	<p><code>sumOdd</code>: the sum of the smallest&nbsp;<code>n</code>&nbsp;positive odd numbers.</p>
	</li>
	<li>
	<p><code>sumEven</code>: the sum of the smallest&nbsp;<code>n</code>&nbsp;positive even numbers.</p>
	</li>
</ul>

<p>Return the GCD of <code>sumOdd</code> and <code>sumEven</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">n = 4</span></p>

<p><strong>Output:</strong> <span class="example-io">4</span></p>

<p><strong>Explanation:</strong></p>

<ul>
	<li>Sum of the first 4 odd numbers <code>sumOdd = 1 + 3 + 5 + 7 = 16</code></li>
	<li>Sum of the first 4 even numbers <code>sumEven = 2 + 4 + 6 + 8 = 20</code></li>
</ul>

<p>Hence, <code>GCD(sumOdd, sumEven) = GCD(16, 20) = 4</code>.</p>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">n = 5</span></p>

<p><strong>Output:</strong> <span class="example-io">5</span></p>

<p><strong>Explanation:</strong></p>

<ul>
	<li>Sum of the first 5 odd numbers <code>sumOdd = 1 + 3 + 5 + 7 + 9 = 25</code></li>
	<li>Sum of the first 5 even numbers <code>sumEven = 2 + 4 + 6 + 8 + 10 = 30</code></li>
</ul>

<p>Hence, <code>GCD(sumOdd, sumEven) = GCD(25, 30) = 5</code>.</p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= n &lt;= 10​​​​​​​00</code></li>
</ul>


<hr>

## Solution Explanation

### Intuition
The key insight is recognizing the mathematical formulas for the sums of the first $n$ odd and even numbers. The sum of the first $n$ odd numbers is exactly $n^2$, and the sum of the first $n$ even numbers is $n(n+1)$. Factoring out $n$ reveals that the greatest common divisor depends entirely on $n$ and $n+1$, which are consecutive integers and therefore always coprime.

### Approach
- Identify the sum of the first $n$ odd numbers, which mathematically simplifies to $n^2$.
- Identify the sum of the first $n$ even numbers, which mathematically simplifies to $n(n + 1)$.
- Express the required GCD as $\gcd(n^2, n(n + 1))$.
- Factor out the common term $n$ to simplify the expression to $n \times \gcd(n, n + 1)$.
- Recognize that consecutive integers ($n$ and $n+1$) share no common divisors other than 1, making the final answer simply $n$.

### Complexity
- **Time:** O(1) — The result is returned directly based on mathematical derivation without any loops.
- **Space:** O(1) — No additional memory is allocated.
