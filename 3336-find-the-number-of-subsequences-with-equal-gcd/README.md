<h2><a href="https://leetcode.com/problems/find-the-number-of-subsequences-with-equal-gcd">Find the Number of Subsequences With Equal GCD</a></h2> <img src='https://img.shields.io/badge/Difficulty-Hard-red' alt='Difficulty: Hard' /><hr><p>You are given an integer array <code>nums</code>.</p>

<p>Your task is to find the number of pairs of <strong>non-empty</strong> <span data-keyword="subsequence-array">subsequences</span> <code>(seq1, seq2)</code> of <code>nums</code> that satisfy the following conditions:</p>

<ul>
	<li>The subsequences <code>seq1</code> and <code>seq2</code> are <strong>disjoint</strong>, meaning <strong>no index</strong> of <code>nums</code> is common between them.</li>
	<li>The <span data-keyword="gcd-function">GCD</span> of the elements of <code>seq1</code> is equal to the GCD of the elements of <code>seq2</code>.</li>
</ul>

<p>Return the total number of such pairs.</p>

<p>Since the answer may be very large, return it <strong>modulo</strong> <code>10<sup>9</sup> + 7</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [1,2,3,4]</span></p>

<p><strong>Output:</strong> <span class="example-io">10</span></p>

<p><strong>Explanation:</strong></p>

<p>The subsequence pairs which have the GCD of their elements equal to 1 are:</p>

<ul>
	<li><code>([<strong><u>1</u></strong>, 2, 3, 4], [1, <strong><u>2</u></strong>, <strong><u>3</u></strong>, 4])</code></li>
	<li><code>([<strong><u>1</u></strong>, 2, 3, 4], [1, <strong><u>2</u></strong>, <strong><u>3</u></strong>, <strong><u>4</u></strong>])</code></li>
	<li><code>([<strong><u>1</u></strong>, 2, 3, 4], [1, 2, <strong><u>3</u></strong>, <strong><u>4</u></strong>])</code></li>
	<li><code>([<strong><u>1</u></strong>, <strong><u>2</u></strong>, 3, 4], [1, 2, <strong><u>3</u></strong>, <strong><u>4</u></strong>])</code></li>
	<li><code>([<strong><u>1</u></strong>, 2, 3, <strong><u>4</u></strong>], [1, <strong><u>2</u></strong>, <strong><u>3</u></strong>, 4])</code></li>
	<li><code>([1, <strong><u>2</u></strong>, <strong><u>3</u></strong>, 4], [<strong><u>1</u></strong>, 2, 3, 4])</code></li>
	<li><code>([1, <strong><u>2</u></strong>, <strong><u>3</u></strong>, 4], [<strong><u>1</u></strong>, 2, 3, <strong><u>4</u></strong>])</code></li>
	<li><code>([1, <strong><u>2</u></strong>, <strong><u>3</u></strong>, <strong><u>4</u></strong>], [<strong><u>1</u></strong>, 2, 3, 4])</code></li>
	<li><code>([1, 2, <strong><u>3</u></strong>, <strong><u>4</u></strong>], [<strong><u>1</u></strong>, 2, 3, 4])</code></li>
	<li><code>([1, 2, <strong><u>3</u></strong>, <strong><u>4</u></strong>], [<strong><u>1</u></strong>, <strong><u>2</u></strong>, 3, 4])</code></li>
</ul>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [10,20,30]</span></p>

<p><strong>Output:</strong> <span class="example-io">2</span></p>

<p><strong>Explanation:</strong></p>

<p>The subsequence pairs which have the GCD of their elements equal to 10 are:</p>

<ul>
	<li><code>([<strong><u>10</u></strong>, 20, 30], [10, <strong><u>20</u></strong>, <strong><u>30</u></strong>])</code></li>
	<li><code>([10, <strong><u>20</u></strong>, <strong><u>30</u></strong>], [<strong><u>10</u></strong>, 20, 30])</code></li>
</ul>
</div>

<p><strong class="example">Example 3:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [1,1,1,1]</span></p>

<p><strong>Output:</strong> <span class="example-io">50</span></p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 200</code></li>
	<li><code>1 &lt;= nums[i] &lt;= 200</code></li>
</ul>


<hr>

## Solution Explanation

### Intuition
The key insight is that since the maximum element in `nums` is small (up to 200), the running GCD of any subsequence is strictly bounded by 200. This allows us to use dynamic programming to track the number of ways to form every possible pair of GCDs `(g1, g2)` by deciding whether each element goes into the first subsequence, the second subsequence, or neither.

### Approach
- Find the maximum value $M$ in `nums` and precompute a 2D GCD table up to $M$ to allow $O(1)$ transitions during the DP phase.
- Initialize a 2D DP table `dp[g1][g2]` with `dp[0][0] = 1`, where the index 0 denotes an empty subsequence.
- Iterate through each element `x` in `nums` and use a `nextDp` table to compute the new states. For every existing state `(g1, g2)`, propagate its combinations to three new states: `(g1, g2)` (exclude `x` from both), `(gcd(g1, x), g2)` (append `x` to the first subsequence), and `(g1, gcd(g2, x))` (append `x` to the second subsequence).
- After processing all elements, sum the counts in `dp[g][g]` for all $g \ge 1$ (which ensures both subsequences are non-empty) and return the result modulo $10^9 + 7$.

### Complexity
- **Time:** O(N * M^2) — where N is the length of `nums` and M is the maximum value in `nums`, as we process N elements and update an M x M DP table at each step.
- **Space:** O(M^2) — for storing the M x M precomputed GCD table and the two M x M DP arrays (`dp` and `nextDp`).
