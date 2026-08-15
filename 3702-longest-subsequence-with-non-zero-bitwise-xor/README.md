<h2><a href="https://leetcode.com/problems/longest-subsequence-with-non-zero-bitwise-xor">Longest Subsequence With Non-Zero Bitwise XOR</a></h2> <img src='https://img.shields.io/badge/Difficulty-Medium-orange' alt='Difficulty: Medium' /><hr><p>You are given an integer array <code>nums</code>.</p>

<p>Return the length of the <strong>longest <span data-keyword="subsequence-array-nonempty">subsequence</span></strong> in <code>nums</code> whose bitwise <strong>XOR</strong> is <strong>non-zero</strong>. If no such <strong>subsequence</strong> exists, return 0.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [1,2,3]</span></p>

<p><strong>Output:</strong> <span class="example-io">2</span></p>

<p><strong>Explanation:</strong></p>

<p>One longest subsequence is <code>[2, 3]</code>. The bitwise XOR is computed as <code>2 XOR 3 = 1</code>, which is non-zero.</p>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [2,3,4]</span></p>

<p><strong>Output:</strong> <span class="example-io">3</span></p>

<p><strong>Explanation:</strong></p>

<p>The longest subsequence is <code>[2, 3, 4]</code>. The bitwise XOR is computed as <code>2 XOR 3 XOR 4 = 5</code>, which is non-zero.</p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>0 &lt;= nums[i] &lt;= 10<sup>9</sup></code></li>
</ul>


<hr>

## Solution Explanation

### Intuition
The key insight is that if the XOR sum of the entire array is zero, removing exactly one non-zero element will shift the remaining XOR sum to a non-zero value (specifically, the value of the removed element). Therefore, the longest valid subsequence will either be the entire array, the array minus one element, or empty if the array consists entirely of zeros.

### Approach
- Initialize a variable `xorSum` to 0 to track the cumulative XOR of all elements.
- Initialize a boolean flag `hasNonZero` to false to check if the array contains any valid non-zero numbers.
- Iterate through the array, updating `xorSum` with each element and setting `hasNonZero` to true if the current element is not zero.
- If the final `xorSum` is non-zero, the entire array is the longest valid subsequence, so return `n`.
- If `xorSum` is zero but `hasNonZero` is true, conceptually remove one non-zero element to make the remaining XOR sum non-zero, returning `n - 1`.
- If all elements are zero, it is impossible to form a non-zero XOR sum, so return `0`.

### Complexity
- **Time:** O(n) — We iterate through the array of size n exactly once.
- **Space:** O(1) — We only use a few primitive variables to store the XOR sum and a boolean flag.
