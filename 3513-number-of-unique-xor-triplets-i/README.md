<h2><a href="https://leetcode.com/problems/number-of-unique-xor-triplets-i">Number of Unique XOR Triplets I</a></h2> <img src='https://img.shields.io/badge/Difficulty-Medium-orange' alt='Difficulty: Medium' /><hr><p>You are given an integer array <code>nums</code> of length <code>n</code>, where <code>nums</code> is a <strong><span data-keyword="permutation">permutation</span></strong> of the numbers in the range <code>[1, n]</code>.</p>

<p>A <strong>XOR triplet</strong> is defined as the XOR of three elements <code>nums[i] XOR nums[j] XOR nums[k]</code> where <code>i &lt;= j &lt;= k</code>.</p>

<p>Return the number of <strong>unique</strong> XOR triplet values from all possible triplets <code>(i, j, k)</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [1,2]</span></p>

<p><strong>Output:</strong> <span class="example-io">2</span></p>

<p><strong>Explanation:</strong></p>

<p>The possible XOR triplet values are:</p>

<ul>
	<li><code>(0, 0, 0) &rarr; 1 XOR 1 XOR 1 = 1</code></li>
	<li><code>(0, 0, 1) &rarr; 1 XOR 1 XOR 2 = 2</code></li>
	<li><code>(0, 1, 1) &rarr; 1 XOR 2 XOR 2 = 1</code></li>
	<li><code>(1, 1, 1) &rarr; 2 XOR 2 XOR 2 = 2</code></li>
</ul>

<p>The unique XOR values are <code>{1, 2}</code>, so the output is 2.</p>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [3,1,2]</span></p>

<p><strong>Output:</strong> <span class="example-io">4</span></p>

<p><strong>Explanation:</strong></p>

<p>The possible XOR triplet values include:</p>

<ul>
	<li><code>(0, 0, 0) &rarr; 3 XOR 3 XOR 3 = 3</code></li>
	<li><code>(0, 0, 1) &rarr; 3 XOR 3 XOR 1 = 1</code></li>
	<li><code>(0, 0, 2) &rarr; 3 XOR 3 XOR 2 = 2</code></li>
	<li><code>(0, 1, 2) &rarr; 3 XOR 1 XOR 2 = 0</code></li>
</ul>

<p>The unique XOR values are <code>{0, 1, 2, 3}</code>, so the output is 4.</p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= n == nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= nums[i] &lt;= n</code></li>
	<li><code>nums</code> is a permutation of integers from <code>1</code> to <code>n</code>.</li>
</ul>


<hr>

## Solution Explanation

### Intuition
The problem asks for the number of unique values formed by XORing three elements from a full permutation of `1` to `n`. Because indices can repeat (`i <= j <= k`), we can effectively evaluate the XOR of one element (`x^x^x=x`), two elements (`x^x^y=y`), or three distinct elements. Since the array contains every integer up to `n`, their XOR combinations will completely fill the binary space up to the most significant bit of `n`. Therefore, for any $n \ge 3$, the unique XOR values generated will be every integer from $0$ up to $2^m - 1$, where $m$ is the number of bits required to represent `n`.

### Approach
- Handle the base cases where $n < 3$. If $n = 1$ or $n = 2$, the available numbers cannot combine to form any new values outside their own range, so the number of unique XOR values is simply $n$.
- For $n \ge 3$, determine the most significant bit of $n$ (the largest power of 2 less than or equal to $n$) using the built-in `highestOneBit` function.
- Left-shift this highest bit by 1 (`<< 1`) to calculate the smallest power of 2 that is strictly greater than $n$.
- Return this calculated power of 2. It perfectly represents the total count of all possible XOR values (spanning continuously from $0$ to this power of 2 minus 1) that can be constructed using up to three numbers from the array.

### Complexity
- **Time:** O(1) — Finding the highest one-bit and performing bitwise shifts are constant-time operations.
- **Space:** O(1) — No extra memory is allocated, as the calculation is done purely with primitive integers.
