<h2><a href="https://leetcode.com/problems/climbing-stairs">Climbing Stairs</a></h2> <img src='https://img.shields.io/badge/Difficulty-Easy-brightgreen' alt='Difficulty: Easy' /><hr><p>You are climbing a staircase. It takes <code>n</code> steps to reach the top.</p>

<p>Each time you can either climb <code>1</code> or <code>2</code> steps. In how many distinct ways can you climb to the top?</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> n = 2
<strong>Output:</strong> 2
<strong>Explanation:</strong> There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> n = 3
<strong>Output:</strong> 3
<strong>Explanation:</strong> There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= n &lt;= 45</code></li>
</ul>


<hr>

## Solution Explanation

### Intuition
To reach step `n`, you must have taken your final step from either step `n-1` (a single step) or step `n-2` (a double step). Therefore, the total number of distinct ways to reach step `n` is simply the sum of the ways to reach the two preceding steps, making this a classic Fibonacci sequence problem.

### Approach
- Handle the base cases immediately: if `n` is 1 or 2, return `n` since there are exactly `n` ways to climb those stairs.
- Initialize two variables, `prev2` (set to 1) and `prev1` (set to 2), to track the number of ways to reach the two most recent steps.
- Iterate from step 3 up to `n`.
- Calculate the ways to reach the current step by adding the ways to reach the previous two steps together (`curr = prev1 + prev2`).
- Update `prev2` and `prev1` to shift the two-step tracking window forward, ultimately returning `prev1` as the final answer once the loop completes.

### Complexity
- **Time:** O(n) — We iterate through a loop from 3 to `n` exactly once, performing constant time operations.
- **Space:** O(1) — We only use a few integer variables to track the previous states, requiring no extra scaling memory.
