<h2><a href="https://leetcode.com/problems/plus-one">Plus One</a></h2> <img src='https://img.shields.io/badge/Difficulty-Easy-brightgreen' alt='Difficulty: Easy' /><hr><p>You are given a <strong>large integer</strong> represented as an integer array <code>digits</code>, where each <code>digits[i]</code> is the <code>i<sup>th</sup></code> digit of the integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading <code>0</code>&#39;s.</p>

<p>Increment the large integer by one and return <em>the resulting array of digits</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> digits = [1,2,3]
<strong>Output:</strong> [1,2,4]
<strong>Explanation:</strong> The array represents the integer 123.
Incrementing by one gives 123 + 1 = 124.
Thus, the result should be [1,2,4].
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> digits = [4,3,2,1]
<strong>Output:</strong> [4,3,2,2]
<strong>Explanation:</strong> The array represents the integer 4321.
Incrementing by one gives 4321 + 1 = 4322.
Thus, the result should be [4,3,2,2].
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> digits = [9]
<strong>Output:</strong> [1,0]
<strong>Explanation:</strong> The array represents the integer 9.
Incrementing by one gives 9 + 1 = 10.
Thus, the result should be [1,0].
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= digits.length &lt;= 100</code></li>
	<li><code>0 &lt;= digits[i] &lt;= 9</code></li>
	<li><code>digits</code> does not contain any leading <code>0</code>&#39;s.</li>
</ul>


<hr>

## Solution Explanation

### Intuition
The key insight is that adding one to a number only propagates a carry leftward if the current digit is a 9. By traversing the number from right to left, we can immediately increment the first non-nine digit we find and stop, only needing to allocate a new, larger array if every single digit rolls over from 9 to 0.

### Approach
- Iterate through the array in reverse, starting from the least significant digit at the end.
- If the current digit is strictly less than 9, increment it by 1 and immediately return the array, as no carry-over is required.
- If the current digit is 9, it becomes 0 due to the carry, and the loop continues to evaluate the next digit to the left.
- If the loop finishes without returning, it means all digits in the original array were 9s (e.g., 999 becomes 000).
- Create a new array of size n + 1, set the first element to 1 (the remaining elements default to 0), and return it to represent the rollover (e.g., 1000).

### Complexity
- **Time:** O(N) — where N is the number of digits, because we may need to traverse the entire array in the worst case (when all digits are 9).
- **Space:** O(N) — in the worst case, a new array of size N + 1 is allocated; otherwise, it takes O(1) auxiliary space as modifications are done in place.
